

//给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。 
//
// 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。 
//
// 回文 是正着读和反着读一样的字符串。 
//
// 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的一个子序列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabca"
//输出：3
//解释：长度为 3 的 3 个回文子序列分别是：
//- "aba" ("aabca" 的子序列)
//- "aaa" ("aabca" 的子序列)
//- "aca" ("aabca" 的子序列)
// 
//
// 示例 2： 
//
// 
//输入：s = "adc"
//输出：0
//解释："adc" 不存在长度为 3 的回文子序列。
// 
//
// 示例 3： 
//
// 
//输入：s = "bbcbaba"
//输出：4
//解释：长度为 3 的 4 个回文子序列分别是：
//- "bbb" ("bbcbaba" 的子序列)
//- "bcb" ("bbcbaba" 的子序列)
//- "bab" ("bbcbaba" 的子序列)
//- "aba" ("bbcbaba" 的子序列)
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 位运算 哈希表 字符串 前缀和 👍 90 👎 0


package cn.db117.leetcode.solution19;

import java.util.TreeSet;


/**
 * 1930.长度为 3 的不同回文子序列.unique-length-3-palindromic-subsequences
 *
 * @author db117
 * @since 2025-11-21 14:43:50
 **/

public class Solution_1930 {
    public static void main(String[] args) {
        Solution solution = new Solution_1930().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPalindromicSubsequence(String s) {
            int ans = 0;
            // 存储每个字符出现的位置
            TreeSet<Integer>[] treeSets = new TreeSet[26];
            for (int i = 0; i < 26; i++) {
                treeSets[i] = new TreeSet<>();
            }
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                treeSets[chars[i] - 'a'].add(i);
            }
            for (int i = 0; i < 26; i++) {
                if (treeSets[i].size() < 2) {
                    // 不是回文
                    continue;
                }
                // 回文的两边的字符
                int first = treeSets[i].first();
                int last = treeSets[i].last();
                for (int j = 0; j < 26; j++) {
                    // 枚举中间的字符
                    Integer higher = treeSets[j].higher(first);
                    if (higher != null && higher < last) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}