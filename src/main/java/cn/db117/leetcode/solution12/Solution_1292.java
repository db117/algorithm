//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], thresh
//old = 1
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
//输出：3
// 
//
// 示例 4： 
//
// 
//输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold =
// 40184
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 300 
// m == mat.length 
// n == mat[i].length 
// 0 <= mat[i][j] <= 10000 
// 0 <= threshold <= 10^5
// 
// Related Topics 数组 二分查找 矩阵 前缀和 
// 👍 66 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1292.元素和小于等于阈值的正方形的最大边长.maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 *
 * @author db117
 * @since 2021-07-13 10:37:44
 **/

public class Solution_1292 {
    public static void main(String[] args) {
        Solution solution = new Solution_1292().new Solution();
        System.out.println(solution.maxSideLength(new int[][]{
                {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}
        }, 4));
        System.out.println(solution.maxSideLength(new int[][]{
                {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}
        }, 6));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 记录矩阵前缀和
                    // 以当前位置为右下角，起始位置为左上角的矩阵和
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }


            int ans = 0;
            int max = Math.min(m, n);// 正方形最大的边长
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 从已经找到的最大正方形长度开始找
                    for (int k = ans; k <= max; k++) {
                        if (i + k > m || j + k > n) {
                            // 越界
                            break;
                        }

                        int sum = dp[i + k][j + k] - dp[i - 1][j + k] - dp[i + k][j - 1] + dp[i - 1][j - 1];
                        if (sum <= threshold) {
                            ans++;
                        } else {
                            break;
                        }
                    }

                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}