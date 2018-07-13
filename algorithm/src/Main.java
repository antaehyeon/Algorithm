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
        int answer = 2;
        int n = s.length()-1;
        String tmp = "";

        if (checkPalindrome(s)) return s.length();
        if (s.length() == 1) return 1;

        int j = 0;
        int k = 0;
        for (int i=0; i<s.length(); i++) {
            if (n==2) return 2;
            j = 0;
            k = n;
            while(true) {
                tmp = s.substring(j, k);
                if (checkPalindrome(tmp)) return tmp.length();
                if (k == s.length()) break;
                j++; k++;
            }
            n--;
        }

        return answer;
    }

    public boolean checkPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String tmp = sb.reverse().toString();

        if (s.equals(tmp)) return true;
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