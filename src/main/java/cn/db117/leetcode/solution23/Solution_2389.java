

//给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。 
//
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度
// 。 
//
// 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,2,1], queries = [3,10,21]
//输出：[2,3,4]
//解释：queries 对应的 answer 如下：
//- 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
//- 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
//- 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,4,5], queries = [1]
//输出：[0]
//解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 二分查找 前缀和 排序 👍 10 👎 0


package cn.db117.leetcode.solution23;

import cn.db117.template.BinarySearch;

import java.util.Arrays;

/**
 * 2389.和有限的最长子序列.longest-subsequence-with-limited-sum
 *
 * @author db117
 * @see BinarySearch
 * @since 2022-09-02 14:46:38
 **/

public class Solution_2389 {
    public static void main(String[] args) {
        Solution solution = new Solution_2389().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int[] preSum = new int[nums.length];
            Arrays.sort(nums);

            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = nums[i] + preSum[i - 1];
            }

            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = bsLeftMax(preSum, queries[i] + 1) + 1;
            }
            return ans;
        }

        /**
         * 找小于目标的最大值
         */
        public int bsLeftMax(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // 选右边中位数
                int mid = left + ((right - left + 1) >> 1);
                if (nums[mid] < target) {
                    // 当前值可能是目标值,继续往右边找
                    left = mid;
                } else {
                    // 当前值不可能是目标值,想左边找
                    right = mid - 1;
                }
            }
            // 防止所有数据都大于目标值
            return nums[right] < target ? right : -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}