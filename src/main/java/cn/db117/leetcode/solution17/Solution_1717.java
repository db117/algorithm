

//给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。 
//
// 
// 删除子字符串 "ab" 并得到 x 分。 
// 
//
// 
// 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。 
// 
// 
// 删除子字符串"ba" 并得到 y 分。
// 
// 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。 
// 
// 
//
//
// 请返回对 s 字符串执行上面操作若干次能得到的最大得分。 
//
// 
//
// 示例 1： 
//
// 输入：s = "cdbcbbaaabab", x = 4, y = 5
//输出：19
//解释：
//- 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
//- 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
//- 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
//- 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
//总得分为 5 + 4 + 5 + 5 = 19 。 
//
// 示例 2： 
//
// 输入：s = "aabbaaxybbaabb", x = 5, y = 4
//输出：20
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 1 <= x, y <= 10⁴ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 栈 贪心 字符串 👍 61 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1717.删除子字符串的最大得分.maximum-score-from-removing-substrings
 *
 * @author db117
 * @since 2025-07-23 16:50:46
 **/

public class Solution_1717 {
    public static void main(String[] args) {
        Solution solution = new Solution_1717().new Solution();
        // "cdbcbbaaabab"
        //4
        //5
        System.out.println(solution.maximumGain("cdbcbbaaabab", 4, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGain(String s, int x, int y) {
            char[] chars = s.toCharArray();
            // 默认 x>y 如果不是就翻转
            if (x < y) {
                x = x ^ y;
                y = x ^ y;
                x = x ^ y;

                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == 'a') {
                        chars[i] = 'b';
                    } else if (chars[i] == 'b') {
                        chars[i] = 'a';
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < chars.length; i++) {
                int countA = 0;
                int countB = 0;
                while (i < chars.length && (chars[i] == 'b' || chars[i] == 'a')) {// 只有 AB 才会进去，否则就跳过
                    if (chars[i] == 'a') {
                        // 记录有多少个 A
                        countA++;
                    } else {
                        if (countA > 0) {
                            // 左边有 A 就配对
                            countA--;
                            ans += x;
                        } else {
                            countB++;
                        }
                    }
                    i++;
                }
                // 剩余的可以配对的 BA
                ans += Math.min(countA, countB) * y;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}