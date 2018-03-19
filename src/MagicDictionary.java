public class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            addWord(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode root, String word, int startIndex) {
        TrieNode cur = root;
        for (int i = startIndex; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (cur.children[j] == null) {
                    continue;
                }
                if (word.charAt(i) - 'a' != j) {
                    if (searchWord(cur.children[j], word, i + 1)) {
                        return true;
                    }
                }
            }

            if (cur.children[word.charAt(i) - 'a'] != null) {
                cur = cur.children[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }

        return false;
    }

    private boolean searchWord(TrieNode root, String word, int index) {
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (cur.children[j] == null) {
                return false;
            }
            cur = cur.children[j];
        }
        return cur.isWord;
    }

    private void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public static void main(String[] args) {
        MagicDictionary solution = new MagicDictionary();
        String[] dict = {"hello","leetcode"};
        solution.buildDict(dict);
        System.out.println(solution.search("hhllo"));
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    TrieNode() {
        children = new TrieNode[26];
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */