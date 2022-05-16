

//给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。 
//
// 请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 10⁹ + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,4], k = 5
//输出：20
//解释：将第一个数增加 5 次。
//得到 nums = [5, 4] ，乘积为 5 * 4 = 20 。
//可以证明 20 是能得到的最大乘积，所以我们返回 20 。
//存在其他增加 nums 的方法，也能得到最大乘积。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,3,2], k = 2
//输出：216
//解释：将第二个数增加 1 次，将第四个数增加 1 次。
//得到 nums = [6, 4, 3, 3] ，乘积为 6 * 4 * 3 * 3 = 216 。
//可以证明 216 是能得到的最大乘积，所以我们返回 216 。
//存在其他增加 nums 的方法，也能得到最大乘积。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 
// 👍 9 👎 0


package cn.db117.leetcode.solution22;

import java.util.PriorityQueue;

/**
 * 2233.K 次增加后的最大乘积.maximum-product-after-k-increments
 *
 * @author db117
 * @since 2022-04-12 15:28:37
 **/

public class Solution_2233 {
    public static void main(String[] args) {
        Solution solution = new Solution_2233().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums, int k) {
            // 优先队列,一直找最小的增加
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }

            while (k > 0) {
                Integer poll = queue.poll();
                queue.offer(poll + 1);
                k--;
            }

            long ans = 1;
            while (!queue.isEmpty()) {
                ans *= queue.poll();
                ans %= 1e9 + 7;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}