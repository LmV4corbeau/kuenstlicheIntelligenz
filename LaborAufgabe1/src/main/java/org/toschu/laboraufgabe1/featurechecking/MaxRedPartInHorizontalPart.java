/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurdefinitions.HorizontalPart;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class MaxRedPartInHorizontalPart {

    public HorizontalPart checkWithPartHaveMoreRed(FeatureColor[][] picture) {
        HorizontalPart mostRed = HorizontalPart.EITHER;
        SplitPictureInParts inParts = new SplitPictureInParts();
        MaxColorWithoutWhiteFeature colorWithoutWhiteFeature
                = new MaxColorWithoutWhiteFeature();
        Map<Quadrant, FeatureColor[][]> quadrants
                = inParts.buildQuadrandsOFPicture(picture);
        int top
                = colorWithoutWhiteFeature.countColorInPicture(
                        quadrants.get(Quadrant.QUADRANT_1), FeatureColor.RED)
                + colorWithoutWhiteFeature.countColorInPicture(
                        quadrants.get(Quadrant.QUADRANT_2), FeatureColor.RED);
        int bottom
                = colorWithoutWhiteFeature.countColorInPicture(
                        quadrants.get(Quadrant.QUADRANT_3), FeatureColor.RED)
                + colorWithoutWhiteFeature.countColorInPicture(
                        quadrants.get(Quadrant.QUADRANT_4), FeatureColor.RED);
        if (top > bottom) {
            mostRed = HorizontalPart.TOP;
        } else if (bottom > top) {
            mostRed = HorizontalPart.BOTTOM;
        } else {
            mostRed = HorizontalPart.EITHER;
        }
        return mostRed;
    }
}
