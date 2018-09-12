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
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int h : H) {
            while(!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == h) continue;
            if (stack.isEmpty() || stack.peek() < h) {
                stack.push(h);
                result++;
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        int result = answer.solution(H);

        System.out.print(result);
    }
}