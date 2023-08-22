

//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。 
//
// 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。 
//
// 子数组 是数组中一个连续且可能为空的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,1,3], k = 3
//输出：3
//解释：最优的方案是删除下标 2 和下标 4 的元素。
//删除后，nums 等于 [1, 3, 3, 3] 。
//最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
//可以证明无法创建更长的等值子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2,2,1,1], k = 2
//输出：4
//解释：最优的方案是删除下标 2 和下标 3 的元素。 
//删除后，nums 等于 [1, 1, 1, 1] 。 
//数组自身就是等值子数组，长度等于 4 。 
//可以证明无法创建更长的等值子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= nums.length 
// 0 <= k <= nums.length 
// 
//
// 👍 18 👎 0


package cn.db117.leetcode.solution28;

import java.util.*;

/**
 * 2831.找出最长等值子数组.find-the-longest-equal-subarray
 *
 * @author db117
 * @since 2023-08-22 11:37:31
 **/

public class Solution_2831 {
    public static void main(String[] args) {
        Solution solution = new Solution_2831().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            if (nums.size() == 1) {
                return 1;
            }

            int ans = 1;
            // 按照数字分组
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                map.computeIfAbsent(nums.get(i), v -> new ArrayList<>()).add(i);
            }

            // 找出每个数字的最长连续长度(可以跳过k个数字)
            for (Integer num : map.keySet()) {
                int longestContinuousLength = findLongestContinuousLength(map.get(num), k);
                ans = Math.max(ans, longestContinuousLength);
            }
            return ans;
        }

        public static int findLongestContinuousLength(List<Integer> nums, int k) {
            int ans = 1;
            Queue<Integer> queue = new LinkedList<>();

            for (Integer num : nums) {
                if (queue.isEmpty()) {
                    queue.add(num);
                    continue;
                }
                while (!queue.isEmpty() && num - queue.size() - queue.peek() > k) {
                    queue.poll();
                }
                queue.add(num);
                ans = Math.max(ans, queue.size());
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}