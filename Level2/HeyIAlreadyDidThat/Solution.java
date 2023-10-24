package Level2.HeyIAlreadyDidThat;

import java.util.Arrays;

public class Solution {
    private static char[] reverse(char[] a) {
        char[] b = new char[a.length];
        int j = a.length;
        for (char c : a) {
            b[j - 1] = c;
            j = j - 1;
        }
        return b;
    }

    private static String getNextNumber(String n, int b) {
        char[] yArray = n.toCharArray();
        Arrays.sort(yArray);

        char[] xArray = reverse(yArray);

        int z = Integer.parseInt(String.valueOf(xArray), b) - Integer.parseInt(String.valueOf(yArray), b);
        return Integer.toString(z, b);
    }

    public static int solution(String n, int b) {
        String slow = n;
        String fast = n;

        // Step 1: Meet each other
        boolean initial = true;
        while (initial || !slow.equals(fast)) {
            initial = false;
            slow = getNextNumber(slow, b);
            fast = getNextNumber(getNextNumber(fast, b), b);
        }

        // Step 2: Find the cycle start
        slow = n;
        while (!slow.equals(fast)) {
            slow = getNextNumber(slow, b);
            fast = getNextNumber(fast, b);
        }

        // Step 3: Count the cycle length
        initial = true;
        int cycleLength = 0;
        while (initial || !slow.equals(fast)) {
            initial = false;
            fast = getNextNumber(fast, b);
            cycleLength++;
        }
        return cycleLength;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution("210022", 3));
//        System.out.println(solution("1211", 10));
//    }
}
