// 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数
//字的数组。 
//
// 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模
//后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
//输出：13 
//解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5
//, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
//输出：6
//解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和
//为 3 + 3 = 6 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
//输出：50
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^3 
// nums.length == n 
// 1 <= nums[i] <= 100 
// 1 <= left <= right <= n * (n + 1) / 2 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 28 👎 0


package cn.db117.leetcode.solution15;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1508.子数组和排序后的区间和.range-sum-of-sorted-subarray-sums
 *
 * @author db117
 * @since 2021-07-19 10:29:50
 **/

public class Solution_1508 {
    public static void main(String[] args) {
        Solution solution = new Solution_1508().new Solution();
        System.out.println(solution.rangeSum(new int[]{
                1, 2, 3, 4
        }, 4, 1, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            // 复杂度
            // 时间：n*logN

            int MOD = 1_000_000_007;
            // 多路排序

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < nums.length; i++) {
                queue.offer(new int[]{nums[i], i + 1});
            }

            long ans = 0;
            while (right > 0) {
                int[] poll = queue.poll();
                // 当前路的和
                int sum = poll[0];
                // 当前路的下一个索引
                int next = poll[1];

                if (left <= 1) {
                    // 进入区间
                    ans += sum;
                }
                if (next < nums.length) {
                    // 后面还有数字
                    queue.offer(new int[]{sum + nums[next], next + 1});
                }
                right--;
                left--;
            }
            return Math.toIntExact(ans % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}