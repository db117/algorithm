

//给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨： 
//
// 
// 你挑选 任意 一块披萨。 
// Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。 
// Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。 
// 重复上述过程直到没有披萨剩下。 
// 
//
// 每一块披萨的大小按顺时针方向由循环数组 slices 表示。 
//
// 请你返回你可以获得的披萨大小总和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：slices = [1,2,3,4,5,6]
//输出：10
//解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小
//为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
// 
//
// 示例 2： 
//
// 
//
// 输入：slices = [8,9,8,6,1,1]
//输出：16
//解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
// 
//
// 示例 3： 
//
// 输入：slices = [4,1,2,5,8,3,1,9,7]
//输出：21
// 
//
// 示例 4： 
//
// 输入：slices = [3,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slices.length <= 500 
// slices.length % 3 == 0 
// 1 <= slices[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 堆（优先队列） 👍 95 👎 0


package cn.db117.leetcode.solution13;

/**
 * 1388.3n 块披萨.pizza-with-3n-slices
 *
 * @author db117
 * @since 2022-03-11 17:09:13
 **/

public class Solution_1388 {
    public static void main(String[] args) {
        Solution solution = new Solution_1388().new Solution();
        System.out.println(solution.maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(solution.maxSizeSlices(new int[]{8, 9, 8, 6, 1, 1}));
        System.out.println(solution.maxSizeSlices(new int[]{4, 1, 2, 5, 8, 3, 1, 9, 7}));
        System.out.println(solution.maxSizeSlices(new int[]{3, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSizeSlices(int[] slices) {
            // 跟打家劫舍 2 类似,去掉头尾 走一遍就行
            int[] arr1 = new int[slices.length - 1];
            int[] arr2 = new int[slices.length - 1];
            System.arraycopy(slices, 0, arr1, 0, slices.length - 1);
            System.arraycopy(slices, 1, arr2, 0, slices.length - 1);

            return Math.max(helper(arr1), helper(arr2));
        }

        private int helper(int[] slices) {
            // 选择次数
            int choose = (slices.length + 1) / 3;
            // i 位置选择 j 个数量的和
            int[][] dp = new int[slices.length + 1][choose + 1];
            for (int i = 1; i <= slices.length; i++) {
                for (int j = 1; j <= choose; j++) {
                    if (i - 2 >= 0) {
                        // 当前位置不选,则当前位置和为 dp[i - 1][j]
                        // 当前位置选,则当前位置和为 i-2 处的最大值 + 当前位置披萨大小  dp[i - 2][j - 1] + slices[i - 1]
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], slices[i - 1]);
                    }
                }
            }
            return dp[slices.length][choose];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}