import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuoshu on 2018/3/17.
 */
public class SnackLadders {
    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

    public static int getMinDiceThrows(int[] moves, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n - 1) {
                    return level;
                }

                for (int j = 1; j <= 6 && cur + j < n; j++) {
                    int next = cur + j;
                    if (moves[next] != -1) {
                        next = moves[next];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}

