package org.toschu.laboraufgabe1.framework;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class DummyDataCreator {

    private static final String filename = "DummyData.dat";

    DummyDataCreator() {
        FeatureVector[] f = new FeatureVector[6];
        f[0] = new DummyFeatureVector(4, 2, 1, Concept.Stop);
        f[1] = new DummyFeatureVector(1, 2, 3, Concept.Stop);
        f[2] = new DummyFeatureVector(4, 5, 6, Concept.Vorfahrt);
        f[3] = new DummyFeatureVector(1, 5, 3, Concept.RechtsAbbiegen);
        f[4] = new DummyFeatureVector(3, 2, 5, Concept.Stop);
        f[5] = new DummyFeatureVector(5, 2, 1, Concept.LinksAbbiegen);

        List<FeatureVector> res = new LinkedList<>();
        for (FeatureVector fv : f) {
            res.add(fv);
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            out.writeObject(res);
            out.close();
        } catch (Throwable t) {
            System.out.println("DummyDataCreator: Could not create DummyData.dat");
            t.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DummyDataCreator();
    }

}
