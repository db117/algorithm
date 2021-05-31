// 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 示例 1: 
//
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。 
// Related Topics 位运算 
// 👍 167 👎 0


package cn.db117.leetcode.solution3;

/**
 * 318.最大单词长度乘积.maximum-product-of-word-lengths
 *
 * @author db117
 * @since 2021-05-31 14:45:33
 **/

public class Solution_318 {
    public static void main(String[] args) {
        Solution solution = new Solution_318().new Solution();
        System.out.println(solution.maxProduct(new String[]{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int len = words.length;
            // 用一个int来保存存在的字母
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                ints[i] = toInt(words[i]);
            }

            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    // & 为0 则代表没有重复的字符
                    if ((ints[i] & ints[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }

            return ans;
        }


        private int toInt(String s) {
            int ans = 0;
            for (char c : s.toCharArray()) {
                ans |= 1 << (c - '`');
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}