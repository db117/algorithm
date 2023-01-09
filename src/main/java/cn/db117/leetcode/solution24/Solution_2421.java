

//给你一棵 n 个节点的树（连通无向无环的图），节点编号从 0 到 n - 1 且恰好有 n - 1 条边。 
//
// 给你一个长度为 n 下标从 0 开始的整数数组 vals ，分别表示每个节点的值。同时给你一个二维整数数组 edges ，其中 edges[i] = [
//ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。 
//
// 一条 好路径 需要满足以下条件： 
//
// 
// 开始节点和结束节点的值 相同 。 
// 开始节点和结束节点中间的所有节点值都 小于等于 开始节点的值（也就是说开始节点的值应该是路径上所有节点的最大值）。 
// 
//
// 请你返回不同好路径的数目。 
//
// 注意，一条路径和它反向的路径算作 同一 路径。比方说， 0 -> 1 与 1 -> 0 视为同一条路径。单个节点也视为一条合法路径。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
//输出：6
//解释：总共有 5 条单个节点的好路径。
//还有 1 条好路径：1 -> 0 -> 2 -> 4 。
//（反方向的路径 4 -> 2 -> 0 -> 1 视为跟 1 -> 0 -> 2 -> 4 一样的路径）
//注意 0 -> 2 -> 3 不是一条好路径，因为 vals[2] > vals[0] 。
// 
//
// 示例 2： 
//
// 
//
// 输入：vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
//输出：7
//解释：总共有 5 条单个节点的好路径。
//还有 2 条好路径：0 -> 1 和 2 -> 3 。
// 
//
// 示例 3： 
//
// 
//
// 输入：vals = [1], edges = []
//输出：1
//解释：这棵树只有一个节点，所以只有一条好路径。
// 
//
// 
//
// 提示： 
//
// 
// n == vals.length 
// 1 <= n <= 3 * 10⁴ 
// 0 <= vals[i] <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵合法的树。 
// 
//
// Related Topics 树 并查集 图 数组 👍 32 👎 0


package cn.db117.leetcode.solution24;

import cn.db117.template.trie.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 2421.好路径的数目.number-of-good-paths
 *
 * @author db117
 * @see Trie
 * @since 2022-09-27 17:38:37
 **/

public class Solution_2421 {
    public static void main(String[] args) {
        Solution solution = new Solution_2421().new Solution();
        // [1,3,2,1,3]
        //[[0,1],[0,2],[2,3],[2,4]]
        System.out.println(solution.numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}));

        // [2,5,5,1,5,2,3,5,1,5]
        //[[0,1],[2,1],[3,2],[3,4],[3,5],[5,6],[1,7],[8,4],[9,7]]
        // 20

        System.out.println(solution.numberOfGoodPaths(new int[]{2, 5, 5, 1, 5, 2, 3, 5, 1, 5},
                new int[][]{{0, 1}, {2, 1}, {3, 2}, {3, 4}, {3, 5}, {5, 6}, {1, 7}, {8, 4}, {9, 7}}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] vals;

        public int numberOfGoodPaths(int[] vals, int[][] edges) {
            int n = vals.length;
            this.vals = vals;
            // 构图
            List<Integer>[] graph = new ArrayList[n];
            Arrays.setAll(graph, value -> new ArrayList<>());
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            // 并查集
            UnionFind uf = new UnionFind(n);

            // 按照 vals 大小对索引进行排序
            Integer[] ids = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(ids, Comparator.comparingInt(o -> vals[o]));

            // sz代表节点x的个数
            int[] size = new int[n];
            Arrays.fill(size, 1);


            int ans = n;
            for (Integer x : ids) {
                int xVal = vals[x];
                int ufx = uf.find(x);
                for (Integer y : graph[x]) {
                    int ufy = uf.find(y);// 索引 y 所链接节点的最大值索引
                    if (ufy == ufx/*两个节点以连通*/ || vals[ufy] > xVal/*y 节点连通的最大值比当前值大*/) {
                        continue;
                    }
                    // y 连通的最大值等于当前连通区域的最大值
                    if (xVal == vals[ufy]) {
                        // 相乘
                        ans += size[ufx] * size[ufy];
                        // 连通块内节点值等于 xVal 的数量
                        size[ufx] += size[ufy];
                    }
                    // 合并节点
                    uf.union(ufx, ufy);
                }
            }
            return ans;
        }

        // 板子,就改了父节点为最大的
        public class UnionFind {
            // 父节点
            int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                // 初始父节点都是自己
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
            }

            public void union(int x, int y) {
                // 直接把 y 的父节点指向 x
                parent[y] = x;
            }

            public int find(int n) {
                while (parent[n] != n) {
                    // 路径压缩
                    parent[n] = parent[parent[n]];
                    n = parent[n];
                }
                return n;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}