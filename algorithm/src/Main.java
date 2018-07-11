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

public class Main {

    static int[] a = new int[10003];
    static int[] dp = new int[10003];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        for (int i=1; i<=n; i++) {
            a[i] = fs.nextInt();
        }

        dp[1] = a[1];
        dp[2] = a[1] + a[2];

        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1];
            if (dp[i] < dp[i-2] + a[i]) {
                dp[i] = dp[i-2] + a[i];
            }
            if (dp[i] < dp[i-3] + a[i] + a[i-1]) {
                dp[i] = dp[i-3] + a[i] + a[i-1];
            }
        }

        System.out.println(dp[n]);

    }
}