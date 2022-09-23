

//给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。 
//
// 定义字符串 word 的 分数 等于以 word 作为 前缀 的 words[i] 的数目。 
//
// 
// 例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 
//"abc" 的一个前缀。 
// 
//
// 返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。 
//
// 注意：字符串视作它自身的一个前缀。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["abc","ab","bc","b"]
//输出：[5,4,3,2]
//解释：对应每个字符串的答案如下：
//- "abc" 有 3 个前缀："a"、"ab" 和 "abc" 。
//- 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" ，1 个字符串的前缀为 "abc" 。
//总计 answer[0] = 2 + 2 + 1 = 5 。
//- "ab" 有 2 个前缀："a" 和 "ab" 。
//- 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" 。
//总计 answer[1] = 2 + 2 = 4 。
//- "bc" 有 2 个前缀："b" 和 "bc" 。
//- 2 个字符串的前缀为 "b" ，1 个字符串的前缀为 "bc" 。 
//总计 answer[2] = 2 + 1 = 3 。
//- "b" 有 1 个前缀："b"。
//- 2 个字符串的前缀为 "b" 。
//总计 answer[3] = 2 。
// 
//
// 示例 2： 
//
// 输入：words = ["abcd"]
//输出：[4]
//解释：
//"abcd" 有 4 个前缀 "a"、"ab"、"abc" 和 "abcd"。
//每个前缀的分数都是 1 ，总计 answer[0] = 1 + 1 + 1 + 1 = 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 由小写英文字母组成 
// 
//
// Related Topics 字典树 数组 字符串 计数 👍 21 👎 0


package cn.db117.leetcode.solution24;

import java.util.Arrays;

/**
 * 2416.字符串的前缀分数和.sum-of-prefix-scores-of-strings
 *
 * @author db117
 * @see cn.db117.leetcode.solution2.Solution208
 * @see cn.db117.template.Trie
 * @since 2022-09-23 11:20:42
 **/

public class Solution_2416 {
    public static void main(String[] args) {
        Solution solution = new Solution_2416().new Solution();
        System.out.println(Arrays.toString(solution.sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sumPrefixScores(String[] words) {
            // 字典树变形
            TrieNode root = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                insert(root, words[i], i);
            }

            int[] ans = new int[words.length];

            for (int i = 0; i < words.length; i++) {
                ans[i] = searchCount(root, words[i]);
            }

            return ans;
        }


        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            // 是否是最后一个
            boolean isEnd;
            // 前缀的数量
            int count;

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
        public void insert(TrieNode root, String word, int index) {
            TrieNode trie = root;
            for (char c : word.toCharArray()) {
                trie = trie.getChildAdd(c);
                trie.count++;
            }
            trie.isEnd = true;
        }

        /**
         * 查找字符串节点
         */
        public int searchCount(TrieNode root, String word) {
            TrieNode trie = root;
            int ans = trie.count;
            for (char c : word.toCharArray()) {
                trie = trie.getChildAdd(c);
                ans += trie.count;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}