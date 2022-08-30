

//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 612 👎 0


package cn.db117.leetcode.solution2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 210.课程表 II.course-schedule-ii
 *
 * @author db117
 * @see cn.db117.template.TopologicalSort
 * @since 2022-04-27 15:57:40
 **/

public class Solution_210 {
    public static void main(String[] args) {
        Solution solution = new Solution_210().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 标准拓扑排序
            // 入度
            int[] in = new int[numCourses];
            // 邻接表
            Queue<Integer>[] graph = new Queue[numCourses];

            // 构建图
            for (int[] prerequisite : prerequisites) {
                int form = prerequisite[1];
                int to = prerequisite[0];

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