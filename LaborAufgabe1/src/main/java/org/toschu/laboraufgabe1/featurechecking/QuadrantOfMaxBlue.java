/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import java.util.HashMap;
import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class QuadrantOfMaxBlue {

    public Quadrant findQuadrantWithMaxBlue(FeatureColor[][] picture) {
        SplitPictureInParts splitPictureInParts = new SplitPictureInParts();
        Map<Quadrant, FeatureColor[][]> quadrantsOfPicture
                = splitPictureInParts.buildQuadrandsOFPicture(picture);
        if (!checkPictureForBlue(picture)) {
            return Quadrant.QUADRANT_0;
        } else {
            MaxColorWithoutWhiteFeature colorWithoutWhiteFeature
                    = new MaxColorWithoutWhiteFeature();
            Quadrant maxQuadrant = Quadrant.QUADRANT_0;
            int maxBlueCountInQuadrant = Integer.MIN_VALUE;
            for (Quadrant currentQuadrant : quadrantsOfPicture.keySet()) {
                if (currentQuadrant == Quadrant.QUADRANT_3
                        || currentQuadrant == Quadrant.QUADRANT_4
                        || currentQuadrant == Quadrant.QUADRANT_0 ) {
                    continue;
                }
                int countColorInPicture
                        = colorWithoutWhiteFeature.
                        countColorInPicture(
                                quadrantsOfPicture.get(currentQuadrant), FeatureColor.WHITE);
                System.out.println(currentQuadrant + ":\t" + countColorInPicture);
                if (countColorInPicture > maxBlueCountInQuadrant) {
                    maxQuadrant = currentQuadrant;
                    maxBlueCountInQuadrant = countColorInPicture;
                }
            }
            return maxQuadrant;
        }
    }

    public boolean checkPictureForBlue(FeatureColor[][] quadrand) {
        for (int rowCounter = 0; rowCounter < quadrand.length; rowCounter++) {
            for (int columnCount = 0;
                    columnCount < quadrand[rowCounter].length; columnCount++) {
                if (quadrand[rowCounter][columnCount].equals(FeatureColor.BLUE)) {
                    return true;
                }
            }
        }
        return false;
    }
}
