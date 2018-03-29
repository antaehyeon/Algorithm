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

    public static void LOG(String data) {
        System.out.println(data);
    }

    public static void LOG(int data) {
        System.out.println(data);
    }

    public static void LOG(double data) {
        System.out.println(data);
    }

    public static int DFS(int[] graph, int[] check, int[] startVertex, int start, int cnt, int step) {

        if (check[start] != 0) {
            if (step != startVertex[start]) {
                // 이미 방문했고, 정점 시작점이 다를 경우 사이클 X
                return 0;
            }

            return cnt - check[start];
        }

        check[start] = cnt;
        startVertex[start] = step;

        return DFS(graph, check, startVertex, graph[start], cnt + 1, step);
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int[] graph;
        int[] check;
        int[] startVertex;

        int testCase = fs.nextInt();

        while (testCase-- > 0) {
            int sn = fs.nextInt();

            graph = new int[sn+1];
            check = new int[sn+1];
            startVertex = new int[sn+1];

            for (int i=1; i<=sn; i++) {
                int data = fs.nextInt();
                graph[i] = data;
            }

            int result = 0;
            for (int i=1; i<=sn; i++) {
                if (check[i] == 0) {
                    result += DFS(graph, check, startVertex, i, 1, i);
                }
            }

            System.out.println(sn - result);
        }

    }
}











