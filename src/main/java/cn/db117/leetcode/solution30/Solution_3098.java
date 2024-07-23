

//给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。 
//
// 一个 子序列 的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。 
//
// 请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。 
//
// 由于答案可能会很大，将答案对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,4], k = 3 
// 
//
// 输出：4 
//
// 解释： 
//
// nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |
//3 - 4| + |2 - 1| + |3 - 4| = 4 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,2], k = 2 
// 
//
// 输出：0 
//
// 解释： 
//
// nums 中唯一一个长度为 2 的子序列是 [2,2] 。能量和为 |2 - 2| = 0 。 
//
// 示例 3： 
//
// 
// 输入：nums = [4,3,-1], k = 2 
// 
//
// 输出：10 
//
// 解释： 
//
// nums 总共有 3 个长度为 2 的子序列：[4,3] ，[4,-1] 和 [3,-1] 。能量和为 |4 - 3| + |4 - (-1)| + |3
// - (-1)| = 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= n == nums.length <= 50 
// -10⁸ <= nums[i] <= 10⁸ 
// 2 <= k <= n 
// 
//
// Related Topics 数组 动态规划 排序 👍 29 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3098.求出所有子序列的能量和.find-the-sum-of-subsequence-powers
 *
 * @author db117
 * @since 2024-07-23 15:40:37
 **/

public class Solution_3098 {
    public static void main(String[] args) {
        Solution solution = new Solution_3098().new Solution();
        // [1,2,3,4] 3
        System.out.println(solution.sumOfPowers(new int[]{1, 2, 3, 4}, 3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int k;
        Map<String, Long> map = new HashMap<>();
        int mod = 1000000007;

        public int sumOfPowers(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            Arrays.sort(nums);
            long dfs = dfs(-1, 0, k, Integer.MAX_VALUE);
            return (int) (dfs % mod);
        }

        private long dfs(int pre, int cur, int remaining, int min) {
            if (cur + remaining > nums.length) {
                return 0;
            }
            if (remaining == 0) {
                return min;
            }
            String key = pre + ":" + cur + ":" + remaining + ":" + min;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            long ans = 0;

            // 当前数字不选
            ans += dfs(pre, cur + 1, remaining, min);


            // 当前数字选
            if (pre == -1) {
                // 之前没有选过
                ans += dfs(cur, cur + 1, remaining - 1, min);
            } else {
                // 之前选过，比较当前数字和上一个数字差值的最小值
                // 数组已经排序了，直接减就行了
                ans += dfs(cur, cur + 1, remaining - 1, Math.min(min, nums[cur] - nums[pre]));
            }

            ans %= mod;
            map.put(key, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}