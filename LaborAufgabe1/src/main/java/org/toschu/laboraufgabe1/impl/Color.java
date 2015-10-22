/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.impl;

import java.util.Objects;
import org.toschu.laboraufgabe1.featurechecking.MaxColorWithoutWhiteFeature;

/**
 *
 * @author toschu
 */
public enum Color {

    BLUE(0),
    YELLOW(1),
    RED(2),
    WHITE(3),
    NOTHING(4);

    private final int value;

    private Color(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static Color getBLUE() {
        return BLUE;
    }

    public static Color getYELLOW() {
        return YELLOW;
    }

    public static Color getRED() {
        return RED;
    }

    public static Color getWHITE() {
        return WHITE;
    }

    public static Color getNOTHING() {
        return NOTHING;
    }

    public int getValue() {
        return value;
    }

}
