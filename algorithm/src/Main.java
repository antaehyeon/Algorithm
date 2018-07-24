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
    public int solution(int[] A, int[] B) {

        int aliveFishNum = A.length;
        int fishNum = A.length;
        Stack<Integer> bottomFishes = new Stack<>();

        for (int i=0; i<fishNum; i++) {
            if (B[i] == 1) {
                bottomFishes.push(A[i]);
                continue;
            }

            while (bottomFishes.size() != 0) {
                aliveFishNum--;
                if (bottomFishes.peek() > A[i]) {
                    break;
                } else {
                    bottomFishes.pop();
                }
            }
        }
        return aliveFishNum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        System.out.println(answer.solution(A, B));
    }
}