package org.example;

import java.util.Scanner;

public class Exercise8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] sequence = new int[n];

        generate(sequence, 0, n, k);

        scanner.close();
    }

    public static void generate(int[] seq, int index, int n, int k) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(seq[i]);
            }
            System.out.println();
            return;
        }

        for (int value = 1; value <= k; value++) {
            seq[index] = value;
            generate(seq, index + 1, n, k);
        }
    }
}
