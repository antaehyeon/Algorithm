import java.io.*;
import java.util.*;

public class Algorithm
{
	public static void main(String[] args) {
        String[] A = {"119", "97674223", "1195524421"};
        String[] B = {"123","456","789"};
        String[] C = {"12","123","1235","567","88"};

		System.out.println(solution(A));
		System.out.println(solution(B));
		System.out.println(solution(C));
	}

    public static boolean solution(String[] phone_book) {
        boolean answer = false;

        Arrays.sort(phone_book);

        for (int i=0; i<phone_book.length-1; i++) {
            for (int j=i+1; j<phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return answer;
                if (phone_book[i].startsWith(phone_book[j])) return answer;
            }
        }
        
        answer = true;

        return answer;
    }
}