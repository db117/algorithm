

//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 559 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 673.最长递增子序列的个数.number-of-longest-increasing-subsequence
 *
 * @author db117
 * @since 2022-03-02 18:20:44
 **/

public class Solution_673 {
    public static void main(String[] args) {
        Solution solution = new Solution_673().new Solution();

        System.out.println(solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(solution.findNumberOfLIS(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            // 以当前位置为结尾的最长递增序列长度数量
            int[] count = new int[nums.length];
            Arrays.fill(count, 1);

            int ans = 0;
            int maxLen = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        int n = dp[j] + 1;
                        if (dp[i] < n) {
                            // 数量直接等于 j 位置的数量
                            dp[i] = n;
                            count[i] = count[j];
                        } else if (dp[i] == n) {
                            // 有其他可能直接就加上 j 位置的数量
                            count[i] += count[j];
                        }
                    }
                }
                maxLen = Math.max(dp[i], maxLen);
            }

            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == maxLen) {
                    ans += count[i];
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}