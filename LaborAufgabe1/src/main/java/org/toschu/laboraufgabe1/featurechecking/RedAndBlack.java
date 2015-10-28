/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;

/**
 *
 * @author toschu
 */
public class RedAndBlack {

    public boolean checkIfRedAndBlackInPicture(FeatureColor[][] picture) {
        MaxColorWithoutWhiteFeature feature = new MaxColorWithoutWhiteFeature();
        double redcount = feature.countColorInPicture(picture, FeatureColor.RED);
        double bluecount = feature.countColorInPicture(picture, FeatureColor.BLUE);
        double blackcount = feature.countColorInPicture(picture, FeatureColor.BLACK);
        double pixels = countPixel(picture);
        double redInPercentage = redcount / pixels;
        double blueInPercentage = bluecount / pixels;
        double blackInPercentage = blackcount / pixels;
        double wantedColorsSum = redInPercentage + blackInPercentage + blueInPercentage;
        double otherSum = 1 - wantedColorsSum;
        //System.out.println("Pixels:" + pixels);
        //System.out.println("red:\t" + redInPercentage + "\t cout: " + redcount);
        //System.out.println("blue:\t" + blueInPercentage + "\t cout: " + bluecount);
        //System.out.println("black:\t" + blackInPercentage + "\t cout: " + blackcount);
        //System.out.println("wantedColorSum:\t" + wantedColorsSum);
        if (redInPercentage > 0.0
                && (blueInPercentage > 0.01
                || blackInPercentage > 0.01)) {
            return true;
        } else {
            return false;
        }

    }

    public int countPixel(FeatureColor[][] picture) {
        int pixels = 0;
        for (int row = 0; row < picture.length; row++) {
            for (int column = 0; column < picture[0].length; column++) {
                if (picture[row][column] == FeatureColor.NOTHING) {
                } else {
                    pixels++;
                }
            }
        }
        return pixels;
    }
}
