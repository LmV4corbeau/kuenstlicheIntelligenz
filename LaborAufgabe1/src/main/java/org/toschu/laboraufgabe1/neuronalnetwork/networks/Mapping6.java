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
public class Mapping6 extends PerzeptronNetwork {

    public Mapping6() {
        super();
        super.setName(this.getClass().getSimpleName());
        buildNetwork();
        mapping();
    }

    public void buildNetwork() {

        PerzeptronNetwork vorfahrtsstrasse
                = new OnlyVorfahrtStrasse();
        //System.out.println(vorfahrtsstrasse.getPerzeptrons());
        super.getPerzeptrons()
                .addAll(vorfahrtsstrasse.getPerzeptrons());

        PerzeptronNetwork rechtsabbiegen
                = new OnlyRight();
        //System.out.println(rechtsabbiegen.getPerzeptrons());
        super.getPerzeptrons().addAll(rechtsabbiegen.getPerzeptrons());

        PerzeptronNetwork linksabbiegen
                = new OnlyLeft();
        //System.out.println(linksabbiegen.getPerzeptrons());
        super.getPerzeptrons().addAll(linksabbiegen.getPerzeptrons());

        PerzeptronNetwork stop
                = new OnlyStop();
        //System.out.println(stop.getPerzeptrons());
        super.getPerzeptrons().addAll(stop.getPerzeptrons());

        PerzeptronNetwork vorfahrtvonRechts
                = new OnlyVorfahrtvonRechts();
        //System.out.println(vorfahrtvonRechts.getPerzeptrons());
        super.getPerzeptrons().addAll(vorfahrtvonRechts.getPerzeptrons());

        PerzeptronNetwork vorfahrtgew
                = new OnlyVorfahrtvonRechts();
        //System.out.println(vorfahrtgew.getPerzeptrons());
        super.getPerzeptrons().addAll(vorfahrtgew.getPerzeptrons());

    }

    public void mapping() {
        rechtsAbbiegenConcept();
        VorfahrtsstraßeConcept();
        linksAbbiegenCoincept();
        vorfahrtVonRechtsConcept();
        vorfahrtGewConcept();
    }

    private void vorfahrtVonRechtsConcept() {
        //VorfahrtVonRechts
        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(1.0);

        Perzeptron vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraße.setOutput(0.0);

        Perzeptron linkssrightDirection = new Perzeptron();
        linkssrightDirection.setName(Concept.LinksAbbiegen.name());
        linkssrightDirection.setOutput(0.0);

        Perzeptron leftrightDirection = new Perzeptron();
        leftrightDirection.setName(Concept.RechtsAbbiegen.name());
        leftrightDirection.setOutput(0.0);

        Perzeptron leftStop = new Perzeptron();
        leftStop.setName(Concept.Stop.name());
        leftStop.setOutput(0.0);

        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(linkssrightDirection);
        perzeptrons.add(leftrightDirection);
        perzeptrons.add(leftStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.VorfahrtVonRechts, perzeptrons);
    }

    private void vorfahrtGewConcept() {
        //VorfahrtGewähren
        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(1.0);

        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(0.0);

        Perzeptron vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraße.setOutput(0.0);

        Perzeptron linkssrightDirection = new Perzeptron();
        linkssrightDirection.setName(Concept.LinksAbbiegen.name());
        linkssrightDirection.setOutput(0.0);

        Perzeptron leftrightDirection = new Perzeptron();
        leftrightDirection.setName(Concept.RechtsAbbiegen.name());
        leftrightDirection.setOutput(0.0);

        Perzeptron leftStop = new Perzeptron();
        leftStop.setName(Concept.Stop.name());
        leftStop.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(linkssrightDirection);
        perzeptrons.add(leftrightDirection);
        perzeptrons.add(leftStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.Vorfahrt, perzeptrons);
    }

    private void stopConcept() {
        //Stop
        Perzeptron vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraße.setOutput(0.0);

        Perzeptron linkssrightDirection = new Perzeptron();
        linkssrightDirection.setName(Concept.LinksAbbiegen.name());
        linkssrightDirection.setOutput(0.0);

        Perzeptron leftrightDirection = new Perzeptron();
        leftrightDirection.setName(Concept.RechtsAbbiegen.name());
        leftrightDirection.setOutput(0.0);

        Perzeptron leftStop = new Perzeptron();
        leftStop.setName(Concept.Stop.name());
        leftStop.setOutput(1.0);

        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(0.0);

        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(linkssrightDirection);
        perzeptrons.add(leftrightDirection);
        perzeptrons.add(leftStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.Stop, perzeptrons);
    }

    private void linksAbbiegenCoincept() {
        //Linksabbiegen
        Perzeptron vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraße.setOutput(0.0);

        Perzeptron linkssrightDirection = new Perzeptron();
        linkssrightDirection.setName(Concept.LinksAbbiegen.name());
        linkssrightDirection.setOutput(1.0);

        Perzeptron leftrightDirection = new Perzeptron();
        leftrightDirection.setName(Concept.RechtsAbbiegen.name());
        leftrightDirection.setOutput(0.0);

        Perzeptron leftStop = new Perzeptron();
        leftStop.setName(Concept.Stop.name());
        leftStop.setOutput(0.0);

        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(0.0);

        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(linkssrightDirection);
        perzeptrons.add(leftrightDirection);
        perzeptrons.add(leftStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.LinksAbbiegen, perzeptrons);
    }

    private void VorfahrtsstraßeConcept() {
        //VorfahrtsStraße
        Perzeptron vorfahrtsStraßeConcept = new Perzeptron();
        vorfahrtsStraßeConcept.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraßeConcept.setOutput(1.0);

        Perzeptron rightDirection = new Perzeptron();
        rightDirection.setName(Concept.RechtsAbbiegen.name());
        rightDirection.setOutput(0.0);

        Perzeptron vorleftDirection = new Perzeptron();
        vorleftDirection.setName(Concept.LinksAbbiegen.name());
        vorleftDirection.setOutput(0.0);

        Perzeptron vorStop = new Perzeptron();
        vorStop.setName(Concept.Stop.name());
        vorStop.setOutput(0.0);

        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(0.0);

        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraßeConcept);
        perzeptrons.add(rightDirection);
        perzeptrons.add(vorleftDirection);
        perzeptrons.add(vorStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.Vorfahrtsstraße, perzeptrons);
    }

    public void rechtsAbbiegenConcept() {
        //Rechtsabbiegen
        Perzeptron vorfahrtsStraße = new Perzeptron();
        vorfahrtsStraße.setName(Concept.Vorfahrtsstraße.name());
        vorfahrtsStraße.setOutput(0.0);

        Perzeptron rightleftDirection = new Perzeptron();
        rightleftDirection.setName(Concept.LinksAbbiegen.name());
        rightleftDirection.setOutput(0.0);

        Perzeptron rechtsrightDirection = new Perzeptron();
        rechtsrightDirection.setName(Concept.RechtsAbbiegen.name());
        rechtsrightDirection.setOutput(1.0);

        Perzeptron rightStop = new Perzeptron();
        rightStop.setName(Concept.Stop.name());
        rightStop.setOutput(0.0);

        Perzeptron vorfahrtvconRechts = new Perzeptron();
        vorfahrtvconRechts.setName(Concept.VorfahrtVonRechts.name());
        vorfahrtvconRechts.setOutput(0.0);

        Perzeptron vorfahrtgew = new Perzeptron();
        vorfahrtgew.setName(Concept.Vorfahrt.name());
        vorfahrtgew.setOutput(0.0);

        List<Perzeptron> perzeptrons = new ArrayList<>();
        perzeptrons.add(vorfahrtsStraße);
        perzeptrons.add(rechtsrightDirection);
        perzeptrons.add(rightleftDirection);
        perzeptrons.add(rightStop);
        perzeptrons.add(vorfahrtvconRechts);
        perzeptrons.add(vorfahrtgew);

        super.getMappingConceptToPerzeptron().put(Concept.RechtsAbbiegen, perzeptrons);
    }
}
