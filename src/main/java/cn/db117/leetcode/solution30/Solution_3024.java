

//给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。 
//
// 
// 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。 
// 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。 
// 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。 
// 
//
// 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,3,3]
//输出："equilateral"
//解释：由于三条边长度相等，所以可以构成一个等边三角形，返回 "equilateral" 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,5]
//输出："scalene"
//解释：
//nums[0] + nums[1] = 3 + 4 = 7 ，大于 nums[2] = 5 。
//nums[0] + nums[2] = 3 + 5 = 8 ，大于 nums[1] = 4 。
//nums[1] + nums[2] = 4 + 5 = 9 ，大于 nums[0] = 3 。
//由于任意两边之和都大于第三边，所以可以构成一个三角形，因为三条边的长度互不相等，所以返回 "scalene"。
// 
//
// 提示： 
//
// 
// nums.length == 3 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 数学 排序 👍 2 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;

/**
 * 3024.三角形类型.type-of-triangle
 *
 * @author db117
 * @since 2024-04-18 11:13:15
 **/

public class Solution_3024 {
    public static void main(String[] args) {
        Solution solution = new Solution_3024().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String triangleType(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] + nums[1] <= nums[2]) {
                return "none";
            }
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }
            if (nums[0] == nums[1] || nums[1] == nums[2]) {
                return "isosceles";
            }
            // 三边都不相等
            return "scalene";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}