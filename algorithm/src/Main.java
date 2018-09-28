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

    String nextLine() throws Exception {
        return br.readLine();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}

public class Main {

    static int D1;
    static int D2;
    static boolean seat[][] = new boolean[2001][2001];
    static int count = 0;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        D1 = fs.nextInt();
        D2 = fs.nextInt();

        for (int i=D1; i<=D2; i++) {
            for (int j=1; j<=i; j++) {
                int sum = GCD(i, j);
                if (!seat[i/sum][j/sum]) {
                    seat[i/sum][j/sum] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int GCD(int p, int q) {
        return q == 0 ? p : GCD(q, p%q);
    }
}