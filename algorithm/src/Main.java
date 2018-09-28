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

    String nextLine() throws Exception {
        return br.readLine();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}

public class Main {

    static int N;
    static int[][] map = new int[101][101];
    static int[] area;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        area = new int[N+1];

        for (int i=0; i<N; i++) {
            int X = fs.nextInt();
            int Y = 100-fs.nextInt();
            int sizeX = fs.nextInt();
            int sizeY = fs.nextInt();
            int tmpX = X;
            for (int j=0; j<sizeY; j++) {
                for (int k=0; k<sizeX; k++, X++) {
                    map[X][Y] = i+1;
                }
                X = tmpX;
                Y--;
            }
        }

        for (int i=0; i<101; i++) {
            for (int j=0; j<101; j++) {
                if (map[i][j] == 0) continue;
                else {
                    int paperId = map[i][j];
                    area[paperId]++;
                }
            }
        }

        for (int i=1; i<N+1; i++) {
            System.out.println(area[i]);
        }
    }
}