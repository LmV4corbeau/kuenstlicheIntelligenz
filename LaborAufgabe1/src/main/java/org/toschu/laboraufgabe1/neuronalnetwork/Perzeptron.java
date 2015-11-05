/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.Neuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.NeuronalEdge;

/**
 *
 * @author toschu
 */
public class Perzeptron extends Neuron {

    private double output;
    private List<NeuronalEdge> inputs;
    private String name;

    public Perzeptron() {
        this.inputs = new ArrayList<>();
    }

    public Perzeptron(double output, List<NeuronalEdge> inputs, String name) {
        this.output = output;
        this.inputs = inputs;
        this.name = name;
    }

    @Override
    public void computeOutPut() {
        double sumInput = 0.0;
        for (NeuronalEdge currentEdge : inputs) {
            currentEdge.getSource().computeOutPut();
            sumInput += currentEdge.getWeight() * currentEdge.getSource().getOutput();
        }
        if (sumInput < 0.0) {
            output = 1.0;
        } else {
            output = 0.0;
        }
    }

    @Override
    public double getOutput() {
        computeOutPut();
        return output;
    }

    @Override
    public void addInput(NeuronalEdge edge) {
        if (this.inputs.contains(edge)) {
            this.inputs.remove(edge);
        }
        boolean add = this.inputs.add(edge);
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public List<NeuronalEdge> getInputs() {
        return inputs;
    }

    public void setInputs(List<NeuronalEdge> inputs) {
        this.inputs = inputs;
    }

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
        if (Double.doubleToLongBits(this.output) != Double.doubleToLongBits(other.output)) {
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
