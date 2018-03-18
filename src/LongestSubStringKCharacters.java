import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuoshu on 2018/3/18.
 */
public class LongestSubStringKCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() > k) {
                int count = map.get(s.charAt(l)) - 1;
                if (count == 0) {
                    map.remove(s.charAt(l));
                } else {
                    map.put(s.charAt(l), count);
                }
                l++;
            }
            max = Math.max(max, i - l + 1);
        }

        return max;
    }

}
