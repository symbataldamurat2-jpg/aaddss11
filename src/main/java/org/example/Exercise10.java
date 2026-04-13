// Checks whether a number is a power of two using recursive division by 2 (2^0 = 1, 2^1 = 2, 2^2 = 4, ...)

package org.example;

import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        for (int i = 0; i <= 32; i++) {
            if (isPowerOfTwo(i)) {
                System.out.println(i + " is a power of two");
            } else {
                System.out.println(i + " is not a power of two");
            }
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}
