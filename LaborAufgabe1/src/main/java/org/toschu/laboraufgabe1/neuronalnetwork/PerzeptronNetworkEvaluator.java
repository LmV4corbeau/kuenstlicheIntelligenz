/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;
import org.toschu.laboraufgabe1.framework.Learner;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.Mapping3;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.Mapping6;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyLeft;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyRight;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyStop;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyVorfahrtGewaehren;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyVorfahrtStrasse;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.OnlyVorfahrtvonRechts;
import org.toschu.repositoryapi.api.Implemented.JSONRepository;
import org.toschu.repositoryapi.api.Repository;

/**
 *
 * @author toschu
 */
public class PerzeptronNetworkEvaluator {

    /**
     * the percentage (between 0 und 100) of vectors from the data to be used
     * for the test
     */
    private int testRate = 50;
    private int numberOfTests = 100;

    public PerzeptronNetworkEvaluator() {

    }

    public PerzeptronNetworkEvaluator(String filename,
            PerzeptronNetwork network,
            int testRate, int numberOfTests, int learingRate) {
        List<FeatureVector> vectors = readData(filename);
        float success = 0;
        float unknown = 0;
        float wrong = 0;
        this.numberOfTests = numberOfTests;
        this.testRate = testRate;

        System.out.println(network.getName());
        int i = 0;
        do {
            Learner learner
                    = new PerzeptronLearner(network,
                            network.getMappingConceptToPerzeptron(),
                            learingRate);
            vectors = mixData(vectors);
            List<List<FeatureVector>> sets = extractTrainingData(vectors);
            learner.learn(sets.get(0));
            Vector<Integer> result = evaluate(sets.get(1), learner);
            success += result.get(0) / (float) sets.get(1).size();
            unknown += result.get(1) / (float) sets.get(1).size();
            wrong += result.get(2) / (float) sets.get(1).size();
            i++;
            System.out.println("");
        } while (i < numberOfTests);
        System.out.println("Result after "
                + numberOfTests + " Test with "
                + vectors.size() + " FeatureVectors:");
        System.out.println("Learning result: \n correct: "
                + (success / numberOfTests) * 100f + "%\n unknown: "
                + (unknown / numberOfTests) * 100f + "%\n wrong: "
                + (wrong / numberOfTests) * 100f + "%");
        Repository<PerzeptronNetwork> repo = new JSONRepository<>(
                new File(network.getClass().getSimpleName()),
                PerzeptronNetwork.class);

    }

    /**
     * Evaluate the reulst from the test for output or furthjer considerations
     *
     * @param result a Vector containing 3 values: a) right classification ba
     * used learner, b) lerner could not decide or c) learner found wrong
     * concept
     */
    private void evalResult(Vector<Integer> result) {
        // TODO hier muss mehr Auswertung passieren, insbes: Vertrauensintervalle etc
        System.out.println("Learning result: \n correct: "
                + result.get(0) + "\n unknown: "
                + result.get(1) + "\n wrong: " + result.get(2));
    }

    /**
     * evaluate the learner with a given test set.
     *
     * @param list: The set of test examples containing the correct concept
     * @param learner: The learner to be tests
     *
     * @return a vector containing the test results: success, unknown, false
     */
    private Vector<Integer> evaluate(List<FeatureVector> list, Learner learner) {
        int success = 0;
        int unknown = 0;
        int fault = 0;
        for (FeatureVector fv : list) {
            Concept c = learner.classify(fv);
            if (c.equals(Concept.Unknown)) {
                unknown++;
            } else if (c.equals(fv.getConcept())) {
                success++;
            } else {
                fault++;
            }

        }
        Vector<Integer> res = new Vector<>();
        res.add(0, success);
        res.add(1, unknown);
        res.add(2, fault);
        return res;
    }

    /**
     *
     * @param vectors a list of vectors
     * @return list containing the same vectors as parameter but (usually) in
     * different order
     */
    private List<FeatureVector> mixData(List<FeatureVector> vectors) {
        Collections.shuffle(vectors);
        return vectors;
    }

    /**
     * Split the set of festure vectors in a set of traing data and a set of
     * test data. For representative results it is essential to mix the order of
     * vectors before splitting the set
     *
     * @param vectors :a List fo Feature Vectors we can use for the test
     * @return a List containt two Lists: first the training data, second the
     * test data they are disjunct subsets of vector
     *
     */
    private List<List<FeatureVector>> extractTrainingData(
            List<FeatureVector> vectors) {
        List<List<FeatureVector>> result = new LinkedList<>();
        List<FeatureVector> trainingData = new LinkedList<>();
        List<FeatureVector> testData = new LinkedList<>();
        int cut = (int) ((testRate / 100) * vectors.size());
        trainingData.addAll(vectors.subList(0, cut));
        testData.addAll(vectors.subList(cut + 1, vectors.size()));

        result.add(trainingData);
        result.add(testData);
        return result;
    }

    /**
     * read data from file
     *
     * @param filename the file with this name should contain a serialized
     * List<FeatureVector> containt all the data
     * @reeturn all the data
     */
    private List<FeatureVector> readData(String filename) {
        List<FeatureVector> vectors = null;
        try {
            ObjectInputStream in
                    = new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)));
            vectors = (List<FeatureVector>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException t) {
            System.out.println("Could not read Data from file: " + filename);
            System.exit(1);
        }
        return vectors;
    }

    /**
     * run the program with training set provided in file with name given in
     * first parameter
     *
     * @param args 1. filename of Serialiszed List<FeatureVector>
     */
    public static void main(String[] args) {
        String filename = null;
        if (args.length == 0) {
            System.out.println("No data file provided, using dummy data: DummyData.dat");
            filename = "TomsFeatureVectors.dat";
        } else {
            filename = args[0];
        }

        int[] testRates = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] learingTerms = {50, 10, 150, 200, 250, 300, 400, 500};

        for (int i = 0; i < testRates.length; i++) {
            for (int j = 0; j < learingTerms.length; j++) {
                tests(filename, testRates[i], learingTerms[j]);
            }
        }
    }

    public static void tests(String filename, int testRate, int learingTerms) {
        System.out.println("First Evaluation run:");
        System.out.println("numberof Tests:\t100");
        System.out.println("Testrate:\t" + testRate);
        System.out.println("LearingTerms:\t" + learingTerms);
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyVorfahrtStrasse
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyVorfahrtStrasse(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyRight
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyRight(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyLeft
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyLeft(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyStop
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyStop(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyVorGew
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyVorfahrtGewaehren(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorOnlyVonRechts
                = new PerzeptronNetworkEvaluator(
                        filename, new OnlyVorfahrtvonRechts(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorMapping6
                = new PerzeptronNetworkEvaluator(
                        filename, new Mapping6(),testRate, 100,learingTerms);
        System.out.println("");
        PerzeptronNetworkEvaluator perzeptronNetworkEvaluatorMapping3
                = new PerzeptronNetworkEvaluator(
                        filename, new Mapping3(),testRate, 100,learingTerms);
        System.out.println("");
    }

}
