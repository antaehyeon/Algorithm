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
    public int solution(String s) {
        int answer = 0;

        if (checkPalindrome(s)) return s.length();

        int n = 3;
        String tmp = "";
        answer = 2;

        while(n <= s.length()) {
            tmp = s.substring(0, n);
            if (checkPalindrome(tmp)) answer = tmp.length();
            n++;
        }

        return answer;
    }

    public boolean checkPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String ts = sb.reverse().toString();

        if (s.equals(ts)) return true;
        else return false;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String line = fs.next();

        System.out.println(answer.solution(line));
    }
}