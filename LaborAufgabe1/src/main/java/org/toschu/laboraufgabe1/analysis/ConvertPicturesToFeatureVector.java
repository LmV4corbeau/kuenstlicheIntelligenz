/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1.analysis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.toschu.laboraufgabe1.TomFeatureVector;
import org.toschu.laboraufgabe1.framework.Concept;
import org.toschu.laboraufgabe1.framework.FeatureVector;

/**
 *
 * @author toschu
 */
public class ConvertPicturesToFeatureVector {

    private File picfolder;
    private int parallelCounter = 0;

    public ConvertPicturesToFeatureVector() {
        this.picfolder = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "files");
    }

    public List<FeatureVector> buildFeatureVectors() {
        List<FeatureVector> featureVectors = new ArrayList<>();
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(
                                new File(picfolder,
                                        "306 - Vorfahrtsstraße")),
                        Concept.Vorfahrtsstraße));
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(new File(picfolder,
                                        "209 - Fahrtrichtung rechts")),
                        Concept.RechtsAbbiegen));
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(new File(picfolder,
                                        "209 - Fahrtrichtung links")),
                        Concept.LinksAbbiegen));
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(new File(picfolder,
                                        "206 - Stop")),
                        Concept.Stop));
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(new File(picfolder,
                                        "205 - Vorfahrt gewähren")),
                        Concept.Vorfahrt));
        featureVectors.addAll(
                buildFeatureVectorsFromFiles(
                        getFilesFromFolder(new File(picfolder,
                                        "102 - Vorfahrt von rechts")),
                        Concept.VorfahrtVonRechts));
        return featureVectors;
    }

    public List<FeatureVector> buildFeatureVectorsFromFiles(List<File> pictures, Concept concept) {
        System.out.println(concept.toString() + "\tSize:\t" + pictures.size());
        List<FeatureVector> featureVectors = new ArrayList<>();
        pictures.parallelStream().forEach((File currentPicture) -> {
            FeatureVectorBuilder builder = new FeatureVectorBuilder();
            TomFeatureVector currentFeatureVector
                    = builder.generateFeatureVector(currentPicture);
            currentFeatureVector.setConcept(concept);
            featureVectors.add(currentFeatureVector);
            System.out.print("#");
            parallelCounter++;
            if (parallelCounter >= 25) {
                System.out.println("");
                parallelCounter = 0;
            }
        });
        System.out.println("|");
        /*
         for (File currentPicture : pictures) {
         FeatureVectorBuilder builder = new FeatureVectorBuilder();
         TomFeatureVector currentFeatureVector
         = builder.generateFeatureVector(currentPicture);
         currentFeatureVector.setConcept(concept);
         featureVectors.add(currentFeatureVector);
         }*/

        return featureVectors;
    }

    public List<File> getFilesFromFolder(File folder) {
        System.out.println(folder.getName());
        List<File> children = new ArrayList<>();
        int counter = 0;
        for (File currentChildren : folder.listFiles()) {
            if (currentChildren.isFile()
                    && (currentChildren.getName().endsWith(".bmp")
                    || currentChildren.getName().endsWith(".jpg"))) {
                System.out.print("+");
                counter++;
                children.add(currentChildren);
            } else if (currentChildren.isDirectory()) {
                children.addAll(getFilesFromFolder(currentChildren));
            }
            if (counter >= 25) {
                System.out.println("");
                counter = 0;
            }
        }
        System.out.println("|");
        return children;
    }

}
