//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
//
// 返回 只删除一个 子数组可获得的 最大得分 。 
//
// 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,4,5,6]
//输出：17
//解释：最优子数组是 [2,4,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,2,1,2,5,2,1,2,5]
//输出：8
//解释：最优子数组是 [5,2,1] 或 [1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 
// Related Topics 双指针 
// 👍 23 👎 0


package cn.db117.leetcode.solution16;

import java.util.HashSet;
import java.util.Set;

/**
 * 1695.删除子数组的最大得分.maximum-erasure-value
 *
 * @author db117
 * @since 2021-06-22 18:49:43
 **/

public class Solution_1695 {
    public static void main(String[] args) {
        Solution solution = new Solution_1695().new Solution();
        System.out.println(solution.maximumUniqueSubarray(new int[]{
                4, 2, 4, 5, 6
        }));
        System.out.println(solution.maximumUniqueSubarray(new int[]{
                5, 2, 1, 2, 5, 2, 1, 2, 5
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int left = 0, right = 0;
            int sum = 0, max = 0;
            Set<Integer> set = new HashSet<>();
            while (right < nums.length) {
                // 右指针右移
                // 一直找到有重复的为止
                while (right < nums.length && !set.contains(nums[right])) {
                    sum += nums[right];
                    set.add(nums[right]);
                    right++;
                }

                max = Math.max(max, sum);

                // 左节点右移
                // 一直删除到没有重复的为止
                while (left < right && right < nums.length && set.contains(nums[right])) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }

            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}