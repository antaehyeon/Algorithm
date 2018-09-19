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
    public void solution(int A, int B, int C) {
        int answerA = (A+B)%C;
        int answerB = (A%C + B%C)%C;
        int answerC = (A*B)%C;
        int answerD = (A%C * B%C)%C;

        System.out.println(answerA);
        System.out.println(answerB);
        System.out.println(answerC);
        System.out.println(answerD);
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int A = fs.nextInt();
        int B = fs.nextInt();
        int C = fs.nextInt();

        answer.solution(A, B, C);

    }
}