

//给你一个整数数组 nums，和一个整数 k 。 
//
// 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。 
//
// nums 的 分数 是 nums 中最大元素和最小元素的差值。 
//
// 在更改每个下标对应的值之后，返回 nums 的最小 分数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 0
//输出：0
//解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,10], k = 2
//输出：6
//解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,3,6], k = 3
//输出：3
//解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁴ 
// 0 <= k <= 10⁴ 
// 
//
// Related Topics 贪心 数组 数学 排序 👍 234 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;

/**
 * 910.最小差值 II.smallest-range-ii
 *
 * @author db117
 * @since 2024-10-21 15:10:41
 **/

public class Solution_910 {
    public static void main(String[] args) {
        Solution solution = new Solution_910().new Solution();
        // [0,10]
        //			2
//        System.out.println(solution.smallestRangeII(new int[]{0, 10}, 2));

        // [1,3,6]
        //			3
        System.out.println(solution.smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int max;
            int min;
            int ans = nums[n - 1] - nums[0];
            // 从左往右枚举，左边的+k 右边-k
            for (int i = 0; i < n - 1; i++) {
                // 当前数字以及左边的都 +k 右边的都 -k
                max = Math.max(nums[i] + k, nums[n - 1] - k);// 最大值要么是当前值+k 要某是最大值 -k
                min = Math.min(nums[0] + k, nums[i + 1] - k);
                ans = Math.min(ans, max - min);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}