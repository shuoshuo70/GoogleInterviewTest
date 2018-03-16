import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuoshu on 2018/3/13.
 */
public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return dfs(pattern, 0, str, 0, map);
    }

    private boolean dfs(String pattern, int pIndex, String str, int sIndex, Map<Character, String> map) {
        if (pIndex == pattern.length() && sIndex == str.length()) {
            return true;
        }
        if (pIndex == pattern.length() || sIndex == str.length()) {
            return false;
        }

        if (map.containsKey(pattern.charAt(pIndex))) {
            String sub = map.get(pattern.charAt(pIndex));
            if (!str.startsWith(sub, sIndex)) {
                return false;
            }
            return dfs(pattern, pIndex + 1, str, sIndex + sub.length(), map);
        } else {
            for (int i = sIndex + 1; i <= str.length(); i++) {
                String sub = str.substring(sIndex, i);
                if (map.containsValue(sub)) {
                    continue;
                }
                map.put(pattern.charAt(pIndex), sub);
                if (dfs(pattern, pIndex + 1, str, sIndex + sub.length(), map)) {
                    return true;
                }
                map.remove(pattern.charAt(pIndex));
            }

            return false;
        }
    }


}
