package com.company;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        LinkedList<String> a = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++) {
            String[] lines = bf.readLine().split(" ");
            switch (lines[0]) {
                case "push":
                    a.offer(lines[1]);
                    break;
                case "pop":
                    if (a.isEmpty()) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(a.poll());
                    break;
                case "size":
                    System.out.println(a.size());
                    break;
                case "empty":
                    if(a.isEmpty()) System.out.println("1");
                    else            System.out.println("0");
                    break;
                case "front":
                    if (a.isEmpty()) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(a.peekFirst());
                    break;
                case "back":
                    if (a.isEmpty()) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(a.peekLast());
                    break;
            } // switch
        } // for i-n
    } // Main
}