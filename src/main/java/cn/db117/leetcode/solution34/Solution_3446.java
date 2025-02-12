

//给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵： 
//
// 
// 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。 
// 右上角三角形 的对角线按 非递减顺序 排序。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[1,7,3],[9,8,2],[4,5,6]] 
// 
//
// 输出： [[8,2,3],[9,6,7],[4,5,1]] 
//
// 解释： 
//
// 
//
// 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序： 
//
// 
// [1, 8, 6] 变为 [8, 6, 1]。 
// [9, 5] 和 [4] 保持不变。 
// 
//
// 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序： 
//
// 
// [7, 2] 变为 [2, 7]。 
// [3] 保持不变。 
// 
//
// 示例 2： 
//
// 
// 输入： grid = [[0,1],[1,2]] 
// 
//
// 输出： [[2,1],[1,0]] 
//
// 解释： 
//
// 
//
// 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。 
//
// 示例 3： 
//
// 
// 输入： grid = [[1]] 
// 
//
// 输出： [[1]] 
//
// 解释： 
//
// 只有一个元素的对角线已经符合要求，因此无需修改。 
//
// 
//
// 提示： 
//
// 
// grid.length == grid[i].length == n 
// 1 <= n <= 10 
// -10⁵ <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 排序 👍 3 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3446.按对角线进行矩阵排序.sort-matrix-by-diagonals
 *
 * @author db117
 * @since  2025-02-12 10:46:10
 **/

  public class Solution_3446{
      public static void main(String[] args) {
           Solution solution = new Solution_3446().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[][] sortMatrix(int[][] grid) {
              int m = grid.length, n = grid[0].length;
              // 从左下角开始顺时针遍历到右上角
              for (int i = m - 1; i >= 0; i--) {
                  int[] temp = new int[Math.min(m - i, n)];
                  for (int j = 0; i + j < m && j < n; j++) {
                      temp[j] = grid[i + j][j];
                  }
                  Arrays.sort(temp);
                  // 翻转
                  for (int j = 0; j < temp.length / 2; j++) {
                      int t = temp[j];
                      temp[j] = temp[temp.length - 1 - j];
                      temp[temp.length - 1 - j] = t;
                  }

                  // 回填
                  for (int j = 0; i + j < m && j < n; j++) {
                      grid[i + j][j] = temp[j];
                  }
              }

              for (int i = 1; i < n; i++) {
                  int[] temp = new int[Math.min(m, n - i)];
                  for (int j = 0; j < m && i + j < n; j++) {
                      temp[j] = grid[j][i + j];
                  }
                  Arrays.sort(temp);


                  // 回填
                  for (int j = 0; j < m && i + j < n; j++) {
                      grid[j][i + j] = temp[j];
                  }
              }
              return grid;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }