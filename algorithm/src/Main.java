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

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int y = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        int E,S,M;

        E = fs.nextInt();
        S = fs.nextInt();
        M = fs.nextInt();

        while(true) {
            if (e == E && s == S && m == M) {
                System.out.println(y);
                return;
            }

            e += 1;
            s += 1;
            m += 1;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;

            y++;
        }
        return;
    }
}