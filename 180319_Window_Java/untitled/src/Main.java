import java.io.BufferedReader;
import java.io.IOException;
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

    static int V;
    static int E;
    static ArrayList<Integer>[] graph;
    static int[] c;

    final static int RED = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int testCase = fs.nextInt();

        // 테스트케이스만큼 반복
        for (int i=0; i<testCase; i++) {

            // 정점과 간선을 받음
            V = fs.nextInt();
            E = fs.nextInt();

            graph = (ArrayList<Integer>[]) new ArrayList[V+1];
            c = new int[V+1];

            for (int k=0; k<=V; k++) {
                graph[k] = new ArrayList<Integer>();
            }

            // 그래프 체크
            for (int j=0; j<E; j++) {
                int a, b;

                a = fs.nextInt();
                b = fs.nextInt();

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int s=1; s<=V; s++) {
                if (c[s] == 0) {
                    DFS(s, RED);
                }
            }

            boolean BipartiteChk = true;

            for(int k=1; k<=V; k++){
                for(int j = 0; j < graph[k].size(); j++){
                    if(c[k] == c[graph[k].get(j)]){
                        BipartiteChk = false;
                    }
                }
            }

            String result = (BipartiteChk) ? "YES" : "NO";
            System.out.println(result);

        }
    }

    public static void DFS (int i, int color) {
        c[i] = color;

        for (int j : graph[i]) {
            if (c[j] == 0) {
                DFS(j, 3-color);
            }
        }
    }
}