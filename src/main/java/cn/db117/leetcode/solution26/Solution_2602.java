

//给你一个正整数数组 nums 。 
//
// 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任
//意 次： 
//
// 
// 将数组里一个元素 增大 或者 减小 1 。 
// 
//
// 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。 
//
// 注意，每次查询后，数组变回最开始的值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,6,8], queries = [1,5]
//输出：[14,10]
//解释：第一个查询，我们可以执行以下操作：
//- 将 nums[0] 减小 2 次，nums = [1,1,6,8] 。
//- 将 nums[2] 减小 5 次，nums = [1,1,1,8] 。
//- 将 nums[3] 减小 7 次，nums = [1,1,1,1] 。
//第一个查询的总操作次数为 2 + 5 + 7 = 14 。
//第二个查询，我们可以执行以下操作：
//- 将 nums[0] 增大 2 次，nums = [5,1,6,8] 。
//- 将 nums[1] 增大 4 次，nums = [5,5,6,8] 。
//- 将 nums[2] 减小 1 次，nums = [5,5,5,8] 。
//- 将 nums[3] 减小 3 次，nums = [5,5,5,5] 。
//第二个查询的总操作次数为 2 + 4 + 1 + 3 = 10 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,9,6,3], queries = [10]
//输出：[20]
//解释：我们可以将数组中所有元素都增大到 10 ，总操作次数为 8 + 1 + 4 + 7 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 10⁵ 
// 1 <= nums[i], queries[i] <= 10⁹ 
// 
//
// 👍 11 👎 0


package cn.db117.leetcode.solution26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2602.使数组元素全部相等的最少操作次数.minimum-operations-to-make-all-array-elements-equal
 *
 * @author db117
 * @since 2023-03-27 15:07:55
 **/

public class Solution_2602 {
    public static void main(String[] args) {
        Solution solution = new Solution_2602().new Solution();
//        System.out.println(solution.minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
        System.out.println(solution.minOperations(new int[]{47, 50, 97, 58, 87, 72, 41, 63, 41, 51, 17, 21, 7, 100, 69, 66, 79, 92, 84, 9, 57, 26, 26, 28, 83, 38},
                new int[]{3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Long> minOperations(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int n = nums.length;
            // 前缀和
            long[] pSum = new long[n + 1];

            for (int i = 0; i < nums.length; i++) {
                pSum[i + 1] = pSum[i] + nums[i];
            }

            List<Long> ans = new ArrayList<>();
            for (int query : queries) {
                long cur = 0;
                int lessMax = bsLessMax(nums, query);
                if (lessMax != -1) {
                    // 比当前值小
                    cur += (long) (lessMax + 1) * query - pSum[lessMax + 1];
                }
                // 剩下都是大于等于当前值的
                cur += pSum[n] - pSum[lessMax + 1] - (long) (n - lessMax - 1) * query;

                ans.add(cur);
            }

            return ans;
        }


        /**
         * 找小于目标的最大值
         */
        public int bsLessMax(int[] nums, int target) {
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