

//一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。 
//
// 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。 
//
// 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。同时给你一个正整数 k ，请你返回在 恰
//好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：piles = [[1,100,3],[7,8,9]], k = 2
//输出：101
//解释：
//上图展示了几种选择 k 个硬币的不同方法。
//我们可以得到的最大面值为 101 。
// 
//
// 示例 2： 
//
// 
//输入：piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
//输出：706
//解释：
//如果我们所有硬币都从最后一个栈中取，可以得到最大面值和。
// 
//
// 
//
// 提示： 
//
// 
// n == piles.length 
// 1 <= n <= 1000 
// 1 <= piles[i][j] <= 10⁵ 
// 1 <= k <= sum(piles[i].length) <= 2000 
// 
// Related Topics 动态规划 👍 27 👎 0


package cn.db117.leetcode.solution22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2218.从栈中取出 K 个硬币的最大面值和.maximum-value-of-k-coins-from-piles
 *
 * @author db117
 * @since 2022-03-29 15:37:11
 **/

public class Solution_2218 {
    public static void main(String[] args) {
        Solution solution = new Solution_2218().new Solution();
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(Arrays.stream(new int[]{1, 100, 3}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{7, 8, 9}).boxed().collect(Collectors.toList()));
        System.out.println(solution.maxValueOfCoins(piles, 2));

        // [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]]
        //7

        piles.clear();
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{100}).boxed().collect(Collectors.toList()));
        piles.add(Arrays.stream(new int[]{1, 1, 1, 1, 1, 1, 700}).boxed().collect(Collectors.toList()));
        System.out.println(solution.maxValueOfCoins(piles, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            // 分组背包
            int len = piles.size();
            // 第 i 组,j 次操作能获取的最大值
            int[][] dp = new int[len][k + 1];
            // 初始化
            // 只考虑第一个栈的情况
            for (int i = 1; i <= piles.get(0).size() && i <= k; i++) {
                dp[0][i] = dp[0][i - 1] + piles.get(0).get(i - 1);
            }

            // 遍历所有栈
            for (int i = 1; i < len; i++) {
                // 遍历操作次数
                for (int j = 1; j <= k; j++) {
                    // 前缀和
                    int sum = 0;
                    // l 为本组选取的数量
                    for (int l = 0; l <= piles.get(i).size(); l++) {

                        // 计算前缀和
                        if (l > 0) {
                            sum += piles.get(i).get(l - 1);
                        }

                        // 遍历当前栈能够取的所有可能,取最大值
                        // 当前栈取 l 个+前面去 j-l 个的最大值
                        if (j >= l) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + sum);
                        }

                    }
                }
            }

            return dp[len - 1][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}