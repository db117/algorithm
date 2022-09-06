

//给你一个 正 整数 k ，同时给你： 
//
// 
// 一个大小为 n 的二维整数数组 rowConditions ，其中 rowConditions[i] = [abovei, belowi] 和 
// 一个大小为 m 的二维整数数组 colConditions ，其中 colConditions[i] = [lefti, righti] 。 
// 
//
// 两个数组里的整数都是 1 到 k 之间的数字。 
//
// 你需要构造一个 k x k 的矩阵，1 到 k 每个数字需要 恰好出现一次 。剩余的数字都是 0 。 
//
// 矩阵还需要满足以下条件： 
//
// 
// 对于所有 0 到 n - 1 之间的下标 i ，数字 abovei 所在的 行 必须在数字 belowi 所在行的上面。 
// 对于所有 0 到 m - 1 之间的下标 i ，数字 lefti 所在的 列 必须在数字 righti 所在列的左边。 
// 
//
// 返回满足上述要求的 任意 矩阵。如果不存在答案，返回一个空的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
//输出：[[3,0,0],[0,0,1],[0,2,0]]
//解释：上图为一个符合所有条件的矩阵。
//行要求如下：
//- 数字 1 在第 1 行，数字 2 在第 2 行，1 在 2 的上面。
//- 数字 3 在第 0 行，数字 2 在第 2 行，3 在 2 的上面。
//列要求如下：
//- 数字 2 在第 1 列，数字 1 在第 2 列，2 在 1 的左边。
//- 数字 3 在第 0 列，数字 2 在第 1 列，3 在 2 的左边。
//注意，可能有多种正确的答案。
// 
//
// 示例 2： 
//
// 输入：k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
//输出：[]
//解释：由前两个条件可以得到 3 在 1 的下面，但第三个条件是 3 在 1 的上面。
//没有符合条件的矩阵存在，所以我们返回空矩阵。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= k <= 400 
// 1 <= rowConditions.length, colConditions.length <= 10⁴ 
// rowConditions[i].length == colConditions[i].length == 2 
// 1 <= abovei, belowi, lefti, righti <= k 
// abovei != belowi 
// lefti != righti 
// 
//
// Related Topics 图 拓扑排序 数组 矩阵 👍 23 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2392.给定条件下构造矩阵.build-a-matrix-with-conditions
 *
 * @author db117
 * @see cn.db117.template.TopologicalSort
 * @since 2022-09-02 14:54:57
 **/

public class Solution_2392 {
    public static void main(String[] args) {
        Solution solution = new Solution_2392().new Solution();
//        System.out.println(Arrays.deepToString(solution.buildMatrix(3,
//                new int[][]{{1,2},{3,2}},
//                new int[][]{{2,1},{3,2}})));

        // 3
        //[[1,2],[2,3],[3,1],[2,3]]
        //[[2,1]]
        System.out.println(Arrays.deepToString(solution.buildMatrix(3,
                new int[][]{{1, 2}, {3, 2}, {3, 1}, {2, 3}},
                new int[][]{{2, 1}})));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

            int[][] ans = new int[k][k];
            int[] row = sort(k + 1, rowConditions);
            int[] col = sort(k + 1, colConditions);
            if (row.length == 0 || col.length == 0) {
                return new int[0][];
            }
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= k; j++) {
                    if (col[j] == row[i]) {
                        ans[i - 1][j - 1] = row[i];
                    }
                }
            }
            return ans;
        }


        public int[] sort(int numCourses, int[][] prerequisites) {
            // 标准拓扑排序
            // 入度
            int[] in = new int[numCourses];
            // 邻接表
            Queue<Integer>[] graph = new Queue[numCourses];

            // 构建图
            for (int[] prerequisite : prerequisites) {
                int form = prerequisite[0];
                int to = prerequisite[1];

                in[to]++;

                if (graph[form] == null) {
                    graph[form] = new LinkedList<>();
                }
                graph[form].offer(to);
            }

            // 0 入度
            Queue<Integer> zeroIn = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (in[i] == 0) {
                    zeroIn.offer(i);
                }
            }
            // 记录访问节点
            int index = 0;
            int[] ans = new int[numCourses];


            while (!zeroIn.isEmpty()) {
                Integer from = zeroIn.poll();
                // 记录访问节点
                ans[index++] = from;

                Queue<Integer> queue = graph[from];
                if (queue == null) {
                    continue;
                }
                // 下一个节点入度全部减一
                while (!queue.isEmpty()) {
                    Integer to = queue.poll();
                    in[to]--;
                    if (in[to] == 0) {
                        // 下一个节点入度为 0 入队
                        zeroIn.offer(to);
                    }
                }
            }
            if (index != numCourses) {
                return new int[0];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}