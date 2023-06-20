

//给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。 
//
// 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接
//成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至
//少与第一组中的一个点连接。 
//
// 返回连通两组点所需的最小成本。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：cost = [[15, 96], [36, 2]]
//输出：17
//解释：连通两组点的最佳方法是：
//1--A
//2--B
//总成本为 17 。
// 
//
// 示例 2： 
//
// 
//
// 输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
//输出：4
//解释：连通两组点的最佳方法是：
//1--A
//2--B
//2--C
//3--A
//最小成本为 4 。
//请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。 
//
// 示例 3： 
//
// 输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// size1 == cost.length 
// size2 == cost[i].length 
// 1 <= size1, size2 <= 12 
// size1 >= size2 
// 0 <= cost[i][j] <= 100 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 矩阵 👍 88 👎 0


package cn.db117.leetcode.solution15;

import java.util.Arrays;
import java.util.List;

/**
 * 1595.连通两组点的最小成本.minimum-cost-to-connect-two-groups-of-points
 *
 * @author db117
 * @since 2023-06-20 09:52:58
 **/

public class Solution_1595 {
    public static void main(String[] args) {
        Solution solution = new Solution_1595().new Solution();
        // [[1,3,5],[4,1,1],[1,5,3]]
        System.out.println(solution.connectTwoGroups(Arrays.asList(
                Arrays.asList(1, 3, 5),
                Arrays.asList(4, 1, 1),
                Arrays.asList(1, 5, 3)
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        int m, n;
        int[] minCost;
        List<List<Integer>> cost;

        public int connectTwoGroups(List<List<Integer>> cost) {
            m = cost.size();
            n = cost.get(0).size();
            this.cost = cost;
            minCost = new int[m];// 第二个集合中每个点的对应的最小值
            Arrays.fill(minCost, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (List<Integer> list : cost) {
                    minCost[j] = Math.min(minCost[j], list.get(j));
                }
            }

            memo = new int[m][1 << n];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }

            return dfs(m - 1, (1 << n) - 1);
        }

        private int dfs(int i, int j) {
            if (i < 0) {
                if (j == 0) {
                    return 0;
                }
                int ans = 0;
                // 完事了，第一个集合中的点都连上了。如果第二个集合中的点还有没连上的，那就直接连上最小的
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) != 0) {
                        ans += minCost[k];
                    }
                }
                return ans;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            // 正常 dp
            int ans = Integer.MAX_VALUE;
            // 枚举每一个选择，找最小的
            List<Integer> get = cost.get(i);
            for (int k = 0; k < n; k++) {
                Integer num = get.get(k);
                ans = Math.min(ans, dfs(i - 1, j & ~(1 << k)) + num);
            }
            return memo[i][j] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}