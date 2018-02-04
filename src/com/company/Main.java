package com.company;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {

        HashMap<String, Integer> hmap = new HashMap<>();
        HashMap<String, Integer> innerMap = new HashMap<>();
        String[] colorArray = {"black", "brown", "red", "orange", "yellow", "green", "blue",
                               "violet", "grey", "white"};

        int n = 1;
        for (int i=0; i<10; i++) {
            hmap.put(colorArray[i], i);
            innerMap.put(colorArray[i], n);
            n *= 10;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String a = bf.readLine();
        String b = bf.readLine();
        String c = bf.readLine();
        long ans = hmap.get(a)*10 + hmap.get(b);
        ans *= innerMap.get(c);

        System.out.println(ans);

    } // MAIN
}