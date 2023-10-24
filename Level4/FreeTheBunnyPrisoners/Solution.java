package Level4.FreeTheBunnyPrisoners;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final List<List<Integer>> bunnyHolds = new ArrayList<>();
    private static final List<Integer> currCombination = new ArrayList<>();
    private static Integer combinationsCnt = 0;

    private static void combination(int start, int num_bunnies, int num_copies) {
        if (currCombination.size() == num_copies) {
            for (Integer worker : currCombination) {
                bunnyHolds.get(worker).add(combinationsCnt);
            }
            combinationsCnt++;
            return;
        }
        for (int i = start; i < num_bunnies; i++) {
            if (!currCombination.contains(i)) {
                currCombination.add(i);
                combination(i+1, num_bunnies, num_copies);
                currCombination.remove((Integer) i);
            }
        }
    }

    // num_bunnies is between [1, 9]
    // num_required is between [0, 9]
    public static int[][] solution(int num_bunnies, int num_required) {
        // Initialize bunnyHolds
        for (int i = 0; i < num_bunnies; i++) {
            bunnyHolds.add(new ArrayList<>());
        }

        // Find all permutations and fill in bunnyHolds
        combination(0, num_bunnies, num_bunnies-num_required+1);

        // Return
        int[][] result = bunnyHolds.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        bunnyHolds.clear();
        currCombination.clear();
        combinationsCnt = 0;
        return result;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(solution(3, 0)));
//        System.out.println(Arrays.deepToString(solution(3, 1)));
//        System.out.println(Arrays.deepToString(solution(2, 2)));
//        System.out.println(Arrays.deepToString(solution(3, 2)));
//        System.out.println(Arrays.deepToString(solution(2, 1)));
//        System.out.println(Arrays.deepToString(solution(4, 4)));
//        System.out.println(Arrays.deepToString(solution(5, 3)));
//    }
}
