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
public enum HorizontalPart {

    TOP(1),
    BOTTOM(0);

    private int value;

    HorizontalPart(int i) {
        this.value = i;
    }

    public static HorizontalPart getTOP() {
        return TOP;
    }

    public static HorizontalPart getBOTTOM() {
        return BOTTOM;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HorizontalParts{" + "value=" + value + '}';
    }

}
