package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        BigDecimal a = sc.nextBigDecimal();
//        int b = sc.nextInt();
//
//        BigDecimal c = a.pow(b);
//        System.out.println(c.toPlainString());

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] lines = line.split(" ");

        BigDecimal a = new BigDecimal(lines[0]);
        int b = Integer.parseInt(lines[1]);

        System.out.println(a.pow(b).toPlainString());
    }
}