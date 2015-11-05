/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurdefinitions;


/**
 *
 * @author toschu
 */
public enum FeatureColor {

    BLUE(5),
    YELLOW(1),
    RED(2),
    WHITE(3),
    BLACK(4),
    NOTHING(0);

    private final int value;

    private FeatureColor(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return ""+getValue();
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

    public static FeatureColor getBLACK() {
        return BLACK;
    }

    public static FeatureColor getNOTHING() {
        return NOTHING;
    }

    public int getValue() {
        return value;
    }

}
