

//给你一个二维 boolean 矩阵 grid 。 
//
// 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。 
//
// 注意： 
//
// 
// 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素
//互相之间不需要相邻。 
// 
//
// 
//
// 示例 1： 
//
// 
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
//
// 
// 输入：grid = [[0,1,0],[0,1,1],[0,1,0]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 有 2 个直角三角形。 
//
// 示例 2： 
//
// 
// 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 0 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]] 
// 
//
// 输出：0 
//
// 解释： 
//
// 没有直角三角形。 
//
// 示例 3： 
//
// 
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
//
// 
// 输入：grid = [[1,0,1],[1,0,0],[1,0,0]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 有两个直角三角形。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 1000 
// 1 <= grid[i].length <= 1000 
// 0 <= grid[i][j] <= 1 
// 
//
// Related Topics 数组 哈希表 数学 组合数学 计数 👍 32 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3128.直角三角形.right-triangles
 *
 * @author db117
 * @since 2024-08-02 19:25:19
 **/

public class Solution_3128 {
    public static void main(String[] args) {
        Solution solution = new Solution_3128().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            long ans = 0;
            int m = grid.length;
            int n = grid[0].length;

            // 统计每行和每列的1的个数
            int[] col = new int[n];
            int[] row = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 除了本身，行和列的1的个数
                        ans += (long) (row[i] - 1) * (col[j] - 1);
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}