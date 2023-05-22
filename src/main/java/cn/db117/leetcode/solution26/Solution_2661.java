

//给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数
//。 
//
// 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。 
//
// 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
//输出：2
//解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
// 
//
// 示例 2： 
// 
// 
//输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
//输出：3
//解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n = mat[i].length 
// arr.length == m * n 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= arr[i], mat[r][c] <= m * n 
// arr 中的所有整数 互不相同 
// mat 中的所有整数 互不相同 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 11 👎 0


package cn.db117.leetcode.solution26;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661.找出叠涂元素.first-completely-painted-row-or-column
 *
 * @author db117
 * @since 2023-05-22 10:19:28
 **/

public class Solution_2661 {
    public static void main(String[] args) {
        Solution solution = new Solution_2661().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[] row = new int[m + 1];
            int[] col = new int[n + 1];
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.put(mat[i][j], new int[]{i, j});
                }
            }
            // 整数互不相同，直接计数就行
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j];
                int[] ints = map.get(num);
                row[ints[0]]++;
                col[ints[1]]++;
                if (row[ints[0]] == n || col[ints[1]] == m) {
                    return j;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}