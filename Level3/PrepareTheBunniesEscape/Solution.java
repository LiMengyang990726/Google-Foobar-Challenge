package Level3.PrepareTheBunniesEscape;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // Shortest path problem better to use dijkstra, dijkstra itself is a BFS
    private static class State {
        int x;
        int y;
        int cost;

        public State(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private static class Comparator implements java.util.Comparator<State> {
        @Override
        public int compare(State o1, State o2) {
            return Integer.compare(o1.cost, o2.cost);
        }
    }

    private static int dijkstra(int[][] map) {
        // Initialization
        int m = map.length; int n = map[0].length;
        int[][] minDist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minDist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator());
        pq.add(new State(0, 0, 1));
        minDist[0][0] = 1;

        while (!pq.isEmpty()) {
            State front = pq.poll();
            List<State> nextStates = new ArrayList<>();
            if (front.x > 0) {
                nextStates.add(new State(front.x - 1, front.y, front.cost + (map[front.x - 1][front.y] == 0 ? 1 : 1000)));
            }
            if (front.x < m - 1) {
                nextStates.add(new State(front.x + 1, front.y, front.cost + (map[front.x + 1][front.y] == 0 ? 1 : 1000)));
            }
            if (front.y > 0) {
                nextStates.add(new State(front.x, front.y - 1, front.cost + (map[front.x][front.y - 1] == 0 ? 1 : 1000)));
            }
            if (front.y < n - 1) {
                nextStates.add(new State(front.x, front.y + 1, front.cost + (map[front.x][front.y + 1] == 0 ? 1 : 1000)));
            }
            for (State nextState : nextStates) {
                if (nextState.cost < minDist[nextState.x][nextState.y]) {
                    minDist[nextState.x][nextState.y] = nextState.cost;
                    pq.add(nextState);
                }
            }
        }

        return minDist[m-1][n-1];
    }

    public static int solution(int[][] map) {
        int res = dijkstra(map);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    res = Math.min(res, dijkstra(map));
                    map[i][j] = 1;
                }
            }
        }
        return res;
    }

    // For Self-test
//    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}}));
//        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}}));
//        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}}));
//    }
}
