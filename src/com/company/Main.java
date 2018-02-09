package com.company;

import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point that) {
        if (this.y < that.y) {
            return -1;
        } else if (this.y == that.y) {
            if (this.x < that.x) {
                return -1;
            } else if (this.x == that.x) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point[] a = new Point[n];
        for (int i=0; i<n; i++) {
            String[] temp = bf.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            a[i] = new Point(x, y);
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (Point p : a) {
            sb.append(p.x + " " + p.y + "\n");
        }
        System.out.print(sb);
    }
}