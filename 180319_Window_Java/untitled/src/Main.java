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

        for (int i=0; i<n; i++) {
            x = fs.nextInt();
            y = fs.nextInt();

            for (int j=x; j<=y; j++) {
                list.add(j);
            }
        }

        Collections.sort(list);

        int maxSize = list.get(list.size()-1);

        int[] array = new int[maxSize+1];

        for (int t : list) {
            array[t]++;
        }

        boolean firstMode = false;
        boolean mode2 = false;
        boolean mode3 = false;
        int startNumberTwoIndex = 0;
        int endNumberTwoIndex = 0;

        for (int i=1; i<=maxSize; i++) {
            if (i == maxSize) {
                sb.append("(");
                sb.append(i);
                sb.append(", +)");
                continue;
            }

            if (!firstMode && array[i] == 1) {
                firstMode = true;
                sb.append("(-, ");
                sb.append(i);
                sb.append(")\n");
                continue;
            }

            if (!mode2 && array[i] == 2) {
                mode2 = true;
                startNumberTwoIndex = i;
                continue;
            }

            if (!mode3 && array[i] == 1) {
                mode2 = false; mode3 = true;
                endNumberTwoIndex = i-1;
                sb.append("[");
                sb.append(startNumberTwoIndex);
                sb.append(", ");
                sb.append(endNumberTwoIndex);
                sb.append("]\n");
                continue;
            }

            if (mode3 && array[i] == 1) {
                endNumberTwoIndex++;
                sb.append("(");
                sb.append(endNumberTwoIndex);
                sb.append(", ");
                sb.append(i);
                sb.append(")\n");
                continue;
            }
        }

        System.out.println(sb.toString());
    }
}

