package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = bf.readLine();

        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();

        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            String[] lines = line.split("");

        }



//        BigDecimal a = new BigDecimal(lines[0]);
//        int b = Integer.parseInt(lines[1]);

//        System.out.println(a.pow(b).toPlainString());
    }
}