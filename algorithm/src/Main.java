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

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    String nextString() throws Exception {
        String result = br.readLine();
        return result;
    }
}

public class Main {

    static Vector<Integer> priceList = new Vector<>();
    static boolean[] index;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int days = fs.nextInt();
        index = new boolean[5];

        for (int i=0; i<days; i++) {
            int price = fs.nextInt();
            priceList.add(price);

            if (i>0) {
                int now = price;
                int before = priceList.get(i-1);

                if (now == before) {
                    stack.push(i-1);
                } else if (now > before) {
                    index[i-1] = true;
                    for (int j=0; j<stack.size(); j++) {
                        int idx = stack.get(j);
                        index[idx] = true;
                    }
                    stack.clear();
                } else if (now < before) {
                    index[i-1] = false;
                    for (int j=0; j<stack.size(); j++) {
                        int idx = stack.get(j);
                        index[idx] = false;
                    }
                    stack.clear();
                }
            }
        }

        int cnt = 0;
        long money = 0;
        int cellPrice = 0;
        for (int i=0; i<priceList.size(); i++) {
            if (index[i]) {
                money -= priceList.get(i);
                cnt++;
            } else if (!index[i]) {
                if (cnt > 0) {
                    money += (priceList.get(i) * cnt) - 1;
                    if (cellPrice == priceList.get(i)) {
                        money++;
                    }
                    cellPrice = priceList.get(i);
                    cnt = 0;
                } else {
                    continue;
                }
            }
        }

        System.out.println(money);

    }
}