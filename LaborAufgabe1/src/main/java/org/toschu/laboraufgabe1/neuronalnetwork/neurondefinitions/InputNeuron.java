/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions;

import org.toschu.laboraufgabe1.featurdefinitions.Feature;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class InputNeuron extends Neuron {

    private Double output;
    private String name;
    private Feature feature;
    private final static String neutralElement = "neutral";

    public InputNeuron(Double output, String name, Feature feature) {
        this.output = output;
        this.name = name;
        this.feature = feature;
    }

    @Override
    public Double getOutput() {
        return this.output;
    }

    @Override
    public Double computeOutPut(FeatureVector featureVector) {
        if (this.feature == null) {
            this.output = -1.0;
        } else {
            int value = featureVector.getFeatureValue(this.feature.getValue());
            this.output = new Double(value);
        }
        //System.out.println(this.name + ":\t" + this.output);
        return this.output;
    }

    @Override
    public void addInput(NeuronalEdge edge) {
    }

    public Double getInput() {
        return output;
    }

    public void setInput(Double input) {
        this.output = input;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNeutralElement() {
        return neutralElement;
    }

    @Override
    public String toString() {
        return "\nInputNeuron{\n"
                + "\t" + "input=" + output + "\n"
                + "\t" + ", name=" + name + "\n"
                + "\t" + ", feature=" + feature + "\n"
                + '}';
    }

}
