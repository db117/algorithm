

//给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。 
//
// 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。 
//
//
// 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。 
//
// 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//输出：[3,2,2]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
// 
//
// 示例 2： 
//
// 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
//输出：[2,3,2,4]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// points[i].length == 2 
// 0 <= xi, yi <= 500 
// 1 <= queries.length <= 500 
// queries[j].length == 3 
// 0 <= xj, yj <= 500 
// 1 <= rj <= 500 
// 所有的坐标都是整数。 
// 
// Related Topics 几何 数组 数学 👍 10 👎 0


package cn.db117.leetcode.solution18;

import java.util.Arrays;

/**
 * 1828.统计一个圆中点的数目.queries-on-number-of-points-inside-a-circle
 *
 * @author db117
 * @since 2021-11-03 18:37:44
 **/

public class Solution_1828 {
    public static void main(String[] args) {
        Solution solution = new Solution_1828().new Solution();
        System.out.println(Arrays.toString(solution.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}},
                new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
        System.out.println(Arrays.toString(solution.countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}},
                new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                // 简单遍历一个个来
                for (int[] point : points) {
                    int x = Math.abs(query[0] - point[0]);
                    int y = Math.abs(query[1] - point[1]);

                    // 肯定不在
                    if (x > query[2] || y > query[2]) {
                        continue;
                    }

                    // 勾股定理
                    if (Math.pow(query[2], 2) >= Math.pow(x, 2) + Math.pow(y, 2)) {
                        ans[i]++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}