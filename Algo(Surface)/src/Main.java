import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

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

    final static int MON = 1;
    final static int TUE = 2;
    final static int WED = 3;
    final static int THU = 4;
    final static int FRI = 5;
    final static int SAT = 6;
    final static int SUN = 0;

    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int month = fs.nextInt();
        int day = fs.nextInt();

        int result = day;

        for (int i=1; i<month; i++) {
            result += days[i-1];
        }

        result %= 7;

        switch (result) {
            case MON:
                System.out.println("MON");
                break;
            case TUE:
                System.out.println("TUE");
                break;
            case WED:
                System.out.println("WED");
                break;
            case THU:
                System.out.println("THU");
                break;
            case FRI:
                System.out.println("FRI");
                break;
            case SAT:
                System.out.println("SAT");
                break;
            case SUN:
                System.out.println("SUN");
                break;
        }
    }
}

