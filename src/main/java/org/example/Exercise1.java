// Computes sum of squares from 1^2 to n^2 using recursion: 1^2 + 2^2 + ... + n^2

package org.example;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        int result = sumOfSquares(n);
        System.out.print("Output: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(i + "^2");
            if (i < n) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + result);
        scanner.close();
    }


    public static int sumOfSquares(int n) {
        if (n == 1) {
            return 1;
        }
        return n * n + sumOfSquares(n - 1);
    }
}

