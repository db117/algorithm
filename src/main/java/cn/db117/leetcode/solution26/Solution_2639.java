

//给你一个下标从 0 开始的 m x n 整数矩阵 grid 。矩阵中某一列的宽度是这一列数字的最大 字符串长度 。 
//
// 
// 比方说，如果 grid = [[-10], [3], [12]] ，那么唯一一列的宽度是 3 ，因为 -10 的字符串长度为 3 。 
// 
//
// 请你返回一个大小为 n 的整数数组 ans ，其中 ans[i] 是第 i 列的宽度。 
//
// 一个有 len 个数位的整数 x ，如果是非负数，那么 字符串长度 为 len ，否则为 len + 1 。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1],[22],[333]]
//输出：[3]
//解释：第 0 列中，333 字符串长度为 3 。
// 
//
// 示例 2： 
//
// 输入：grid = [[-15,1,3],[15,7,12],[5,6,-2]]
//输出：[3,1,2]
//解释：
//第 0 列中，只有 -15 字符串长度为 3 。
//第 1 列中，所有整数的字符串长度都是 1 。
//第 2 列中，12 和 -2 的字符串长度都为 2 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -10⁹ <= grid[r][c] <= 10⁹ 
// 
//
// Related Topics 数组 矩阵 👍 8 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2639.查询网格图中每一列的宽度.find-the-width-of-columns-of-a-grid
 *
 * @author db117
 * @since 2024-04-06 19:59:43
 **/

public class Solution_2639 {
    public static void main(String[] args) {
        Solution solution = new Solution_2639().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int[] ints : grid) {
                    max = Math.max(max, String.valueOf(ints[i]).length());
                }
                ans[i] = max;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}