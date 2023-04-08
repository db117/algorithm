

//现有一个按 升序 排列的整数数组 nums ，其中每个数字都 互不相同 。 
//
// 给你一个整数 k ，请你找出并返回从数组最左边开始的第 k 个缺失数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,7,9,10], k = 1
//输出：5
//解释：第一个缺失数字为 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,7,9,10], k = 3
//输出：8
//解释：缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,4], k = 3
//输出：6
//解释：缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 1 <= nums[i] <= 10⁷ 
// nums 按 升序 排列，其中所有元素 互不相同 。 
// 1 <= k <= 10⁸ 
// 
//
// 
//
// 进阶：你可以设计一个对数时间复杂度（即，O(log(n))）的解决方案吗？ 
//
// Related Topics 数组 二分查找 👍 130 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1060.有序数组中的缺失元素.missing-element-in-sorted-array
 *
 * @author db117
 * @since 2023-04-06 14:05:19
 **/

public class Solution_1060 {
    public static void main(String[] args) {
        Solution solution = new Solution_1060().new Solution();
        System.out.println(solution.missingElement(new int[]{4, 7, 9, 10}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            this.nums = nums;
            // 前面空的数字 = nums[i] - nums[0] - i
            // 二分查找 前面空的数字 小于 k 的最大值(也可以找等于的最小值 - 1，需要特判目标值不在数组区间内的情况)
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                int cur = helper(mid);
                if (cur >= k) {
                    right = mid - 1;
                } else {
                    left = mid;// 可能是答案，不能移动
                }
            }
            return nums[left] + k - helper(left);
        }

        private int helper(int i) {
            return nums[i] - nums[0] - i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}