

//给你一个整数数组 nums ，请你返回长度为 3 的 子数组 的数量，满足第一个数和第三个数的和恰好为第二个数的一半。 
//
// 子数组 指的是一个数组中连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,1,4,1] 
// 
//
// 输出：1 
//
// 解释： 
//
// 只有子数组 [1,4,1] 包含 3 个元素且第一个和第三个数字之和是中间数字的一半。number. 
//
// 示例 2： 
//
// 
// 输入：nums = [1,1,1] 
// 
//
// 输出：0 
//
// 解释： 
//
// [1,1,1] 是唯一长度为 3 的子数组，但第一个数和第三个数的和不是第二个数的一半。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 👍 22 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3392.统计符合条件长度为 3 的子数组数目.count-subarrays-of-length-three-with-a-condition
 *
 * @author db117
 * @since 2025-04-27 19:34:43
 **/

public class Solution_3392 {
    public static void main(String[] args) {
        Solution solution = new Solution_3392().new Solution();
        // [1,2,1,4,1]
        System.out.println(solution.countSubarrays(new int[]{1, 2, 1, 4, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubarrays(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                if ((nums[i - 1] + nums[i + 1])*2 == nums[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}