package com.company;

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] lines = line.split(" ");

        BigInteger a = new BigInteger(lines[0]);
        BigInteger b = new BigInteger(lines[1]);

        System.out.println(a.add(b));
    }
}