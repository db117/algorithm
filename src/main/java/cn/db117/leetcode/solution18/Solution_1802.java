//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 109 
// 0 <= index < n 
// 
// Related Topics 贪心 二分查找 
// 👍 28 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1802.有界数组中指定下标处的最大值.maximum-value-at-a-given-index-in-a-bounded-array
 *
 * @author db117
 * @since 2021-07-23 17:13:37
 **/

public class Solution_1802 {
    public static void main(String[] args) {
        Solution solution = new Solution_1802().new Solution();
        System.out.println(solution.maxValue(4, 2, 6));
        System.out.println(solution.maxValue(6, 1, 10));
        System.out.println(solution.maxValue(4, 0, 4));// 1
        System.out.println(solution.maxValue(685453290, 293811406, 689728311));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1, right = maxSum;
            while (left < right) {
                // 保留左边界，选择右边界
                int mid = left + (right - left + 1) / 2;

                if (check(n, index, maxSum, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        // m 能否放在 index 处
        public boolean check(int n, int index, int maxSum, int m) {
            long sum = 0;
            // 左边和
            if (m >= index + 1) {
                // 从 m-index 加到 m
                sum += sum(m, m - index);
            } else {
                // 从 1 加到 m，加上剩下的 1
                sum += sum(m, 1);
                sum += index + 1 - m;
            }

            // 右边和
            if (m >= n - index) {
                // 从 m-index+1 加到 m
                sum += sum(m, m - (n - index) + 1);
            } else {
                // 从 1 加到 m，加上剩下的 1
                sum += sum(m, 1);
                sum += n - index - m;
            }
            sum -= m;

            return sum <= maxSum;
        }


        // 从 min 累加到 max
        private long sum(long max, long min) {
            long count = max - min + 1;
            long ans = (min + max) * (count / 2);

            if ((count & 1) == 1) {
                ans += (min + max) / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}