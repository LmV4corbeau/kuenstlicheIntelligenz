package org.toschu.laboraufgabe1.analysis;

import org.toschu.laboraufgabe1.featurdefinitions.FeatureColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hanne on 16.10.2015.
 */
public class ImageConverter {

    private BufferedImage image;
    private FeatureColor[][] matrix;

    public FeatureColor[][] getImageMatrix() {
        return matrix;
    }

    ImageConverter(File file) {
        try {
            this.image = ImageIO.read(file);
            this.matrix = new FeatureColor[this.image.getWidth()][this.image.getHeight()];

            this.imageToMatrix();
            this.removeEdges();

            //this.printMatrix();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void imageToMatrix() throws IOException {
        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = 0; x < this.image.getWidth(); x++) {
                Color color = new Color(this.image.getRGB(x, y));

                if (color.getRed() > 230 && color.getGreen() > 230 && color.getBlue() > 230) {
                    this.matrix[x][y] = FeatureColor.WHITE;
                } else if (color.getRed() < 25 && color.getGreen() < 25 && color.getBlue() < 25) {
                    this.matrix[x][y] = FeatureColor.BLACK;
                } else if (color.getRed() > color.getGreen() && color.getRed() > color.getBlue()) {
                    this.matrix[x][y] = FeatureColor.RED;
                } else if (color.getBlue() > color.getRed() && color.getBlue() > color.getGreen()) {
                    this.matrix[x][y] = FeatureColor.BLUE;
                } else if (color.getBlue() < color.getGreen() && color.getBlue() < color.getRed()) {
                    this.matrix[x][y] = FeatureColor.YELLOW;
                } else {
                    this.matrix[x][y] = FeatureColor.NOTHING;
                }
            }
        }
    }

    private void printMatrix() {
        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = 0; x < this.image.getWidth(); x++) {
                System.out.print(this.matrix[x][y]);
            }
            System.out.println();
        }
    }

    private void removeEdges() {
        int removeRight = 0;
        int removeLeft = this.image.getWidth() + 1;

        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = 0; x < this.image.getWidth(); x++) {
                if (this.matrix[x][y] == FeatureColor.WHITE) {
                    this.matrix[x][y] = FeatureColor.NOTHING;
                } else {
                    break;
                }
            }
        }
        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = this.image.getWidth() - 1; x > 0; x--) {
                if (this.matrix[x][y] == FeatureColor.WHITE) {
                    this.matrix[x][y] = FeatureColor.NOTHING;
                } else {
                    break;
                }
            }
        }
    }
}