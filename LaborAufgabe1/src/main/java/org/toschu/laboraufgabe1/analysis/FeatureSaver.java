/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.analysis;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class FeatureSaver {

    private static String filename = "TomsFeatureVectors.dat";

    public void saveVectors(List<FeatureVector> featureVectors) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            out.writeObject(featureVectors);
            out.close();
        } catch (Throwable t) {
            System.out.println("DummyDataCreator: Could not create DummyData.dat");
            t.printStackTrace();
        }
    }

    public FeatureSaver() {
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        FeatureSaver.filename = filename;
    }

}
