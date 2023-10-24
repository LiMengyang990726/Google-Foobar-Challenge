package Level3.FuelInjectionPerfection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static String plusOne(String input) {
        StringBuilder inputStringBuilder = new StringBuilder(input);
        boolean added = false;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c != '9') {
                added = true;
                c += 1;
                inputStringBuilder.setCharAt(i, c);
                break;
            } else {
                inputStringBuilder.setCharAt(i, '0');
            }
        }
        String addFuel = inputStringBuilder.toString();
        if (!added) {
            return '1' + addFuel;
        } else {
            return addFuel;
        }
    }

    private static String removeOne(String input) {
        if (input.isEmpty() || input.equals("0") || input.equals("1")) {
            throw new RuntimeException("Should reach removeOne function for input: " + input);
        }

        StringBuilder inputStringBuilder = new StringBuilder(input);
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c != '0') {
                c -= 1;
                inputStringBuilder.setCharAt(i, c);
                break;
            } else {
                inputStringBuilder.setCharAt(i, '9');
            }
        }
        return inputStringBuilder.toString().replaceFirst("^0+(?!$)", "");
    }

    // Assume input is divisible of 2
    private static String divideToHalf(String input) {
        StringBuilder inputStringBuilder = new StringBuilder();
        int x = 0;
        for (int i = 0; i < input.length(); i++) {
            int d = (x * 10 + input.charAt(i) - '0') / 2;
            x = (input.charAt(i) - '0') % 2;
            if (i > 0 || d != 0)
                inputStringBuilder.append(d);
        }

        return inputStringBuilder.toString();
    }

    private static List<String> getNextSteps(String input) {
        List<String> result = new ArrayList<>();
        if (input.isEmpty()) {
            return result;
        }

        // Move 1: Add a fuel
        String addFuel = plusOne(input);
        // if length >= 309, cannot add fuel anymore
        if (addFuel.length() < 309) {
            result.add(addFuel);
        }

        // Move 2: Remove a fuel
        String removeFuel = removeOne(input);
        result.add(removeFuel);

        // Move 3: Split by half
        if ((input.charAt(input.length() - 1) - '0') % 2 == 0) {
            String halfFuel = divideToHalf(input);
            result.add(halfFuel);
        }

        return result;
    }

    public static int solution(String x) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int steps = 0;

        // Initialization
        q.add(x);
        visited.add(x);

        // BFS
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String front = q.remove();
                if (front.equals("1")) {
                    return steps;
                }
                List<String> nextSteps = getNextSteps(front);
                for (String nextStep : nextSteps) {
                    if (!visited.contains(nextStep)) {
                        visited.add(nextStep);
                        q.add(nextStep);
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution("15"));
//        System.out.println(solution("4"));
//    }
}
