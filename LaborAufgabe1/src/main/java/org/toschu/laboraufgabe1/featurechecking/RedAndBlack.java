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
        int redcount = feature.countColorInPicture(picture, FeatureColor.RED);
        int bluecount = feature.countColorInPicture(picture, FeatureColor.BLUE);
        int blackcount = feature.countColorInPicture(picture, FeatureColor.BLACK);

    }

    public int countPixel(FeatureColor[][] picture) {

        for (int row = 0; row < picture.length; row++) {
            
        }
    }
}
