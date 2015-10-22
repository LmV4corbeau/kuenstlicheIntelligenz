/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import java.util.HashMap;
import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.Color;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class SplitPictureInParts {

    public Map<Quadrant, Color[][]> splitPictureOnHorizonalLine(Color[][] picture) {
        Map<Quadrant, Color[][]> splits = new HashMap<>();
        splits.put(Quadrant.QUADRANT_1, getUpperPartOfPicture(picture));
        splits.put(Quadrant.QUADRANT_4, getLowerPartOfPicture(picture));
        return splits;
    }

    public Color[][] getUpperPartOfPicture(Color[][] picture) {
        double halflength = picture.length / 2;
        Double halfdouble = Math.floor(halflength);
        int half = halfdouble.intValue();
        int numberOfElementsInArray = picture[0].length;
        Color[][] upperPart = new Color[half][numberOfElementsInArray];
        System.arraycopy(picture, 0, upperPart, 0, half);
        return upperPart;
    }

    public Color[][] getLowerPartOfPicture(Color[][] picture) {
        double halflength = picture.length / 2;
        Double halfdouble = Math.floor(halflength);
        int half = halfdouble.intValue();
        int numberOfElementsInArray = picture[0].length;
        Color[][] lowerPart = new Color[picture.length - half][numberOfElementsInArray];
        System.arraycopy(picture, half, lowerPart, 0, picture.length - half);
        return lowerPart;
    }
}
