/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1;

import java.util.HashMap;
import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.Feature;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;
import org.toschu.repositoryapi.api.Identity;

/**
 *
 * @author toschu
 */
public class TomFeatureVector extends Identity implements FeatureVector {

    private Map<Integer, Integer> features;
    private Concept concept;

    public TomFeatureVector(Map<Integer, Integer> features) {
        this.features = features;
    }

    public TomFeatureVector() {
        this.features = new HashMap<>();
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    @Override
    public Concept getConcept() {
        return this.concept;
    }

    @Override
    public int getNumFeatures() {
        if (this.features == null) {
            this.features = new HashMap<>();
        }
        return this.features.keySet().size();
    }

    @Override
    public int getFeatureValue(int i) {
        if (this.features == null || this.features.isEmpty()) {
            return -10;
        } else if (!this.features.containsKey(i)) {
            return -11;
        } else {
            return this.features.get(i);
        }
    }

    public void addFeatureToVector(Feature feature, int value) {
        if (this.features.containsKey(feature.getValue())) {
            this.features.remove(feature.getValue());
        }
        this.features.put(feature.getValue(), value);

    }

    @Override
    public String toString() {
        return "TomFeatureVector{\n" + "features=" + features
                + "\n, concept=" + concept
                + "\n}";
    }

    public String toStringHumanReadable() {
        String readable = "TomFeatureVector{\n" + "features=\n";

        for (Integer currentFeature : this.features.keySet()) {
            readable += Feature.byValue(currentFeature);
            readable += ":=";
            readable += this.features.get(currentFeature);
            readable += "  |  ";
        }
        readable += "\n, concept=" + concept + "\n}";
        return readable;
    }

    public Map<Integer, Integer> getFeatures() {
        return features;
    }

    public void setFeatures(Map<Integer, Integer> features) {
        this.features = features;
    }

}
