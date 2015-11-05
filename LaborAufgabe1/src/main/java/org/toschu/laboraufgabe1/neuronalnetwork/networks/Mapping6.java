package org.toschu.laboraufgabe1.neuronalnetwork.networks;

import java.util.ArrayList;
import java.util.List;
import org.toschu.laboraufgabe1.featurdefinitions.Feature;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.neuronalnetwork.Perzeptron;
import org.toschu.laboraufgabe1.neuronalnetwork.PerzeptronNetwork;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.InputNeuron;
import org.toschu.laboraufgabe1.neuronalnetwork.neuron.NeuronalEdge;

/**
 *
 * @author toschu
 */
public class Mapping6 extends PerzeptronNetwork {

    private Perzeptron vorfahrtsStraße;
    private Perzeptron vorfahrtGewaehren;
    private Perzeptron vorfahrtVonRecht;
    private Perzeptron stop;
    private Perzeptron fahrtNachLinks;
    private Perzeptron fahrtNachRechts;

    public Mapping6() {
        super();
        buildNetwork();
        buildVorfahrtConcept();
        buildVorfahrtGewConcept();
        buildVorfahrtRechtsConcept();
        buildStopConcept();
        buildNachLinksConcept();
        buildRechtsConcept();
    }

    public void buildNetwork() {
        vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName("Vorfahrt");
        vorfahrtGewaehren = new Perzeptron();
        vorfahrtGewaehren.setName("VorfahrtGewähren");
        vorfahrtVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        stop = new Perzeptron();
        stop.setName("Stop");
        fahrtNachLinks = new Perzeptron();
        fahrtNachLinks.setName("fahrtNachLinks");
        fahrtNachRechts = new Perzeptron();
        fahrtNachRechts.setName("fahrtNachRechts");
        super.getPerzeptrons().add(vorfahrtsStraße);
        super.getPerzeptrons().add(vorfahrtGewaehren);
        super.getPerzeptrons().add(vorfahrtVonRecht);
        super.getPerzeptrons().add(stop);
        super.getPerzeptrons().add(fahrtNachLinks);
        super.getPerzeptrons().add(fahrtNachRechts);

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
        super.getInputs().add(RED_AND_BLACK);
        super.getInputs().add(MAX_RED_PART_IN_HORIZONTAL_PART);
        super.getInputs().add(WHITE_PART_IN_PICTURE_TO_RED);
        super.getInputs().add(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT);
        super.getInputs().add(MAX_COLOR_WITHOUT_WHITE);
        super.getInputs().add(PIXELCOUNT);
        super.getInputs().add(BLUECOUNT);
        super.getInputs().add(YELLOWCOUNT);
        super.getInputs().add(REDCOUNT);
        super.getInputs().add(WHITECOUNT);
        super.getInputs().add(BLACKCOUNT);

        //Edges
        //YELLOW
        NeuronalEdge YelloCountToVorfahrt
                = new NeuronalEdge(YELLOWCOUNT, vorfahrtsStraße, 0.0);
        NeuronalEdge NegYelloCountToVorfahrtGewaehren
                = new NeuronalEdge(YELLOWCOUNT, vorfahrtGewaehren, -0.0);
        NeuronalEdge NegYelloCountToVorfahrtvonRechts
                = new NeuronalEdge(YELLOWCOUNT, vorfahrtVonRecht, -0.0);
        NeuronalEdge yellowStop
                = new NeuronalEdge(YELLOWCOUNT, stop, -0.0);
        NeuronalEdge linksYellow
                = new NeuronalEdge(YELLOWCOUNT, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsYellow
                = new NeuronalEdge(YELLOWCOUNT, fahrtNachRechts, -0.0);

        //REDC
        NeuronalEdge vorstrRed
                = new NeuronalEdge(REDCOUNT, vorfahrtsStraße, -0.0);
        NeuronalEdge vorGewRed
                = new NeuronalEdge(REDCOUNT, vorfahrtGewaehren, 0.0);
        NeuronalEdge vorRechtRed
                = new NeuronalEdge(REDCOUNT, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopRed
                = new NeuronalEdge(REDCOUNT, stop, 0.0);
        NeuronalEdge linksRed
                = new NeuronalEdge(REDCOUNT, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsRed
                = new NeuronalEdge(REDCOUNT, fahrtNachRechts, -0.0);

        //BlueC
        NeuronalEdge vorstrBlue
                = new NeuronalEdge(BLUECOUNT, vorfahrtsStraße, -0.0);
        NeuronalEdge vorGewBlue
                = new NeuronalEdge(BLUECOUNT, vorfahrtGewaehren, -0.0);
        NeuronalEdge vorRechtBlue
                = new NeuronalEdge(BLUECOUNT, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopBlue
                = new NeuronalEdge(BLUECOUNT, stop, -0.0);
        NeuronalEdge linksBlue
                = new NeuronalEdge(BLUECOUNT, fahrtNachLinks, 0.0);
        NeuronalEdge rechtsBlue
                = new NeuronalEdge(BLUECOUNT, fahrtNachRechts, 0.0);

        //BlackC
        NeuronalEdge vorstrBlack
                = new NeuronalEdge(BLACKCOUNT, vorfahrtsStraße, -0.0);
        NeuronalEdge vorGewBlack
                = new NeuronalEdge(BLACKCOUNT, vorfahrtGewaehren, 0.0);
        NeuronalEdge vorRechtBlack
                = new NeuronalEdge(BLACKCOUNT, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopBlack
                = new NeuronalEdge(BLACKCOUNT, stop, 0.0);
        NeuronalEdge linksBlack
                = new NeuronalEdge(BLACKCOUNT, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsBlack
                = new NeuronalEdge(BLACKCOUNT, fahrtNachRechts, -0.0);

        //MaxQuadrantBlue
        NeuronalEdge vorstrqmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, vorfahrtsStraße, -0.0);
        NeuronalEdge vorgewqmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, vorfahrtGewaehren, -0.0);
        NeuronalEdge vorrechtmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, vorfahrtVonRecht, -0.0);
        NeuronalEdge stopmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, stop, -0.0);
        NeuronalEdge linksmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, fahrtNachLinks, 0.0);
        NeuronalEdge rechtsmaxblue
                = new NeuronalEdge(MAX_WHITE_PART_TO_BLUE_IN_QUADRANT, fahrtNachRechts, -0.0);

        //MaxColorWithoutWhite
        NeuronalEdge vorstrMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, vorfahrtsStraße, 0.0);
        NeuronalEdge vorgewMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, vorfahrtGewaehren, 0.0);
        NeuronalEdge vorrechtsMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, stop, 0.0);
        NeuronalEdge linksMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, fahrtNachLinks, 0.0);
        NeuronalEdge rechtsMaxColor
                = new NeuronalEdge(MAX_COLOR_WITHOUT_WHITE, fahrtNachRechts, 0.0);

        //WHITEPARTINREDPART
        NeuronalEdge vorstrWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, vorfahrtsStraße, -0.0);
        NeuronalEdge vorgewWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, vorfahrtGewaehren, 0.0);
        NeuronalEdge vorrechtsWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, stop, 0.0);
        NeuronalEdge linksWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsWIR
                = new NeuronalEdge(WHITE_PART_IN_PICTURE_TO_RED, fahrtNachRechts, -0.0);

        //MaxRedinHPart
        NeuronalEdge vorstrMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, vorfahrtsStraße, -0.0);
        NeuronalEdge vorgewMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, vorfahrtGewaehren, 0.0);
        NeuronalEdge vorrechtMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, stop, 0.0);
        NeuronalEdge linksMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsMRIH
                = new NeuronalEdge(MAX_RED_PART_IN_HORIZONTAL_PART, fahrtNachRechts, -0.0);

        //RAB
        NeuronalEdge vorstrRAB
                = new NeuronalEdge(RED_AND_BLACK, vorfahrtsStraße, -0.0);
        NeuronalEdge vorgewRAB
                = new NeuronalEdge(RED_AND_BLACK, vorfahrtGewaehren, -0.0);
        NeuronalEdge vorrechtRAB
                = new NeuronalEdge(RED_AND_BLACK, vorfahrtVonRecht, 0.0);
        NeuronalEdge stopRAB
                = new NeuronalEdge(RED_AND_BLACK, stop, -0.0);
        NeuronalEdge linksRAB
                = new NeuronalEdge(RED_AND_BLACK, fahrtNachLinks, -0.0);
        NeuronalEdge rechtsRAB
                = new NeuronalEdge(RED_AND_BLACK, fahrtNachRechts, -0.0);
    }

    public void buildVorfahrtConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("Vorfahrt")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.Vorfahrtsstraße, perzeptrons);
    }

    public void buildVorfahrtGewConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("VorfahrtGewähren")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.Vorfahrt, perzeptrons);
    }

    public void buildVorfahrtRechtsConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("VorfahrtVonRechts")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.VorfahrtVonRechts, perzeptrons);
    }

    public void buildStopConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("Stop")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.VorfahrtVonRechts, perzeptrons);
    }

    public void buildNachLinksConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("FahrtNachLinks")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.VorfahrtVonRechts, perzeptrons);
    }

    public void buildRechtsConcept() {
        Perzeptron vorsStraße = new Perzeptron();
        vorsStraße.setName("Vorfahrt");
        Perzeptron vorGewaehren = new Perzeptron();
        vorGewaehren.setName("VorfahrtGewähren");
        Perzeptron vorVonRecht = new Perzeptron();
        vorfahrtVonRecht.setName("VorfahrtVonRechts");
        vorfahrtVonRecht.setOutput(0.0);
        Perzeptron vorstop = new Perzeptron();
        Perzeptron NachLinks = new Perzeptron();
        NachLinks.setName("FahrtNachLinks");
        Perzeptron NachRechts = new Perzeptron();
        NachRechts.setName("FahrtNachRechts");
        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.stream().forEach((Perzeptron current) -> {
            if (current.getName().equals("FahrtNachRechts")) {
                current.setOutput(1.0);
            } else {
                current.setOutput(0.0);

            }
            current.setInputs(new ArrayList<>());
        });
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(vorfahrtGewaehren);
        perzeptrons.add(vorfahrtVonRecht);
        perzeptrons.add(vorstop);
        perzeptrons.add(fahrtNachLinks);
        perzeptrons.add(fahrtNachRechts);
        super.getMappingConceptsToOutput().put(Concept.VorfahrtVonRechts, perzeptrons);
    }
}
