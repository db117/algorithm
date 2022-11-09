

//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 139 👎 0


package cn.db117.leetcode.solution7;

import java.util.Arrays;

/**
 * 764.最大加号标志.largest-plus-sign
 *
 * @author db117
 * @since 2022-11-09 11:13:54
 **/

public class Solution_764 {
    public static void main(String[] args) {
        Solution solution = new Solution_764().new Solution();

        System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));

//        System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}}));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] gird = new int[n + 7][n + 7];
            for (int[] ints : gird) {
                Arrays.fill(ints, 1);
            }
            // 坐标统一加一 不要考虑边界
            // 记录 4 个方向
            int[][] top = new int[n + 7][n + 7];
            int[][] down = new int[n + 7][n + 7];
            int[][] left = new int[n + 7][n + 7];
            int[][] right = new int[n + 7][n + 7];

            for (int[] mine : mines) {
                // 标记 0
                gird[mine[0] + 1][mine[1] + 1] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (gird[i][j] == 0) {
                        continue;
                    }
                    top[i][j] = top[i - 1][j] + 1;
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
            for (int i = n; i > 0; i--) {
                for (int j = n; j > 0; j--) {
                    if (gird[i][j] == 0) {
                        continue;
                    }
                    down[i][j] = down[i + 1][j] + 1;
                    right[i][j] = right[i][j + 1] + 1;

                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans = Math.max(ans, Math.min(top[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j]))));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}