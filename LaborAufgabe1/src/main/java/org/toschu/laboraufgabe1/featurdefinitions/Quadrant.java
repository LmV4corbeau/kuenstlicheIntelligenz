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
public enum Quadrant {

    QUADRANT_0(-1),
    QUADRANT_1(0),
    QUADRANT_2(1),
    QUADRANT_3(2),
    QUADRANT_4(3);

    private final int value;

    private Quadrant(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return "Quadrant{" + "value=" + value + '}';
    }


    public int getValue() {
        return value;
    }

}
