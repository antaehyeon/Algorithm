import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int x = 0, y = 0;
        int n = fs.nextInt();
        int d = fs.nextInt();
        int k = fs.nextInt();
        int j = fs.nextInt();

        System.out.println(solution(n, d, k, j));
    }

    public static int solution(int n, int d, int k, int j) {

        LinkedList<Integer> list = new LinkedList<>();

        if (d==1) {
            for (int i=1; i<=n; i++) {
                list.add(i);
            }
        } else {
            list.add(1);
            n += 1;
            while (n-- > 2) {
                list.add(n);
            }
        }

        int movePosition = k;
        int index = movePosition;
        list.remove(index);
        index -= 1;

        while(list.size() != 1) {
            movePosition += j;
            index += movePosition;

            if (index >= list.size()) {
                index %= list.size();
            }

            list.remove(index);
            index -= 1;
        }

        return list.getFirst();
    }
}

