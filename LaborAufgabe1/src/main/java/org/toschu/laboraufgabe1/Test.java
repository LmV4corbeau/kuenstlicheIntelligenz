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
        double tom = mat.length / 2;
        Double halfdouble = Math.floor(tom);
        int half = halfdouble.intValue();
        int numberOfElementsInArray = mat[0].length;
        int[][] A = new int[half][numberOfElementsInArray];
        int[][] B = new int[mat.length - half][numberOfElementsInArray];
        System.arraycopy(mat, 0, A, 0, half);
        System.arraycopy(mat, half, B, 0, mat.length - half);
        System.out.println(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(B);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

    }
}
