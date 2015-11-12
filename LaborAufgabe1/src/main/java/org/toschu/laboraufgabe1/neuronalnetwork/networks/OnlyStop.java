/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.neuronalnetwork.networks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class OnlyStop extends PerzeptronNetwork {

    private Perzeptron stop;

    public OnlyStop() {
        super(new ArrayList<>());
        super.setName(this.getClass().getSimpleName());
        init();
        super.setMappingConceptToPerzeptron(mapping());
    }

    private void init() {
        stop = new Perzeptron();
        stop.setName(Concept.Stop.name());
        super.getPerzeptrons().add(stop);

        //INPUTS
        InputNeuron RED_AND_BLACK
                = new InputNeuron(0.0,
                        Feature.RED_AND_BLACK.name(),
                        Feature.RED_AND_BLACK);
        InputNeuron MAX_RED_PART_IN_HORIZONTAL_PART
                = new InputNeuron(0.0,
                        Feature.MAX_RED_PART_IN_HORIZONTAL_PART.name(),
                        Feature.MAX_RED_PART_IN_HORIZONTAL_PART);
        InputNeuron WHITE_PART_IN_PICTURE_TO_RED
                = new InputNeuron(0.0,
                        Feature.WHITE_PART_IN_PICTURE_TO_RED.name(),
                        Feature.WHITE_PART_IN_PICTURE_TO_RED);
        InputNeuron MAX_WHITE_PART_TO_BLUE_IN_QUADRANT
                = new InputNeuron(0.0,
                        Feature.MAX_WHITE_PART_TO_BLUE_IN_QUADRANT.name(),
                        Feature.MAX_WHITE_PART_TO_BLUE_IN_QUADRANT);
        InputNeuron MAX_COLOR_WITHOUT_WHITE
                = new InputNeuron(0.0,
                        Feature.MAX_COLOR_WITHOUT_WHITE.name(),
                        Feature.MAX_COLOR_WITHOUT_WHITE);
        InputNeuron PIXELCOUNT = new InputNeuron(0.0,
                Feature.PIXELCOUNT.name(),
                Feature.PIXELCOUNT);
        InputNeuron BLUECOUNT = new InputNeuron(0.0,
                Feature.BLUECOUNT.name(),
                Feature.BLUECOUNT);
        InputNeuron YELLOWCOUNT = new InputNeuron(0.0,
                Feature.YELLOWCOUNT.name(),
                Feature.YELLOWCOUNT);
        InputNeuron REDCOUNT = new InputNeuron(0.0,
                Feature.REDCOUNT.name(),
                Feature.REDCOUNT);
        InputNeuron WHITECOUNT = new InputNeuron(0.0,
                Feature.WHITECOUNT.name(),
                Feature.WHITECOUNT);
        InputNeuron BLACKCOUNT = new InputNeuron(0.0,
                Feature.BLACKCOUNT.name(),
                Feature.BLACKCOUNT);
        InputNeuron NOREDANDBLUE = new InputNeuron(0.0,
                Feature.NOREDANDBLUE.name(), Feature.REDCOUNT);

        InputNeuron neutral = new InputNeuron(-1.0, InputNeuron.getNeutralElement(), null);
        NeuronalEdge neutralVorsST = new NeuronalEdge(neutral, stop, 1.0, false);

        NeuronalEdge RedCount
                = new NeuronalEdge(REDCOUNT, stop, false);
        NeuronalEdge maxcolor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, stop, false);
        NeuronalEdge blue
                = new NeuronalEdge(BLUECOUNT, stop, true);
        NeuronalEdge yellow
                = new NeuronalEdge(YELLOWCOUNT, stop, true);
    }

    public static Map<Concept, List<Perzeptron>> mapping() {
        Map<Concept, List<Perzeptron>> mappingConceptToPerzeptrontmp
                = new HashMap<>();
        Perzeptron stopConcept = new Perzeptron();
        stopConcept.setName(Concept.Stop.name());
        stopConcept.setOutput(1.0);
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(stopConcept);
        mappingConceptToPerzeptrontmp.put(Concept.Stop, perzeptrons);
        return mappingConceptToPerzeptrontmp;
    }

}
