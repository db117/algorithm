

//给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。 
//
// 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作： 
//
//
// 
// 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足
// row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。 
// 
//
// 返回执行完所有操作后得到的矩阵 mat 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
//输出：[[1,1,0],[1,2,1],[0,1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
//- 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。 
//- 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 2, queries = [[0,0,1,1]]
//输出：[[1,1],[1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。 
//- 第一个操作：将矩阵中的每个元素加 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= queries.length <= 10⁴ 
// 0 <= row1i <= row2i < n 
// 0 <= col1i <= col2i < n 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2536.子矩阵元素加 1.increment-submatrices-by-one
 *
 * @author db117
 * @since 2023-01-16 11:42:51
 **/

public class Solution_2536 {
    public static void main(String[] args) {
        Solution solution = new Solution_2536().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            // 二维差分
            // 数组开大防止越界
            int[][] diff = new int[n + 2][n + 2];

            for (int[] query : queries) {
                int row1 = query[0];
                int col1 = query[1];
                int row2 = query[2];
                int col2 = query[3];
                // 向右下方平移,减少越界处理逻辑
                row1++;
                col1++;
                row2++;
                col2++;

                diff[row1][col1]++;
                diff[row2 + 1][col2 + 1]++;
                // 下面两个是从
                diff[row1][col2 + 1]--;
                diff[row2 + 1][col1]--;

            }

            int[][] ans = new int[n][n];

            // 还原数组
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    diff[i + 1][j + 1] += diff[i][j + 1] + diff[i + 1][j] - diff[i][j];
                    ans[i][j] = diff[i + 1][j + 1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}