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
    public int solution(int A, int B) {
        while(A % B != 0) {
            A %= B;
            // swap
            int tmp = A;
            A = B;
            B = tmp;
        }

        return B;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        int A = fs.nextInt();
        int B = fs.nextInt();

        int gcd = answer.solution(A, B);
        int lcm = (A * B) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}