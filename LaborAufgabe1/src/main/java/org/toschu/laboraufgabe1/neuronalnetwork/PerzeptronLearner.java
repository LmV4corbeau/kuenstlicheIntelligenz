/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;
import org.toschu.laboraufgabe1.framework.Learner;

/**
 *
 * @author toschu
 */
public class PerzeptronLearner implements Learner {

    private PerzeptronNetwork perzeptronNetwork;
    private Map<Concept, List<Perzeptron>> mappingConceptsToOutput;
    private int learingRate = 50;

    public PerzeptronLearner(PerzeptronNetwork perzeptronNetwork,
            Map<Concept, List<Perzeptron>> mappingConceptsToOutput, int learningRate) {
        this.perzeptronNetwork = perzeptronNetwork;
        this.mappingConceptsToOutput = mappingConceptsToOutput;
        this.learingRate = learningRate;
    }

    @Override
    public void learn(List<FeatureVector> trainingSet) {
        //System.out.println("Netowrk:");
        //System.out.println(perzeptronNetwork.toString());
        for (int i = 0; i < learingRate; i++) {
            for (FeatureVector currentFeatureVector : trainingSet) {
                giveInputsToNetworks(currentFeatureVector);
                Concept classified = classify(currentFeatureVector);
                if (!classified.equals(currentFeatureVector.getConcept())) {
                    List<Perzeptron> conceptPerzeptrons
                            = mappingConceptsToOutput.get(currentFeatureVector.getConcept());
                    if (conceptPerzeptrons == null) {
                        conceptPerzeptrons = new ArrayList<>();
                    }
                    for (Perzeptron currentNetworkPerzeptron
                            : perzeptronNetwork.getPerzeptrons()) {
                        for (Perzeptron currentConceptPerzeptron : conceptPerzeptrons) {
                            if (currentNetworkPerzeptron.getName().equals(
                                    currentConceptPerzeptron.getName())) {
                                double perSum
                                        = currentNetworkPerzeptron.computeSum(
                                                currentFeatureVector);
                                currentNetworkPerzeptron
                                        .correctCosts(currentFeatureVector, perSum);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Concept classify(FeatureVector example) {
        List<Perzeptron> networkPerzeptrons = perzeptronNetwork.getPerzeptrons();
        Concept result = Concept.Unknown;
        //System.out.println("soll:\t" + example.getConcept());
        networkPerzeptrons.stream().forEach((current) -> {
            current.computeOutPut(example);
        });
        Map<Concept, Boolean> results = new HashMap<>();
        for (Concept currentConcept
                : mappingConceptsToOutput.keySet()) {
            results.put(currentConcept,
                    equalsPerzeptronOutputs(
                            mappingConceptsToOutput.get(currentConcept),
                            networkPerzeptrons));
        }
        ////System.out.println(results);
        int matches = 0;
        for (Boolean currentResult : results.values()) {
            if (currentResult) {
                matches++;
            }
        }
        if (matches == 1) {
            for (Concept currentConcept : results.keySet()) {
                if (results.get(currentConcept)) {
                    result = currentConcept;
                }
            }
        }
        return result;
    }

    public boolean equalsPerzeptronOutputs(List<Perzeptron> conceptValues,
            List<Perzeptron> networkPerzeptrons) {
        //TODO FALSCH nochmal machen
        if (conceptValues.isEmpty()) {
            return false;
        }
        if (networkPerzeptrons.isEmpty()) {
            return false;
        }
        for (Perzeptron networkPerzeptron : networkPerzeptrons) {
            for (Perzeptron conceptPerzeptron : conceptValues) {
                if (networkPerzeptron.getName()
                        .equals(conceptPerzeptron.getName())) {
                    ////System.out.println("");
                    ////System.out.println(networkPerzeptron.getName());
                    ////System.out.println("network:\t" + networkPerzeptron.getOutput());
                    //System.out.println("concept:\t" + conceptPerzeptron.getOutput());
                    if (networkPerzeptron.getOutput().compareTo(
                            conceptPerzeptron.getOutput()) == 0) {
                        //System.out.println("eq");

                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void giveInputsToNetworks(FeatureVector featureVector) {
        for (Perzeptron currentNetworkPerzeptron
                : perzeptronNetwork.getPerzeptrons()) {
            currentNetworkPerzeptron.computeOutPut(featureVector);
        }
    }
}
