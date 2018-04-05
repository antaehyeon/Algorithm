import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        Scanner sc = new Scanner(System.in);

        String line = "";

        while((line=fs.nextString()) != null && line.length() != 0) {

            String[] ns = line.split(" ");

            if (ns[0].equals("0") && ns[1].equals("0")) {
                break;
            }

            System.out.println(Integer.parseInt(ns[0]) + Integer.parseInt(ns[1]));

        }
    }
}

