package com.company;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        // init
//        int a;
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<Integer> list = new ArrayList<>();
//
//        // input
//        a = Integer.parseInt(bf.readLine());
//
//        for (int i = 0; i < a; i++) {
//            list.add(Integer.parseInt(bf.readLine()));
//        }
//
//        // algorithm
//        Collections.sort(list);
//
//        // output
//        for (int x : list) {
//            System.out.println(x);
//        }


        // init
        int a;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // input
        a = sc.nextInt();
        for (int i = 0; i < a; i++)
            list.add(sc.nextInt());

        // algorithm
        Collections.sort(list);

        // output
        for (int x : list)
            System.out.println(x);
    }
}
