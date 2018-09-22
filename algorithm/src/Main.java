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

public class Main {

    static int[] map = new int[11];

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int nRepeat = fs.nextInt();

        for (int i=0; i<nRepeat; i++) {
            System.out.println(bottomUp(fs.nextInt()));
        }

    }

    public static int bottomUp(int n) {
        map[0] = 1; // DP 에서는 0도 1로 인식
        map[1] = 1; // 1
        map[2] = 2; // 1+1, 2

        for (int i=3; i<=n; i++) {
            map[i] = map[i-1] + map[i-2] + map[i-3];
        }

        return map[n];
    }
}