

//在第 1 天，有一个人发现了一个秘密。 
//
// 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在
//发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。 
//
// 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 6, delay = 2, forget = 4
//输出：5
//解释：
//第 1 天：假设第一个人叫 A 。（一个人知道秘密）
//第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
//第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
//第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
//第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
//第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
// 
//
// 示例 2： 
//
// 输入：n = 4, delay = 1, forget = 3
//输出：6
//解释：
//第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
//第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
//第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
//第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 1 <= delay < forget <= n 
// 
// Related Topics 队列 动态规划 模拟 👍 30 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2327.知道秘密的人数.number-of-people-aware-of-a-secret
 *
 * @author db117
 * @since 2022-07-13 18:22:16
 **/

public class Solution_2327 {
    public static void main(String[] args) {
        Solution solution = new Solution_2327().new Solution();
// 289
//7
//23
        System.out.println(solution.peopleAwareOfSecret(289, 7, 23));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 1000000007;

        public int peopleAwareOfSecret(int n, int delay, int forget) {
            // 新添加的人，能分享的人，一共的人
            long[][] dp = new long[n][3];
            long[] one = dp[0];
            // 第一天
            one[0] = 1;
            one[1] = 0;
            one[2] = 1;
            for (int i = 1; i < n; i++) {
                if (i - delay >= 0) {
                    // 现在能分享的人=昨天能分享的人+ delay 天前新添加的人
                    dp[i][1] = dp[i - 1][1] + dp[i - delay][0];
                    if (i - forget >= 0) {
                        // 有人可以遗忘了,就忘掉 forget 天新加入的人
                        dp[i][1] = (dp[i][1] - dp[i - forget][0] + mod) % mod;
                    }
                    // 每个人可以分享一个人
                    dp[i][0] = dp[i][1];
                    // 所有知道秘密的人 = 昨天知道秘密的人 + 今天新增加的人
                    dp[i][2] = dp[i - 1][2] + dp[i][0];
                    if (i - forget >= 0) {
                        // 如果有人遗忘,则减去 forget 天前知道密码的人
                        dp[i][2] = (dp[i][2] - dp[i - forget][0] + mod) % mod;
                    }
                } else {
                    // 还没有开始分享
                    dp[i][2] = dp[i - 1][2];
                }
                dp[i][0] %= mod;
                dp[i][1] %= mod;
                dp[i][2] %= mod;
            }
            return (int) dp[n - 1][2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}