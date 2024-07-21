

//给你一个下标从 0 开始大小为 m x n 的二进制矩阵 grid 。 
//
// 从原矩阵中选出若干行构成一个行的 非空 子集，如果子集中任何一列的和至多为子集大小的一半，那么我们称这个子集是 好子集。 
//
// 更正式的，如果选出来的行子集大小（即行的数量）为 k，那么每一列的和至多为 floor(k / 2) 。 
//
// 请你返回一个整数数组，它包含好子集的行下标，请你将其 升序 返回。 
//
// 如果有多个好子集，你可以返回任意一个。如果没有好子集，请你返回一个空数组。 
//
// 一个矩阵 grid 的行 子集 ，是删除 grid 中某些（也可能不删除）行后，剩余行构成的元素集合。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]
//输出：[0,1]
//解释：我们可以选择第 0 和第 1 行构成一个好子集。
//选出来的子集大小为 2 。
//- 第 0 列的和为 0 + 0 = 0 ，小于等于子集大小的一半。
//- 第 1 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
//- 第 2 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
//- 第 3 列的和为 0 + 1 = 1 ，小于等于子集大小的一半。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0]]
//输出：[0]
//解释：我们可以选择第 0 行构成一个好子集。
//选出来的子集大小为 1 。
//- 第 0 列的和为 0 ，小于等于子集大小的一半。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1]]
//输出：[]
//解释：没有办法得到一个好子集。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 10⁴ 
// 1 <= n <= 5 
// grid[i][j] 要么是 0 ，要么是 1 。 
// 
//
// Related Topics 位运算 数组 哈希表 矩阵 👍 43 👎 0


package cn.db117.leetcode.solution27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2732.找到矩阵中的好子集.find-a-good-subset-of-the-matrix
 *
 * @author db117
 * @since 2024-06-25 19:44:14
 **/

public class Solution_2732 {
    public static void main(String[] args) {
        Solution solution = new Solution_2732().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // 如果一行全是 0 则直接返回
            // 如果有可能是多行，那么其中任意两行也会满足。直接返回其中两行就行
            int[] arr = new int[m];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < grid.length; i++) {
                int[] ints = grid[i];
                int cur = 0;
                for (int j = 0; j < n; j++) {
                    cur |= ints[j] << j;
                }
                // 找到一行为 0
                if (cur == 0) {
                    return List.of(i);
                }
                map.put(cur, i);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
                    // 找到 2 行匹配
                    if ((entry.getKey() & entry1.getKey()) == 0) {
                        Integer v = entry.getValue();
                        Integer v1 = entry1.getValue();
                        if (v > v1) {
                            return List.of(v1, v);
                        } else {
                            return List.of(v, v1);
                        }
                    }
                }
            }

            return new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}