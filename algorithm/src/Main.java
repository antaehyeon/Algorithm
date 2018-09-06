import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream i) throws Exception {
        br = new BufferedReader(new InputStreamReader(i));
    }

    String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}

class Solution {

    public int letterToIntger(char letter) {
        switch (letter) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 0;
    }

    public int[] solution(String S, int[] P, int[] Q) {

        int SL = S.length(); // String Length
        int[][] CA = new int[SL + 1][4]; // Count Array
        int I; // Index

        for (int i=0; i<SL; i++) {
            for (int j=0; j<4; j++) {
                CA[i+1][j] = CA[i][j];
            }
            I = letterToIntger(S.charAt(i));
            CA[i+1][I]++;
        }

        int PL = P.length; // P array Length
        int[] RA = new int[PL]; // Result Array

        for (int i=0; i<PL; i++) {
            int PD = P[i]; // P array Data
            int QD = Q[i]; // Q array Data

            for (int j=0; j<4; j++) {
                if (CA[QD+1][j] - CA[PD+0][j] > 0) {
                    RA[i] = j+1;
                    break;
                }
            }
        }

        return RA;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int[] result = answer.solution(S, P, Q);

        System.out.print(result);
    }
}