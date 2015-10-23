/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;


import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class QuadrantOfMaxBlue {

    public Quadrant findQuadrantWithMaxBlue(FeatureColor[][] picture) {
        Map<Quadrant, FeatureColor[][]> quadrantsOfPicture;
        if (!checkPictureForBlue(picture)) {
            return Quadrant.QUADRANT_0;
        } else {
            //TODO
            return Quadrant.QUADRANT_0;
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
