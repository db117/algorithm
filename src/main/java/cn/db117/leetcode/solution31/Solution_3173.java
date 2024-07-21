

//给定一个长度为 n 的数组 nums，返回一个长度为 n - 1 的数组 answer 使得 answer[i] = nums[i] | nums[i + 
//1]，其中 | 表示按位 OR 操作。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,7,15] 
// 
//
// 输出：[3,7,15] 
//
// 
//
// 示例 2： 
//
// 
// 输入：nums = [8,4,2] 
// 
//
// 输出：[12,6] 
//
// 
//
// 示例 3： 
//
// 
// 输入：nums = [5,4,9,11] 
// 
//
// 输出：[5,13,11] 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 👍 0 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3173.相邻元素的按位或.bitwise-or-of-adjacent-elements
 *
 * @author db117
 * @since 2024-07-05 17:48:59
 **/

public class Solution_3173 {
    public static void main(String[] args) {
        Solution solution = new Solution_3173().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] orArray(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                ans[i] = nums[i] | nums[i + 1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}