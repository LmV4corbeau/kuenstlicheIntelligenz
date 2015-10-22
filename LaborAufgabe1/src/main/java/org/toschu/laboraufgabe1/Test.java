/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.toschu.laboraufgabe1;

/**
 *
 * @author toschu
 */
public class Test {

    public static void main(String[] args) {
        int[][] mat;
        mat = new int[][]{
            new int[]{1, 2, 3},
            new int[]{11, 12, 13, 14},
            new int[]{21, 22, 23, 24},
            new int[]{31, 32, 33}};

        System.out.println(mat.toString());
        for (int rowCount = 0; rowCount < mat.length; rowCount++) {
            for (int columCount = 0; columCount < mat[rowCount].length; columCount++) {
                System.out.print(mat[rowCount][columCount] + " ");
            }
            System.out.println("");
        }
        System.out.println(mat.length);
    }
}
