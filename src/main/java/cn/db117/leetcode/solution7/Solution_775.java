

//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。 
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目： 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目： 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] < n 
// nums 中的所有整数 互不相同 
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列 
// 
//
// Related Topics 数组 数学 👍 190 👎 0


package cn.db117.leetcode.solution7;

/**
 * 775.全局倒置与局部倒置.global-and-local-inversions
 *
 * @author db117
 * @since 2022-11-16 23:37:24
 **/

public class Solution_775 {
    public static void main(String[] args) {
        Solution solution = new Solution_775().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            // 倒这遍历，发现 nums[i+2...] 小于当前值则返回 FALSE
            int n = nums.length;
            int min = nums[n - 1];
            for (int i = n - 3; i >= 0; i--) {
                if (nums[i] > min) {
                    return false;
                }
                min = Math.min(nums[i + 1], min);
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}