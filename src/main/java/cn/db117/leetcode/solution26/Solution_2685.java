

//给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = 
//[ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。 
//
// 返回图中 完全连通分量 的数量。 
//
// 如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。 
//
// 如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
//输出：3
//解释：如上图所示，可以看到此图所有分量都是完全连通分量。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
//输出：1
//解释：包含节点 0、1 和 2 的分量是完全连通分量，因为每对节点之间都存在一条边。
//包含节点 3 、4 和 5 的分量不是完全连通分量，因为节点 4 和 5 之间不存在边。
//因此，在图中完全连接分量的数量是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 0 <= edges.length <= n * (n - 1) / 2 
// edges[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 不存在重复的边 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 13 👎 0


package cn.db117.leetcode.solution26;

import java.util.*;

/**
 * 2685.统计完全连通分量的数量.count-the-number-of-complete-components
 *
 * @author db117
 * @since 2023-05-22 10:48:34
 **/

public class Solution_2685 {
    public static void main(String[] args) {
        Solution solution = new Solution_2685().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                // 并查集连接相同的点
                uf.union(edge[0], edge[1]);
            }
            Map<Integer, Set<Integer>> edge = new HashMap<>();
            for (int[] ints : edges) {
                edge.putIfAbsent(ints[0], new HashSet<>());
                edge.putIfAbsent(ints[1], new HashSet<>());

                edge.get(ints[0]).add(ints[1]);
                edge.get(ints[1]).add(ints[0]);
            }


            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // 并查集对不同的连通块进行统计
                int p = uf.find(i);
                map.putIfAbsent(p, new ArrayList<>());
                map.get(p).add(i);
            }

            int ans = 0;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer integer = entry.getKey();
                List<Integer> list = entry.getValue();
                int size = list.size();
                if (size == 1) {
                    ans++;
                    continue;
                }

                // 对每一个点进行校验，是否和其他点有连接
                boolean flag = true;
                for (int i = 0; i < size; i++) {
                    for (int j = i + 1; j < size; j++) {
                        if (!edge.get(list.get(i)).contains(list.get(j))) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (flag) {
                    ans++;
                }
            }

            return ans;
        }

        public class UnionFind {
            // 连通分量
            int count;
            // 父节点
            int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];

                // 初始父节点都是自己
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
            }

            public void union(int x, int y) {
                int xp = find(x);
                int yp = find(y);
                if (xp == yp) {
                    return;
                }
                if (xp < yp) {
                    parent[yp] = xp;
                } else {
                    parent[xp] = yp;
                }
                // 连通分量
                count--;
            }

            public int find(int n) {
                while (parent[n] != n) {
                    // 路径压缩
                    parent[n] = parent[parent[n]];
                    n = parent[n];
                }
                return n;
            }

            public boolean connected(int x, int y) {
                return find(y) == find(x);
            }

            public int count() {
                return count;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}