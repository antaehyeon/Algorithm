package com.company;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        for(int i=0; i<a; i++) {
            int b = Integer.parseInt(bf.readLine());
            if (b==0)
                if (p.isEmpty()) System.out.println("0");
                else System.out.println(p.poll());
            else
                p.offer(b);
        } // for i-a
    } // Main
}