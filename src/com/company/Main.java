package com.company;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bf.readLine().split(" ");
        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[1]);

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0; i<a; i++) {
            String name = bf.readLine();
            hm.put(name, 1);
        } // FOR-듣는사람 입력문
        for (int i=0; i<b; i++) {
            String name = bf.readLine();
            Integer c = hm.get(name);
            if (c == null) {
                c = 0;
            }
            c += 2;
            hm.put(name, c);
        } // FOR-보는사람 입력문

        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 3) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }

    } // Main
}