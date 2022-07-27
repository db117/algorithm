


//给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺
//序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/ 
//
// Related Topics 数组 二分查找 👍 26 👎 0


package cn.db117.leetcode.office;

import java.util.Arrays;

/**
 * 剑指 Offer II 068.查找插入位置.N6YdxV
 *
 * @author db117
 * @since 2022-07-27 14:57:24
 **/

public class Offer_II068 {
    public static void main(String[] args) {
        Solution solution = new Offer_II068().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            // 标准二分
            int bs = Arrays.binarySearch(nums, target);
            if (bs >= 0) {
                return bs;
            }
            // 最大最小
            if (nums[nums.length - 1] < target) {
                return nums.length;
            }
            if (nums[0] > target) {
                return 0;
            }

            // 找小于等于目标值位置
            return bsLeft(nums, target) + 1;
        }

        public int bsLeft(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // 中位数选右边
                int mid = (left + right + 1) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}