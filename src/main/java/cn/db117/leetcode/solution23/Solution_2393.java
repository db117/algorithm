

//给定一个由 正整数 组成的数组 nums 。 
//
// 返回 严格递增 顺序的 nums 子数组 的数目。 
//
// 子数组 是数组的一部分，且是 连续 的。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,4,4,6]
//输出: 10
//解释: 严格递增的子数组如下:
//- 长度为 1 的子数组: [1], [3], [5], [4], [4], [6]。
//- 长度为 2 的子数组: [1,3], [3,5], [4,6]。
//- 长度为 3 的子数组: [1,3,5]。
//子数组的总数是 6 + 3 + 1 = 10。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,5]
//输出: 15
//解释: 每个子数组都严格递增。我们可以取 15 个子数组。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 数学 动态规划 👍 3 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2393.严格递增的子数组个数.count-strictly-increasing-subarrays
 *
 * @author db117
 * @since 2023-02-28 13:50:02
 **/

public class Solution_2393 {
    public static void main(String[] args) {
        Solution solution = new Solution_2393().new Solution();
        System.out.println(solution.countSubarrays(new int[]{1, 3, 5, 4, 4, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums) {
            long ans = 0;
            int n = nums.length;
            int left = 0, right = 0;
            while (left < n) {
                right = left + 1;
                while (right < n && nums[right] > nums[right - 1]) {
                    right++;
                }
                // 连续严格递增长度
                ans += helper(right - left);
                left = right;

            }
            return ans;
        }

        private long helper(int n) {
            // n 加到 0  [n,n-1,n-2,...1,0]
            return (long) n * (n + 1) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}