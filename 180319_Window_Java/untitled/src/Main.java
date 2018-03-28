import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        String a = st.nextToken() + st.nextToken();
        String b = st.nextToken() + st.nextToken();

//        long result = Integer.parseInt(a) + Integer.parseInt(b);
        long result = Long.parseLong(a) + Long.parseLong(b);
        System.out.print(result);
    }
}