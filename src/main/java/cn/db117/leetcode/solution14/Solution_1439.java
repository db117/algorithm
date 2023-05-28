

//给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。 
//
// 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。 
//
// 
//
// 示例 1： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 5
//输出：7
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。  
//
// 示例 2： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 9
//输出：17
// 
//
// 示例 3： 
//
// 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
//输出：9
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。 
// 
//
// 示例 4： 
//
// 输入：mat = [[1,1,10],[2,2,9]], k = 7
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat.length[i] 
// 1 <= m, n <= 40 
// 1 <= k <= min(200, n ^ m) 
// 1 <= mat[i][j] <= 5000 
// mat[i] 是一个非递减数组 
// 
//
// Related Topics 数组 二分查找 矩阵 堆（优先队列） 👍 161 👎 0


package cn.db117.leetcode.solution14;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1439.有序矩阵中的第 k 个最小数组和.find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows
 *
 * @author db117
 * @since 2023-05-28 23:26:09
 **/

public class Solution_1439 {
    public static void main(String[] args) {
        Solution solution = new Solution_1439().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] mat, int k) {
            int m = mat.length;

            int[] pre = new int[]{0};
            for (int[] ints : mat) {
                // 只需要知道前面几行的前 k 个最小的数对即可，后面的没有用
                pre = helper(pre, ints, k);
            }

            return pre[k - 1];
        }

        private int[] helper(int[] nums1, int[] nums2, int k) {
            int n = nums1.length, m = nums2.length, sz = 0;
            // 记录前 k 个最小的数对的和
            int[] ans = new int[Math.min(n * m, k)];
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            queue.add(new int[]{nums1[0] + nums2[0], 0, 0});
            while (!queue.isEmpty() && sz < k) {// 只循环 k 次
                int[] poll = queue.poll();
                int i = poll[1], j = poll[2];
                ans[sz++] = nums1[i] + nums2[j];
                // 继续往下走
                if (j == 0 && i + 1 < n) {// j==0 省的用一个set进行去重了
                    queue.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                }
                if (j + 1 < m) {
                    queue.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}