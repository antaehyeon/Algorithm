import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
    public int[] solution(int[] A, int K) {

        int[] array = new int[A.length];

        for (int i=0; i<A.length; i++) {
            int tempIndex = (i+K) % A.length;
            array[tempIndex] = A[i];
        }

        return array;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] array = {3, 8, 9, 7, 6};
        int[] result = answer.solution(array, 3);

        for(int i : result) {
            System.out.print(i + " ");
        }

    }
}