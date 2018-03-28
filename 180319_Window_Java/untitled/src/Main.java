import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean visited[];
    static int N;
    static int E;
    static int start;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());       // 정점
        E = Integer.parseInt(st.nextToken());       // 간선
        start = Integer.parseInt(st.nextToken());   // 시작지점

        graph = new int[1001][1001];        // 정점의갯수 N, 간선의갯수 M
        visited = new boolean[10001];       // 간선의 갯수

        int a, b;

        for (int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 간선 데이터 Ex) 1 2
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 그래프 설정
            graph[a][b] = graph[b][a] = 1;
        }

        DFS(start);

        System.out.println(sb.toString().trim());
        sb.delete(0, sb.length());

        // 방문 체크 배열 초기화
        for (int j=1; j<=N; j++) {
            visited[j] = false;
        }

        BFS(start);
        System.out.println(sb.toString().trim());
    }

    public static void DFS(int i) {

        visited[i] = true;

        sb.append(i + " ");

        for (int j=0; j<=N; j++) {
            if (graph[i][j] == 1 && !visited[j]) {
                DFS(j);
            }
        }
    }

    public static void BFS(int i) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(i);     // 큐에 데이터 추가
        visited[i] = true;  // 방문했다 체크

        sb.append(i + " ");

        int temp;
        while(!q.isEmpty()) {
            temp = q.poll();
            for (int j=0; j<N+1; j++) {
                if (graph[temp][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                    sb.append(j + " ");
                }
            }
        }

    }
}