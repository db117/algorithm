

//想象一下你是个城市基建规划者，地图上有 n 座城市，它们按以 1 到 n 的次序编号。 
//
// 给你整数 n 和一个数组 conections，其中 connections[i] = [xi, yi, costi] 表示将城市 xi 和城市 yi 连
//接所要的costi（连接是双向的）。 
//
// 返回连接所有城市的最低成本，每对城市之间至少有一条路径。如果无法连接所有 n 个城市，返回 -1 
//
// 该 最小成本 应该是所用全部连接成本的总和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
//输出：6
//解释：选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 4, conections = [[1,2,3],[3,4,4]]
//输出：-1
//解释：即使连通所有的边，也无法连接所有城市。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 1 <= connections.length <= 10⁴ 
// connections[i].length == 3 
// 1 <= xi, yi <= n 
// xi != yi 
// 0 <= costi <= 10⁵ 
// 
//
// Related Topics 并查集 图 最小生成树 堆（优先队列） 👍 108 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1135.最低成本联通所有城市.connecting-cities-with-minimum-cost
 *
 * @author db117
 * @since 2023-06-07 10:09:57
 **/

public class Solution_1135 {
    public static void main(String[] args) {
        Solution solution = new Solution_1135().new Solution();
        // [[1,2,5],[1,3,6],[2,3,1]]
        System.out.println(solution.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCost(int n, int[][] connections) {
            UnionFind uf = new UnionFind(n);
            // 按照路径分数排序
            Arrays.sort(connections, Comparator.comparing(ints -> ints[2]));

            int ans = 0;
            for (int[] connection : connections) {
                // 如果两个点没有连接过则进行链接
                if (uf.connected(connection[0] - 1, connection[1] - 1)) {
                    continue;
                }
                uf.union(connection[0] - 1, connection[1] - 1);
                ans += connection[2];
            }
            if (uf.count == 1) {// 连通分量为 1 则说明所有节点都在一块了
                return ans;
            }
            return -1;
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