/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.toschu.laboraufgabe1.framework.FeatureVector;
import org.toschu.laboraufgabe1.neuronalnetwork.networks.Mapping3;
import org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions.InputNeuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions.Neuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions.NeuronalEdge;

/**
 *
 * @author toschu
 */
public class Perzeptron extends Neuron {

    private Double output = 0.0;
    private List<NeuronalEdge> inputs;
    private String name;

    public Perzeptron() {
        this.inputs = new ArrayList<>();
    }

    public Perzeptron(Double output, List<NeuronalEdge> inputs, String name) {
        this.output = output;
        this.inputs = inputs;
        this.name = name;
    }

    @Override
    public Double computeOutPut(FeatureVector feature) {
        Double sumInput = computeSum(feature);
        if (sumInput < 0.0) {
            output = 0.0;
        } else {
            output = 1.0;
        }
        return output;
    }

    public Double computeSum(FeatureVector featureVector) {
        Double sumInput = 0.0;
        for (NeuronalEdge currentEdge : inputs) {
            currentEdge.getSource().computeOutPut(featureVector);
            sumInput += currentEdge.getWeight() 
                    * currentEdge.getSource().getOutput()
                    * currentEdge.inhibitoryValue();
        }
        return sumInput;
    }

    @Override
    public Double getOutput() {
        return output;
    }

    @Override
    public void addInput(NeuronalEdge edge) {
        if (this.inputs.contains(edge)) {
            this.inputs.remove(edge);
        }
        boolean add = this.inputs.add(edge);
    }

    public void correctCosts(FeatureVector featureVector, Double sum) {
        if (sum >= 0.0) {
            for (NeuronalEdge currentInputEdge : inputs) {
                InputNeuron currentinputNeuron = (InputNeuron) currentInputEdge.getSource();
                if (currentinputNeuron.getName().equals(InputNeuron.getNeutralElement())) {
                    continue;
                }
                currentInputEdge.setWeight(
                        currentInputEdge.getWeight()
                        + featureVector.getFeatureValue(
                                currentinputNeuron.getFeature().getValue()));

            }
        } else {
            for (NeuronalEdge currentInputEdge : inputs) {
                InputNeuron currentinputNeuron = (InputNeuron) currentInputEdge.getSource();
                if (currentinputNeuron.getName().equals(InputNeuron.getNeutralElement())) {
                    continue;
                }
                currentInputEdge.setWeight(
                        currentInputEdge.getWeight()
                        - featureVector.getFeatureValue(
                                currentinputNeuron.getFeature().getValue()));

            }
        }

    }

    public void setOutput(Double output) {
        this.output = output;
    }

    public List<NeuronalEdge> getInputs() {
        return inputs;
    }

    public void setInputs(List<NeuronalEdge> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perzeptron other = (Perzeptron) obj;
        if (!Objects.equals(this.output, other.output)) {
            return false;
        }
        if (!Objects.equals(this.inputs, other.inputs)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nPerzeptron{\n"
                + "\t" + "name=" + name + "\n"
                + "\t" + "output=" + output + "\n"
                + "\t" + "inputs=" + inputs + "\n"
                + "}";
    }


}
