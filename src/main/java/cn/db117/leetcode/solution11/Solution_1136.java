

//给你一个整数 n ，表示编号从 1 到 n 的 n 门课程。另给你一个数组 relations ，其中 relations[i] = [
//prevCoursei, nextCoursei] ，表示课程 prevCoursei 和课程 nextCoursei 之间存在先修关系：课程 prevCoursei 必须在 
//nextCoursei 之前修读完成。 
//
// 在一个学期内，你可以学习 任意数量 的课程，但前提是你已经在上一学期修读完待学习课程的所有先修课程。 
//
// 
// 
// 请你返回学完全部课程所需的 最少 学期数。如果没有办法做到学完全部这些课程的话，就返回 -1。 
// 
// 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3, relations = [[1,3],[2,3]]
//输出：2
//解释：上图表示课程之间的关系图：
//在第一学期，可以修读课程 1 和 2 。
//在第二学期，可以修读课程 3 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 3, relations = [[1,2],[2,3],[3,1]]
//输出：-1
//解释：没有课程可以学习，因为它们互为先修课程。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// 1 <= relations.length <= 5000 
// relations[i].length == 2 
// 1 <= prevCoursei, nextCoursei <= n 
// prevCoursei != nextCoursei 
// 所有 [prevCoursei, nextCoursei] 互不相同 
// 
//
// Related Topics 图 拓扑排序 👍 60 👎 0


package cn.db117.leetcode.solution11;

import java.util.*;

/**
 * 1136.并行课程.parallel-courses
 *
 * @author db117
 * @since 2023-04-13 10:16:51
 **/

public class Solution_1136 {
    public static void main(String[] args) {
        Solution solution = new Solution_1136().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            // 建图  邻接表
            Map<Integer, Set<Integer>> preMap = new HashMap<>();
            Map<Integer, Set<Integer>> nextMap = new HashMap<>();

            for (int[] relation : relations) {
                preMap.putIfAbsent(relation[1], new HashSet<>());
                preMap.get(relation[1]).add(relation[0]);

                nextMap.putIfAbsent(relation[0], new HashSet<>());
                nextMap.get(relation[0]).add(relation[1]);
            }

            // 入队 没有前置课程的
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (!preMap.containsKey(i)) {
                    queue.add(i);
                }
            }

            // 队列为 0  ，死循环
            if (queue.isEmpty()) {
                return -1;
            }

            boolean[] flag = new boolean[n + 1];
            // bfs
            int ans = 0;
            while (!queue.isEmpty()) {
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer cur = queue.poll();
                    flag[cur] = true;
                    Set<Integer> nextSet = nextMap.get(cur);// 后面解锁的课程
                    if (nextSet != null && !nextSet.isEmpty()) {
                        for (Integer next : nextSet) {
                            // 每一个后面的课程少了当前课程
                            Set<Integer> set = preMap.get(next);
                            set.remove(cur);
                            if (set.size() == 0) {
                                // 没有前置课程了
                                queue.add(next);
                            }
                        }
                    }
                }
            }
            // 校验是否都走完了
            for (int i = 1; i <= n; i++) {
                if (!flag[i]) {
                    return -1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}