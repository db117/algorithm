

//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。 
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。 
//
// 请你返回 好 子数组的最大可能 分数 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 0 <= k < nums.length 
// 
//
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 116 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1793.好子数组的最大分数.maximum-score-of-a-good-subarray
 *
 * @author db117
 * @since 2024-03-19 16:28:28
 **/

public class Solution_1793 {
    public static void main(String[] args) {
        Solution solution = new Solution_1793().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int min = nums[k], ans = min;
            int left = k, right = k, n = nums.length;
            while (left >= 0 && right < n) {
                // 跳过比当前值大的值
                while (right < n - 1 && nums[right + 1] >= min) {
                    right++;
                }

                while (left > 0 && nums[left - 1] >= min) {
                    left--;
                }

                ans = Math.max(ans, min * (right - left + 1));

                // 跑完了
                if (left == 0 && right == n - 1) {
                    break;
                }

                // 只能往一个方向走
                if (left == 0) {
                    right++;
                    min = nums[right];
                } else if (right == n - 1) {
                    left--;
                    min = nums[left];
                } else {
                    // 那个大走那个
                    if (nums[left - 1] > nums[right + 1]) {
                        left--;
                        min = Math.min(min, nums[left]);
                    } else {
                        right++;
                        min = Math.min(min, nums[right]);
                    }
                }
                ans = Math.max(ans, min * (right - left + 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}