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

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

class Position {
    int x, y, cnt;
    Position (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int[][] box;
    static boolean[][] visited;

    static int X, Y;

    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    // 상 하 좌 우

    static Queue<Position> q = new LinkedList<Position>();

    public static void BFS () {

        while (!q.isEmpty()) {
            Position p = q.remove();

            for (int i=0; i<4; i++) {
                int nextX = p.x + dX[i];
                int nextY = p.y + dY[i];

                if (nextX < 0 || nextX >= X || nextY < 0 || nextY >= Y) {
                    continue;
                }
                if (box[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }
                q.add(new Position(nextX, nextY, p.cnt+1));
                box[nextX][nextY] = p.cnt+1;
                visited[nextX][nextY] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        Y = fs.nextInt();   // 4
        X = fs.nextInt();   // 6

        box = new int[X][Y];
        visited = new boolean[X][Y];

        // 박스만들기
        for (int i=0; i<Y; i++) {
            String line = fs.nextString();
            String[] splitData = line.split("");
            for (int j=0; j<X; j++) {

                int temp = Integer.parseInt(splitData[j]);
                if (temp == 1) {
                    box[j][i] = 1;
                }
            }
        }

        q.add(new Position(0, 0, 1));
        visited[0][0] = true;

        BFS();

        int result = box[X-1][Y-1];

        System.out.println(result);
    }
}