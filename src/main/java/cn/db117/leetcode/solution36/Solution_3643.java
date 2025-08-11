

//给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。 
//
// 整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。 
//
// 你的任务是垂直翻转子矩阵的行顺序。 
//
// 返回更新后的矩阵。 
//
// 
//
// 示例 1： 
// 
// 
// 输入： grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k 
//= 3 
// 
//
// 输出： [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]] 
//
// 解释： 
//
// 上图展示了矩阵在变换前后的样子。 
//
// 示例 2： 
// 
// 
// 输入： grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2 
// 
//
// 输出： [[3,4,4,2],[2,3,2,3]] 
//
// 解释： 
//
// 上图展示了矩阵在变换前后的样子。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j] <= 100 
// 0 <= x < m 
// 0 <= y < n 
// 1 <= k <= min(m - x, n - y) 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution36;

/**
 * 3643.垂直翻转子矩阵.flip-square-submatrix-vertically
 *
 * @author db117
 * @since 2025-08-11 15:48:32
 **/

public class Solution_3643 {
    public static void main(String[] args) {
        Solution solution = new Solution_3643().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
            // 记录需要翻转的数据，后面在翻转
            int[][] arr = new int[k][k];
            for (int i = x; i < x + k; i++) {
                for (int j = y; j < y + k; j++) {
                    arr[i - x][j - y] = grid[i][j];
                }
            }
            for (int i = 0; i < k / 2; i++) {
                int[] tmp = arr[i];
                arr[i] = arr[k - 1 - i];
                arr[k - 1 - i] = tmp;
            }
            for (int i = x; i < x + k; i++) {
                for (int j = y; j < y + k; j++) {
                    grid[i][j] = arr[i - x][j - y];
                }
            }
            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}