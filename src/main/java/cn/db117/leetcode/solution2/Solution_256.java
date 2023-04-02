

//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 
//costs 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
//
// Related Topics 数组 动态规划 👍 210 👎 0


package cn.db117.leetcode.solution2;

/**
 * 256.粉刷房子.paint-house
 *
 * @author db117
 * @since 2023-03-24 17:16:43
 **/

public class Solution_256 {
    public static void main(String[] args) {
        Solution solution = new Solution_256().new Solution();
        // [[3,5,3],[6,17,6],[7,13,18],[9,10,18]]
        System.out.println(solution.minCost(new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n + 1][3];
            dp[0] = costs[0];
            for (int i = 1; i < n; i++) {
                // 找前面不相邻的颜色的最小值
                for (int j = 0; j < 3; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        if (k == j) {
                            continue;
                        }
                        min = Math.min(dp[i - 1][k], min);
                    }
                    dp[i][j] = min + costs[i][j];
                }
            }
            return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}