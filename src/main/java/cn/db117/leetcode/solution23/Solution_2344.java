

//给你两个正整数数组 nums 和 numsDivide 。你可以从 nums 中删除任意数目的元素。 
//
// 请你返回使 nums 中 最小 元素可以整除 numsDivide 中所有元素的 最少 删除次数。如果无法得到这样的元素，返回 -1 。 
//
// 如果 y % x == 0 ，那么我们说整数 x 整除 y 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
//输出：2
//解释：
//[2,3,2,4,3] 中最小元素是 2 ，它无法整除 numsDivide 中所有元素。
//我们从 nums 中删除 2 个大小为 2 的元素，得到 nums = [3,4,3] 。
//[3,4,3] 中最小元素为 3 ，它可以整除 numsDivide 中所有元素。
//可以证明 2 是最少删除次数。
// 
//
// 示例 2： 
//
// 输入：nums = [4,3,6], numsDivide = [8,2,6,10]
//输出：-1
//解释：
//我们想 nums 中的最小元素可以整除 numsDivide 中的所有元素。
//没有任何办法可以达到这一目的。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, numsDivide.length <= 10⁵ 
// 1 <= nums[i], numsDivide[i] <= 10⁹ 
// 
//
// Related Topics 数组 数学 数论 排序 堆（优先队列） 👍 7 👎 0


package cn.db117.leetcode.solution23;

import java.util.PriorityQueue;

/**
 * 2344.使数组可以被整除的最少删除次数.minimum-deletions-to-make-array-divisible
 *
 * @author db117
 * @since 2022-07-29 16:59:27
 **/

public class Solution_2344 {
    public static void main(String[] args) {
        Solution solution = new Solution_2344().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int[] numsDivide) {
            // 数组的最大公约数
            int arrGcd;
            if (numsDivide.length == 1) {
                arrGcd = numsDivide[0];
            } else {
                arrGcd = gcd(numsDivide[0], numsDivide[1]);

                for (int i = 2; i < numsDivide.length; i++) {
                    arrGcd = gcd(arrGcd, numsDivide[i]);
                }
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll > arrGcd) {
                    return -1;
                }
                // 等于数组的最大公约数或者是数字最大公约数的约数
                if (poll == arrGcd || arrGcd % poll == 0) {
                    return ans;
                }
                ans++;
            }
            return -1;
        }

        // 最大公约数
        public int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }

            return gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}