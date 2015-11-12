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
    RED_AND_BLACK(0),
    //MaxRedPartInHorizontalPart.java
    MAX_RED_PART_IN_HORIZONTAL_PART(1),
    //WhitePartInPictureToRed.java
    WHITE_PART_IN_PICTURE_TO_RED(2),
    //QuadrantOfMaxBlue.java
    MAX_WHITE_PART_TO_BLUE_IN_QUADRANT(3),
    //MaxColorWithoutWithFeature.java
    MAX_COLOR_WITHOUT_WHITE(4),
    PIXELCOUNT(5),
    BLUECOUNT(6),
    YELLOWCOUNT(7),
    REDCOUNT(8),
    WHITECOUNT(9),
    BLACKCOUNT(10);
    

    private final int value;

    private Feature(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public static Feature getRED_AND_BLACK() {
        return RED_AND_BLACK;
    }

    public static Feature getMAX_RED_PART_IN_HORIZONTAL_PART() {
        return MAX_RED_PART_IN_HORIZONTAL_PART;
    }

    public static Feature getWHITE_PART_IN_PICTURE_TO_RED() {
        return WHITE_PART_IN_PICTURE_TO_RED;
    }

    public static Feature getMAX_WHITE_PART_TO_BLUE_IN_QUADRANT() {
        return MAX_WHITE_PART_TO_BLUE_IN_QUADRANT;
    }

    public static Feature getMAX_COLOR_WITHOUT_WHITE() {
        return MAX_COLOR_WITHOUT_WHITE;
    }

    public static Feature getPIXELCOUNT() {
        return PIXELCOUNT;
    }

    public static Feature getBLUECOUNT() {
        return BLUECOUNT;
    }

    public static Feature getYELLOWCOUNT() {
        return YELLOWCOUNT;
    }

    public static Feature getREDCOUNT() {
        return REDCOUNT;
    }

    public static Feature getWHITECOUNT() {
        return WHITECOUNT;
    }

    public static Feature getBLACKCOUNT() {
        return BLACKCOUNT;
    }

    public static Feature byValue(int ord) {
        for (Feature m : Feature.values()) {
            if (m.value == ord) {
                return m;
            }
        }
        return null;
    }
}
