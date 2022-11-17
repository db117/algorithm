

//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 268 👎 0


package cn.db117.leetcode.solution7;

import java.util.TreeSet;

/**
 * 792.匹配子序列的单词数.number-of-matching-subsequences
 *
 * @author db117
 * @since 2022-11-17 10:55:43
 **/

public class Solution_792_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_792_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int ans = 0;
            char[] chars = s.toCharArray();
            // 用 treeSet 省的写二分
            TreeSet<Integer>[] setArr = new TreeSet[26];
            for (int i = 0; i < setArr.length; i++) {
                setArr[i] = new TreeSet<>();
            }
            for (int i = 0; i < chars.length; i++) {
                setArr[chars[i] - 'a'].add(i);
            }

            for (String word : words) {
                Integer cur = setArr[word.charAt(0) - 'a'].stream().findFirst().orElse(null);
                if (cur == null) {
                    continue;
                }
                if (word.length() == 1) {
                    ans++;
                }
                for (int i = 1; i < word.length(); i++) {
                    char c = word.charAt(i);
                    Integer higher = setArr[c - 'a'].higher(cur);
                    if (higher == null) {
                        break;
                    }
                    if (i == word.length() - 1) {
                        ans++;
                    }
                    cur = higher;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}