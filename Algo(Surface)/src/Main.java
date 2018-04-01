////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStream;
////import java.io.InputStreamReader;
////import java.util.*;
////
////class FastScanner {
////
////    BufferedReader br;
////    StringTokenizer st;
////
////
////    FastScanner(InputStream i) throws Exception {
////        br = new BufferedReader(new InputStreamReader(i));
////    }
////
////    String next() throws Exception {
////        while (st == null || !st.hasMoreTokens()) {
////            st = new StringTokenizer(br.readLine());
////        }
////        return st.nextToken();
////    }
////
////    int nextInt() throws Exception {
////        return Integer.parseInt(next());
////    }
////
////    String nextString() throws Exception {
////        String result = br.readLine();
////        return result;
////    }
////}
////
////public class Main {
////
////    /**
////     * Time complexity:
////     * Space complexity:
////     */
////    public static void main(String[] args) throws Exception {
////        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
////            int T = Integer.parseInt(br.readLine().trim());
////
////            String result = "";
////            String temp;
////            int cnt = 0;
////            boolean chk = false;
////
////            for (int i = 0; i < T; ++i) {
////                String word = br.readLine().trim();
////                String[] words = word.split("");
////
////                String preLetter = "";
////
////                for (int j=0; j<word.length(); j++) {
////                    temp = words[j];
////                    if (preLetter.equals("")) {
////                        preLetter = temp;
////                        cnt++;
////                    } else if (preLetter.equals(temp)) {
////                        cnt++;
////                    } else if (!preLetter.equals(temp)){
////                        if (j==word.length()-1) {
////                            chk = true;
////                        }
////                        result += cnt;
////                        result += preLetter;
////                        preLetter = temp;
////                        cnt = (j==word.length()-1) ? cnt : 1;
////                    }
////                }
////                cnt = (chk) ? 1 : cnt;
////                result += cnt + preLetter;
////                System.out.println(result);
////                result = "";
////                preLetter = "";
////                cnt = 0;
////                chk = false;
////            }
////        }
////    }
////}
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//class Shop implements Comparable<Shop>{
//
//    int index;
//    int x; int y;
//    String name;
//    int coupon;
//    int calX;
//    int calY;
//    int forSortData;
//
//    Shop(int index, int x, int y, int calX, int calY, String name, int coupon) {
//        this.index = index;
//        this.x = x;
//        this.y = y;
//        this.calX = calX;
//        this.calY = calY;
//        this.name = name;
//        this.coupon = coupon;
//
//        forSortData = calX + calY;
//    }
//
//    public String toString() {
//        return "" + x + " " + y + " " + name + " " + coupon + " " + forSortData;
//    }
//
//    @Override
//    public int compareTo(Shop s) {
////        if (forSortData == s.forSortData) {
////            if (coupon == s.coupon) {
////            }
////            return s.coupon - coupon;
////        }
//        return forSortData - s.forSortData;
//    }
//}
//
//public class Main {
//
//    static LinkedList<Shop> s = new LinkedList<>();
//
//    /**
//     * Time complexity:
//     * Space complexity:
//     */
//    public static int division100(int data) {
//        return (data/100) * 100;
//    }
//
//    public static void main(String[] args) throws Exception {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
//            int userX = Integer.parseInt(tokens.nextToken());
//            int userY = Integer.parseInt(tokens.nextToken());
//            int shopCount = Integer.parseInt(tokens.nextToken());
//
//            for (int i = 0; i < shopCount; i++) {
//                tokens = new StringTokenizer(br.readLine().trim());
//                int shopX = Integer.parseInt(tokens.nextToken());
//                int shopY = Integer.parseInt(tokens.nextToken());
//                String name = tokens.nextToken();
//                int coupon = Integer.parseInt(tokens.nextToken());
//
//                userX = division100(userX);
//                userY = division100(userY);
//                int calShopX = division100(shopX);
//                int calShopY = division100(shopY);
//
//                s.add(new Shop(i, shopX, shopY, Math.abs(userX-calShopX), Math.abs(userY-calShopY), name, coupon));
//
//            }
//
//            Collections.sort(s);
//
//            for (Shop tmp : s) {
//                System.out.println(tmp.toString());
//            }
//        }
//    }
//}
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashSet<Integer> s = new HashSet<Integer>();
    static ArrayList<Integer>[] graph;
    static int[] visited = new int[100001];
    static Vector<Integer> v = new Vector<>();
    static int result;
    static int maxN = 0;

    /**
     * Time complexity:
     * Space complexity:
     */

    public static void DFS(int x) {

        visited[x] = 1;

        for (int i=0; i<graph[x].size(); i++) {
            if (visited[graph[x].get(i)] == 1) {
                continue;
            }
            DFS(graph[x].get(i));
        }

    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(tokens.nextToken());
                int y = Integer.parseInt(tokens.nextToken());

                s.add(x);
                s.add(y);

                v.add(x);
                v.add(y);
            }

            graph = new ArrayList[100001];

            for (int x : s) {
                graph[x] = new ArrayList<>();
            }

            for (int i=0; i<v.size(); i++) {
                int x = v.get(i);
                int y = v.get(++i);

                graph[x].add(y);
                graph[y].add(x);
            }

            for (int x : s) {
                if (visited[x] == 0) {
                    result++;
                    DFS(x);
                }
            }

            System.out.println(result);

        }
    }
}

