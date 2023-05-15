

//给定 m x n 矩阵 matrix 。 
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 68 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1072.按列翻转得到最大值等行数.flip-columns-for-maximum-number-of-equal-rows
 *
 * @author db117
 * @since 2023-05-12 15:42:58
 **/

public class Solution_1072 {
    public static void main(String[] args) {
        Solution solution = new Solution_1072().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // 找最多相同特征的行（经过翻转能一样的行）
            // 把第一列都变成 1 ，直接找一样的行的数量
            for (int[] ints : matrix) {
                if (ints[0] == 0) {
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = ints[i] == 0 ? 1 : 0;
                    }
                }
            }
            Map<String, Integer> map = new HashMap<>();
            for (int[] ints : matrix) {
                map.merge(Arrays.toString(ints), 1, Integer::sum);
            }
            return map.values().stream().max(Comparator.naturalOrder()).orElse(1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}