/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.networks;

import java.util.ArrayList;
import java.util.List;
import org.toschu.laboraufgabe1.featurdefinitions.Feature;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.neuronalnetwork.Perzeptron;
import org.toschu.laboraufgabe1.neuronalnetwork.PerzeptronNetwork;
import org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions.InputNeuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neurondefinitions.NeuronalEdge;

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
        super.setName(this.getClass().getSimpleName());
        init();
        vorfahrtConcept();
        linksConcept();
        rechtsConcept();
        StopConcept();
        vorfahrtGewConcept();
        vorfahrtVonRechtsConcept();
    }

    public void init() {

        //INPUTS
        InputNeuron RED_AND_BLACK
                = new InputNeuron(0.0,
                        Feature.RED_AND_BLACK.toString(),
                        Feature.RED_AND_BLACK);
        InputNeuron MAX_RED_PART_IN_HORIZONTAL_PART
                = new InputNeuron(0.0,
                        Feature.MAX_RED_PART_IN_HORIZONTAL_PART.toString(),
                        Feature.MAX_RED_PART_IN_HORIZONTAL_PART);
        InputNeuron WHITE_PART_IN_PICTURE_TO_RED
                = new InputNeuron(0.0,
                        Feature.WHITE_PART_IN_PICTURE_TO_RED.toString(),
                        Feature.WHITE_PART_IN_PICTURE_TO_RED);
        InputNeuron MAX_WHITE_PART_TO_BLUE_IN_QUADRANT
                = new InputNeuron(0.0,
                        Feature.MAX_WHITE_PART_TO_BLUE_IN_QUADRANT.toString(),
                        Feature.MAX_WHITE_PART_TO_BLUE_IN_QUADRANT);
        InputNeuron MAX_COLOR_WITHOUT_WHITE
                = new InputNeuron(0.0,
                        Feature.MAX_COLOR_WITHOUT_WHITE.toString(),
                        Feature.MAX_COLOR_WITHOUT_WHITE);
        InputNeuron PIXELCOUNT = new InputNeuron(0.0,
                Feature.PIXELCOUNT.toString(),
                Feature.PIXELCOUNT);
        InputNeuron BLUECOUNT = new InputNeuron(0.0,
                Feature.BLUECOUNT.toString(),
                Feature.BLUECOUNT);
        InputNeuron YELLOWCOUNT = new InputNeuron(0.0,
                Feature.YELLOWCOUNT.toString(),
                Feature.YELLOWCOUNT);
        InputNeuron REDCOUNT = new InputNeuron(0.0,
                Feature.REDCOUNT.toString(),
                Feature.REDCOUNT);
        InputNeuron WHITECOUNT = new InputNeuron(0.0,
                Feature.WHITECOUNT.toString(),
                Feature.WHITECOUNT);
        InputNeuron BLACKCOUNT = new InputNeuron(0.0,
                Feature.BLACKCOUNT.toString(),
                Feature.BLACKCOUNT);

        this.binaer2hoch0 = new Perzeptron();
        this.binaer2hoch0.setName(BinaryNames.ZweiHOCHNull.name());
        InputNeuron neutral20 = new InputNeuron(-1.0, InputNeuron.getNeutralElement(), null);
        NeuronalEdge neutralST20 = new NeuronalEdge(neutral20, this.binaer2hoch0, 1.0, false);
        this.binaer2hoch1 = new Perzeptron();
        this.binaer2hoch1.setName(BinaryNames.ZweiHOCHEINS.name());
        InputNeuron neutral21 = new InputNeuron(-1.0, InputNeuron.getNeutralElement(), null);
        NeuronalEdge neutralST21 = new NeuronalEdge(neutral21, this.binaer2hoch1, 1.0, false);
        this.binaer2hoch2 = new Perzeptron();
        this.binaer2hoch2.setName(BinaryNames.ZweiHOCHZWEI.name());
        InputNeuron neutral22 = new InputNeuron(-1.0, InputNeuron.getNeutralElement(), null);
        NeuronalEdge neutralST22 = new NeuronalEdge(neutral22, this.binaer2hoch2, 1.0, false);

        //2^0
        NeuronalEdge bin20MRHP
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART,
                        this.binaer2hoch0, false);
        NeuronalEdge bin20RiHP
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART,
                        this.binaer2hoch0, false);
        NeuronalEdge bin20Yellow
                = new NeuronalEdge(YELLOWCOUNT,
                        this.binaer2hoch0, false);
        NeuronalEdge bin20QMB
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT,
                        this.binaer2hoch0, false);
        NeuronalEdge bin20HP
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, binaer2hoch0, true);

        //2^1
        NeuronalEdge bin21BC
                = new NeuronalEdge(BLUECOUNT, binaer2hoch1, false);
        NeuronalEdge bin21RAB
                = new NeuronalEdge(RED_AND_BLACK, binaer2hoch1, false);
        NeuronalEdge bin21Y
                = new NeuronalEdge(YELLOWCOUNT, binaer2hoch1, true);

        //2^2
        NeuronalEdge bin22R
                = new NeuronalEdge(REDCOUNT, binaer2hoch2, false);
        NeuronalEdge bin22Y
                = new NeuronalEdge(YELLOWCOUNT, binaer2hoch1, true);
        NeuronalEdge bin22b
                = new NeuronalEdge(BLUECOUNT, binaer2hoch1, true);
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
