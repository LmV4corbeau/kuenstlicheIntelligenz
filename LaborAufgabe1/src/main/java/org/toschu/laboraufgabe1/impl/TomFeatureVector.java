/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.impl;

import java.util.HashMap;
import java.util.Map;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class TomFeatureVector implements FeatureVector {

    private Map<Integer, Integer> features;
    private Concept concept;

    public TomFeatureVector(Map<Integer, Integer> features) {
        this.features = features;
    }

    public TomFeatureVector() {
        this.features = new HashMap<>();
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

}
