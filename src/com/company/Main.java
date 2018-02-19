package com.company;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        BigInteger[] d = new BigInteger[Math.max(n+1, 2)];
        d[0] = BigInteger.ZERO;
        d[1] = BigInteger.ONE;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1].add(d[i-2]);
        }
        System.out.println(d[n]);
    }
}