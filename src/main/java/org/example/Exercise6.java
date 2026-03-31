package org.example;

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = Integer.parseInt(scanner.nextLine());

        readAndReverse(n, scanner);

        scanner.close();
    }

    public static void readAndReverse(int n, Scanner scanner) {
        if (n == 0) {
            return;
        }

        char[] str = scanner.nextLine().toCharArray();

        readAndReverse(n - 1, scanner);

        System.out.println(new String(str));
    }
}