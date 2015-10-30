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
public class WhitePartInPictureToRed {

    public int getWhiteToRedRelation(FeatureColor[][] picture) {
        MaxColorWithoutWhiteFeature colorWithoutWhiteFeature
                = new MaxColorWithoutWhiteFeature();
        int redCount
                = colorWithoutWhiteFeature.countColorInPicture(
                        picture, FeatureColor.RED);
        int withCount
                = colorWithoutWhiteFeature.countColorInPicture(
                        picture, FeatureColor.WHITE);
        double colorRelation
                = (double) redCount / (double) withCount;
        return (int) Math.round(colorRelation);
    }
}
