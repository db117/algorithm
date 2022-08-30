

//你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条
//边。 
//
// 返回 图中已连接分量的数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 5, edges = [[0, 1], [1, 2], [3, 4]]
//输出: 2
// 
//
// 示例 2: 
//
// 
//
// 
//输入: n = 5, edges = [[0,1], [1,2], [2,3], [3,4]]
//输出:  1 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 1 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai <= bi < n 
// ai != bi 
// edges 中不会出现重复的边 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 151 👎 0


package cn.db117.leetcode.solution3;

/**
 * 323.无向图中连通分量的数目.number-of-connected-components-in-an-undirected-graph
 *
 * @author db117
 * @see cn.db117.template.UnionFind
 * @since 2022-08-30 16:15:21
 **/

public class Solution_323 {
    public static void main(String[] args) {
        Solution solution = new Solution_323().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countComponents(int n, int[][] edges) {
            UnionFind unionFind = new UnionFind(n);
            for (int[] edge : edges) {
                unionFind.union(edge[0], edge[1]);
            }
            return unionFind.count();
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