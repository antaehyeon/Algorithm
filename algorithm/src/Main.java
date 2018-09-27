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

    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int M = fs.nextInt();

        int n;
        int bitSet = 0;

        for (int i=0; i<M; i++) {
            String[] cmd = fs.nextLine().split(" ");

            switch (cmd[0]) {
                case "add":
                    n = Integer.parseInt(cmd[1]);
                    bitSet = bitSet | (1<<n);
                    break;
                case "remove":
                    n = Integer.parseInt(cmd[1]);
                    bitSet = bitSet & ~(1<<n);
                    break;
                case "check":
                    n = Integer.parseInt(cmd[1]);
                    int result = (bitSet & (1<<n));
                    if (result > 0)
                        sb.append("1\n");
                    else if (result == 0)
                        sb.append("0\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(cmd[1]);
                    bitSet = bitSet ^ (1<<n);
                    break;
                case "all":
                    bitSet = (1 << 21) - 1;
                    bitSet = bitSet & ~(1);
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}