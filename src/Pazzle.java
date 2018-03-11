import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuoshu on 2018/3/11.
 */
public class Pazzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String input = format(board);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int[] directions = {-3, -1, 1, 3};
        int level = 0;

        q.add(input);
        visited.add(input);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (target.equals(cur)) {
                    return level;
                }

                int index = cur.indexOf("0");
                for (int d : directions) {
                    int loc = index + d;
                    if (loc < 0 || loc >= 6 || (index == 2 && loc == 3) || (index == 3 && loc == 2)) {
                        continue;
                    }
                    char[] ch = cur.toCharArray();
                    ch[index] = ch[loc];
                    ch[loc] = '0';
                    if (visited.add(new String(ch))) {
                        q.add(new String(ch));
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private String format(int[][] board) {
        String s = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                s += board[i][j];
            }
        }

        return s;
    }
}
