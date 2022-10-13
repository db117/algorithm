

//给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ： 
//
// 
// pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]. 
// 
//
// 注意 ^ 表示 按位异或（bitwise-xor）运算。 
//
// 可以证明答案是 唯一 的。 
//
// 
//
// 示例 1： 
//
// 输入：pref = [5,2,0,3,1]
//输出：[5,7,2,3,2]
//解释：从数组 [5,7,2,3,2] 可以得到如下结果：
//- pref[0] = 5
//- pref[1] = 5 ^ 7 = 2
//- pref[2] = 5 ^ 7 ^ 2 = 0
//- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
//- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1
// 
//
// 示例 2： 
//
// 输入：pref = [13]
//输出：[13]
//解释：pref[0] = arr[0] = 13
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pref.length <= 10⁵ 
// 0 <= pref[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 👍 6 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2433.找出前缀异或的原始数组.find-the-original-array-of-prefix-xor
 *
 * @author db117
 * @since 2022-10-13 17:17:24
 **/

public class Solution_2433 {
    public static void main(String[] args) {
        Solution solution = new Solution_2433().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int numberOfPaths(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            // 第三维为对 k 取模后的值
            int[][][] dp = new int[m][n][k];

            // 初始化
            dp[0][0][grid[0][0] % k] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < k; l++) {
                        // 能过来的索引位置
                        int pre = (k + l - grid[i][j] % k) % k;
                        if (i > 0) {
                            dp[i][j][l] += dp[i - 1][j][pre];
                            dp[i][j][l] %= mod;
                        }
                        if (j > 0) {
                            dp[i][j][l] += dp[i][j - 1][pre];
                            dp[i][j][l] %= mod;
                        }
                    }
                }
            }
            return dp[m - 1][n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}