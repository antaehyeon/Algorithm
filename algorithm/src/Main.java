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
    static int[] arr;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        while ((N = fs.nextInt()) != 0) {

            arr = new int[N];

            for (int i=0; i<N; i++)
                arr[i] = fs.nextInt();

            for (int i=0; i<N; i++) {
                cnt = 1;
                DFS(i, arr[i] + " ");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void DFS(int v, String str) {
        if (cnt == 6)
            sb.append(str + "\n");
        else {
            for (int i=v+1; i<N; i++) {
                cnt++;
                DFS(i, str+arr[i] + " ");
            }
        }
        cnt--;
    }

}