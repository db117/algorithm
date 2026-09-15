

//给你一个字符串 s 和一个 正 整数 k 。 
//
// 从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串： 
//
// 
// 每个子字符串的长度 至少 为 k 。 
// 每个子字符串是一个 回文串 。 
// 
//
// 返回最优方案中能选择的子字符串的 最大 数目。 
//
// 子字符串 是字符串中一个连续的字符序列。 
//
// 
//
// 示例 1 ： 
//
// 
//输入：s = "abaccdbbd", k = 3
//输出：2
//解释：可以选择 s = "abaccdbbd" 中斜体加粗的子字符串。"aba" 和 "dbbd" 都是回文，且长度至少为 k = 3 。
//可以证明，无法选出两个以上的有效子字符串。
// 
//
// 示例 2 ： 
//
// 
//输入：s = "adbcda", k = 2
//输出：0
//解释：字符串中不存在长度至少为 2 的回文子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 动态规划 👍 66 👎 0


package cn.db117.leetcode.solution24;

import java.util.Arrays;

/**
 * 2472.不重叠回文子字符串的最大数目.maximum-number-of-non-overlapping-palindrome-substrings
 *
 * @author db117
 * @since 2026-09-15 20:37:12
 **/

public class Solution_2472 {
    public static void main(String[] args) {
        Solution solution = new Solution_2472().new Solution();

        // "abaccdbbd"
        //3
        System.out.println(solution.maxPalindromes("abaccdbbd", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] memo;
        char[] chars;
        int k;

        public int maxPalindromes(String s, int k) {
            int n = s.length();
            memo = new int[n + 1];
            chars = s.toCharArray();
            this.k = k;
            Arrays.fill(memo, -1);
            return dfs(n);
        }

        int dfs(int i) {
            if (i < k) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            int ans = 0;
            // 不选
            ans = dfs(i - 1);
            // 要找到最多的，那么就选尽可能短的
            // 长度为 k 的回文子字符串
            if (isPalindrome(i - k, i - 1)) {
                ans = Math.max(ans, dfs(i - k) + 1);
            }
            // 长度为 k+1 的回文子字符串
            if (i > k && isPalindrome(i - k - 1, i - 1)) {
                ans = Math.max(ans, dfs(i - k - 1) + 1);
            }


            return memo[i] = ans;
        }

        private boolean isPalindrome(int l, int r) {
            while (l < r) {
                if (chars[l] != chars[r]) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}