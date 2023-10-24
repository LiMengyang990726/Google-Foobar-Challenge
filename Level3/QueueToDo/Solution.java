package Level3.QueueToDo;

public class Solution {
    public static int solution(int start, int length) {
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i; j++) {
                res ^= (start + i * length + j);
            }
        }
        return res;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution(0, 3));
//        System.out.println(solution(17, 4));
//    }
}
