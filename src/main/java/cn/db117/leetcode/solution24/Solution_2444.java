

//给你一个整数数组 nums 和两个整数 minK 以及 maxK 。 
//
// nums 的定界子数组是满足下述条件的一个子数组： 
//
// 
// 子数组中的 最小值 等于 minK 。 
// 子数组中的 最大值 等于 maxK 。 
// 
//
// 返回定界子数组的数目。 
//
// 子数组是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,5,2,7,5], minK = 1, maxK = 5
//输出：2
//解释：定界子数组是 [1,3,5] 和 [1,3,5,2] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1], minK = 1, maxK = 1
//输出：10
//解释：nums 的每个子数组都是一个定界子数组。共有 10 个子数组。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i], minK, maxK <= 10⁶ 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 👍 45 👎 0


package cn.db117.leetcode.solution24;

import java.util.TreeSet;

/**
 * 2444.统计定界子数组的数目.count-subarrays-with-fixed-bounds
 *
 * @author db117
 * @since 2022-10-18 16:09:49
 **/

public class Solution_2444 {
    public static void main(String[] args) {
        Solution solution = new Solution_2444().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int minK, maxK;

        public long countSubarrays(int[] nums, int minK, int maxK) {
            if (minK > maxK) {
                return 0;
            }
            this.maxK = maxK;
            this.minK = minK;
            long ans = 0;
            if (minK == maxK) {
                // 找最长相等的数量
                int count = 0;
                for (int num : nums) {
                    if (num == maxK) {
                        count++;
                    } else {
                        ans += helper(count);
                        count = 0;
                    }
                }
                if (count != 0) {
                    ans += helper(count);
                }

                return ans;
            }

            TreeSet<Integer> minSet = new TreeSet<>();
            TreeSet<Integer> maxSet = new TreeSet<>();
            TreeSet<Integer> notSet = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == maxK) {
                    maxSet.add(i);
                } else if (num == minK) {
                    minSet.add(i);
                } else if (num < minK || num > maxK) {
                    notSet.add(i);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (notSet.contains(i)) {
                    continue;
                }
                Integer end = notSet.higher(i);
                if (end == null) {
                    end = nums.length;
                }
                Integer min = minSet.ceiling(i);
                Integer max = maxSet.ceiling(i);
                if (min == null || max == null) {
                    break;
                }
                if (min > end || max > end) {
                    i = end;
                    continue;
                }
                ans += end - Math.max(min, max);
            }

            return ans;
        }

        private long helper(int n) {
            if (n <= 1) {
                return n;
            }
            return n + helper(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}