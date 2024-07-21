

//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1385 👎 0


package cn.db117.leetcode.solution3;

import java.util.Arrays;

/**
 * 312.戳气球.burst-balloons
 *
 * @author db117
 * @since 2024-06-11 10:47:17
 **/

public class Solution_312 {
    public static void main(String[] args) {
        Solution solution = new Solution_312().new Solution();
        // [3,1,5,8]
        System.out.println(solution.maxCoins(new int[]{
                3, 1, 5, 8
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        int[] arr;

        public int maxCoins(int[] nums) {
            int n = nums.length;
            // 弄一个新的数组，把头尾加上1
            arr = new int[n + 2];
            arr[0] = arr[n + 1] = 1;
            System.arraycopy(nums, 0, arr, 1, n);
            memo = new int[n + 2][n + 2];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            // 反着来，往中间一个个添加气球，那么只需要考虑左右两边的气球
            return dfs(0, n + 1);
        }

        private int dfs(int left, int right) {
            if (left + 1 >= right) {
                return 0;
            }

            if (memo[left][right] != -1) {
                return memo[left][right];
            }

            for (int i = left + 1; i < right; i++) {
                // 当前添加的气球，乘以左右两边的气球
                int sum = arr[left] * arr[i] * arr[right];
                // 分成 2 个区间继续添加气球
                sum += dfs(left, i) + dfs(i, right);
                memo[left][right] = Math.max(memo[left][right], sum);
            }


            return memo[left][right];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}