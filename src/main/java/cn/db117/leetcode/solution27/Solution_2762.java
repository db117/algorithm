

//给你一个下标从 0 开始的整数数组 nums 。nums 的一个子数组如果满足以下条件，那么它是 不间断 的： 
//
// 
// i，i + 1 ，...，j 表示子数组中的下标。对于所有满足 i <= i1, i2 <= j 的下标对，都有 0 <= |nums[i1] - 
//nums[i2]| <= 2 。 
// 
//
// 请你返回 不间断 子数组的总数目。 
//
// 子数组是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,4,2,4]
//输出：8
//解释：
//大小为 1 的不间断子数组：[5], [4], [2], [4] 。
//大小为 2 的不间断子数组：[5,4], [4,2], [2,4] 。
//大小为 3 的不间断子数组：[4,2,4] 。
//没有大小为 4 的不间断子数组。
//不间断子数组的总数目为 4 + 3 + 1 = 8 。
//除了这些以外，没有别的不间断子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：6
//解释：
//大小为 1 的不间断子数组：[1], [2], [3] 。
//大小为 2 的不间断子数组：[1,2], [2,3] 。
//大小为 3 的不间断子数组：[1,2,3] 。
//不间断子数组的总数目为 3 + 2 + 1 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 10 👎 0


package cn.db117.leetcode.solution27;

import java.util.TreeMap;

/**
 * 2762.不间断子数组.continuous-subarrays
 *
 * @author db117
 * @since 2023-07-03 10:50:38
 **/

public class Solution_2762 {
    public static void main(String[] args) {
        Solution solution = new Solution_2762().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long continuousSubarrays(int[] nums) {
            long ans = 0;
            int n = nums.length;
            // key 为数字，value 为数字出现的次数
            TreeMap<Integer, Integer> map = new TreeMap<>();
            // 滑动窗口
            int left = 0, right = 0;
            while (right < n) {
                // 右边界加入
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                // 维护区间最大最小值
                while (map.lastKey() - map.firstKey() > 2) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
                ans += right - left + 1;
                right++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}