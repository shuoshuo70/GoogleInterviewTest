import java.util.Random;

/**
 * Created by shuoshu on 2018/3/10.
 */
public class SelectKItem {
    public int[] selectKItems(int[] items, int n, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = items[i];
        }

        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(i + 1);
            if (index < k) {
                res[index] = items[i];
            }
        }

        return res;
    }


}
