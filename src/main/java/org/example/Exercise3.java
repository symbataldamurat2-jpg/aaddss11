// Computes sum of first n positive integers using recursion: 1 + 2 + 3 + ... + n

package org.example;

import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Error: n must be a positive integer!");
        } else {
            int result = sumOfFirstN(n);

            System.out.print("Sum of first " + n + " positive integers (");
            for (int i = 1; i <= n; i++) {
                System.out.print(i);
                if (i < n) {
                    System.out.print(" + ");
                }
            }
            System.out.println(") = " + result);
        }

        scanner.close();
    }


    public static int sumOfFirstN(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumOfFirstN(n - 1);
    }
}
