

//给你一个整数数组 nums 和整数 k ，返回最大和 sum ，满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < 
//k 。如果没有满足此等式的 i,j 存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [34,23,1,24,75,33,54,8], k = 60
//输出：58
//解释：
//34 和 24 相加得到 58，58 小于 60，满足题意。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,20,30], k = 15
//输出：-1
//解释：
//我们无法找到和小于 15 的两个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 1 <= k <= 2000 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 65 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1099.小于 K 的两数之和.two-sum-less-than-k
 *
 * @author db117
 * @since 2022-05-18 15:23:08
 **/

public class Solution_1099 {
    public static void main(String[] args) {
        Solution solution = new Solution_1099().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            int max = -1;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= k) {
                    break;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    if (sum >= k) {
                        break;
                    }
                    max = Math.max(max, sum);
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}