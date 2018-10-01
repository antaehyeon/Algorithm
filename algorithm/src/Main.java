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

    static int[] alphabets = new int[26];
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int T = fs.nextInt();

        for (int i=0; i<T; i++) {
            String line = fs.nextString();
            String[] data = line.split("");

            for (int j=0; j<data.length; j++) {
                int idx = data[j].charAt(0) - 'A';
                alphabets[idx]++;
            }

            RLE();
            Arrays.fill(alphabets, 0);
        }

        System.out.println(sb);
    }

    public static void RLE() {
        for (int i=0; i<26; i++) {
            if (alphabets[i] == 0) continue;
            char alphabet = (char)(i + 65);
            sb.append(alphabets[i]);
            sb.append(alphabet);
        }
        sb.append("\n");
    }
}