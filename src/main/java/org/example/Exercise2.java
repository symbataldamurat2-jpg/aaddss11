package org.example;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter n (number of elements to sum): ");
        int n = scanner.nextInt();

        if (n > size) {
            System.out.println("Error: n cannot be greater than array size!");
        } else {
            int result = sumOfFirstN(arr, n);

            System.out.print("Sum of first " + n + " elements (");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i < n - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.println(") = " + result);
        }

        scanner.close();
    }


    public static int sumOfFirstN(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        return arr[n - 1] + sumOfFirstN(arr, n - 1);
    }
}


