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
        Stack<Character> stack = new Stack<>();

        if (S == null) return 1;
        char[] strArr = S.toCharArray();
        if (strArr.length == 1) return 1;


        for(char letter : strArr) {
            if (letter == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return 0;
                if (!stack.peek().equals('(')) return 0;
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
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