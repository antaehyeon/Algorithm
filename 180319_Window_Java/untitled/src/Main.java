import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] A = {2, 2, 9, 9, 9, 2, 2, 2};
        System.out.print(solution(A, 3, 2));

    }

    public static int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
        int appleTreeNum = A.length;

        int aliceYieldAbleNum = K;
        int bobYieldAbleNum = L;
        int maxAliceAppleNum = 0;
        int maxBobAppleNum = 0;

        int aliceStartIndex = K-1;
        int aliceHarvestIndex = 0;

        int bobStartIndex = L-1;
        int bobHarvestIndex = 0;

        int aliceCount = 0;
        int bobCount = 0;

        int firstResult = 0;
        int secondResult = 0;

        if ((aliceYieldAbleNum + bobYieldAbleNum) > appleTreeNum) {
            return -1;
        }

        for (int i=aliceStartIndex; i<appleTreeNum; i++) {
            int yieldableNumber = 0;
            K = i+1;
            while (K-- > aliceCount) {
                yieldableNumber += A[K];
            }
            if (maxAliceAppleNum < yieldableNumber) {
                maxAliceAppleNum = yieldableNumber;
                aliceHarvestIndex = i;
            }
            aliceCount++;
        }

        for (int i=bobStartIndex; i<appleTreeNum; i++) {

            if ( i <= aliceHarvestIndex - aliceYieldAbleNum + 1 && i >= aliceHarvestIndex) {
                continue;
            }

            int yieldableNumber = 0;
            L = i+1;
            while (L-- > bobCount) {
                if (L >= aliceHarvestIndex - aliceYieldAbleNum + 1 && L <= aliceHarvestIndex) {
                    break;
                }
                yieldableNumber += A[L];
            }

            if (maxBobAppleNum < yieldableNumber) {
                maxBobAppleNum = yieldableNumber;
            }

            bobCount++;
        }

        firstResult = maxAliceAppleNum + maxBobAppleNum;
        aliceCount = 0;
        bobCount = 0;
        maxAliceAppleNum = 0;
        maxBobAppleNum = 0;

        for (int i=bobStartIndex; i<appleTreeNum; i++) {
            int yieldableNumber = 0;
            L = i+1;
            while (L-- > bobCount) {
                yieldableNumber += A[L];
            }
            if (maxBobAppleNum < yieldableNumber) {
                maxBobAppleNum = yieldableNumber;
                bobHarvestIndex = i;
            }
            bobCount++;
        }

        for (int i=aliceStartIndex; i<appleTreeNum; i++) {

            if ( i <= bobHarvestIndex - bobYieldAbleNum + 1 && i >= bobHarvestIndex) {
                continue;
            }

            int yieldableNumber = 0;
            K = i+1;
            while (K-- > aliceCount) {
                if (K >= bobHarvestIndex - bobYieldAbleNum + 1 && K <= bobHarvestIndex) {
                    break;
                }
                yieldableNumber += A[K];
            }

            if (maxAliceAppleNum < yieldableNumber) {
                maxAliceAppleNum = yieldableNumber;
            }

            aliceCount++;
        }

        secondResult = maxAliceAppleNum + maxBobAppleNum;

        return (firstResult > secondResult) ? firstResult : secondResult;

    }
}

