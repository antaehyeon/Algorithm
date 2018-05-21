import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.print(solution("A586QK", "JJ653K"));

    }

    public static int solution(String A, String B) {
        // write your code in Java SE 8
        int result = 0;
        String[] ALEC = splitter(A);
        String[] BOB = splitter(B);

        for (int i=0; i<ALEC.length; i++) {
            ALEC[i] = transNumeric(ALEC[i]);
            BOB[i] = transNumeric(BOB[i]);

            if (stringToNum(ALEC[i]) > stringToNum(BOB[i])) {
                result++;
            }
        }

        return result;
    }

    public static String[] splitter(String S) {
        return S.split("");
    }

    public static String transNumeric(String s) {
        if (s.equals("A")) return "14";
        else if (s.equals("K")) return "13";
        else if (s.equals("Q")) return "12";
        else if (s.equals("J")) return "11";
        else if (s.equals("T")) return "10";
        else return s;
    }

    public static int stringToNum(String s) {
        return Integer.parseInt(s);
    }
}

