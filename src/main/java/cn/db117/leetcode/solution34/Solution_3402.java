

//给你一个由 非负 整数组成的 m x n 矩阵 grid。 
//
// 在一次操作中，你可以将任意元素 grid[i][j] 的值增加 1。 
//
// 返回使 grid 的所有列 严格递增 所需的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入: grid = [[3,2],[1,3],[3,4],[0,1]] 
// 
//
// 输出: 15 
//
// 解释: 
//
// 
// 为了让第 0 列严格递增，可以对 grid[1][0] 执行 3 次操作，对 grid[2][0] 执行 2 次操作，对 grid[3][0] 执行 6 
//次操作。 
// 为了让第 1 列严格递增，可以对 grid[3][1] 执行 4 次操作。 
// 
//
//
// 示例 2： 
//
// 
// 输入: grid = [[3,2,1],[2,1,0],[1,2,3]] 
// 
//
// 输出: 12 
//
// 解释: 
//
// 
// 为了让第 0 列严格递增，可以对 grid[1][0] 执行 2 次操作，对 grid[2][0] 执行 4 次操作。 
// 为了让第 1 列严格递增，可以对 grid[1][1] 执行 2 次操作，对 grid[2][1] 执行 2 次操作。 
// 为了让第 2 列严格递增，可以对 grid[1][2] 执行 2 次操作。 
// 
//
//
// 
//
// 提示: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 0 <= grid[i][j] < 2500 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution34;

 /**
 * 3402.使每一列严格递增的最少操作次数.minimum-operations-to-make-columns-strictly-increasing
 *
 * @author db117
 * @since  2025-01-02 11:12:04
 **/

  public class Solution_3402{
      public static void main(String[] args) {
           Solution solution = new Solution_3402().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int minimumOperations(int[][] grid) {
              int m = grid.length;
              int n = grid[0].length;
              int ans = 0;
              for (int i = 0; i < n; i++) {
                  int cur = Integer.MIN_VALUE;
                  for (int[] ints : grid) {
                      if (ints[i] <= cur) {
                          // 需要把当前数字变成 cur + 1
                          ans += cur - ints[i] + 1;
                          cur = cur + 1;
                      } else {
                          // 下一个数字要比当前数字大
                          cur = ints[i];
                      }
                  }
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }