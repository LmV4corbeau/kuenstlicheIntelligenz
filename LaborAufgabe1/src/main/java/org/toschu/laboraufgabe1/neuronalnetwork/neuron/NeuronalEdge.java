/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.neuron;

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
            double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.inhibitory = inhibitory;
        this.destination.addInput(this);
    }

    public NeuronalEdge clone() {
        return new NeuronalEdge(source, destination, weight);
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

}
