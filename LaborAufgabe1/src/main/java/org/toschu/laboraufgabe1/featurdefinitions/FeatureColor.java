/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurdefinitions;

import java.util.Objects;
import org.toschu.laboraufgabe1.featurechecking.MaxColorWithoutWhiteFeature;

/**
 *
 * @author toschu
 */
public enum FeatureColor {

    BLUE(0),
    YELLOW(1),
    RED(2),
    WHITE(3),
    NOTHING(4);

    private final int value;

    private FeatureColor(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static FeatureColor getBLUE() {
        return BLUE;
    }

    public static FeatureColor getYELLOW() {
        return YELLOW;
    }

    public static FeatureColor getRED() {
        return RED;
    }

    public static FeatureColor getWHITE() {
        return WHITE;
    }

    public static FeatureColor getNOTHING() {
        return NOTHING;
    }

    public int getValue() {
        return value;
    }

}
