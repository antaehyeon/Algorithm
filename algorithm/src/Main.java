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
        Stack<Character> letterStack = new Stack<>();

        for (char letter : S.toCharArray()) {
            if (letter == '(' || letter == '{' || letter == '[') {
                letterStack.push(letter);
            } else {
                if (letterStack.isEmpty()) return 0;
                char stackPeekData = letterStack.peek();
                if (letter == ')' && stackPeekData != '(') return 0;
                else if (letter == '}' && stackPeekData != '{') return 0;
                else if (letter == ']' && stackPeekData != '[') return 0;
                letterStack.pop();
            }
        }
        return (letterStack.isEmpty()) ? 1 : 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String S = "{[()()]}";

        int result = answer.solution(S);

        System.out.print(result);
    }
}