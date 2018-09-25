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
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();
        int[] array = new int[n];

        for (int i=0; i<n; i++) {
            array[i] = i+1;
            sb.append((i+1) + " ");
        }
        sb.append("\n");

        while(printPermutation(array)) {};

        System.out.println(sb);
    }

    public static boolean printPermutation(int[] array) {

        final int arrLen = array.length-1;

        int i = arrLen;
        while(i>0 && array[i-1] >= array[i])
            i--;

        if (i<=0)
            return false;

        // 피벗 : array[i-1]
        // 위의 피벗과 스왑할 위의 피벗을 초과한 가장 큰 오른쪽 요소를 찾는다
        int j = arrLen;
        while (array[j] <= array[i-1])
            j--;

        // 조건 : array[j] <= array[i-1]
        // 사전순으로 경우의 수를 돌려야하기 때문에
        // array[i-1] 과 array[j] 를 이용하여 새로운 피벗을 구함
        // array[j] 가 새로운 피벗
        // Assertion j >= i

        // swap
        // pivot1 : i-1
        // pivot2 : j
        int temp = array[i-1];
        array[i-1] = array[j];
        array[j] = temp;

        // 접미사 인덱스를 이용해 반대로 만들어줌
        j = arrLen;
        while (i < j) {
            // swap
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        for (int k=0; k<n; k++) {
            sb.append(array[k] + " ");
        }
        sb.append("\n");

        return true;
    }
}