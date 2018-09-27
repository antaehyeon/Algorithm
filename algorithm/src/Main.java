import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
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

    static int N;
    static int[] T;
    static int[] P;
    static int maxPay = Integer.MIN_VALUE;
    static int adviceTime = 0;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();

        T = new int[N];
        P = new int[N];

        for (int i=0; i<N; i++) {
            T[i] = fs.nextInt();
            P[i] = fs.nextInt();
        }

        DFS(0, 0);

        System.out.print(maxPay);
    }

    public static void DFS(int d, int sum) {
        if (d == N) {
            maxPay = Math.max(maxPay, sum);
            return;
        }

        if (d+T[d] <= N) {
            DFS(d + T[d], sum + P[d]);
        }
        if (d+1 <= N) {
            DFS(d+1, sum);
        }
    }
}