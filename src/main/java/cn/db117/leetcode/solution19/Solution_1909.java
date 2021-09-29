

//给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组
//本身已经是严格递增的，请你也返回 true 。 
//
// 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。 
//
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,10,5,7]
//输出：true
//解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
//[1,2,5,7] 是严格递增的，所以返回 true 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,2]
//输出：false
//解释：
//[3,1,2] 是删除下标 0 处元素后得到的结果。
//[2,1,2] 是删除下标 1 处元素后得到的结果。
//[2,3,2] 是删除下标 2 处元素后得到的结果。
//[2,3,1] 是删除下标 3 处元素后得到的结果。
//没有任何结果数组是严格递增的，所以返回 false 。 
//
// 示例 3： 
//
// 输入：nums = [1,1,1]
//输出：false
//解释：删除任意元素后的结果都是 [1,1] 。
//[1,1] 不是严格递增的，所以返回 false 。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3]
//输出：true
//解释：[1,2,3] 已经是严格递增的，所以返回 true 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 数组 👍 18 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1909.删除一个元素使数组严格递增.remove-one-element-to-make-the-array-strictly-increasing
 *
 * @author db117
 * @since 2021-09-29 18:14:04
 **/

public class Solution_1909 {
    public static void main(String[] args) {
        Solution solution = new Solution_1909().new Solution();
        System.out.println(solution.canBeIncreasing(new int[]{
                2, 3, 1, 2
        }));
        System.out.println(solution.canBeIncreasing(new int[]{
                1, 2, 3, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            // 双指针
            int left = 0, right = nums.length - 1;
            while (left < right && nums[left] < nums[left + 1]) {
                left++;
            }
            while (right > left && nums[right - 1] < nums[right]) {
                right--;
            }
            if (left == right) {
                // 本身有序
                return true;
            }
            // 被删除的数字在首位的情况
            if (left == nums.length - 2 || right == 1) {
                return true;
            }
            // 两个数字需要相邻
            if (left + 1 != right) {
                return false;
            }
            // 删除一个数字可以严格递增
            if (right < nums.length - 1 && nums[left] < nums[right + 1]) {
                return true;
            }
            if (left > 0 && nums[left - 1] < nums[right]) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}