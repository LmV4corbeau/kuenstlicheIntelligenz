/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.featurechecking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;

/**
 *
 * @author toschu
 */
public class MaxColorWithoutWhiteFeature {

    private List<FeatureColor> colors = Arrays.asList(FeatureColor.values());

    public FeatureColor findMaximalColorWithoutWhite(FeatureColor[][] pictureMatrix) {
        Map<FeatureColor, Integer> colorAndCountMap = new HashMap<>();
        for (FeatureColor currentColor : this.colors) {
            colorAndCountMap.put(currentColor,
                    this.countColorInPicture(pictureMatrix, currentColor));
        }
        colorAndCountMap.remove(FeatureColor.WHITE);
        colorAndCountMap.remove(FeatureColor.NOTHING);
        FeatureColor maxColor = FeatureColor.NOTHING;
        Integer maxCount = Integer.MIN_VALUE;
        for (FeatureColor currentColor : colorAndCountMap.keySet()) {
            if (colorAndCountMap.get(currentColor) > maxCount) {
                maxColor = currentColor;
                maxCount = colorAndCountMap.get(currentColor);
            }
        }
        return maxColor;
    }

    public int countColorInPicture(FeatureColor[][] picture, FeatureColor wantedColor) {
        int countOfColor = 0;
        for (int rowCounter = 0; rowCounter < picture.length; rowCounter++) {
            for (int columnCounter = 0; columnCounter < picture[rowCounter].length; columnCounter++) {
                if (wantedColor.equals(picture[rowCounter][columnCounter])) {
                    countOfColor++;
                }
            }
        }
        return countOfColor;
    }

    public int countColorInPictureBin(FeatureColor[][] picture, FeatureColor wantedColor) {
        int countOfColor = 0;
        for (int rowCounter = 0; rowCounter < picture.length; rowCounter++) {
            for (int columnCounter = 0; columnCounter < picture[rowCounter].length; columnCounter++) {
                if (wantedColor.equals(picture[rowCounter][columnCounter])) {
                    countOfColor++;
                }
            }
        }

        if (countOfColor > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
