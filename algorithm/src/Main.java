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
}

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> userDB = new HashMap<>();

        for (String cmd : record) {
            String[] userData = cmd.split(" ");
            String command = userData[0];
            if (command.equals("Enter") || command.equals("Change")) {
                String userID = userData[1];
                String userNickName = userData[2];
                userDB.put(userID, userNickName);
            }
        }

        for (String cmd : record) {
            String[] userData = cmd.split(" ");
            String command = userData[0];
            String userID = userData[1];
            String nickName = userDB.get(userID);
            String logData = "";

            if (command.equals("Enter"))
                logData = nickName + "님이 들어왔습니다.";
            else if (command.equals("Leave"))
                logData = nickName + "님이 나갔습니다.";
            else continue;

            result.add(logData);
        }

        return result.toArray(new String[result.size()]);
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] result = answer.solution(record);

        for (String s : result) {
            System.out.println(s);
        }
    }
}