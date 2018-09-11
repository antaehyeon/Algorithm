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
    public int solution(String S) {
        Stack<String> stack = new Stack<>();

        String[] strArr = S.split("");

        for(String letter : strArr) {
            if (letter.equals("(")) {
                stack.push("(");
            } else {
                if (stack.size() == 0) return 0;
                if (!stack.peek().equals("(")) return 0;
                stack.pop();
            }
        }
        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String S = "())";

        int result = answer.solution(S);

        System.out.print(result);
    }
}