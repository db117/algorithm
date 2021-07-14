// 给你一个整数数组 arr 和一个整数值 target 。
//
// 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。 
//
// 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,2,4,3], target = 3
//输出：2
//解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,3,4,7], target = 7
//输出：2
//解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
// 
//
// 示例 3： 
//
// 输入：arr = [4,3,2,6,2,3,4], target = 6
//输出：-1
//解释：我们只有一个和为 6 的子数组。
// 
//
// 示例 4： 
//
// 输入：arr = [5,5,4,4,5], target = 3
//输出：-1
//解释：我们无法找到和为 3 的子数组。
// 
//
// 示例 5： 
//
// 输入：arr = [3,1,1,1,5,1,2,1], target = 3
//输出：3
//解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 1000 
// 1 <= target <= 10^8 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 滑动窗口 
// 👍 72 👎 0


package cn.db117.leetcode.solution14;

import java.util.Map;
import java.util.TreeMap;

/**
 * 1477.找两个和为目标值且不重叠的子数组.find-two-non-overlapping-sub-arrays-each-with-target-sum
 *
 * @author db117
 * @since 2021-07-14 17:49:11
 **/

public class Solution_1477 {
    public static void main(String[] args) {
        Solution solution = new Solution_1477().new Solution();

        System.out.println(solution.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
        System.out.println(solution.minSumOfLengths(new int[]{7, 3, 4, 7}, 7));
        System.out.println(solution.minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6));
        System.out.println(solution.minSumOfLengths(new int[]{5, 5, 4, 4, 5}, 3));
        System.out.println(solution.minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3));
        System.out.println(solution.minSumOfLengths(new int[]{1, 1, 1, 2, 2, 2, 4, 4}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            // 滑动窗口，记录当前位置开始的和为 target 数组的长度
            int[] lens = new int[arr.length];

            int right = 0, sum = 0;
            for (int left = 0; left < arr.length; left++) {
                while (right < arr.length && sum + arr[right] <= target) {
                    sum += arr[right];
                    right++;
                }
                if (sum == target) {
                    lens[left] = right - left;
                } else {
                    lens[left] = -1;
                }
                sum -= arr[left];
            }

            // 更新所有位置的长度为当前位置右边最小的长度
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int rightMin = Integer.MAX_VALUE;
            for (int i = lens.length - 1; i >= 0; i--) {
                if (lens[i] == -1) {
                    continue;
                }
                map.put(i, rightMin = Math.min(rightMin, lens[i]));
            }


            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < lens.length; i++) {
                if (lens[i] == -1) {
                    continue;
                }
                // 找下一个数组
                Map.Entry<Integer, Integer> next = map.ceilingEntry(i + lens[i]);
                if (next == null) {
                    continue;
                }

                ans = Math.min(ans, lens[i] + next.getValue());
            }

            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}