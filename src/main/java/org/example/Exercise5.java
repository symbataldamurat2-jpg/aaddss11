package org.example;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " numbers:");
        readAndReverse(n, scanner);

        scanner.close();
    }

    public static void readAndReverse(int n, Scanner scanner) {
        if (n == 0) {
            return;
        }

        int num = scanner.nextInt();

        readAndReverse(n - 1, scanner);

        System.out.print(num + " ");
    }
}