

//给你一个整数数组 nums。 
//
// 如果一个子数组中所有元素的 按位与 运算结果等于该子数组的 最小值 ，则称该子数组为 一致子数组 。 
//
// 返回 nums 中 一致子数组 的个数。 
//
// 子数组 是数组中一个连续、非空的元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [5,3,1,2] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 以下子数组是一致子数组： 
//
// 
// 
// 
// 子数组 
// 包含的值 
// 按位与 
// 最小值 
// 
// 
// nums[0..0] 
// [5] 
// 5 
// 5 
// 
// 
// nums[1..1] 
// [3] 
// 3 
// 3 
// 
// 
// nums[2..2] 
// [1] 
// 1 
// 1 
// 
// 
// nums[3..3] 
// [2] 
// 2 
// 2 
// 
// 
// nums[1..2] 
// [3, 1] 
// 3 & 1 = 1 
// 1 
// 
// 
// nums[0..2] 
// [5, 3, 1] 
// 5 & 3 & 1 = 1 
// 1 
// 
// 
// 
//
// 因此，一致子数组的个数为 6。 
//
//
// 示例 2： 
//
// 
// 输入： nums = [1,1,1] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 对于每个子数组，其按位与运算结果和最小值均等于 1。因此，答案为 6。 
//
//
// 示例 3： 
//
// 
// 输入： nums = [0] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 唯一的子数组是 [0]，其按位与运算结果和最小值均为 0。因此，答案为 1。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution41;

/**
 * 4111.统计一致子数组数目 I.count-consistent-subarrays-i
 *
 * @author db117
 * @since 2026-11-15 15:38:55
 **/

public class Solution_4111 {
    public static void main(String[] args) {
        Solution solution = new Solution_4111().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistent(int[] nums) {
            int n = nums.length;
            int ans = 0;
            // 模拟
            for (int i = 0; i < n; i++) {
                int s = nums[i];
                int min = nums[i];
                if (s == min) {
                    ans++;
                }
                for (int j = i + 1; j < n; j++) {
                    min = Math.min(min, nums[j]);
                    s &= nums[j];
                    if (s == min) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}