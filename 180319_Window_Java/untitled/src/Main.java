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

    public static void LOG (String data) {
        System.out.println(data);
    }

    public static void LOG (int data) {
        System.out.println(data);
    }

    public static void DFS (ArrayList<Integer>[] g, int[] visit, int start ) {
        visit[start] = 1;

        for (int data : g[start]) {
            if (visit[data] == 0) {
                DFS(g, visit, data);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        ArrayList<Integer>[] g;
        int[] visit;

        int result = 0;
        int testCase = fs.nextInt();

        for (int t=0; t<testCase; t++) {
            int N = fs.nextInt();
             g = (ArrayList<Integer>[]) new ArrayList[N+1];
             visit = new int[N+1];
            for (int i=0; i<=N; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i=1; i<=N; i++) {
                int input = fs.nextInt();
                g[i].add(input);
            }
            for (int i=1; i<=N; i++) {
                if (visit[i] == 0) {
                    DFS(g, visit, i);
                    result++;
                }
            }
            System.out.println(result);
            result = 0;
        }
    }
}