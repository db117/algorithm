

//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
//
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 10⁹ + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 动态规划 👍 326 👎 0


package cn.db117.leetcode.solution5;

/**
 * 552.学生出勤记录 II.student-attendance-record-ii
 *
 * @author db117
 * @since 2024-08-19 10:57:58
 **/

public class Solution_552 {
    public static void main(String[] args) {
        Solution solution = new Solution_552().new Solution();
        // 测试用例:2
        //			1
        //			10101
//        System.out.println(solution.checkRecord(2));// 8
//        System.out.println(solution.checkRecord(1));// 3
        System.out.println(solution.checkRecord(10101));// 183236316
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int mod = (int) 1e9 + 7;
        static int max = 100_001;
        static int[][][] memo = new int[max][2][3];

        static {
            memo[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
            for (int i = 1; i < max; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        // 出勤
                        long ans = memo[i - 1][j][0];// 今天出勤的情况下，计算昨天缺勤 j 次，累计迟到 0 次的情况下的数量
                        // 缺勤
                        if (j == 0) {
                            ans += memo[i - 1][1][0];// 今天缺勤的情况下，计算昨天缺勤 1 次，累计迟到 0 次的情况下的数量
                        }
                        // 迟到
                        if (k < 2) {
                            ans += memo[i - 1][j][k + 1];// 今天迟到的情况下，计算昨天缺勤 j 次，累计迟到 k+1 次的情况下的数量
                        }
                        memo[i][j][k] = (int) (ans % mod);

                    }
                }
            }
        }

        public int checkRecord(int n) {
            return memo[n][0][0];
        }

        static int dfs(int i, int absent, int late) {
            if (i == 0) {
                return 1;
            }
            if (memo[i][absent][late] > 0) {
                return memo[i][absent][late];
            }
            // 出勤
            long ans = dfs(i - 1, absent, 0);
            // 缺勤
            if (absent == 0) {
                ans += dfs(i - 1, 1, 0);
            }
            // 迟到
            if (late < 2) {
                ans += dfs(i - 1, absent, late + 1);
            }

            return memo[i][absent][late] = (int) (ans % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}