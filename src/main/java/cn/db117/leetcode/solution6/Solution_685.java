

//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
// 
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 441 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 685.冗余连接 II.redundant-connection-ii
 *
 * @author db117
 * @since 2024-10-28 16:23:49
 **/

public class Solution_685 {
    public static void main(String[] args) {
        Solution solution = new Solution_685().new Solution();
        // [[2,1],[3,1],[4,2],[1,4]]
        System.out.println(Arrays.toString(solution.findRedundantDirectedConnection(new int[][]{
                {2, 1}, {3, 1}, {4, 2}, {1, 4}
        })));


        // [[1,2],[1,3],[2,3]]

        System.out.println(Arrays.toString(solution.findRedundantDirectedConnection(new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        })));// 2 3

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int n = edges.length;
            // 找到入度为 2 的结点
            int[] in = new int[n + 1];
            int t = -1;
            for (int[] edge : edges) {
                in[edge[1]]++;
                if (in[edge[1]] == 2) {
                    t = edge[1];
                }
            }

            // 看看去掉一个是不是有环
            for (int i = edges.length - 1; i >= 0; i--) {// 从后面开始，如果两个都满足。需要返回后面的
                int[] edge = edges[i];
                if (edge[1] == t) {
                    if (check(edges, edge)) {
                        return edge;
                    }
                }
            }

            // 剩下的情况就是有环，和 684 题一样
            UnionFind uf = new UnionFind(n + 1);
            for (int[] edge : edges) {
                if (!uf.connected(edge[0], edge[1])) {
                    uf.union(edge[0], edge[1]);
                } else {
                    return edge;
                }
            }
            return null;
        }

        private boolean check(int[][] edges, int[] removed) {
            int n = edges.length;
            UnionFind uf = new UnionFind(n + 1);
            for (int[] edge : edges) {
                if (Arrays.equals(edge, removed)) {
                    // 不加入这个节点
                    continue;
                }

                if (!uf.connected(edge[0], edge[1])) {
                    // 加入并查集
                    uf.union(edge[0], edge[1]);
                } else {
                    // 存在环
                    return false;
                }
            }
            return true;
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