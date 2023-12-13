

//给你一个整数数组 nums 和一个 正整数 k 。 
//
// 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。 
//
// 子数组是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,3], k = 2
//输出：6
//解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 
//。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,2,1], k = 3
//输出：0
//解释：没有子数组包含元素 4 至少 3 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 数组 滑动窗口 👍 12 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2962.统计最大元素出现至少 K 次的子数组.count-subarrays-where-max-element-appears-at-least-k-times
 *
 * @author db117
 * @since 2023-12-13 11:11:03
 **/

public class Solution_2962 {
    public static void main(String[] args) {
        Solution solution = new Solution_2962().new Solution();
        // [1,3,2,3,3]
        //			2
        System.out.println(solution.countSubarrays(new int[]{
                1, 3, 2, 3, 3
        }, 2));
        //[61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82]
        //			2
        System.out.println(solution.countSubarrays(new int[]{
                61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82
        }, 2));

        // [28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49]
        //			1
        // 187
        System.out.println(solution.countSubarrays(new int[]{
                28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49
        }, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            int n = nums.length;
            int max = -1;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            long ans = 0;
            // 滑动窗口
            int left = 0;
            int count = 0;
            for (int num : nums) {
                if (max == num) {
                    count++;
                }
                while (count >= k) {
                    if (max == nums[left++]) {
                        count--;
                    }
                }

                // 第一次 达到窗口大小的时候, left 一直都是 0
                ans += left;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}