import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null && line.length() != 0) {
            char[] words = line.toCharArray();

            int small = 0; int big = 0;
            int space = 0; int number = 0;
            int error = 0;

            for (char a : words) {
                if ('a' <= a && 'z' >= a) {
                    small++;
                }
                else if ('A' <= a && 'Z' >= a) {
                    big++;
                }
                else if (' ' == a) {
                    space++;
                }
                else if ('0' <= a && '9' >= a) {
                    number++;
                }
                else {
                    error++;
                }
            }

            String result = small + " " + big + " " + number + " " + space + "\n";
            sb.append(result);
        }

        System.out.print(sb);
        br.close();
    }
}