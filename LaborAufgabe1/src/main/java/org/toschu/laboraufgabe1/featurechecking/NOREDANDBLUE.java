/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class NOREDANDBLUE {

    public int NOREDANDBLUE(FeatureColor[][] picture) {
        MaxColorWithoutWhiteFeature colorWithoutWhiteFeature
                = new MaxColorWithoutWhiteFeature();
        int redCount
                = colorWithoutWhiteFeature.countColorInPicture(
                        picture, FeatureColor.RED);
        int withCount
                = colorWithoutWhiteFeature.countColorInPicture(
                        picture, FeatureColor.BLUE);
        int colorRelation
                = redCount + withCount;
        if (colorRelation >= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
