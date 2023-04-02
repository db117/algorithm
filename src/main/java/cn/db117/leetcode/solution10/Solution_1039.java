

//你有一个凸的
// n 边形，其每个顶点都有一个整数值。给定一个整数数组
// values ，其中
// values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。 
//
// 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之
//和。 
//
// 返回 多边形进行三角剖分后可以得到的最低分 。 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：values = [1,2,3]
//输出：6
//解释：多边形已经三角化，唯一三角形的分数为 6。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：values = [3,7,4,5]
//输出：144
//解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：values = [1,3,1,4,1,5]
//输出：13
//解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length 
// 3 <= n <= 50 
// 1 <= values[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 225 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1039.多边形三角剖分的最低得分.minimum-score-triangulation-of-polygon
 *
 * @author db117
 * @since 2023-04-02 23:38:10
 **/

public class Solution_1039 {
    public static void main(String[] args) {
        Solution solution = new Solution_1039().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] cache;
        int[] values;

        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            this.values = values;
            cache = new int[n][n];
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            // 从 0 到 n-1 最小的值
            return bfs(0, n - 1);
        }

        public int bfs(int i, int j) {
            if (cache[i][j] != -1) {
                return cache[i][j];
            }
            if (i == j - 1) {
                // 两个边 ，搞不成
                return 0;
            }
            int cur = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                // 枚举每一个点，拆分成两个凸变形，和当前三角形
                cur = Math.min(cur, bfs(i, k) + bfs(k, j) + values[i] * values[j] * values[k]);
            }
            cache[i][j] = cur;

            return cache[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}