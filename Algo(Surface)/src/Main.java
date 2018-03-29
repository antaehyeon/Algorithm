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

    static final int[] dRow = {0, -1, 0, 1};
    static final int[] dCol = {-1, 0, 1, 0};

    static int N;
    static int[][] map = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static ArrayList<Integer> a = new ArrayList<Integer>();
    static Vector<Integer> v = new Vector<Integer>();

    public static int DFS(int row, int col, int groupN, int cnt) {

        cnt++;
        visited[row][col] = true;

        for (int i=0; i<4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 아래, 왼쪽, 위에, 오른쪽 순으로 탐색

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) continue;
            if (map[nextRow][nextCol] == 0) continue;
            if (visited[nextRow][nextCol]) continue;

            cnt = DFS(nextRow, nextCol, groupN, cnt);
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        // 입력

        N = fs.nextInt();


        for (int a=0; a<N; a++) {
            String line = fs.next();
            char[] splitData = line.toCharArray();

            for (int b=0; b<N; b++) {
                map[a][b] = splitData[b] - '0';
            }
        }

        // 계산
        int groupN = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    // 요소가 있는데 방문을 안한경우 체크
                    groupN++;
                    int cnt = DFS(i, j, groupN, 0);

                    v.add(cnt);
                }
            }
        }

        Collections.sort(v);

        // 출력

        System.out.println(groupN);
        for (int data : v) {
            System.out.println(data);
        }

    }
}