

//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 814 👎 0


package cn.db117.leetcode.solution7;

import java.util.*;

/**
 * 743.网络延迟时间.network-delay-time
 *
 * @author db117
 * @since 2024-11-25 22:52:32
 **/

public class Solution_743 {
    public static void main(String[] args) {
        Solution solution = new Solution_743().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 建图
            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                graph[u].add(new int[]{v, w});
            }

            // 标准的 dijkstra 算法
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{k, 0});
            Set<Integer> visited = new HashSet<>();
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int num = poll[0];
                int time = poll[1];
                if (visited.contains(num)) {
                    // 已经被访问过
                    continue;
                }
                visited.add(num);
                if (visited.size() == n) {
                    // 所有节点都访问过
                    return time;
                }
                for (int[] next : graph[num]) {
                    pq.offer(new int[]{next[0], time + next[1]});
                }
            }
            return -1;// 没有找到
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}