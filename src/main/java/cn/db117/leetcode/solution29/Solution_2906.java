

//给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，
//则称 p 为 grid 的 乘积矩阵 ： 
//
// 
// 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。 
// 
//
// 返回 grid 的乘积矩阵。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,2],[3,4]]
//输出：[[24,12],[8,6]]
//解释：p[0][0] = grid[0][1] * grid[1][0] * grid[1][1] = 2 * 3 * 4 = 24
//p[0][1] = grid[0][0] * grid[1][0] * grid[1][1] = 1 * 3 * 4 = 12
//p[1][0] = grid[0][0] * grid[0][1] * grid[1][1] = 1 * 2 * 4 = 8
//p[1][1] = grid[0][0] * grid[0][1] * grid[1][0] = 1 * 2 * 3 = 6
//所以答案是 [[24,12],[8,6]] 。 
//
// 示例 2： 
//
// 
//输入：grid = [[12345],[2],[1]]
//输出：[[2],[0],[0]]
//解释：p[0][0] = grid[0][1] * grid[0][2] = 2 * 1 = 2
//p[0][1] = grid[0][0] * grid[0][2] = 12345 * 1 = 12345. 12345 % 12345 = 0 ，所以 
//p[0][1] = 0
//p[0][2] = grid[0][0] * grid[0][1] = 12345 * 2 = 24690. 24690 % 12345 = 0 ，所以 
//p[0][2] = 0
//所以答案是 [[2],[0],[0]] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == grid.length <= 10⁵ 
// 1 <= m == grid[i].length <= 10⁵ 
// 2 <= n * m <= 10⁵ 
// 1 <= grid[i][j] <= 10⁹ 
// 
//
// 👍 15 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2906.构造乘积矩阵.construct-product-matrix
 *
 * @author db117
 * @since 2023-10-16 16:43:39
 **/

public class Solution_2906 {
    public static void main(String[] args) {
        Solution solution = new Solution_2906().new Solution();
        // [[1,2],[3,4]]
        System.out.println(Arrays.deepToString(solution.constructProductMatrix(new int[][]{
                {1, 2},
                {3, 4}
        })));

        // [[4,3,9],[3,9,10],[9,7,8],[8,4,7],[6,1,3]]
        System.out.println(Arrays.deepToString(solution.constructProductMatrix(new int[][]{
                {4, 3, 9},
                {3, 9, 10},
                {9, 7, 8},
                {8, 4, 7},
                {6, 1, 3}
        })));

        // [[414750857],[449145368],[767292749]]
        System.out.println(Arrays.deepToString(solution.constructProductMatrix(new int[][]{
                {414750857},
                {449145368},
                {767292749}
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 12345;

        public int[][] constructProductMatrix(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] ans = new int[m][n];
            int[][] pre = new int[m][n];

            // 从前面乘,然后从后面乘
            long mul = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) {
                        mul *= grid[i][j - 1];
                    } else if (i > 0) {
                        mul *= grid[i - 1][n - 1];
                    }
                    mul %= mod;
                    pre[i][j] = (int) mul;
                }
            }

            mul = 1;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (j < n - 1) {
                        mul *= grid[i][j + 1];
                    } else if (i < m - 1) {
                        mul *= grid[i + 1][0];
                    }
                    mul %= mod;
                    // 乘上前面的
                    ans[i][j] = (int) ((pre[i][j] * mul) % mod);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}