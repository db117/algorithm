

//给你一个数组 nums ，它是 [0, 1, 2, ..., n - 1] 的一个排列 。对于任意一个 [0, 1, 2, ..., n - 1] 的排列 
//perm ，其 分数 定义为： 
//
// score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |
//perm[n - 1] - nums[perm[0]]| 
//
// 返回具有 最低 分数的排列 perm 。如果存在多个满足题意且分数相等的排列，则返回其中字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,0,2] 
// 
//
// 输出：[0,1,2] 
//
// 解释： 
//
// 
//
// 字典序最小且分数最低的排列是 [0,1,2]。这个排列的分数是 |0 - 0| + |1 - 2| + |2 - 1| = 2 。 
//
// 示例 2： 
//
// 
// 输入：nums = [0,2,1] 
// 
//
// 输出：[0,2,1] 
//
// 解释： 
//
// 
//
// 字典序最小且分数最低的排列是 [0,2,1]。这个排列的分数是 |0 - 1| + |2 - 2| + |1 - 0| = 2 。 
//
// 
//
// 提示： 
//
// 
// 2 <= n == nums.length <= 14 
// nums 是 [0, 1, 2, ..., n - 1] 的一个排列。 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 11 👎 0


package cn.db117.leetcode.solution31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3149.找出分数最低的排列.find-the-minimum-cost-array-permutation
 *
 * @author db117
 * @since 2024-05-17 10:36:33
 **/

public class Solution_3149 {
    public static void main(String[] args) {
        Solution solution = new Solution_3149().new Solution();
        // [1,0,2]
        System.out.println(Arrays.toString(solution.findPermutation(new int[]{
                1, 0, 2
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        int[] nums;


        public int[] findPermutation(int[] nums) {
            // perm 数组可以循环移动，所以第一个数字只能是 0
            int n = nums.length;
            this.nums = nums;
            memo = new int[1 << n][n];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            List<Integer> ans = new ArrayList<>(n);

            // 跑的时候记录路径
            dfs_ans(1, 0, ans);

            return ans
                    .stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        /**
         * @param flag 已经选择的数字
         * @param i    上一个数字
         */
        private int dfs(int flag, int i) {
            if (flag == (1 << nums.length) - 1) {
                // 最后一个数字了
                return Math.abs(i - nums[0]);
            }
            if (memo[flag][i] != -1) {
                return memo[flag][i];
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j < nums.length; j++) {
                if ((flag & (1 << j)) == 0) {
                    // 还没选择
                    ans = Math.min(ans, Math.abs(i - nums[j]) + dfs(flag | (1 << j), j));
                }
            }

            return memo[flag][i] = ans;
        }

        private void dfs_ans(int flag, int i, List<Integer> ans) {
            ans.add(i);
            if (flag == (1 << nums.length) - 1) {
                // 最后一个数字了
                return;
            }

            // 最短路径
            int target = dfs(flag, i);

            for (int j = 1; j < nums.length; j++) {
                if ((flag & (1 << j)) == 0) {
                    // 这个路径的值
                    int cur = Math.abs(i - nums[j]) + dfs(flag | (1 << j), j);
                    if (cur == target) {
                        // 说明在最小分数的情况下走的是这个分支
                        dfs_ans(flag | (1 << j), j, ans);
                        return;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}