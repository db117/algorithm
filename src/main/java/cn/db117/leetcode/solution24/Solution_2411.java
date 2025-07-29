

//给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。对于 0 到 n - 1 之间的每一个下标 i ，你需要找出 nums 
//中一个 最小 非空子数组，它的起始位置为 i （包含这个位置），同时有 最大 的 按位或运算值 。 
//
// 
// 换言之，令 Bij 表示子数组 nums[i...j] 的按位或运算的结果，你需要找到一个起始位置为 i 的最小子数组，这个子数组的按位或运算的结果等于 
//max(Bik) ，其中 i <= k <= n - 1 。 
// 
//
// 一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。 
//
// 请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，按位或运算结果最大，且 最短 子数组的长度。 
//
// 子数组 是数组里一段连续非空元素组成的序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,0,2,1,3]
//输出：[3,3,2,2,1]
//解释：
//任何位置开始，最大按位或运算的结果都是 3 。
//- 下标 0 处，能得到结果 3 的最短子数组是 [1,0,2] 。
//- 下标 1 处，能得到结果 3 的最短子数组是 [0,2,1] 。
//- 下标 2 处，能得到结果 3 的最短子数组是 [2,1] 。
//- 下标 3 处，能得到结果 3 的最短子数组是 [1,3] 。
//- 下标 4 处，能得到结果 3 的最短子数组是 [3] 。
//所以我们返回 [3,3,2,2,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2]
//输出：[2,1]
//解释：
//下标 0 处，能得到最大按位或运算值的最短子数组长度为 2 。
//下标 1 处，能得到最大按位或运算值的最短子数组长度为 1 。
//所以我们返回 [2,1] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 位运算 数组 二分查找 滑动窗口 👍 70 👎 0


package cn.db117.leetcode.solution24;

import java.util.TreeSet;

/**
 * 2411.按位或最大的最小子数组长度.smallest-subarrays-with-maximum-bitwise-or
 *
 * @author db117
 * @since 2025-07-29 17:06:32
 **/

public class Solution_2411 {
    public static void main(String[] args) {
        Solution solution = new Solution_2411().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            // 记录每个 bit 的位置
            TreeSet<Integer>[] set = new TreeSet[32];
            for (int i = 0; i < 32; i++) {
                set[i] = new TreeSet<>();
            }
            for (int i = 0; i < nums.length; i++) {
                int num= nums[i];
                for (int j = 0; j < 32; j++) {
                    if ((num & (1 << j) )> 0) {
                        set[j].add(i);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int far = i;
                for (TreeSet<Integer> treeSet : set) {
                    // 找到第一个大于等于当前位置的位置
                    Integer higher = treeSet.ceiling(i);
                    if (higher != null) {
                        far = Math.max(far, higher);
                    }
                }
                ans[i] = far - i + 1;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}