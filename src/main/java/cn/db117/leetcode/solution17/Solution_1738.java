

//给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。 
//
// 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下
//标从 0 开始计数）执行异或运算得到。 
//
// 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[5,2],[1,6]], k = 1
//输出：7
//解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。 
//
// 示例 2： 
//
// 输入：matrix = [[5,2],[1,6]], k = 2
//输出：5
//解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。 
//
// 示例 3： 
//
// 输入：matrix = [[5,2],[1,6]], k = 3
//输出：4
//解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。 
//
// 示例 4： 
//
// 输入：matrix = [[5,2],[1,6]], k = 4
//输出：0
//解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 0 <= matrix[i][j] <= 10⁶ 
// 1 <= k <= m * n 
// 
//
// Related Topics 位运算 数组 分治 矩阵 前缀和 快速选择 排序 堆（优先队列） 👍 122 👎 0


package cn.db117.leetcode.solution17;

import java.util.PriorityQueue;

/**
 * 1738.找出第 K 大的异或坐标值.find-kth-largest-xor-coordinate-value
 *
 * @author db117
 * @since 2024-05-26 21:36:54
 **/

public class Solution_1738 {
    public static void main(String[] args) {
        Solution solution = new Solution_1738().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] pre = new int[m + 1][n + 1];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            // 计算前缀和
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    pq.add(pre[i][j]);
                }
            }

            // 找到第 k 大的数
            for (int i = 0; i < k - 1; i++) {
                pq.poll();
            }
            return pq.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}