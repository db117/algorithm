

//我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。 
//
// 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 
//countUniqueChars(s) = 5 。 
//
// 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整
//数。 
//
// 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "ABC"
//输出: 10
//解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
//     其中，每一个子串都由独特字符构成。
//     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
// 
//
// 示例 2： 
//
// 
//输入: s = "ABA"
//输出: 8
//解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
// 
//
// 示例 3： 
//
// 
//输入：s = "LEETCODE"
//输出：92
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含大写英文字符 
// 
//
// Related Topics 哈希表 字符串 动态规划 👍 372 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;

/**
 * 828.统计子串中的唯一字符.count-unique-characters-of-all-substrings-of-a-given-string
 *
 * @author db117
 * @since 2023-11-27 13:54:49
 **/

public class Solution_828 {
    public static void main(String[] args) {
        Solution solution = new Solution_828().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniqueLetterString(String s) {
            int ans = 0;
            int cur = 0;// 以当前位置结尾的子串的唯一字符的个数
            int n = s.length();
            int[] last0 = new int[26];// 上一个字符的位置
            int[] last1 = new int[26];// 上上个字符的位置
            Arrays.fill(last0, -1);
            Arrays.fill(last1, -1);
            for (int i = 0; i < n; i++) {
                // 把当前加到前面所有的子串中
                int c = s.charAt(i) - 'A';
                // 对于当前位置到 last0 之间的字符都可以加上当前字符
                // 对于 last0 到 last1 因为已经不是唯一的了,就需要减掉
                cur += (i - last0[c]) - (last0[c] - last1[c]);

                ans += cur;
                last1[c] = last0[c];
                last0[c] = i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}