

//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
//
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 数学 动态规划 排序 👍 627 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368.最大整除子集.largest-divisible-subset
 *
 * @author db117
 * @since 2025-04-09 19:18:46
 **/

public class Solution_368 {
    public static void main(String[] args) {
        Solution solution = new Solution_368().new Solution();
        // [1,2,4,8]
//        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        // [3,4,16,8]
        System.out.println(solution.largestDivisibleSubset(new int[]{3, 4, 16, 8}));



    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int[] from;// 记录最优的前驱节点
        int[] memo;

        public List<Integer> largestDivisibleSubset(int[] nums) {
            this.nums = nums;
            this.from = new int[nums.length];
            this.memo = new int[nums.length];
            int n = nums.length;
            Arrays.sort(nums);
            Arrays.fill(from, -1);

            int maxF = -1;// 最长路径长度
            int maxIndex = -1;// 最长路径的起始位置
            for (int i = 0; i < n; i++) {
                int dfs = dfs(i);
                if (dfs > maxF) {
                    maxIndex = i;
                    maxF = dfs;
                }
            }

            // 找最长的路径
            List<Integer> ans = new ArrayList<>();
            for (int i = maxIndex; i >= 0; i = from[i]) {
                ans.add(nums[i]);
            }
            return ans;
        }

        int dfs(int i) {
            if (memo[i] != 0) {
                return memo[i];
            }
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] != 0) {
                    continue;
                }
                int cur = dfs(j);
                if (cur > max) {
                    // 更新最大值
                    max = cur;
                    from[i] = j;// 记录最优前驱节点
                }
            }

            return memo[i] = max + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}