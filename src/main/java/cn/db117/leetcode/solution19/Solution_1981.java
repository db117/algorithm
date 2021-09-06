


//给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。 
//
// 从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。 
//
// 返回 最小的绝对差 。 
//
// a 和 b 两数字的 绝对差 是 a - b 的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
//输出：0
//解释：一种可能的最优选择方案是：
//- 第一行选出 1
//- 第二行选出 5
//- 第三行选出 7
//所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[1],[2],[3]], target = 100
//输出：94
//解释：唯一一种选择方案是：
//- 第一行选出 1
//- 第二行选出 2
//- 第三行选出 3
//所选元素的和是 6 ，绝对差是 94 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：mat = [[1,2,9,8,7]], target = 6
//输出：1
//解释：最优的选择方案是选出第一行的 7 。
//绝对差是 1 。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 70 
// 1 <= mat[i][j] <= 70 
// 1 <= target <= 800 
// 
// Related Topics 数组 动态规划 矩阵 👍 31 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1981.最小化目标值与所选元素的差.minimize-the-difference-between-target-and-chosen-elements
 *
 * @author db117
 * @since 2021-09-02 16:19:19
 **/

public class Solution_1981 {
    public static void main(String[] args) {
        Solution solution = new Solution_1981().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimizeTheDifference(int[][] mat, int target) {
            // 记录每一行可能出现的数字
            boolean[][] dp = new boolean[mat.length][4901];

            for (int i = 0; i < mat.length; i++) {
                int[] curNum = mat[i];
                boolean[] curDp = dp[i];
                if (i == 0) {
                    // 第一行
                    for (int j : curNum) {
                        curDp[j] = true;
                    }
                } else {
                    boolean[] topDp = dp[i - 1];
                    for (int j = 0; j < topDp.length; j++) {
                        for (int k : curNum) {
                            if (topDp[j]) {
                                // 上一行加上当前数字
                                curDp[k + j] = true;
                            }
                        }
                    }
                }
            }

            // 找最近的
            int ans = 0;
            boolean[] lastDp = dp[dp.length - 1];
            while (ans < 4901) {
                if (target + ans < lastDp.length && lastDp[target + ans]) {
                    return ans;
                } else if (target - ans >= 0 && lastDp[target - ans]) {
                    return ans;
                } else {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}