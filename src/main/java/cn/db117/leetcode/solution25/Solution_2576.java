

//给你一个下标从 0 开始的整数数组 nums 。 
//
// 一开始，所有下标都没有被标记。你可以执行以下操作任意次： 
//
// 
// 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。 
// 
//
// 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,2,4]
//输出：2
//解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
//没有其他更多可执行的操作，所以答案为 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9,2,5,4]
//输出：4
//解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
//第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
//没有其他更多可执行的操作，所以答案为 4 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,6,8]
//输出：0
//解释：没有任何可以执行的操作，所以答案为 0 。
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
// 👍 18 👎 0


package cn.db117.leetcode.solution25;

import java.util.Arrays;

/**
 * 2576.求出最多标记下标.find-the-maximum-number-of-marked-indices
 *
 * @author db117
 * @since 2023-02-27 10:42:29
 **/

public class Solution_2576 {
    public static void main(String[] args) {
        Solution solution = new Solution_2576().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = 0;

            int mid = n / 2;
            int right = mid;
            int left = 0;
            // 从中间分，左边匹配右边
            while (left < mid && right < n) {
                while (right < n && nums[right] < nums[left] * 2) {
                    right++;
                }
                if (right >= n) {
                    break;
                }
                ans++;
                left++;
                right++;
            }

            return ans * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}