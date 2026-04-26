package org.example;

import java.util.Scanner;

public class rec {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

    }
    public static void print(int num, int n) {
        if (num > n) {
            return;
        }
        System.out.print(num);
        if (num < n) {
            System.out.print(", ");
        }
        print(n);
    }
}