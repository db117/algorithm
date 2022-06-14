

//给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 
//ai 和 bi 之间存在一条无向边。 
//
// 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//输出: true 
//
// 示例 2: 
//
// 
//
// 
//输入: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// 不存在自循环或重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 166 👎 0


package cn.db117.leetcode.solution2;

/**
 * 261.以图判树.graph-valid-tree
 *
 * @author db117
 * @since 2022-04-27 16:31:18
 **/

public class Solution_261 {
    public static void main(String[] args) {
        Solution solution = new Solution_261().new Solution();
        //5
        //[[0,1],[0,2],[0,3],[1,4]]
        System.out.println(solution.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));

        // 5
        //[[0,1],[1,2],[2,3],[1,3],[1,4]]
        System.out.println(solution.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean validTree(int n, int[][] edges) {
            if (edges.length != n - 1) {
                // 当所有节点都连在一起需要 n-1 个边
                // 如果数组的数量大于 n-1 则说明有环
                return false;
            }
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }

            // 数组数量为 n-1 且所有节点都在一块,则没有环
            return uf.count == 1;
        }

        /**
         * 并查集
         */
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