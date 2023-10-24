package Level1.ReID;

import java.util.Arrays;

public class Solution {
    private static String primes = "";

    private static void constructPrimes() {
        if (!primes.isEmpty()) {
            return;
        }

        int n = 20500;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i1 = 2; i1 * i1 < n; i1++) {
            if (isPrime[i1]) {
                for (int j = i1 * i1; j < n; j += i1) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder primesBuilder = new StringBuilder();
        for (int i1 = 2; i1 < n; i1++) {
            if (isPrime[i1]) {
                primesBuilder.append(i1);
            }
        }
        primes = primesBuilder.toString();
    }

    public static String solution(int i) {
        constructPrimes();
        return primes.substring(i, i+5);
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution(0));
//        System.out.println(solution(3));
//        System.out.println(solution(10000));
//    }
}
