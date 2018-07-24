import java.io.*;
import java.util.*;

public class Algorithm
{
	public static void main(String[] args) {
		int[] A = {4, 3, 2, 1, 5};
		int[] B = {0, 1, 0, 0, 0};

		System.out.println(solution(A, B));
	}

    public static int solution(int[] A, int[] B) {

        int aliveFishNum = A.length;
        int fishNum = A.length;
        Stack<Integer> bottomFishes = new Stack<>();

        for (int i=0; i<fishNum; i++) {
            if (B[i] == 1) {
                bottomFishes.push(A[i]);
                continue;
            }

            while (bottomFishes.size() != 0) {
                aliveFishNum--;
                if (bottomFishes.peek() > A[i]) {
                    break;
                } else {
                    bottomFishes.pop();
                }
            }
        }
        return aliveFishNum;
    }
}