/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1;

import java.io.File;
import java.util.Map;
import org.toschu.laboraufgabe1.analysis.ImageConverter;
import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;
import org.toschu.laboraufgabe1.featurdefinitions.Quadrant;
import org.toschu.laboraufgabe1.featurechecking.MaxColorWithoutWhiteFeature;
import org.toschu.laboraufgabe1.featurechecking.MaxRedPartInHorizontalPart;
import org.toschu.laboraufgabe1.featurechecking.QuadrantOfMaxBlue;
import org.toschu.laboraufgabe1.featurechecking.RedAndBlack;
import org.toschu.laboraufgabe1.featurechecking.SplitPictureInParts;
import sun.awt.X11.XConstants;

/**
 *
 * @author toschu
 */
public class Test {

    public static void main(String[] args) {
        

        FeatureColor[][] pic = new FeatureColor[][]{
            new FeatureColor[]{FeatureColor.NOTHING, FeatureColor.BLUE},
            new FeatureColor[]{FeatureColor.YELLOW, FeatureColor.RED},
            new FeatureColor[]{FeatureColor.NOTHING, FeatureColor.WHITE},
            new FeatureColor[]{FeatureColor.NOTHING, FeatureColor.BLUE}
        };
        Map<Quadrant, FeatureColor[][]> buildQuadrandsOFPicture
                = new SplitPictureInParts().buildQuadrandsOFPicture(pic);
        new SplitPictureInParts().printQuadrants(buildQuadrandsOFPicture);

        File picfolder = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "files");
        System.out.println(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "files");
        ImageConverter imageConverter = new ImageConverter(new File(picfolder, "vorfahrt.bmp"));
        imageConverter.printMatrix();
        FeatureColor[][] leftPartOfPicture
                = new SplitPictureInParts().rotateMatrix(
                        new SplitPictureInParts().getLeftPartOfPicture(imageConverter.getImageMatrix()));
        FeatureColor[][] rightPartOfPicture
                = new SplitPictureInParts().rotateMatrix(
                        new SplitPictureInParts().getRightPartOfPicture(imageConverter.getImageMatrix()));
        System.out.println("-.-");

        for (FeatureColor[] currentRowOfLeftPart : leftPartOfPicture) {
            for (FeatureColor currentCellOfCurrentRow : currentRowOfLeftPart) {
                if (currentCellOfCurrentRow != FeatureColor.NOTHING) {
                    System.out.print(currentCellOfCurrentRow);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        for (FeatureColor[] currentRowOfRightPart : rightPartOfPicture) {
            for (FeatureColor currentCellOfRow : currentRowOfRightPart) {
                if (currentCellOfRow != FeatureColor.NOTHING) {
                    System.out.print(currentCellOfRow);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        SplitPictureInParts inParts = new SplitPictureInParts();
        inParts.printQuadrants(inParts.buildQuadrandsOFPicture(imageConverter.getImageMatrix()));

        System.out.println("MaxColorWithoutWithe:\t"
                + new MaxColorWithoutWhiteFeature().findMaximalColorWithoutWhite(
                        imageConverter.getImageMatrix()));
        System.out.println("QuadrantOfMaxBlue:\t"
                + new QuadrantOfMaxBlue().findQuadrantWithMaxBlue(
                        imageConverter.getImageMatrix()));
        System.out.println("RedAndBlack:\t"
                + new RedAndBlack().checkIfRedAndBlackInPicture(
                        imageConverter.getImageMatrix()));
        System.out.println("MaxRedInHorizontalPart:\t"
                + new MaxRedPartInHorizontalPart().checkWithPartHaveMoreRed(
                        imageConverter.getImageMatrix()));
    }

}
