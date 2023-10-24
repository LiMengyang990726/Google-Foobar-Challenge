package Level4.DistractTheTrainers;

// List length <= 100
// Number = 2 ^ 30 - 1
public class Solution {
    // Greatest common divisor (reduce the number to the lowest format)
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static boolean isPowerOfTwo(int n) {
        double logRes = Math.log(n) / Math.log(2);
        return (int) (Math.ceil(logRes)) == (int) (Math.floor(logRes));
    }

    private static boolean bpm(boolean[][] pairingMap, int i, boolean[] seen, int[] matchR) {
        for (int j = 0; j < pairingMap.length; j++) {
            if (pairingMap[i][j] && !seen[j]) {
                seen[j] = true;

                if (matchR[j] < 0 || bpm(pairingMap, matchR[j], seen, matchR)) {
                    matchR[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    private static int maxBPM(boolean[][] pairingMap) {
        int[] matchR = new int[pairingMap.length];
        for (int i = 0; i < pairingMap.length; i++) {
            matchR[i] = -1;
        }

        int result = 0;
        for (int i = 0; i < pairingMap.length; i++) {
            boolean[] seen = new boolean[pairingMap.length];
            for (int j = 0; j < pairingMap.length; j++) {
                seen[j] = false;
            }

            if (bpm(pairingMap, i, seen, matchR)) {
                result++;
            }
        }
        return pairingMap.length - 2 * (result / 2);
    }

    public static int solution(int[] banana_list) {
        // Corner case:
        if (banana_list.length <= 1) {
            return banana_list.length;
        }

        // Step 1: Compute the pairing relationship
        boolean[][] pairingMap = new boolean[banana_list.length][banana_list.length];
        for (int i = 0; i < banana_list.length; i++) {
            for (int j = i + 1; j < banana_list.length; j++) {
                int newNum = (banana_list[i] + banana_list[j]) / gcd(banana_list[i], banana_list[j]);
                pairingMap[i][j] = !isPowerOfTwo(newNum);
                pairingMap[j][i] = pairingMap[i][j];
            }
        }

        // Step 2: Compute the best pairing
        return maxBPM(pairingMap);
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 1}));
//        System.out.println(solution(new int[]{1, 1, 2}));
//        System.out.println(solution(new int[]{1, 1000}));
//        System.out.println(solution(new int[]{1, 1073741823}));
//        System.out.println(solution(new int[]{1, 7, 3, 21, 13, 19}));
//    }
}
