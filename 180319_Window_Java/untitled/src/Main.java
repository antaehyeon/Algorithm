import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int a = 0, b = 0;

        for (int i=0; i<n; i++) {
            String line = bf.readLine();
            String[] lines = line.split("");

            for (int j=0; j<line.length(); j++) {
                if (lines[j].equals(")")) a++;
                else                      b++;
            }

            if (a == b) System.out.println("YES");
            else        System.out.println("NO");
            a = 0; b = 0;
        }
    }
}
