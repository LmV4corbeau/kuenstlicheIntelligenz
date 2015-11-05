/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.neuron;

import org.toschu.laboraufgabe1.featurdefinitions.Feature;

/**
 *
 * @author toschu
 */
public class InputNeuron extends Neuron {

    private double input;
    private String name;
    private Feature feature;

    public InputNeuron(double input, String name, Feature feature) {
        this.input = input;
        this.name = name;
        this.feature = feature;
    }

    @Override
    public double getOutput() {
        return this.input;
    }

    @Override
    public void computeOutPut() {
    }

    @Override
    public void addInput(NeuronalEdge edge) {
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
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

    @Override
    public String toString() {
        return "\nInputNeuron{\n"
                + "\t" + "input=" + input + "\n"
                + "\t" + ", name=" + name + "\n"
                + "\t" + ", feature=" + feature + "\n"
                + '}';
    }

}
