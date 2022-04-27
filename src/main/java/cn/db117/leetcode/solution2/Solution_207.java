

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1240 👎 0


package cn.db117.leetcode.solution2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 207.课程表.course-schedule
 *
 * @author db117
 * @since 2022-04-27 11:48:32
 **/

public class Solution_207 {
    public static void main(String[] args) {
        Solution solution = new Solution_207().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
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

            // 处理完节点数量
            int count = 0;
            while (!zeroIn.isEmpty()) {
                Integer from = zeroIn.poll();
                count++;

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
            return count == numCourses;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}