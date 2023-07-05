

//给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第
// i 个类型。 
//
// 在一步操作中，你可以用成本 x 执行下述行为： 
//
// 
// 同时修改所有巧克力的类型，将巧克力的类型 iᵗʰ 修改为类型 ((i + 1) mod n)ᵗʰ。 
// 
//
// 假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [20,1,15], x = 5
//输出：13
//解释：最开始，巧克力的类型分别是 [0,1,2] 。我们可以用成本 1 购买第 1 个类型的巧克力。
//接着，我们用成本 5 执行一次操作，巧克力的类型变更为 [1,2,0] 。我们可以用成本 1 购买第 2 个类型的巧克力。
//然后，我们用成本 5 执行一次操作，巧克力的类型变更为 [2,0,1] 。我们可以用成本 1 购买第 0 个类型的巧克力。
//因此，收集所有类型的巧克力需要的总成本是 (1 + 5 + 1 + 5 + 1) = 13 。可以证明这是一种最优方案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], x = 4
//输出：6
//解释：我们将会按最初的成本收集全部三个类型的巧克力，而不需执行任何操作。因此，收集所有类型的巧克力需要的总成本是 1 + 2 + 3 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 1 <= x <= 10⁹ 
// 
//
// Related Topics 数组 枚举 👍 16 👎 0


package cn.db117.leetcode.solution27;

import java.util.Arrays;

/**
 * 2735.收集巧克力.collecting-chocolates
 *
 * @author db117
 * @since 2023-07-05 16:43:26
 **/

public class Solution_2735 {
    public static void main(String[] args) {
        Solution solution = new Solution_2735().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long[] cache;
        int[] nums;
        int x;

        public long minCost(int[] nums, int x) {
            long ans = 0;
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            cache = new long[n];
            Arrays.fill(cache, -1);
            this.nums = nums;
            this.x = x;

            // 二分查找最小值（最小值可能再中间）
            int left = 0, right = n - 1;
            if (helper(left) < helper(left + 1)) {
                return helper(left);
            }
            if (helper(right) < helper(right - 1)) {
                return helper(right);
            }


            while (left < right) {
                int mid = (left + right) / 2;
                // 最小值在mid的右侧

                if (mid > 0 && helper(mid) <= helper(mid - 1)) {
                    left = mid;
                }
                if (mid < n && helper(mid) <= helper(mid + 1)) {
                    right = mid;
                }


                if (left == right) {
                    return helper(left);
                }
            }


            return helper(left);
        }

        // 移动多少次的总成本
        private long helper(int move) {
            if (cache[move] != -1) {
                return cache[move];
            }
            int n = nums.length;
            long curAns = (long) move * x;
            for (int i = 0; i < n; i++) {
                int min = nums[i];
                for (int j = 1; j <= move; j++) {
                    int next = (i + j) % n;
                    min = Math.min(min, nums[next]);
                }
                curAns += min;

            }
            return cache[move] = curAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}