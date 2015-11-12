/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1;

import java.util.Date;
import java.util.List;
import org.toschu.laboraufgabe1.analysis.ConvertPicturesToFeatureVector;
import org.toschu.laboraufgabe1.analysis.FeatureSaver;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class TestTom {

    public static void main(String[] args) {
        ConvertPicturesToFeatureVector convertPicturesToFeatureVector
                = new ConvertPicturesToFeatureVector();
        System.out.println(new Date().toString());
        List<FeatureVector> buildFeatureVectors
                = convertPicturesToFeatureVector.buildFeatureVectors();
        System.out.println(buildFeatureVectors.getClass().toString());
        buildFeatureVectors.stream().forEach((featureVector) -> {
            if (featureVector.getConcept() != null) {
                //System.out.println(featureVector.getConcept());
            } else {
                System.out.println("NULL!!!!");
            }
        });
        System.out.println(new Date().toString());
        FeatureSaver featureSaver = new FeatureSaver();
        featureSaver.saveVectors(buildFeatureVectors);
        System.out.println(new Date().toString());
        System.out.println(buildFeatureVectors.size());
    }

}
