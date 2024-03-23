

//前缀树（trie ，发音为 "try"）是一个树状的数据结构，用于高效地存储和检索一系列字符串的前缀。前缀树有许多应用，如自动补全和拼写检查。 
//
// 实现前缀树 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 将字符串 word 插入前缀树中。 
// int countWordsEqualTo(String word) 返回前缀树中字符串 word 的实例个数。 
// int countWordsStartingWith(String prefix) 返回前缀树中以 prefix 为前缀的字符串个数。 
// void erase(String word) 从前缀树中移除字符串 word 。 
// 
//
// 
//
// 示例 1: 
//
// 输入
//["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", 
//"erase", "countWordsEqualTo", "countWordsStartingWith", "erase", 
//"countWordsStartingWith"]
//[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], 
//["apple"], ["app"]]
//输出
//[null, null, null, 2, 2, null, 1, 1, null, 0]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");               // 插入 "apple"。
//trie.insert("apple");               // 插入另一个 "apple"。
//trie.countWordsEqualTo("apple");    // 有两个 "apple" 实例，所以返回 2。
//trie.countWordsStartingWith("app"); // "app" 是 "apple" 的前缀，所以返回 2。
//trie.erase("apple");                // 移除一个 "apple"。
//trie.countWordsEqualTo("apple");    // 现在只有一个 "apple" 实例，所以返回 1。
//trie.countWordsStartingWith("app"); // 返回 1
//trie.erase("apple");                // 移除 "apple"。现在前缀树是空的。
//trie.countWordsStartingWith("app"); // 返回 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 只包含小写英文字母。 
// insert、 countWordsEqualTo、 countWordsStartingWith 和 erase 总共调用最多 3 * 10⁴ 次。 
// 保证每次调用 erase 时，字符串 word 总是存在于前缀树中。 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 19 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1804.实现 Trie （前缀树） II.implement-trie-ii-prefix-tree
 *
 * @author db117
 * @since 2024-03-23 15:35:18
 **/

public class Solution_1804 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
                cur.prefix++;
            }
            cur.count++;
        }

        public int countWordsEqualTo(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.next[c - 'a'];
            }
            return cur == null ? 0 : cur.count;
        }

        public int countWordsStartingWith(String prefix) {
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.next[c - 'a'];
            }
            return cur == null ? 0 : cur.prefix;
        }

        public void erase(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.next[c - 'a'];
                cur.prefix--;
            }
            cur.count--;
        }

        public static class Node {
            Node[] next = new Node[26];
            int count = 0;
            int prefix = 0;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}