

//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心 位运算 数组 矩阵 👍 210 👎 0


package cn.db117.leetcode.solution8;

/**
 * 861.翻转矩阵后的得分.score-after-flipping-matrix
 *
 * @author db117
 * @since 2021-11-12 14:22:09
 **/

public class Solution_861 {
    public static void main(String[] args) {
        Solution solution = new Solution_861().new Solution();

        System.out.println(solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            // 贪心
            // 把第一列都换成 1
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 0) {
                    // 把该行换一遍
                    for (int j = 0; j < grid[i].length; j++) {
                        grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                    }
                }
            }
            // 把剩下的每一列从左到右换成 1 最多
            for (int i = 1; i < n; i++) {
                int one = 0;
                for (int[] ints : grid) {
                    if (ints[i] == 1) {
                        one++;
                    }
                }
                if (one < m - one) {
                    // 1 比 0 少,则换
                    for (int[] ints : grid) {
                        ints[i] = ints[i] == 0 ? 1 : 0;
                    }
                }
            }

            // 算和
            for (int[] ints : grid) {
                int cur = 0;
                for (int i = 0; i < ints.length; i++) {
                    if (ints[i] == 1) {
                        cur |= 1 << (ints.length - 1 - i);
                    }
                }

                ans += cur;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}