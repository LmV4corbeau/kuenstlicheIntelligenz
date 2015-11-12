/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.networks;

import java.util.ArrayList;
import java.util.List;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.neuronalnetwork.Perzeptron;
import org.toschu.laboraufgabe1.neuronalnetwork.PerzeptronNetwork;

/**
 *
 * @author toschu
 */
public class Mapping3 extends PerzeptronNetwork {

    private Perzeptron binaer2hoch0;
    private Perzeptron binaer2hoch1;
    private Perzeptron binaer2hoch2;

    public Mapping3() {
        super(new ArrayList<>());
        init();
        vorfahrtConcept();
    }

    public void init() {

    }

    public void vorfahrtConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(1.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(0.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.Vorfahrtsstraße, perzeptrons);
    }
    
    public void rechtsConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(0.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(1.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.RechtsAbbiegen, perzeptrons);
    }
    
    public void linksConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(1.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(1.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.LinksAbbiegen, perzeptrons);
    }
    
    public void StopConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(0.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(0.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(1.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.Stop, perzeptrons);
    }
    
    public void vorfahrtGewConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(1.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(0.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(1.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.Vorfahrt, perzeptrons);
    }
    
    public void vorfahrtVonRechtsConcept() {
        Perzeptron bin2hoch0 = new Perzeptron();
        bin2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        bin2hoch0.setOutput(1.0);
        Perzeptron bin2hoch1 = new Perzeptron();
        bin2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        bin2hoch1.setOutput(1.0);
        Perzeptron bin2hoch2 = new Perzeptron();
        bin2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        bin2hoch2.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(bin2hoch0);
        perzeptrons.add(bin2hoch1);
        perzeptrons.add(bin2hoch2);

        super.getMappingConceptToPerzeptron().put(
                Concept.VorfahrtVonRechts, perzeptrons);
    }

    public enum BinaryNames {

        ZweiHOCHNull,
        ZweiHOCHEINS,
        ZweiHOCHZWEI
    }
}
