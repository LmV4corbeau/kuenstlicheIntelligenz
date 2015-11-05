/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;
import org.toschu.laboraufgabe1.framework.Learner;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.InputNeuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.NeuronalEdge;

/**
 *
 * @author toschu
 */
public class PerzeptronNetwork implements Learner {

    private List<InputNeuron> inputs;
    private List<Perzeptron> perzeptrons;
    private List<FeatureVector> positivExamples;
    private List<FeatureVector> negativExamples;
    private List<FeatureVector> examples;
    private Map<Concept, List<Perzeptron>> mappingConceptsToOutput;

    public PerzeptronNetwork() {
        inputs = new ArrayList<>();
        perzeptrons = new ArrayList<>();
        positivExamples = new ArrayList<>();
        negativExamples = new ArrayList<>();
        examples = new ArrayList<>();
        mappingConceptsToOutput = new HashMap<>();
    }

    @Override
    public void learn(List<FeatureVector> trainingSet) {
        buildExamplsList();
        for (FeatureVector currentFeatureVector : examples) {
            Concept result = classify(currentFeatureVector);
            if (result.equals(currentFeatureVector.getConcept())) {
                continue;
            } else {
                List<Perzeptron> conpectPerzeptrons
                        = mappingConceptsToOutput.get(currentFeatureVector.getConcept());

                for (Perzeptron currentConceptPerzeptron : conpectPerzeptrons) {
                    for (Perzeptron currentNetworkPerzeptron : perzeptrons) {
                        if (currentNetworkPerzeptron.getName()
                                .equals(currentConceptPerzeptron.getName())) {
                            if (currentConceptPerzeptron.getOutput() > 0.0) {
                                positivExample(currentNetworkPerzeptron, currentFeatureVector);
                            } else {
                                negativExample(currentNetworkPerzeptron, currentFeatureVector);
                            }
                        }
                    }
                }
            }
        }
        perzeptrons.stream().forEach((Perzeptron current) -> {
            current.setOutput(0.0);
        });
    }

    public void positivExample(Perzeptron perzeptron, FeatureVector example) {
        for (NeuronalEdge currentEdge : perzeptron.getInputs()) {
            InputNeuron currentInputNeuron = (InputNeuron) currentEdge.getSource();
            int value = example.getFeatureValue(currentInputNeuron.getFeature().getValue());
            currentEdge.setWeight(currentEdge.getWeight() + value);
        }
    }

    public void negativExample(Perzeptron perzeptron, FeatureVector example) {
        for (NeuronalEdge currentEdge : perzeptron.getInputs()) {
            InputNeuron currentInputNeuron = (InputNeuron) currentEdge.getSource();
            int value = example.getFeatureValue(currentInputNeuron.getFeature().getValue());
            currentEdge.setWeight(currentEdge.getWeight() - value);
        }
    }

    @Override
    public Concept classify(FeatureVector example) {
        Concept result = Concept.Unknown;
        setInputInNetwork(example);
        computeOutputInNetwork();
        Map<Concept, Boolean> results = new HashMap<>();
        for (Concept currentConcept
                : mappingConceptsToOutput.keySet()) {
            results.put(currentConcept,
                    equalsPerzeptronOutputs(
                            mappingConceptsToOutput.get(currentConcept)));
        }
        int matches = 0;
        for (Boolean currentResult : results.values()) {
            if (currentResult) {
                matches++;
            }
        }
        if (matches == 1) {
            for (Iterator<Concept> it = results.keySet().iterator(); it.hasNext();) {
                Concept currentConcept = it.next();
                if (results.get(currentConcept)) {
                    result = currentConcept;
                }
            }
        } else {
            result = Concept.Unknown;
        }
        return result;
    }

    public boolean equalsPerzeptronOutputs(List<Perzeptron> conceptValues) {
        for (Perzeptron conceptPerzeptron : conceptValues) {
            for (Perzeptron perzeptron : this.perzeptrons) {
                if (!conceptPerzeptron.equals(perzeptron)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void computeOutputInNetwork() {
        for (Perzeptron currentpPerzeptron : perzeptrons) {
            currentpPerzeptron.computeOutPut();
            System.out.println(currentpPerzeptron.getName()
                    + ":\t" + currentpPerzeptron.getOutput());
        }
    }

    public void setInputInNetwork(FeatureVector example) {
        for (InputNeuron currentInputNeuron : inputs) {
            currentInputNeuron
                    .setInput(
                            example.getFeatureValue(
                                    currentInputNeuron.getFeature().getValue()));
        }
    }

    public void buildExamplsList() {
        examples = new ArrayList<>();
        positivExamples.stream().forEach((currentFeatureVector) -> {
            examples.add(currentFeatureVector);
        });
        negativExamples.stream().forEach((currentFeatureVector) -> {
            examples.add(currentFeatureVector);
        });
        Collections.shuffle(examples);
    }

    public List<InputNeuron> getInputs() {
        return inputs;
    }

    public void setInputs(List<InputNeuron> inputs) {
        this.inputs = inputs;
    }

    public List<Perzeptron> getPerzeptrons() {
        return perzeptrons;
    }

    public void setPerzeptrons(List<Perzeptron> perzeptrons) {
        this.perzeptrons = perzeptrons;
    }

    public List<FeatureVector> getPositivExamples() {
        return positivExamples;
    }

    public void setPositivExamples(List<FeatureVector> positivExamples) {
        this.positivExamples = positivExamples;
    }

    public List<FeatureVector> getNegativExamples() {
        return negativExamples;
    }

    public void setNegativExamples(List<FeatureVector> negativExamples) {
        this.negativExamples = negativExamples;
    }

    public List<FeatureVector> getExamples() {
        return examples;
    }

    public void setExamples(List<FeatureVector> examples) {
        this.examples = examples;
    }

    public Map<Concept, List<Perzeptron>> getMappingConceptsToOutput() {
        return mappingConceptsToOutput;
    }

    public void setMappingConceptsToOutput(Map<Concept, List<Perzeptron>> mappingConceptsToOutput) {
        this.mappingConceptsToOutput = mappingConceptsToOutput;
    }

    @Override
    public String toString() {
        return "\nPerzeptronNetwork{\n"
                +"\t"+ "inputs=" + inputs + "\n"
                +"\t"+ ", perzeptrons=" + perzeptrons + "\n"
                +"\t"+ ", positivExamples=" + positivExamples + "\n"
                +"\t"+ ", negativExamples=" + negativExamples + "\n"
                +"\t"+ ", examples=" + examples + "\n"
                +"\t"+ ", mappingConceptsToOutput=" + mappingConceptsToOutput + "\n"
                + '}';
    }

}
