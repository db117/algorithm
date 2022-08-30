package cn.db117.leetcode.solution2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/11/011 17:42
 * @see cn.db117.template.TopologicalSort
 */
public class Solution207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            return findOrder(numCourses, prerequisites).length == numCourses;
        }

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
}
