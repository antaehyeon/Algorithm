import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N = 0; int M = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) -1;

        for (int i=1; i<=N; i++) {
            list.add(i);
        }

        int index = 0;

        while(!list.isEmpty()) {
            index += M;
            if (index >= list.size()) {
                index %= list.size();
            }
            sb.append(list.remove(index) + ", ");
        }
        System.out.println(sb.toString().substring(0, sb.length()-2) + ">");
    }
}