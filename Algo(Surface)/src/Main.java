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

class Tomato {
    int x, y, cnt;
    Tomato (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int[][] box;

    static int X, Y;

    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    // 상 하 좌 우

    static Queue<Tomato> q = new LinkedList<Tomato>();

    public static void BFS () {

        while (!q.isEmpty()) {
            Tomato tomato = q.remove();

            for (int i=0; i<4; i++) {
                int nextX = tomato.x + dX[i];
                int nextY = tomato.y + dY[i];

                if (nextX < 0 || nextX >= X || nextY < 0 || nextY >=Y) {
                    continue;
                }
                if (box[nextX][nextY] == -1 || box[nextX][nextY] >= 1) {
                    continue;
                }
                q.add(new Tomato(nextX, nextY, tomato.cnt+1));
                box[nextX][nextY] = tomato.cnt+1;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        X = fs.nextInt();
        Y = fs.nextInt();

        box = new int[X][Y];

        boolean chk = true;

        // 박스만들기
        for (int i=0; i<Y; i++) {
            String line = fs.nextString();
            String[] splitData = line.split(" ");
            for (int j=0; j<X; j++) {

                int temp = Integer.parseInt(splitData[j]);
                if (temp == 1) {
                    box[j][i] = temp;
                    q.add(new Tomato(j, i, 0));
                } else if(temp == -1) {
                    box[j][i] = temp;
                } else {
                    chk = false;
                }
            }
        }

        // 처음부터 모든 토마토가 익어있을 경우
        if (chk) {
            System.out.print("0");
            return;
        }

        BFS();

        chk = true;

        int result = 0;

        for (int i=0; i<X; i++) {
            for (int j=0; j<Y; j++) {
                if (box[i][j] > result) {
                    result = box[i][j];
                }
                if (box[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(result);
    }
}