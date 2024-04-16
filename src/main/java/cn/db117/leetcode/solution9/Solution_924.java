

//给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图
// graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。 
//
// 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传
//播将继续，直到没有更多的节点可以被这种方式感染。 
//
// 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 
//
// 如果从 initial 中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。 
//
// 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// n == graph.length 
// n == graph[i].length 
// 2 <= n <= 300 
// graph[i][j] == 0 或 1. 
// graph[i][j] == graph[j][i] 
// graph[i][i] == 1 
// 1 <= initial.length <= n 
// 0 <= initial[i] <= n - 1 
// initial 中所有整数均不重复 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 哈希表 👍 106 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 924.尽量减少恶意软件的传播.minimize-malware-spread
 *
 * @author db117
 * @since 2024-04-16 09:54:42
 **/

public class Solution_924 {
    public static void main(String[] args) {
        Solution solution = new Solution_924().new Solution();
        // [[1,0,0,0],[0,1,0,0],[0,0,1,1],[0,0,1,1]]
        //			[3,1]
//        System.out.println(solution.minMalwareSpread(new int[][]{
//                {1, 0, 0, 0},
//                {0, 1, 0, 0},
//                {0, 0, 1, 1},
//                {0, 0, 1, 1}
//        }, new int[]{3, 1}));

        // [[1,0,0,0,1,0,0,0,0,0,1],[0,1,0,1,0,0,0,0,0,0,0],[0,0,1,0,0,0,0,1,0,0,0],[0,1,0,1,0,1,0,0,0,0,0],[1,0,0,0,1,0,0,0,0,0,0],[0,0,0,1,0,1,0,0,1,1,0],[0,0,0,0,0,0,1,1,0,0,0],[0,0,1,0,0,0,1,1,0,0,0],[0,0,0,0,0,1,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,1,0],[1,0,0,0,0,0,0,0,0,0,1]]
        //			[7,8,6,2,3]
//        System.out.println(solution.minMalwareSpread(new int[][]{
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
//                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
//        }, new int[]{7, 8, 6, 2, 3}));

        // [[1,0,0,0,1,0,0,0],[0,1,1,0,0,1,0,0],[0,1,1,0,1,0,0,0],[0,0,0,1,1,0,0,0],[1,0,1,1,1,0,0,1],[0,1,0,0,0,1,0,0],[0,0,0,0,0,0,1,1],[0,0,0,0,1,0,1,1]]
        //			[7,2]
        System.out.println(solution.minMalwareSpread(new int[][]{
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 1, 1}
        }, new int[]{7, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;

            // 并查集
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            if (unionFind.count() == n || initial.length == 1 ) {
                return initial[0];
            }
            if (unionFind.count() == 1) {
                return Arrays.stream(initial).min().getAsInt();
            }

            int ans = initial[0];
            int min = Integer.MAX_VALUE;
            int k = initial.length;
            int[] parent = unionFind.getParent();
            for (int i = 0; i < k; i++) {
                // 找到其他节点的父节点
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < k; j++) {
                    if (i == j) {
                        continue;
                    }
                    set.add(parent[initial[j]]);
                }

                // 统计其他节点能够感染的节点数量
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (set.contains(parent[j])) {
                        count++;
                    }
                }
                if (count < min) {
                    min = count;
                    ans = initial[i];
                }else if (count == min){
                    ans = Math.min(ans, initial[i]);
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

            public int[] getParent() {
                return parent;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}