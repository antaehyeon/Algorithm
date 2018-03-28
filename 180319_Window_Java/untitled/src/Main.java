import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V;
    static int E;
    static int[][] graph;
    static int[] visited;
    public static int mode = 1;
    static boolean BipartiteChk = false;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(bf.readLine());

        // 테스트케이스만큼 반복
        for (int i=0; i<testCase; i++) {
            st = new StringTokenizer(bf.readLine(), " ");

            // 정점과 간선을 받음
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new int[V+5][V+5];
            visited = new int[V+5];

            int a; int b;

            // 그래프 체크
            for (int j=0; j<E; j++) {
                st = new StringTokenizer(bf.readLine(), " ");

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                graph[a][b] = graph[b][a] = 1;
            }

            DFS(1);
            String result = (BipartiteChk) ? "NO" : "YES";
            System.out.println(result);

            for (int k=1; k<=V; k++) {
                visited[k] = 0;
            }
        }
    }

    public static void DFS (int i) {
        visited[i] = mode;
        mode = (mode == 1) ? 2 : 1;

        for (int j=1; j<=V; j++) {
            if (graph[i][j] == 1 && visited[j] == 0) {
                // 방문을 아직 하지 않았다면
                visited[j] = mode;
                DFS(j);
            } else if (graph[i][j] == 1 && visited[j] != mode) {
                BipartiteChk = true;
                break;
            }
        }
    }
}