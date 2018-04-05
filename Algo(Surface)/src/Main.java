import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        StringBuilder sb = new StringBuilder("");

        String line = fs.nextString();
        String[] words = line.split("");
        int lineL = line.length();

        for (int i=0; i<lineL; i++) {

            sb.append(words[i]);

            if (sb.length() == 10) {
                System.out.println(sb);
                sb.setLength(0);
            }

        }

        System.out.println(sb);

    }
}

