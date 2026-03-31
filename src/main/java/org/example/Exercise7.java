package org.example;

import java.util.Scanner;

public class Exercise7 {

    private static int counter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        fillSpiral(matrix, 0, n - 1, 0, n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void fillSpiral(int[][] matrix, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) {
            return;
        }

        for (int i = left; i <= right; i++) {
            matrix[top][i] = counter++;
        }
        top++;

        for (int i = top; i <= bottom; i++) {
            matrix[i][right] = counter++;
        }
        right--;

        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = counter++;
            }
            bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = counter++;
            }
            left++;
        }

        fillSpiral(matrix, top, bottom, left, right);
    }
}