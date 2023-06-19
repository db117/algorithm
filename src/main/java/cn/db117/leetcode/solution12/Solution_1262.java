

//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 253 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;

/**
 * 1262.可被三整除的最大和.greatest-sum-divisible-by-three
 *
 * @author db117
 * @since 2023-06-19 11:28:34
 **/

public class Solution_1262 {
    public static void main(String[] args) {
        Solution solution = new Solution_1262().new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{
                1, 2, 3, 4, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int[][] memo;

        public int maxSumDivThree(int[] nums) {
            this.nums = nums;
            memo = new int[nums.length][3];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            return dfs(nums.length - 1, 0);
        }

        private int dfs(int i, int m) {
            if (i < 0) {
                return m == 0 ? 0 : Integer.MIN_VALUE;
            }
            if (memo[i][m] != -1) {
                return memo[i][m];
            }
            // 选择当前
            int cur = nums[i];
            int nextMod = (m - (cur % 3) + 3) % 3;// 下一个余数

            // 不选择当前

            return memo[i][m] = Math.max(cur + dfs(i - 1, nextMod), dfs(i - 1, m));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}