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
import java.util.Objects;
import org.toschu.laboraufgabe1.impl.Color;

/**
 *
 * @author toschu
 */
public class MaxColorWithoutWhiteFeature {

    private List<Color> colors = Arrays.asList(Color.values());

    public Color findMaximalColorWithoutWhite(Color[][] pictureMatrix) {
        Map<Color, Integer> colorAndCountMap = new HashMap<>();
        for (Color currentColor : this.colors) {
            colorAndCountMap.put(currentColor,
                    this.countColorInPicture(pictureMatrix, currentColor));
        }
        Color maxColor = Color.NOTHING;
        Integer maxCount = Integer.MIN_VALUE;
        for (Color currentColor : colorAndCountMap.keySet()) {
            if (colorAndCountMap.get(currentColor) > maxCount) {
                maxColor = currentColor;
                maxCount = colorAndCountMap.get(currentColor);
            }
        }
        return maxColor;
    }

    public int countColorInPicture(Color[][] picture, Color wantedColor) {
        int countOfColor = 0;
        for (int row = 0; row < picture.length; row++) {
            for (int column = 0; column < picture.length; column++) {
                if (wantedColor.equals(picture[row][column])) {
                    countOfColor++;
                }
            }
        }
        return countOfColor;
    }

}
