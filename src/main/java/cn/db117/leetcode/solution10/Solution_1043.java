

//给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。 
//
// 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,15,7,9,2,5,10], k = 3
//输出：84
//解释：数组变为 [15,15,15,9,10,10,10] 
//
// 示例 2： 
//
// 
//输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//输出：83
// 
//
// 示例 3： 
//
// 
//输入：arr = [1], k = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10⁹ 
// 1 <= k <= arr.length 
// 
//
// Related Topics 数组 动态规划 👍 211 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1043.分隔数组以得到最大和.partition-array-for-maximum-sum
 *
 * @author db117
 * @since 2023-04-19 13:40:57
 **/

public class Solution_1043 {
    public static void main(String[] args) {
        Solution solution = new Solution_1043().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr;
        int k;
        int[] memo;

        public int maxSumAfterPartitioning(int[] arr, int k) {
            this.arr = arr;
            this.k = k;
            memo = new int[arr.length];
            Arrays.fill(memo, -1);
            // 前面数组能凑的最大值
            return dfs(arr.length - 1);
        }

        private int dfs(int end) {
            if (end < 0) {
                return 0;
            }
            if (memo[end] != -1) {
                return memo[end];
            }

            int ans = 0, mx = -1;
            for (int i = end; i >= 0 && end - i + 1 <= k; i--) {
                // 当前区间数组的最大值
                mx = Math.max(mx, arr[i]);
                // 当前区间的数量 * 当前区间的最大值  + 前面的最大值
                ans = Math.max(ans, (end - i + 1) * mx + dfs(i - 1));
            }

            memo[end] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}