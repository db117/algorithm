

//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics 数组 字符串 动态规划 👍 844 👎 0


package cn.db117.leetcode.solution4;

/**
 * 474.一和零.ones-and-zeroes
 *
 * @author db117
 * @since 2023-01-11 15:07:55
 **/

public class Solution_474 {
    public static void main(String[] args) {
        Solution solution = new Solution_474().new Solution();
        // ["10","0001","111001","1","0"] 5 3
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            // 预处理 1 0 数量
            int[] zero = new int[len];
            int[] one = new int[len];
            for (int i = 0; i < len; i++) {
                String s = strs[i];
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '1') {
                        one[i]++;
                    } else {
                        zero[i]++;
                    }
                }
            }
            // 背包
            int[][] dp = new int[m + 1][n + 1];
            for (int k = 0; k < len; k++) {
                for (int i = m; i >= zero[k]; i--) {
                    for (int j = n; j >= one[k]; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero[k]][j - one[k]] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}