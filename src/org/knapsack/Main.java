package org.knapsack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Liczba przedmiotow:");
        int n = scanner.nextInt();

        System.out.println("ziarno:");
        int seed = scanner.nextInt();

        System.out.println("pojemnosc:");
        int capacity = scanner.nextInt();

        Problem problem = new Problem(n, seed, 1, 10);
        System.out.println(problem);

        Result result = problem.solve(capacity);
        System.out.println(result);
    }
}