

//给你一个整数数组 nums 和一个整数 k 。 
//
// 如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。 
//
// 返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。 
//子数组 是数组中的一个连续元素序列。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [3,9,2,1,7], k = 3 
// 
//
// 输出：7 
//
// 解释： 
//
// 
// 1 出现在两个大小为 3 的子数组中：[9, 2, 1]、[2, 1, 7] 
// 2 出现在三个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1]、[2, 1, 7] 
// 3 出现在一个大小为 3 的子数组中：[3, 9, 2] 
// 7 出现在一个大小为 3 的子数组中：[2, 1, 7] 
// 9 出现在两个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1] 
// 
//
// 返回 7 ，因为它满足题意的所有整数中最大的那个。 
//
// 示例 2： 
//
// 
// 输入：nums = [3,9,7,2,1,7], k = 4 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// 1 出现在两个大小为 3 的子数组中：[9, 7, 2, 1]、[7, 2, 1, 7] 
// 2 出现在三个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7] 
// 3 出现在一个大小为 3 的子数组中：[3, 9, 7, 2] 
// 7 出现在三个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7] 
// 9 出现在两个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1] 
// 
//
// 返回 3 ，因为它满足题意的所有整数中最大的那个。 
//
// 示例 3： 
//
// 
// 输入：nums = [0,0], k = 1 
// 
//
// 输出：-1 
//
// 解释： 
//
// 不存在满足题意的整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 50 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 👍 8 👎 0


package cn.db117.leetcode.solution34;

import java.util.HashMap;
import java.util.Map;

/**
 * 3471.找出最大的几近缺失整数.find-the-largest-almost-missing-integer
 *
 * @author db117
 * @since 2025-03-06 19:38:04
 **/

public class Solution_3471 {
    public static void main(String[] args) {
        Solution solution = new Solution_3471().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestInteger(int[] nums, int k) {
            int n = nums.length;
            int ans = -1;
            int[] hash = new int[51];
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                hash[num]++;
                map.putIfAbsent(num, new int[]{i, 0});
                map.get(num)[1] = i;
            }
            if (k == n) {
                // 所有元素的最大值
                int max = 0;
                for (int num : nums) {
                    max = Math.max(max, num);
                }
                return max;
            }
            if (k == 1) {
                // 出现一次的最大元素
                for (int i = 50; i >= 0; i--) {

                    if (hash[i] == 1) {
                        ans = Math.max(ans, i);
                    }
                }
                return ans;
            }

            // 最左边，最右边的出现次数为 1 的最大值
            int left = hash[nums[0]];
            int right = hash[nums[n - 1]];

            if (left == 1 && right == 1) {
                return Math.max(nums[0], nums[n - 1]);
            }

            if (left == 1) {
                return nums[0];
            }
            if (right == 1) {
                return nums[n - 1];
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}