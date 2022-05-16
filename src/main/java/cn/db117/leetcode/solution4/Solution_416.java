

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1271 👎 0


package cn.db117.leetcode.solution4;

/**
 * 416.分割等和子集.partition-equal-subset-sum
 *
 * @author db117
 * @since 2022-04-24 16:57:09
 **/

public class Solution_416 {
    public static void main(String[] args) {
        Solution solution = new Solution_416().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{3, 3, 3, 4, 5}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            if (nums.length < 2) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            //  奇数不可能
            if ((sum & 1) == 1) {
                return false;
            }

            sum /= 2;
            // i 个数字 能不能凑出 j
            boolean[][] dp = new boolean[nums.length][sum + 1];

            // 初始化
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j >= nums[i]) {
                        // i-1 能凑出或者 i-1 个数字能凑出 j - nums[i]
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                    } else {
                        // i-1 能凑出就可以
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[nums.length - 1][sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}