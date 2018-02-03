package com.company;

import java.io.*;
import java.util.TreeSet;

public class Main {
    public static void main(String args[]) throws IOException {
        TreeSet<String> treeset = new TreeSet<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            String[] lines = line.split(" ");
            String name = lines[0];
            String type = lines[1];
            if (type.equals("enter")) {
                treeset.add(name);
            } else if (type.equals("leave")) {
                treeset.remove(name);
            }
        } // for i-n

        int size = treeset.size();

        for (int i=0; i<size; i++) {
            String s = treeset.last();
            System.out.println(s);
            treeset.remove(s);
        }
    } // MAIN
}