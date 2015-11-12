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

/**
 *
 * @author toschu
 */
public class PerzeptronNetwork {

    private String name;
    private List<Perzeptron> perzeptrons;
    private Map<Concept, List<Perzeptron>> mappingConceptToPerzeptron;

    public PerzeptronNetwork(List<Perzeptron> perzeptrons) {
        this.perzeptrons = perzeptrons;
        this.mappingConceptToPerzeptron = new HashMap<>();
    }

    public PerzeptronNetwork() {
        perzeptrons = new ArrayList<>();
        mappingConceptToPerzeptron = new HashMap<>();
    }

    public boolean addPerzeptron(Perzeptron p) {
        if (perzeptrons.contains(p)) {
            perzeptrons.remove(p);
        }
        return perzeptrons.add(p);
    }

    public List<Perzeptron> getPerzeptrons() {
        return perzeptrons;
    }

    public void setPerzeptrons(List<Perzeptron> perzeptrons) {
        this.perzeptrons = perzeptrons;
    }

    public Map<Concept, List<Perzeptron>> getMappingConceptToPerzeptron() {
        return mappingConceptToPerzeptron;
    }

    public void setMappingConceptToPerzeptron(Map<Concept, List<Perzeptron>> mappingConceptToPerzeptron) {
        this.mappingConceptToPerzeptron = mappingConceptToPerzeptron;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PerzeptronNetwork{" + "name=" + name + "\n"
                + "\t" + ", perzeptrons=" + perzeptrons + "\n"
                + "\t" + ", mappingConceptToPerzeptron=" + mappingConceptToPerzeptron + "\n"
                + "\t" + "}";
    }

}
