

//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 677 👎 0


package cn.db117.leetcode.solution8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862.和至少为 K 的最短子数组.shortest-subarray-with-sum-at-least-k
 *
 * @author db117
 * @since 2023-07-21 15:54:25
 **/

public class Solution_862 {
    public static void main(String[] args) {
        Solution solution = new Solution_862().new Solution();
//        System.out.println(solution.shortestSubarray(new int[]{1}, 1));
        // [1,2]
        //4
//        System.out.println(solution.shortestSubarray(new int[]{1, 2}, 4));
        //[2,-1,2]
        //3
        System.out.println(solution.shortestSubarray(new int[]{2, -1, 2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            // 前缀和
            long[] pre = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }

            // 单调队列
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < pre.length; i++) {
                // 保证队列中的值满足条件
                while (!deque.isEmpty() && pre[i] - pre[deque.peekFirst()] >= k) {
                    // 更新最小值,并弹出
                    ans = Math.min(ans, i - deque.pollFirst());
                }

                // 保证队列单调递增
                while (!deque.isEmpty() && pre[deque.peekLast()] >= pre[i]) {
                    // 如果当前值小于队列中的值,那么队列中的值就不可能是最小值
                    deque.pollLast();
                }

                deque.offerLast(i);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}