// Computes sum of powers from b^0 to b^n using recursion: b^0 + b^1 + b^2 + ... + b^n

package org.example;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("b: ");
        int b = scanner.nextInt();

        System.out.print("n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Error: n must be non-negative!");
        } else {
            int result = sumOfPowers(b, n);

            System.out.print("Result: ");
            for (int i = 0; i <= n; i++) {
                System.out.print(b + "^" + i);
                if (i < n) {
                    System.out.print(" + ");
                }
            }
            System.out.println(" = " + result);
        }

        scanner.close();
    }

    public static int sumOfPowers(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return power(b, n) + sumOfPowers(b, n - 1);
    }

    public static int power(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * power(base, exp - 1);
    }
}