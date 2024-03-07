

//给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。 
//
// 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵 的数目。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[7,6,3],[6,6,1]], k = 18
//输出：4
//解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。 
//
// 示例 2： 
// 
// 
//输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
//输出：6
//解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= n, m <= 1000 
// 0 <= grid[i][j] <= 1000 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 3 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3070.元素和小于等于 k 的子矩阵的数目.count-submatrices-with-top-left-element-and-sum-less-than-k
 *
 * @author db117
 * @since 2024-03-07 11:07:07
 **/

public class Solution_3070 {
    public static void main(String[] args) {
        Solution solution = new Solution_3070().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 二维前缀和
        int[][] sums;

        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            sums = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 把一整块分成 4 份,其中 3 份已经算过了
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + grid[i][j];
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 以 i,j 为右下角的矩形
                    int sum = sumRegion(0, 0, i, j);
                    if (sum <= k) {
                        ans++;
                    }
                }
            }

            return ans;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}