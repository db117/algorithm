

//给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。 
//
// 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ： 
//
// 
// 0 <= i < j < n，且 
// lower <= nums[i] + nums[j] <= upper 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6
//输出：6
//解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,7,9,2,5], lower = 11, upper = 11
//输出：1
//解释：只有单个公平数对：(2,3) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums.length == n 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= lower <= upper <= 10⁹ 
// 
//
// 👍 16 👎 0


package cn.db117.leetcode.solution25;

import java.util.Arrays;

/**
 * 2563.统计公平数对的数目.count-the-number-of-fair-pairs
 *
 * @author db117
 * @since 2023-02-13 11:27:24
 **/

public class Solution_2563 {
    public static void main(String[] args) {
        Solution solution = new Solution_2563().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            long ans = 0;
            // 求的是数对,可以直接排序
            Arrays.sort(nums);

            for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
                int num = nums[i];

                // 找数对区间
                int l = bsGreaterEqualMin(nums, lower - num, i + 1);
                int r = bsLessEqualMax(nums, upper - num, i + 1);
                if (l >= i && r > i) {
                    ans += r - l + 1;
                }
            }
            return ans;
        }


        /**
         * 大于等于目标值的最小位置
         */
        public int bsGreaterEqualMin(int[] nums, int target, int left) {
            int right = nums.length - 1;
            while (left < right) {
                // 左边中位数
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    // 移动左边界
                    // 上面选择左边中位数,所有加一
                    left = mid + 1;
                } else {
                    // 大于等于则保持右边界
                    // 等于则继续往左边查找
                    right = mid;
                }
            }

            // 需要判断是否找到
            return nums[right] >= target ? right : -1;
        }

        /**
         * 小于等于目标值的最大值
         */
        public int bsLessEqualMax(int[] nums, int target, int left) {
            int right = nums.length - 1;
            while (left < right) {
                // 选右边中位数
                int mid = left + ((right - left + 1) >> 1);
                if (nums[mid] <= target) {
                    // 小于移动左边界
                    // 上面选择的是右边中位数,所以这里不加一
                    // 等于则继续往右边寻找
                    left = mid;
                } else {
                    // 移动右边界
                    right = mid - 1;
                }
            }

            // 需要判断是否找到
            return nums[right] <= target ? right : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}