//给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
//
// 为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，也就是说一个农场组中的任何
//一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。 
//
// land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角
//的坐标。一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。 
//
// 请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。可以以 任意
//顺序 返回所有农场组。 
//
// 示例 1： 
//
// 
//
// 输入：land = [[1,0,0],[0,1,1],[0,1,1]]
//输出：[[0,0,0,0],[1,1,2,2]]
//解释：
//第一个农场组的左上角为 land[0][0] ，右下角为 land[0][0] 。
//第二个农场组的左上角为 land[1][1] ，右下角为 land[2][2] 。
// 
//
// 示例 2： 
//
// 
//
// 输入：land = [[1,1],[1,1]]
//输出：[[0,0,1,1]]
//解释：
//第一个农场组左上角为 land[0][0] ，右下角为 land[1][1] 。
// 
//
// 示例 3： 
//
// 
//
// 输入：land = [[0]]
//输出：[]
//解释：
//没有任何农场组。
// 
//
// 
//
// 提示： 
//
// 
// m == land.length 
// n == land[i].length 
// 1 <= m, n <= 300 
// land 只包含 0 和 1 。 
// 农场组都是 矩形 的形状。 
// 
// 👍 0 👎 0


package cn.db117.leetcode.solution19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1992.找到所有的农场组.find-all-groups-of-farmland
 *
 * @author db117
 * @since 2021-09-07 18:33:21
 **/

public class Solution_1992 {
    public static void main(String[] args) {
        Solution solution = new Solution_1992().new Solution();

        System.out.println(Arrays.deepToString(solution.findFarmland(new int[][]
                {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}}
        )));
        System.out.println(Arrays.deepToString(solution.findFarmland(new int[][]
                {{1, 1}, {1, 1}}
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findFarmland(int[][] land) {
            int m = land.length;
            int n = land[0].length;
            boolean[][] flag = new boolean[m][n];
            List<int[]> ans = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (flag[i][j] || land[i][j] == 0) {
                        // 不能当左上角
                        continue;
                    }
                    // 右下角
                    int z = i, k = j;

                    while (z < m && land[z][j] == 1) {
                        z++;
                    }
                    while (k < n && land[i][k] == 1) {
                        k++;
                    }

                    ans.add(new int[]{i, j, z - 1, k - 1});

                    // 标记
                    for (int l = i; l < z; l++) {
                        for (int o = j; o < k; o++) {
                            flag[l][o] = true;
                        }
                    }
                }
            }
            return ans.toArray(new int[0][0]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}