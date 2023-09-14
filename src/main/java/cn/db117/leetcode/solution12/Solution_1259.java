

//偶数 个人站成一个圆，总人数为 num_people 。每个人与除自己外的一个人握手，所以总共会有 num_people / 2 次握手。 
//
// 将握手的人之间连线，请你返回连线不会相交的握手方案数。 
//
// 由于结果可能会很大，请你返回答案 模 10^9+7 后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：num_people = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：num_people = 4
//输出：2
//解释：总共有两种方案，第一种方案是 [(1,2),(3,4)] ，第二种方案是 [(2,3),(4,1)] 。
// 
//
// 示例 3： 
//
// 
//
// 输入：num_people = 6
//输出：5
// 
//
// 示例 4： 
//
// 输入：num_people = 8
//输出：14
// 
//
// 
//
// 提示： 
//
// 
// 2 <= num_people <= 1000 
// num_people % 2 == 0 
// 
//
// Related Topics 数学 动态规划 👍 36 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1259.不相交的握手.handshakes-that-dont-cross
 *
 * @author db117
 * @since 2023-09-14 11:22:43
 **/

public class Solution_1259 {
    public static void main(String[] args) {
        Solution solution = new Solution_1259().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int mod = 1000000007;
        static long[] dp = new long[1001];

        static {
            dp[0] = 1;
            dp[2] = 1;
            for (int i = 4; i <= 1000; i += 2) {
                // 以第一个人为中心，开始握手
                for (int j = 1; j <= i; j += 2) {
                    // 左边有 j-1 个人，右边有 i-1-j 个人
                    dp[i] += dp[j - 1] * dp[i - 1 - j];
                    dp[i] %= mod;
                }
            }
        }

        public int numberOfWays(int numPeople) {
            return (int) dp[numPeople];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}