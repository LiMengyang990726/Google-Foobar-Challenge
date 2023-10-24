package Level2.EnRouteSalute;

public class Solution {
    public static int solution(String s) {
        int walkToLeftCount = 0;
        int res = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '<') {
                walkToLeftCount++;
            } else if (s.charAt(i) == '>') {
                res += walkToLeftCount;
            }
        }
        return 2 * res;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution("<<>><"));
//        System.out.println(solution(">----<"));
//    }
}
