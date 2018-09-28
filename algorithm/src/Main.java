import java.io.BufferedReader;
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

    String nextLine() throws Exception {
        return br.readLine();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }
}

public class Main {
    static int[] bag = new int[3];
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        String command = fs.nextLine();
        String[] nums = command.split(" ");

        for (String s : nums) {
            int item = Integer.parseInt(s);
            int bagSize = calBagSize();

            if (bagSize < 3) {
                bag[bagSize] = item;
                continue;
            }

            if(isContainItem(item)) {
                int idx = calItemIdx(item);
                if (idx == 0) {
                    swap(0,1);
                    swap(1,2);
                    bag[2] = item;
                } else if (idx == 1) {
                    swap(1,2);
                } else {
                    continue;
                }
            } else {
                swap(0, 1);
                swap(1, 2);
                sb.append(bag[2] + "\n");
                bag[2] = item;
            }
        }
        if (sb.toString().equals("")) sb.append(0);
        System.out.println(sb);
    }

    public static void swap (int a, int b) {
        int temp = bag[a];
        bag[a] = bag[b];
        bag[b] = temp;
    }

    public static boolean isContainItem(int n) {
        for (int item : bag) {
            if (n == item) return true;
        }
        return false;
    }

    public static int calItemIdx(int n) {
        for (int i=0; i<3; i++) {
            if (n == bag[i]) return i;
        }
        return -1;
    }

    public static int calBagSize() {
        int size = 0;
        for (int item : bag) {
            if (item != 0) size++;
        }
        return size;
    }
}