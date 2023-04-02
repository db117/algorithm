

//假如有一排房子共有 n 幢，每个房子可以被粉刷成 k 种颜色中的一种。房子粉刷成不同颜色的花费成本也是不同的。你需要粉刷所有的房子并且使其相邻的两个房子颜色
//不能相同。 
//
// 每个房子粉刷成不同颜色的花费以一个 n x k 的矩阵表示。 
//
// 
// 例如，costs[0][0] 表示第 0 幢房子粉刷成 0 号颜色的成本；costs[1][2] 表示第 1 幢房子粉刷成 2 号颜色的成本，以此类推。 
//
// 
//
// 返回 粉刷完所有房子的最低成本 。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[1,5,3],[2,9,4]]
//输出: 5
//解释: 
//将房子 0 刷成 0 号颜色，房子 1 刷成 2 号颜色。花费: 1 + 4 = 5; 
//或者将 房子 0 刷成 2 号颜色，房子 1 刷成 0 号颜色。花费: 3 + 2 = 5. 
//
// 示例 2: 
//
// 
//输入: costs = [[1,3],[2,4]]
//输出: 5
// 
//
// 
//
// 提示： 
//
// 
// costs.length == n 
// costs[i].length == k 
// 1 <= n <= 100 
// 2 <= k <= 20 
// 1 <= costs[i][j] <= 20 
// 
//
// 
//
// 进阶：您能否在 O(nk) 的时间复杂度下解决此问题？ 
//
// Related Topics 数组 动态规划 👍 144 👎 0


package cn.db117.leetcode.solution2;

/**
 * 265.粉刷房子 II.paint-house-ii
 *
 * @author db117
 * @since 2023-03-24 17:35:36
 **/

public class Solution_265 {
    public static void main(String[] args) {
        Solution solution = new Solution_265().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostII(int[][] costs) {
            int n = costs.length;
            int m = costs[0].length;
            int[][] dp = new int[n][m];
            dp[0] = costs[0];
            for (int i = 1; i < n; i++) {
                // 找前面不相邻的颜色的最小值
                for (int j = 0; j < m; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) {
                        if (k == j) {
                            continue;
                        }
                        min = Math.min(dp[i - 1][k], min);
                    }
                    dp[i][j] = min + costs[i][j];
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i : dp[n - 1]) {
                ans = Math.min(i, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}