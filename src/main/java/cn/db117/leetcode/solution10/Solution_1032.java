

//设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。 
//
// 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到
// "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。 
//
// 按下述要求实现 StreamChecker 类： 
//
// 
// StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。 
// boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 
//true ；否则，返回 false。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["StreamChecker", "query", "query", "query", "query", "query", "query", 
//"query", "query", "query", "query", "query", "query"]
//[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], 
//["i"], ["j"], ["k"], ["l"]]
//输出：
//[null, false, false, false, true, false, true, false, false, false, false, 
//false, true]
//
//解释：
//StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
//streamChecker.query("a"); // 返回 False
//streamChecker.query("b"); // 返回 False
//streamChecker.query("c"); // 返回n False
//streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
//streamChecker.query("e"); // 返回 False
//streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
//streamChecker.query("g"); // 返回 False
//streamChecker.query("h"); // 返回 False
//streamChecker.query("i"); // 返回 False
//streamChecker.query("j"); // 返回 False
//streamChecker.query("k"); // 返回 False
//streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 200 
// words[i] 由小写英文字母组成 
// letter 是一个小写英文字母 
// 最多调用查询 4 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 数组 字符串 数据流 👍 134 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1032.字符流.stream-of-characters
 *
 * @author db117
 * @since 2023-03-24 16:53:08
 **/

public class Solution_1032 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamChecker {
        TrieNode root = new TrieNode();
        StringBuilder sb = new StringBuilder();
        int max = 0;

        public StreamChecker(String[] words) {
            for (String word : words) {
                // 倒序建树
                max = Math.max(max, word.length());
                insert(root, new StringBuilder(word).reverse().toString());
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            TrieNode node = root;
            // 倒着搜索看是否有
            for (int i = 0; i < max && sb.length() - i - 1 >= 0; i++) {
                char c = sb.charAt(sb.length() - i - 1);
                TrieNode child = node.get(c);
                if (child == null) {
                    return false;
                }
                if (child.isEnd) {
                    return true;
                }
                node = child;
            }
            return false;
        }

        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            // 是否是最后一个
            boolean isEnd;

            // 获取子节点
            public TrieNode get(char c1) {
                return child[c1 - 'a'];
            }

            // 获取,如果没有就创建
            private TrieNode getChildAdd(char c) {
                if (child[c - 'a'] == null) {
                    child[c - 'a'] = new TrieNode();
                }
                return child[c - 'a'];
            }
        }


        /**
         * 插入
         */
        public void insert(TrieNode root, String word) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                trie = trie.getChildAdd(c);
            }
            trie.isEnd = true;
        }

        /**
         * 查找字符串
         */
        public boolean search(TrieNode root, String word) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                // 获取下一级
                if (trie.get(c) == null) {
                    // 没有找到说明不存在
                    return false;
                }
                trie = trie.getChildAdd(c);
            }
            // 判断可以是结尾
            return trie.isEnd;
        }

        /**
         * 查找字符串节点
         */
        public TrieNode searchNode(TrieNode root, String word) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                // 获取下一级
                if (trie.get(c) == null) {
                    return null;
                }
                trie = trie.getChildAdd(c);
            }
            return trie;
        }

        /**
         * 是否有该前缀
         */
        public boolean startsWith(TrieNode root, String prefix) {
            TrieNode trie = root;
            for (char c : prefix.toCharArray()) {
                TrieNode next = trie.get(c);
                if (next == null) {
                    // 字符不存在
                    return false;
                }
                trie = next;
            }
            // 找到了
            return true;

        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//leetcode submit region end(Prohibit modification and deletion)

}