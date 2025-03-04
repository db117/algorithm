

//给你一个由小写字母组成的字符串 s，和一个整数 k。 
//
// 请你按下面的要求分割字符串： 
//
// 
// 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。 
// 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。 
// 
//
// 请返回以这种方式分割字符串所需修改的最少字符数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abc", k = 2
//输出：1
//解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
// 
//
// 示例 2： 
//
// 输入：s = "aabbc", k = 3
//输出：0
//解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 8
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= s.length <= 100 
// s 中只含有小写英文字母。 
// 
//
// Related Topics 字符串 动态规划 👍 160 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;

/**
 * 1278.分割回文串 III.palindrome-partitioning-iii
 *
 * @author db117
 * @since 2025-03-03 17:50:53
 **/

public class Solution_1278 {
    public static void main(String[] args) {
        Solution solution = new Solution_1278().new Solution();
        // s =
        //"mepekjkpgihfcg" 12
        System.out.println(solution.palindromePartition("mepekjkpgihfcg", 12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;
        int[][] memo;
        int[][] helperMemo;

        public int palindromePartition(String s, int k) {
            this.chars = s.toCharArray();
            int n = s.length();
            if (n == k) {
                return 0;
            }
            memo = new int[n][k];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            helperMemo = new int[n + 1][n];
            for (int[] ints : helperMemo) {
                Arrays.fill(ints, -1);
            }
            return dfs(n - 1, k - 1);
        }

        // i:当前位置 j:分割的次数
        int dfs(int i, int j) {

            if (j == 0) {
                return helper(0, i);
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int ans = Integer.MAX_VALUE;
            for (int left = j/*最小也要从 j 开始*/; left <= i; left++) {
                ans = Math.min(ans, helper(left, i) + dfs(left - 1, j - 1));
            }
            return memo[i][j] = ans;
        }

        // 判断[left,right]区间修改为回文串需要多少次修改次数
        int helper(int left, int right) {
            if (left >= right) {
                return 0;
            }
            if (helperMemo[left][right] != -1) {
                return helperMemo[left][right];
            }
            int ans = helper(left + 1, right - 1);

            if (chars[left] != chars[right]) {
                ans++;
            }

            return helperMemo[left][right] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}