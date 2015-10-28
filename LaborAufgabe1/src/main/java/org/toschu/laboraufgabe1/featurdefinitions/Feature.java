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
public enum Feature {

    //RedAndBlack.java
//RedAndBlack.java
    RED_AND_BLACK(0),
    //MaxRedPartInHorizontalPart.java
    MAX_RED_PART_IN_HORIZONTAL_PART(1),
    //WhitePartInPictureToRed.java
    WHITE_PART_IN_PICTURE_TO_RED(2),
    //QuadrantOfMaxBlue.java
    MAX_WHITE_PART_TO_BLUE_IN_QUADRANT(3),
    //MaxColorWithoutWithFeature.java
    MAX_COLOR_WITHOUT_WHITE(4);

    private final int value;

    private Feature(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

}
