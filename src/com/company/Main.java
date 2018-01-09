package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> d = new HashSet<>();

        int n;

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            d.add(sc.nextInt());
        }

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (d.contains(sc.nextInt())) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
