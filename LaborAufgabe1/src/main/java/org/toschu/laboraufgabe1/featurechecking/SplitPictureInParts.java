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
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;

/**
 *
 * @author toschu
 */
public class SplitPictureInParts {

    public Map<Quadrant, FeatureColor[][]> splitPictureOnHorizonalLine(FeatureColor[][] picture) {
        Map<Quadrant, FeatureColor[][]> splits = new HashMap<>();
        splits.put(Quadrant.QUADRANT_1, getUpperPartOfPicture(picture));
        splits.put(Quadrant.QUADRANT_4, getLowerPartOfPicture(picture));
        return splits;
    }

    public Map<Quadrant, FeatureColor[][]> buildQuadrandsOFPicture(FeatureColor[][] picture) {
        Map<Quadrant, FeatureColor[][]> quadrants = new HashMap<>();
        FeatureColor[][] upperPartOfPicture = getUpperPartOfPicture(picture);
        FeatureColor[][] lowerPartOfPicture = getLowerPartOfPicture(picture);
        List<FeatureColor[][]> upperQuadrants = getVerticalPartsOfPicture(upperPartOfPicture);
        List<FeatureColor[][]> lowerQuadrants = getVerticalPartsOfPicture(lowerPartOfPicture);
        quadrants.put(Quadrant.QUADRANT_1, upperQuadrants.get(1));
        quadrants.put(Quadrant.QUADRANT_2, upperQuadrants.get(0));
        quadrants.put(Quadrant.QUADRANT_3, lowerQuadrants.get(1));
        quadrants.put(Quadrant.QUADRANT_4, lowerQuadrants.get(0));
        return quadrants;
    }

    public List<FeatureColor[][]> getVerticalPartsOfPicture(FeatureColor[][] picture) {
        List<FeatureColor[][]> parts = new ArrayList<>();
        int maxRowCount = picture.length;
        int maxColumnCount = getMaxColumnCount(picture);
        double maxColumnCountHalf = maxColumnCount / 2;
        Double halfdouble = Math.floor(maxColumnCountHalf);
        int half = halfdouble.intValue();
        FeatureColor[][] leftPart = new FeatureColor[maxRowCount][];
        FeatureColor[][] rightPart = new FeatureColor[maxRowCount][];
        for (int row = 0; row < picture.length; row++) {
            int currentColumnCount = picture[row].length;
            double currentCoulumnCounthalf = currentColumnCount / 2;
            Double currenthalfdouble = Math.floor(currentCoulumnCounthalf);
            int currenthalf = currenthalfdouble.intValue();
            FeatureColor[] currentLeftPart = new FeatureColor[currenthalf];
            FeatureColor[] currentRightPart = new FeatureColor[currentColumnCount - currenthalf];
            System.arraycopy(picture[row], 0, currentLeftPart, 0, currenthalf);
            System.arraycopy(picture[row], currenthalf,
                    currentRightPart, 0, currentColumnCount - currenthalf);
            leftPart[row] = currentLeftPart;
            rightPart[row] = currentRightPart;
        }
        parts.add(0, leftPart);
        parts.add(1, rightPart);
        return parts;
    }

    public FeatureColor[][] getUpperPartOfPicture(FeatureColor[][] picture) {
        double halflength = picture.length / 2;
        Double halfdouble = Math.floor(halflength);
        int half = halfdouble.intValue();
        int numberOfElementsInArray = picture[0].length;
        FeatureColor[][] upperPart = new FeatureColor[half][numberOfElementsInArray];
        System.arraycopy(picture, 0, upperPart, 0, half);
        return upperPart;
    }

    public FeatureColor[][] getLowerPartOfPicture(FeatureColor[][] picture) {
        double halflength = picture.length / 2;
        Double halfdouble = Math.floor(halflength);
        int half = halfdouble.intValue();
        int numberOfElementsInArray = picture[0].length;
        FeatureColor[][] lowerPart = new FeatureColor[picture.length - half][numberOfElementsInArray];
        System.arraycopy(picture, half, lowerPart, 0, picture.length - half);
        return lowerPart;
    }

    public int getMaxColumnCount(FeatureColor[][] picture) {
        int maxColumnCount = Integer.MIN_VALUE;
        for (int row = 0; row < picture.length; row++) {
            if (picture[row].length > maxColumnCount) {
                maxColumnCount = picture[row].length;
            }
        }
        return maxColumnCount;
    }

    public void printQuadrants(Map<Quadrant, FeatureColor[][]> quadrants) {
        for (Quadrant currentQuadrant : quadrants.keySet()) {
            System.out.println(currentQuadrant);
            for (int row = 0;
                    row < quadrants.get(currentQuadrant).length;
                    row++) {
                for (int column = 0;
                        column < quadrants.get(currentQuadrant)[row].length;
                        column++) {
                    System.out.print(quadrants.get(currentQuadrant)[row][column]);
                }
                System.out.println("");
            }
            System.out.println("--------------------------------------");
        }
    }
}
