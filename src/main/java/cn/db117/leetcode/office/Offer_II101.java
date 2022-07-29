


//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 49 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer II 101.分割等和子集.NUPfPr
 *
 * @author db117
 * @since 2022-07-27 15:23:16
 **/

public class Offer_II101 {
    public static void main(String[] args) {
        Solution solution = new Offer_II101().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length < 2) {
                return false;
            }
            int sum = 0;
            int maxNum = -1;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(num, maxNum);
            }
            if ((sum & 1) == 1) {
                return false;
            }
            int mid = sum / 2;
            if (maxNum > mid) {
                // 有一个数字大于一半,这剩下的所有值之和肯定小于一半
                return false;
            }
            // 01 背包
            // 前 i 个数字 能不能凑齐 j
            boolean[][] dp = new boolean[nums.length][mid + 1];
            // base
            // 第一个数字
            dp[0][nums[0]] = true;

            for (int i = 0; i < nums.length; i++) {
                // 全不选
                dp[i][0] = true;
            }


            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= mid; j++) {
                    // 不选当前数字
                    dp[i][j] = dp[i - 1][j];
                    // 选当前数字
                    if (j > nums[i]) {
                        dp[i][j] |= dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[nums.length - 1][mid];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}