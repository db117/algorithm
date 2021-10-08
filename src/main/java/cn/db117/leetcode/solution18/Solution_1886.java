

//给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 
//target 一致，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//输出：true
//解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//输出：false
//解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//输出：true
//解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
// 
//
// 
//
// 提示： 
//
// 
// n == mat.length == target.length 
// n == mat[i].length == target[i].length 
// 1 <= n <= 10 
// mat[i][j] 和 target[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 矩阵 👍 10 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1886.判断矩阵经轮转后是否一致.determine-whether-matrix-can-be-obtained-by-rotation
 *
 * @author db117
 * @since 2021-09-29 18:32:51
 **/

public class Solution_1886 {
    public static void main(String[] args) {
        Solution solution = new Solution_1886().new Solution();
        System.out.println(solution.findRotation(new int[][]
                        {{0, 1}, {1, 1}}
                , new int[][]
                        {{1, 0}, {0, 1}}
        ));
        System.out.println(solution.findRotation(new int[][]
                        {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}
                , new int[][]
                        {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length;
            boolean f1 = true, f2 = true, f3 = true, f4 = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // 旋转90
                    if (f1 && mat[j][n - 1 - i] != target[i][j]) {
                        f1 = false;
                    }

                    // 旋转180
                    if (f2 && mat[n - 1 - i][n - 1 - j] != target[i][j]) {
                        f2 = false;
                    }

                    // 旋转270
                    if (f3 && mat[n - 1 - j][i] != target[i][j]) {
                        f3 = false;
                    }

                    // 旋转360
                    if (f4 && mat[i][j] != target[i][j]) {
                        f4 = false;
                    }

                    if (!f1 && !f2 && !f3 && !f4) {
                        // 都不行
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}