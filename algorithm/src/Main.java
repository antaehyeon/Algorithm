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
    public int solution(int[] A, int[] B) {
        Stack<Integer> downStreamFishes = new Stack<>();
        int aliveFishNum = 0;

        for (int i=0; i<A.length; i++) {
            if (B[i] == 0) {
                aliveFishNum++;

                if (downStreamFishes.isEmpty()) continue;

                while (!downStreamFishes.isEmpty()) {
                    aliveFishNum--;
                    if (downStreamFishes.peek() > A[i]) {
                        break;
                    }
                    else downStreamFishes.pop();
                }
            } else {
                aliveFishNum++;
                downStreamFishes.push(A[i]);
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

        int result = answer.solution(A, B);

        System.out.print(result);
    }
}