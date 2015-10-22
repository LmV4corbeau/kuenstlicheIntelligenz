/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.impl;

/**
 *
 * @author toschu
 */
public enum Feature {

    RED_AND_BLACK(0),
    MAX_RED_PART_IN_HORIZONTAL_PART(1),
    WHITE_PART_IN_PITCURE_TO_RED(2),
    MAX_WHITE_PART_TO_BLUE_IN_QUADRANT(3),
    MAX_COLOR_WITHOUT_WHITE(4);

    private final int value;

    private Feature(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

}
