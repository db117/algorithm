

//字符串的 波动 定义为子字符串中出现次数 最多 的字符次数与出现次数 最少 的字符次数之差。 
//
// 给你一个字符串 s ，它只包含小写英文字母。请你返回 s 里所有 子字符串的 最大波动 值。 
//
// 子字符串 是一个字符串的一段连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbb"
//输出：3
//解释：
//所有可能的波动值和它们对应的子字符串如以下所示：
//- 波动值为 0 的子字符串："a" ，"aa" ，"ab" ，"abab" ，"aababb" ，"ba" ，"b" ，"bb" 和 "bbb" 。
//- 波动值为 1 的子字符串："aab" ，"aba" ，"abb" ，"aabab" ，"ababb" ，"aababbb" 和 "bab" 。
//- 波动值为 2 的子字符串："aaba" ，"ababbb" ，"abbb" 和 "babb" 。
//- 波动值为 3 的子字符串 "babbb" 。
//所以，最大可能波动值为 3 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcde"
//输出：0
//解释：
//s 中没有字母出现超过 1 次，所以 s 中每个子字符串的波动值都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 数组 动态规划 👍 114 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2272.最大波动的子字符串.substring-with-largest-variance
 *
 * @author db117
 * @since 2025-03-19 16:17:21
 **/

public class Solution_2272 {
    public static void main(String[] args) {
        Solution solution = new Solution_2272().new Solution();
        // lripaa
        System.out.println(solution.largestVariance("lripaa"));// 1

        // abbaaabzaabaaaaaaaaaaaaa
        System.out.println(solution.largestVariance("abbaaabzaabaaaaaaaaaaaaa"));// 18

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestVariance(String s) {
            char[] chars = s.toCharArray();
            int ans = 0;
            // 枚举所有的可能性
            for (char i = 'a'; i <= 'z'; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (i == j) {
                        continue;
                    }
                    // 针对 2 个字符计算波动值
                    int f1 = 0;// 当前字符结尾的和
                    int f2 = Integer.MIN_VALUE;// 当前字符结尾，但是包含 j
                    for (char c : chars) {
                        if (c == i) {
                            f1 = Math.max(0, f1) + 1;
                            f2++;// 默认值是最小值，如果一直没有碰见j，则不会取这个值
                        } else if (c == j) {
                            f1 = Math.max(0, f1) - 1;
                            f2 = f1;
                        }
                        ans = Math.max(ans, f2);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}