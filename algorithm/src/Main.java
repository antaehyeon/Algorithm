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
    static int[][] map;
    static ArrayList<Integer>[] a;
    static boolean[] visit;
    static int N; // 정점
    static int M; // 간선
    static int V; // 시작하는 정점 번호
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();
        V = fs.nextInt();

        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        a = (ArrayList<Integer>[]) new ArrayList[N+1];

        for (int i=0; i<=N; i++)
            a[i] = new ArrayList<>();

        // 간선의 갯수만큼 반복
        for (int i=0; i<M; i++) {
            int v1 = fs.nextInt();
            int v2 = fs.nextInt();

            map[v1][v2] = 1;
            map[v2][v1] = 1;

            a[v1].add(v2);
            a[v2].add(v1);
        }

        for (int i=1; i<=N; i++)
            Collections.sort(a[i]);

//        DFS(V);
//        DFS_STACK(V, false);
        DFS_LIST(V);
        Arrays.fill(visit, false);
        System.out.println();
//        BFS(V);
        BFS_LIST(V);

    }

    public static void DFS(int v) {

        visit[v] = true;
        System.out.print(v + " ");

        for (int i=1; i<=N; i++) {
            // map[v][i] : v-i 간선이 존재(==1)할 때
            if (map[v][i] == 1 && !visit[i]) {
                DFS(i);
            }
        }
    }

    public static void DFS_STACK(int v, boolean flag) {
        Stack<Integer> stack = new Stack<>();

        stack.push(v);
        visit[v] = true;
        System.out.print(v + " ");

        while(!stack.isEmpty()) {
            int peek = stack.peek(); // 최상위(TOP) 값을 읽으며, 스택에 영향은 없음

            flag = false;

            for (int i=1; i<=N; i++) {
                // 간선이 존재하고,
                if(map[peek][i] == 1 && !visit[i]) {
                    stack.push(i);
                    System.out.print(i + " ");

                    visit[i] = true;
                    flag = true;
                    break;
                }
            }

            if (!flag) stack.pop();
        }
    }

    public static void DFS_LIST(int v) {

        if (visit[v])
            return;

        visit[v] = true;
        System.out.print(v + " ");

        for (int list : a[v]) {
            if (!visit[list])
                DFS(list);
        }
    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        int n = map.length-1;

        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            v = q.poll(); // 제일 앞에 있는 요소를 반환하고, 해당 요소를 큐에서 제거함
            System.out.print(v + " ");

            for (int i=1; i<=n; i++) {
                if (map[v][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void BFS_LIST(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visit[v] = true;

        while(!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int vIdx : a[v]) {
                if (!visit[vIdx]) {
                    q.add(vIdx);
                    visit[vIdx] = true;
                }
            }
        }
    }

}