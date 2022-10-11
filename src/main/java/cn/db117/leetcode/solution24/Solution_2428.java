

//给你一个大小为 m x n 的整数矩阵 grid 。 
//
// 按以下形式将矩阵的一部分定义为一个 沙漏 ： 
// 返回沙漏中元素的 最大 总和。 
//
// 注意：沙漏无法旋转且必须整个包含在矩阵中。 
//
// 
//
// 示例 1： 
// 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
//输出：30
//解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
// 
//
// 示例 2： 
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：35
//解释：上图中的单元格表示元素总和最大的沙漏：1 + 2 + 3 + 5 + 7 + 8 + 9 = 35 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 3 <= m, n <= 150 
// 0 <= grid[i][j] <= 10⁶ 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 5 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2428.沙漏的最大总和.maximum-sum-of-an-hourglass
 *
 * @author db117
 * @since 2022-10-11 14:50:48
 **/

public class Solution_2428 {
    public static void main(String[] args) {
        Solution solution = new Solution_2428().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSum(int[][] grid) {
            // 模拟
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;

            for (int i = 2; i < m; i++) {
                for (int j = 2; j < n; j++) {
                    int sum = 0;

                    for (int l = 0; l < 3; l++) {
                        sum += grid[i][j - l];
                        sum += grid[i - 2][j - l];
                    }
                    sum += grid[i - 1][j - 1];
                    ans = Math.max(ans, sum);
                }
            }

            return ans;
        }
    }
//runtime:2 ms
//memory:43.2 MB

//leetcode submit region end(Prohibit modification and deletion)

}