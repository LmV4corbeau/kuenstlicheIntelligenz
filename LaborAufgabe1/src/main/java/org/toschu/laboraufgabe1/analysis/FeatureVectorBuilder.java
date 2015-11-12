/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.analysis;

import java.io.File;
import org.toschu.laboraufgabe1.TomFeatureVector;
import org.toschu.laboraufgabe1.featurdefinitions.Feature;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurechecking.MaxColorWithoutWhiteFeature;
import org.toschu.laboraufgabe1.featurechecking.MaxRedPartInHorizontalPart;
import org.toschu.laboraufgabe1.featurechecking.NOREDANDBLUE;
import org.toschu.laboraufgabe1.featurechecking.QuadrantOfMaxBlue;
import org.toschu.laboraufgabe1.featurechecking.RedAndBlack;
import org.toschu.laboraufgabe1.featurechecking.WhitePartInPictureToRed;

/**
 *
 * @author toschu
 */
public class FeatureVectorBuilder {

    public TomFeatureVector generateFeatureVector(File picture) {
        TomFeatureVector vector = new TomFeatureVector();
        ImageConverter converter = new ImageConverter(picture);
        FeatureColor[][] image = converter.getImageMatrix();
        MaxColorWithoutWhiteFeature colorWithoutWhiteFeature
                = new MaxColorWithoutWhiteFeature();
        MaxRedPartInHorizontalPart maxRedPartInHorizontalPart
                = new MaxRedPartInHorizontalPart();
        QuadrantOfMaxBlue quadrantOfMaxBlue
                = new QuadrantOfMaxBlue();
        RedAndBlack redAndBlack = new RedAndBlack();
        WhitePartInPictureToRed whitePartInPictureToRed
                = new WhitePartInPictureToRed();
        NOREDANDBLUE noredandblue
                = new NOREDANDBLUE();

        //addFeatures
        vector.addFeatureToVector(
                Feature.PIXELCOUNT,
                redAndBlack.countPixel(image));
        vector.addFeatureToVector(
                Feature.BLACKCOUNT,
                colorWithoutWhiteFeature.countColorInPictureBin(
                        image, FeatureColor.BLACK));
        vector.addFeatureToVector(
                Feature.BLUECOUNT,
                colorWithoutWhiteFeature.countColorInPictureBin(
                        image, FeatureColor.BLUE));
        vector.addFeatureToVector(
                Feature.REDCOUNT,
                colorWithoutWhiteFeature.countColorInPictureBin(
                        image, FeatureColor.RED));
        vector.addFeatureToVector(
                Feature.WHITECOUNT,
                colorWithoutWhiteFeature.countColorInPictureBin(
                        image, FeatureColor.WHITE));
        vector.addFeatureToVector(
                Feature.YELLOWCOUNT,
                colorWithoutWhiteFeature.countColorInPictureBin(
                        image, FeatureColor.YELLOW));
        vector.addFeatureToVector(
                Feature.MAX_COLOR_WITHOUT_WHITE,
                colorWithoutWhiteFeature.findMaximalColorWithoutWhite(
                        image).getValue());
        vector.addFeatureToVector(
                Feature.MAX_RED_PART_IN_HORIZONTAL_PART,
                maxRedPartInHorizontalPart.checkWithPartHaveMoreRed(
                        image).getValue());
        vector.addFeatureToVector(
                Feature.MAX_WHITE_PART_TO_BLUE_IN_QUADRANT,
                quadrantOfMaxBlue.findQuadrantWithMaxBlue(image).getValue());
        vector.addFeatureToVector(
                Feature.RED_AND_BLACK, redAndBlack.checkIfRedAndBlackInPicture(image));
        vector.addFeatureToVector(
                Feature.WHITE_PART_IN_PICTURE_TO_RED,
                whitePartInPictureToRed.getWhiteToRedRelation(image));
        vector.addFeatureToVector(Feature.NOREDANDBLUE, noredandblue.NOREDANDBLUE(image));
        return vector;
    }
}
