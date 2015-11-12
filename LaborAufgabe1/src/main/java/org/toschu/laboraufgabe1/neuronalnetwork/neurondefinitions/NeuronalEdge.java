/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions;

import java.util.Random;

/**
 *
 * @author toschu
 */
public class NeuronalEdge {

    private Neuron source;
    private Neuron destination;
    private double weight;
    private boolean inhibitory;

    public NeuronalEdge(Neuron source, Neuron destination,
            double weight, boolean inhibitory) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.inhibitory = inhibitory;
        this.destination.addInput(this);
    }

    public NeuronalEdge(Neuron source, Neuron destination, boolean inhibitory) {
        this.source = source;
        this.destination = destination;
        this.inhibitory = inhibitory;
        this.destination.addInput(this);
        initialize();
    }

    public void initialize() {
        Random random = new Random();
        this.weight = random.nextDouble();
    }

    public NeuronalEdge clone() {
        return new NeuronalEdge(source, destination, weight, inhibitory);
    }

    public Neuron getSource() {
        return source;
    }

    public void setSource(Neuron source) {
        this.source = source;
    }

    public Neuron getDestination() {
        return destination;
    }

    public void setDestination(Neuron destination) {
        destination.addInput(this);
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isInhibitory() {
        return inhibitory;
    }

    public void setInhibitory(boolean inhibitory) {
        this.inhibitory = inhibitory;
    }

    @Override
    public String toString() {
        return " \nNeuronalEdge{\n"
                + "\t" + "source=" + source.getName() + "\n"
                + "\t" + ", destination=" + destination.getName() + "\n"
                + "\t" + ", weight=" + weight + "\n"
                + "\t" + ", inhibitory=" + inhibitory + "\n"
                + '}';
    }

    public double inhibitoryValue() {
        if (this.inhibitory) {
            return -1.0;
        } else {
            return 1.0;
        }
    }

}
