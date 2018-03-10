import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuoshu on 2018/3/10.
 */
public class Maze {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] startFrom, int[] target) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(startFrom);
        visited[startFrom[0]][startFrom[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] direction : directions) {
                int x = cur[0], y = cur[1];
                while (isValid(m, n, x + direction[0], y +direction[1])) {
                    x += direction[0];
                    y += direction[1];
                }

                if (!visited[x][y]) {
                    if (target[0] == x && target[1] == y) {
                        return true;
                    }
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }

    private boolean isValid(int m, int n, int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
    }

}
