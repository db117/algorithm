

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2141 👎 0


package cn.db117.leetcode.solution2;

import java.util.PriorityQueue;

/**
 * 239.滑动窗口最大值.sliding-window-maximum
 *
 * @author db117
 * @since 2023-03-01 10:53:44
 **/

public class Solution_239 {
    public static void main(String[] args) {
        Solution solution = new Solution_239().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            int[] ans = new int[nums.length - k + 1];
            // 前 k-1 个入队
            for (int i = 0; i < k - 1; i++) {
                pq.offer(new int[]{nums[i], i});
            }

            for (int i = 0; i < ans.length; i++) {
                int index = i + k - 1;
                // 当前数字入队
                pq.offer(new int[]{nums[index], index});

                // 窗口外的都出队
                while (!pq.isEmpty() && pq.peek()[1] < i) {
                    pq.poll();
                }

                ans[i] = pq.peek()[0];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}