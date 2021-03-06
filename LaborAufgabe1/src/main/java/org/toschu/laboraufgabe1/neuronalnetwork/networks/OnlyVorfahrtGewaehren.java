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
public class OnlyVorfahrtGewaehren extends PerzeptronNetwork {

    private Perzeptron vorfahrtgew;

    public OnlyVorfahrtGewaehren() {
        super(new ArrayList<>());
        super.setName(this.getClass().getSimpleName());
        init();
        super.setMappingConceptToPerzeptron(mapping());
    }

    private void init() {
        vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Stop.name());
        super.getPerzeptrons().add(vorfahrtgew);

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
        InputNeuron NOREDANDBLUE = new InputNeuron(0.0,
                Feature.NOREDANDBLUE.name(), Feature.REDCOUNT);

        InputNeuron neutral = new InputNeuron(-1.0, InputNeuron.getNeutralElement(), null);
        NeuronalEdge neutralVorsST = new NeuronalEdge(neutral, vorfahrtgew, 1.0, false);

        NeuronalEdge RedCount
                = new NeuronalEdge(REDCOUNT, vorfahrtgew, false);
        NeuronalEdge maxWithInHorizontal
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, vorfahrtgew, false);
        NeuronalEdge WithCount
                = new NeuronalEdge(WHITECOUNT, vorfahrtgew, false);
        NeuronalEdge withToRed
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, vorfahrtgew, false);
        NeuronalEdge blue
                = new NeuronalEdge(BLUECOUNT, vorfahrtgew, true);
        NeuronalEdge yellow
                = new NeuronalEdge(YELLOWCOUNT, vorfahrtgew, true);
        NeuronalEdge RUB
                = new NeuronalEdge(RED_AND_BLACK, vorfahrtgew, true);
        NeuronalEdge mrihp
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, vorfahrtgew,true);
        
    }

    public static Map<Concept, List<Perzeptron>> mapping() {
        Map<Concept, List<Perzeptron>> mappingConceptToPerzeptrontmp
                = new HashMap<>();
        Perzeptron stopConcept = new Perzeptron();
        stopConcept.setName(Concept.Vorfahrt.name());
        stopConcept.setOutput(1.0);
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(stopConcept);
        mappingConceptToPerzeptrontmp.put(Concept.Vorfahrt, perzeptrons);
        return mappingConceptToPerzeptrontmp;
    }
}
