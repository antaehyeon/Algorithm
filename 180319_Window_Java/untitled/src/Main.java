import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();

        String[] lines = line.split("");

        System.out.print(lines.length);
    }
}
