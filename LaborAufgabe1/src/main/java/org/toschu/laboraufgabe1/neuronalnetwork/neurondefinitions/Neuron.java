/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions;

import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public abstract class Neuron {

    public abstract String getName();

    public abstract void addInput(NeuronalEdge edge);

    public abstract Double getOutput();

    public abstract Double computeOutPut(FeatureVector feature);
}
