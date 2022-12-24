

//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。 
//
// 在第 i 次操作时（操作编号从 1 开始），你需要： 
//
// 
// 选择两个元素 x 和 y 。 
// 获得分数 i * gcd(x, y) 。 
// 将 x 和 y 从 nums 中删除。 
// 
//
// 请你返回 n 次操作后你能获得的分数和最大为多少。 
//
// 函数 gcd(x, y) 是 x 和 y 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2]
//输出：1
//解释：最优操作是：
//(1 * gcd(1, 2)) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [3,4,6,8]
//输出：11
//解释：最优操作是：
//(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,6]
//输出：14
//解释：最优操作是：
//(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 7 
// nums.length == 2 * n 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 回溯 状态压缩 数论 👍 54 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1799.N 次操作后的最大分数和.maximize-score-after-n-operations
 *
 * @author db117
 * @since 2022-12-22 10:21:27
 **/

public class Solution_1799 {
    public static void main(String[] args) {
        Solution solution = new Solution_1799().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] nums) {
            int len = nums.length;
            // 预处理最大公约数
            int[][] gcd = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    gcd[i][j] = gcd(nums[i], nums[j]);
                }
            }
            // 状态压缩, 1 标识删除掉了
            int[] f = new int[1 << len];
            for (int k = 3; k < f.length; k++) {
                int bitCount = Integer.bitCount(k);
                if ((bitCount & 1) == 1) {
                    // 必须成对删除
                    continue;
                }
                for (int i = 0; i <= len; i++) {
                    if ((k & (1 << i)) == 0) {
                        continue;
                    }
                    for (int j = i + 1; j <= len; j++) {
                        if ((k & (1 << j)) == 0) {
                            continue;
                        }
                        // 前面肯定算过
                        int preScore = f[k ^ (1 << i) ^ (1 << j)];
                        // 当前分数
                        int curScore = bitCount / 2 * gcd[i][j];
                        f[k] = Math.max(f[k], preScore + curScore);
                    }
                }
            }
            return f[f.length - 1];
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}