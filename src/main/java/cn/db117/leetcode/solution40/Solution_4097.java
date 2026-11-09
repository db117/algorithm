

//给你一个长度为偶数 n 的整数数组 nums。 
//
// 你需要将 nums 中的元素两两合并：将 nums[0] 与 nums[1] 合并，将 nums[2] 与 nums[3] 合并，依此类推，直到将 
//nums[n - 2] 与 nums[n - 1] 合并。 
//
// 返回所有合并后得到的整数中的最小值。 
//
// 合并两个整数，是指将第二个整数的所有十进制数位拼接在第一个整数的所有十进制数位之后。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [23,55,42,21] 
// 
//
// 输出： 2355 
//
// 解释： 
//
// 
// 将 nums[0] = 23 与 nums[1] = 55 合并，得到 2355。 
// 将 nums[2] = 42 与 nums[3] = 21 合并，得到 4221。 
// 合并后得到的整数中的最小值为 min(2355, 4221) = 2355。 
// 
//
//
// 示例 2： 
//
// 
// 输入： nums = [34,7,11,11] 
// 
//
// 输出： 347 
//
// 解释： 
//
// 
// 将 nums[0] = 34 与 nums[1] = 7 合并，得到 347。 
// 将 nums[2] = 11 与 nums[3] = 11 合并，得到 1111。 
// 合并后得到的整数中的最小值为 min(347, 1111) = 347。 
// 
//
//
// 示例 3： 
//
// 
// 输入： nums = [9,20] 
// 
//
// 输出： 920 
//
// 解释： 
//
// 
// 将 nums[0] = 9 与 nums[1] = 20 合并，得到 920。 
// 合并后只有一个整数，因此最小值为 920。 
// 
//
//
// 
//
// 提示： 
//
// 
// 2 <= n == nums.length <= 100 
// n 为偶数 
// 1 <= nums[i] <= 1000 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution40;

/**
 * 4097.合并整数后的最小值.minimum-value-of-merged-integers
 *
 * @author db117
 * @since 2026-11-09 22:29:42
 **/

public class Solution_4097 {
    public static void main(String[] args) {
        Solution solution = new Solution_4097().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMergedInteger(int[] nums) {
            int ans = Integer.MAX_VALUE;

            int n = nums.length;
            for (int i = 0; i < n; i += 2) {
                int anInt = Integer.parseInt(nums[i] + "" + nums[i + 1]);
                ans = Math.min(ans, anInt);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}