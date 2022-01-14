

//对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。 
//
// 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
//输出：true
//解释：在此例中，n = 3 ，每一行和每一列都包含数字 1、2、3 。
//因此，返回 true 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[1,1,1],[1,2,3],[1,2,3]]
//输出：false
//解释：在此例中，n = 3 ，但第一行和第一列不包含数字 2 和 3 。
//因此，返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// 1 <= matrix[i][j] <= n 
// 
// Related Topics 数组 哈希表 矩阵 👍 5 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2133.检查是否每一行每一列都包含全部整数.check-if-every-row-and-column-contains-all-numbers
 *
 * @author db117
 * @since 2022-01-14 15:46:08
 **/

public class Solution_2133 {
    public static void main(String[] args) {
        Solution solution = new Solution_2133().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValid(int[][] matrix) {
            // 暴力
            int n = matrix.length;
            int[] count = new int[n];
            for (int[] ints : matrix) {
                for (int i : ints) {
                    count[i - 1]++;
                }
                int k = count[0];
                for (int i = 0; i < n; i++) {
                    if (count[i] != k) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int[] ints : matrix) {
                    count[ints[i] - 1]++;
                }
                int k = count[0];
                for (int j = 0; j < n; j++) {
                    if (count[j] != k) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}