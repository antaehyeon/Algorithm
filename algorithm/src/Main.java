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
    public int solution(String[][] relation) {
        int answer = 0;
        int nTuple = relation.length;
        int nAttribute = relation[0].length;
        int primaryKeyIdx = 0;
        int nOnekey = 0;
        int nTwoKey = 0;
        int nThreeKey = 0;

        HashSet<String> setForDuplicationExam = new HashSet<>();

        while(true) {
            for (String[] tuple : relation) {
                setForDuplicationExam.add(tuple[primaryKeyIdx]);
            }
            primaryKeyIdx++;
            if (primaryKeyIdx == nTuple) break;
            if (setForDuplicationExam.size() == nTuple) {
                nOnekey++;
                break;
            } else {
                setForDuplicationExam.clear();
            }
        }

        setForDuplicationExam.clear();

        for (int i=0; i<nAttribute; i++) {
            for (int k=i+1; k<nAttribute; k++) {
                for (int j=0; j<nTuple; j++) {
                    String combineData = relation[j][i] + relation[j][k];
                    setForDuplicationExam.add(combineData);
                }
                if (setForDuplicationExam.size() == nTuple) nTwoKey++;
                setForDuplicationExam.clear();
            }
        }

        setForDuplicationExam.clear();

        for (int i=0; i<nAttribute; i++) {
            for (int k=i+1; k<nAttribute-1; k++) {
                for (int j=0; j<nTuple; j++) {
                    String combineData = relation[j][i] + relation[j][k] + relation[j][k+1];
                    setForDuplicationExam.add(combineData);
                }
                if (setForDuplicationExam.size() == nTuple) nThreeKey++;
                setForDuplicationExam.clear();
            }
        }

        if (nOnekey == 1) {
            nTwoKey -= nAttribute-1;
            if (nTwoKey > 0) {
                nThreeKey -= nAttribute-1;
                nThreeKey -= (nAttribute-2);
            }
        }
        answer = nOnekey + nTwoKey;

        return answer;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Solution answer = new Solution();

        String[][] testCase = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(answer.solution(testCase));
    }
}