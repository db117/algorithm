

//给你一个 2 行 n 列的二进制数组： 
//
// 
// 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。 
// 第 0 行的元素之和为 upper。 
// 第 1 行的元素之和为 lower。 
// 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。 
// 
//
// 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。 
//
// 如果有多个不同的答案，那么任意一个都可以通过本题。 
//
// 如果不存在符合要求的答案，就请返回一个空的二维数组。 
//
// 
//
// 示例 1： 
//
// 输入：upper = 2, lower = 1, colsum = [1,1,1]
//输出：[[1,1,0],[0,0,1]]
//解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
// 
//
// 示例 2： 
//
// 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
//输出：[]
// 
//
// 示例 3： 
//
// 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
//输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colsum.length <= 10^5 
// 0 <= upper, lower <= colsum.length 
// 0 <= colsum[i] <= 2 
// 
//
// Related Topics 贪心 数组 矩阵 👍 56 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1253.重构 2 行二进制矩阵.reconstruct-a-2-row-binary-matrix
 *
 * @author db117
 * @since 2023-06-29 13:47:13
 **/

public class Solution_1253 {
    public static void main(String[] args) {
        Solution solution = new Solution_1253().new Solution();
        // 5
        //			5
        //			[2,1,2,0,1,0,1,2,0,1]
        System.out.println(solution.reconstructMatrix(5, 5, new int[]{
                2, 1, 2, 0, 1, 0, 1, 2, 0, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            int n = colsum.length;
            int sum = 0;
            int[] up = new int[n];
            int[] low = new int[n];
            // 先填充 2 的
            for (int i = 0; i < n; i++) {
                if (colsum[i] == 2) {
                    up[i] = 1;
                    upper--;
                    low[i] = 1;
                    lower--;
                } else {
                    sum += colsum[i];
                }
            }
            if (lower < 0 || upper < 0) {
                return new ArrayList<>();
            }
            // 填充 1 的
            for (int i = 0; i < n && lower > 0; i++) {
                if (up[i] + low[i] < colsum[i]) {
                    low[i] = 1;
                    lower--;
                    sum--;
                }
            }
            for (int i = 0; i < n && upper > 0; i++) {
                if (up[i] + low[i] < colsum[i]) {
                    up[i] = 1;
                    upper--;
                    sum--;
                }
            }
            if (lower != 0 || upper != 0 || sum != 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Arrays.stream(up).boxed().toList());
            ans.add(Arrays.stream(low).boxed().toList());
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}