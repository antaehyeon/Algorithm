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

    static int subSetCnt = 0;
    static int N;
    static int S;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        S = fs.nextInt();

        nums = new int[N];
        visit = new boolean[N];

        for (int i=0; i<N; i++) {
            nums[i] = fs.nextInt();
        }

        DFS(0, 0, 0);

        System.out.print(subSetCnt);
    }

    public static void DFS(int v, int sum, int len) {
        if (v == N) {
            if (sum == S && len != 0) {
                subSetCnt++;
                return;
            }
            return;
        }

        DFS(v+1, sum + nums[v], len+1);
        DFS(v+1, sum, len);
    }
}