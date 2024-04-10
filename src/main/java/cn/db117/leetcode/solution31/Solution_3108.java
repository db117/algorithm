

//给你一个 n 个节点的带权无向图，节点编号为 0 到 n - 1 。 
//
// 给你一个整数 n 和一个数组 edges ，其中 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间有一条权值为 wi 的无向
//边。 
//
// 在图中，一趟旅途包含一系列节点和边。旅途开始和结束点都是图中的节点，且图中存在连接旅途中相邻节点的边。注意，一趟旅途可能访问同一条边或者同一个节点多次。 
//
//
// 如果旅途开始于节点 u ，结束于节点 v ，我们定义这一趟旅途的 代价 是经过的边权按位与 AND 的结果。换句话说，如果经过的边对应的边权为 w0, 
//w1, w2, ..., wk ，那么代价为w0 & w1 & w2 & ... & wk ，其中 & 表示按位与 AND 操作。 
//
// 给你一个二维数组 query ，其中 query[i] = [si, ti] 。对于每一个查询，你需要找出从节点开始 si ，在节点 ti 处结束的旅途的
//最小代价。如果不存在这样的旅途，答案为 -1 。 
//
// 返回数组 answer ，其中 answer[i] 表示对于查询 i 的 最小 旅途代价。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]] 
// 
//
// 输出：[1,-1] 
//
// 解释： 
//
// 
//
// 第一个查询想要得到代价为 1 的旅途，我们依次访问：0->1（边权为 7 ）1->2 （边权为 1 ）2->1（边权为 1 ）1->3 （边权为 7 ）。
// 
//
// 第二个查询中，无法从节点 3 到节点 4 ，所以答案为 -1 。 
//
// 示例 2： 
//
// 
// 输入：n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]] 
// 
//
// 输出：[0] 
//
// 解释： 
//
// 
//
// 第一个查询想要得到代价为 0 的旅途，我们依次访问：1->2（边权为 1 ），2->1（边权 为 6 ），1->2（边权为 1 ）。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 0 <= edges.length <= 10⁵ 
// edges[i].length == 3 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= wi <= 10⁵ 
// 1 <= query.length <= 10⁵ 
// query[i].length == 2 
// 0 <= si, ti <= n - 1 
// 
//
// Related Topics 位运算 并查集 图 数组 👍 6 👎 0


package cn.db117.leetcode.solution31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3108.带权图里旅途的最小代价.minimum-cost-walk-in-weighted-graph
 *
 * @author db117
 * @since 2024-04-10 16:33:45
 **/

public class Solution_3108 {
    public static void main(String[] args) {
        Solution solution = new Solution_3108().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            int m = edges.length;
            int q = query.length;
            int[] res = new int[q];

            // 邻接表
            List<List<int[]>> data = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                data.add(new ArrayList<>());
            }

            // 并查集
            UnionFind uf = new UnionFind(n);

            for (int[] edge : edges) {
                data.get(edge[0]).add(new int[]{edge[1], edge[2]});
                data.get(edge[1]).add(new int[]{edge[0], edge[2]});
                uf.union(edge[0], edge[1]);
            }

            // 记录每个连通分量的权值
            Map<Integer, Integer> pMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int p = uf.find(i);
                if (p == i) {
                    continue;
                }
                Integer w = pMap.getOrDefault(p, Integer.MAX_VALUE);
                List<int[]> ints = data.get(i);
                if (ints == null) {
                    continue;
                }
                for (int[] anInt : ints) {
                    w &= anInt[1];
                }
                pMap.put(p, w);
            }

            for (int i = 0; i < q; i++) {
                int x = query[i][0], y = query[i][1];
                if (x == y) {
                    res[i] = 0;
                    continue;
                }
                if (!uf.connected(x, y)) {
                    res[i] = -1;
                    continue;
                }
                // 直接返回连通分量的权值
                res[i] = pMap.get(uf.find(x));
            }
            return res;
        }

        public class UnionFind {
            // 连通分量
            int count;
            // 父节点
            public int[] parent;

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