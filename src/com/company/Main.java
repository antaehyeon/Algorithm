package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashSet<String> ans = new HashSet<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int a = 0;
        int b = 0;
        int c = 0;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (c==0) a = n;
            else      b = n;
            for (int i = 0; i < n; i++) {
                if (c==1) {
                    String s = bf.readLine();
                    set2.add(s);
                    continue;
                }
                String s = bf.readLine();
                set1.add(s);
                if (i==a-1) c++;
            }
        }

        String[] set1Array = set1.toArray(new String[set1.size()]);
        String[] set2Array = set2.toArray(new String[set2.size()]);

        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                if (set1Array[i].equals(set2Array[j])) {
                    ans.add(set2Array[j]);
                    break;
                }
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (String s : ans) {
            list.add(s);
        }

        Collections.sort(list);

        int ls = list.size();
        for (int i=0; i<ls; i++)
            System.out.println(list.get(i));



    } // MAIN
}