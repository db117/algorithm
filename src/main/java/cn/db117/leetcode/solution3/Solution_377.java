

//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 968 👎 0


package cn.db117.leetcode.solution3;

import java.util.Arrays;

/**
 * 377.组合总和 Ⅳ.combination-sum-iv
 *
 * @author db117
 * @since 2024-04-22 11:09:35
 **/

public class Solution_377 {
    public static void main(String[] args) {
        Solution solution = new Solution_377().new Solution();
        // nums = [1,2,3], target = 4
        System.out.println(solution.combinationSum4(new int[]{
                1, 2, 3
        }, 4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int[] memo;

        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            this.nums = nums;
            this.memo = new int[target + 1];
            Arrays.fill(memo, -1);


            return dfs(target);
        }

        private int dfs(int target) {
            if (target == 0) {
                return 1;
            }
            if (memo[target] != -1) {
                return memo[target];
            }
            int ans = 0;
            for (int num : nums) {
                if (target >= num) {
                    // 每个数字都可以选择
                    ans += dfs(target - num);
                }
            }
            return memo[target] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}