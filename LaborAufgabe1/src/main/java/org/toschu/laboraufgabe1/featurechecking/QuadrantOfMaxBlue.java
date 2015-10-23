/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.Color;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class QuadrantOfMaxBlue {

    public Quadrant findQuadrantWithMaxBlue(Color[][] picture) {
        Map<Quadrant, Color[][]> quadrantsOfPicture;
        if (!checkPictureForBlue(picture)) {
            return Quadrant.QUADRANT_0;
        } else {
            //TODO
            return Quadrant.QUADRANT_0;
        }
    }

    public boolean checkPictureForBlue(Color[][] quadrand) {
        for (int rowCounter = 0; rowCounter < quadrand.length; rowCounter++) {
            for (int columnCount = 0;
                    columnCount < quadrand[rowCounter].length; columnCount++) {
                if (quadrand[rowCounter][columnCount].equals(Color.BLUE)) {
                    return true;
                }
            }
        }
        return false;
    }
}
