

//给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot 。请你将 nums 重新排列，使得以下条件均成立： 
//
// 
// 所有小于 pivot 的元素都出现在所有大于 pivot 的元素 之前 。 
// 所有等于 pivot 的元素都出现在小于和大于 pivot 的元素 中间 。 
// 小于 pivot 的元素之间和大于 pivot 的元素之间的 相对顺序 不发生改变。
// 
// 更正式的，考虑每一对 pi，pj ，pi 是初始时位置 i 元素的新位置，pj 是初始时位置 j 元素的新位置。对于小于 pivot 的元素，如果 i <
// j 且 nums[i] < pivot 和 nums[j] < pivot 都成立，那么 pi < pj 也成立。类似的，对于大于 pivot 的元素，如果 
//i < j 且 nums[i] > pivot 和 nums[j] > pivot 都成立，那么 pi < pj 。 
// 
// 
// 
//
// 请你返回重新排列 nums 数组后的结果数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [9,12,5,10,14,3,10], pivot = 10
//输出：[9,5,3,10,10,12,14]
//解释：
//元素 9 ，5 和 3 小于 pivot ，所以它们在数组的最左边。
//元素 12 和 14 大于 pivot ，所以它们在数组的最右边。
//小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [9, 5, 3] 和 [12, 14] ，它们在结果数组中的相对顺序需要保留
//。
// 
//
// 示例 2： 
//
// 输入：nums = [-3,4,3,2], pivot = 2
//输出：[-3,2,4,3]
//解释：
//元素 -3 小于 pivot ，所以在数组的最左边。
//元素 4 和 3 大于 pivot ，所以它们在数组的最右边。
//小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [-3] 和 [4, 3] ，它们在结果数组中的相对顺序需要保留。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁶ <= nums[i] <= 10⁶ 
// pivot 等于 nums 中的一个元素。 
// 
// Related Topics 数组 双指针 模拟 👍 9 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;

/**
 * 2161.根据给定数字划分数组.partition-array-according-to-given-pivot
 *
 * @author db117
 * @since 2022-02-23 15:30:32
 **/

public class Solution_2161 {
    public static void main(String[] args) {
        Solution solution = new Solution_2161().new Solution();
        System.out.println(Arrays.toString(solution.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(Arrays.toString(solution.pivotArray(new int[]{-3, 4, 3, 2}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            int[] ans = new int[nums.length];
            int left = 0, right = nums.length - 1;
            // 从左往右 找小于的
            for (int num : nums) {
                if (num < pivot) {
                    ans[left++] = num;
                }
            }
            // 从右往左找大于的
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > pivot) {
                    ans[right--] = nums[i];
                }
            }
            // 补齐剩下等于的
            for (int i = left; i <= right; i++) {
                ans[i] = pivot;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}