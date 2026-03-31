package org.example;

import java.util.Scanner;

public class Exercise9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        char[] arr = str.toCharArray();

        permutations(arr, 0);

        scanner.close();
    }

    public static void permutations(char[] arr, int fixed) {
        if (fixed == arr.length - 1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = fixed; i < arr.length; i++) {
            swap(arr, fixed, i);
            permutations(arr, fixed + 1);
            swap(arr, fixed, i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
