

//给你一个二进制数组 nums 。 
//
// 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。 
//
// 返回数组 nums 中交替子数组的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [0,1,1,1] 
// 
//
// 输出： 5 
//
// 解释： 
//
//
// 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,0,1,0] 
// 
//
// 输出： 10 
//
// 解释： 
//
//
// 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 。 
// 
//
// Related Topics 数组 数学 👍 4 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3101.交替子数组计数.count-alternating-subarrays
 *
 * @author db117
 * @since 2024-04-06 19:40:07
 **/

public class Solution_3101 {
    public static void main(String[] args) {
        Solution solution = new Solution_3101().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            int n = nums.length;
            long ans = 0;
            // 双指针
            int left = 0, right = 1;
            for (; right < n; right++) {
                // 找到不满足条件的
                if (nums[right] == nums[right - 1]) {
                    // 以left开头的满足条件的子数组个数
                    ans += count(right - left);
                    left = right;
                }
            }
            // 最后一个
            ans += count(right - left);
            return ans;
        }

        private long count(int n) {
            return (long) n * (n + 1) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}