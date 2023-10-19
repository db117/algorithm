

//给你两个下标从 0 开始的二进制字符串 s1 和 s2 ，两个字符串的长度都是 n ，再给你一个正整数 x 。 
//
// 你可以对字符串 s1 执行以下操作 任意次 ： 
//
// 
// 选择两个下标 i 和 j ，将 s1[i] 和 s1[j] 都反转，操作的代价为 x 。 
// 选择满足 i < n - 1 的下标 i ，反转 s1[i] 和 s1[i + 1] ，操作的代价为 1 。 
// 
//
// 请你返回使字符串 s1 和 s2 相等的 最小 操作代价之和，如果无法让二者相等，返回 -1 。 
//
// 注意 ，反转字符的意思是将 0 变成 1 ，或者 1 变成 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "1100011000", s2 = "0101001010", x = 2
//输出：4
//解释：我们可以执行以下操作：
//- 选择 i = 3 执行第二个操作。结果字符串是 s1 = "1101111000" 。
//- 选择 i = 4 执行第二个操作。结果字符串是 s1 = "1101001000" 。
//- 选择 i = 0 和 j = 8 ，执行第一个操作。结果字符串是 s1 = "0101001010" = s2 。
//总代价是 1 + 1 + 2 = 4 。这是最小代价和。
// 
//
// 示例 2： 
//
// 
//输入：s1 = "10110", s2 = "00011", x = 4
//输出：-1
//解释：无法使两个字符串相等。
// 
//
// 
//
// 提示： 
//
// 
// n == s1.length == s2.length 
// 1 <= n, x <= 500 
// s1 和 s2 只包含字符 '0' 和 '1' 。 
// 
//
// Related Topics 字符串 动态规划 👍 34 👎 0


package cn.db117.leetcode.solution28;

import java.util.Arrays;

/**
 * 2896.执行操作使两个字符串相等.apply-operations-to-make-two-strings-equal
 *
 * @author db117
 * @since 2023-10-19 14:45:09
 **/

public class Solution_2896 {
    public static void main(String[] args) {
        Solution solution = new Solution_2896().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] c1, c2;
        int x;
        int[][][] memo;

        public int minOperations(String s1, String s2, int x) {
            c1 = s1.toCharArray();
            c2 = s2.toCharArray();
            this.x = x;
            int n = c1.length;

            // 两个字符串的 1 的数量奇偶性不一样,无法转换
            // 两种操作都不会改变奇偶性
            int diff = 0;
            for (int i = 0; i < n; i++) {
                diff ^= c1[i] ^ c2[i];
            }
            if (diff != 0) {
                // 如果两个字符串 1 的数量奇偶性不一样,无法转换
                return -1;
            }

            memo = new int[n][n + 1][2];
            for (int[][] ints : memo) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, -1);
                }
            }

            return dfs(n - 1, 0, 0);
        }

        /**
         * 计算需要的操作数量
         *
         * @param i         当前的下标
         * @param preRev    上一个是否反转
         * @param freeCount 剩余的免费操作次数(后面选择了第一个操作)
         * @return 最小的操作次数
         */
        private int dfs(int i, int freeCount, int preRev) {
            if (i < 0) {
                // 递归结束
                // 最后一个字符
                return preRev == 0 && freeCount == 0 ? 0 : Integer.MAX_VALUE / 2;
            }

            if (memo[i][freeCount][preRev] != -1) {
                return memo[i][freeCount][preRev];
            }
            int ans = Integer.MAX_VALUE;
            if (c1[i] == c2[i] && preRev == 0) {
                // 两个字符相等,不需要反转
                return dfs(i - 1, freeCount, preRev);
            }
            if (c1[i] != c2[i] && preRev == 1) {
                // 两个字符不相等,后面已经反转过了(这个不算次数)
                return dfs(i - 1, freeCount, 0);
            }

            // 选择第一个操作
            ans = Math.min(ans, dfs(i - 1, freeCount + 1, 0) + x);
            // 选择第二个操作
            ans = Math.min(ans, dfs(i - 1, freeCount, 1) + 1);
            if (freeCount > 0) {
                // 可以免费操作
                ans = Math.min(ans, dfs(i - 1, freeCount - 1, 0));
            }
            return memo[i][freeCount][preRev] = ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}