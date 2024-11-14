

//现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其
//中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。 
//
// 如果一个节点的所有子节点为根的 子树 包含的节点数相同，则认为该节点是一个 好节点。 
//
// 返回给定树中 好节点 的数量。 
//
// 子树 指的是一个节点以及它所有后代节点构成的一棵树。 
//
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]] 
// 
//
// 输出：7 
//
// 说明： 
// 
// 树的所有节点都是好节点。 
//
// 示例 2： 
//
// 
// 输入：edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]] 
// 
//
// 输出：6 
//
// 说明： 
// 
// 树中有 6 个好节点。上图中已将这些节点着色。 
//
// 示例 3： 
//
// 
// 输入：edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,1
//2],[10,11]] 
// 
//
// 输出：12 
//
// 解释： 
// 
// 除了节点 9 以外其他所有节点都是好节点。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// 输入确保 edges 总表示一棵有效的树。 
// 
//
// Related Topics 树 深度优先搜索 👍 25 👎 0


package cn.db117.leetcode.solution32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3249.统计好节点的数目.count-the-number-of-good-nodes
 *
 * @author db117
 * @since 2024-11-14 10:53:44
 **/

public class Solution_3249 {
    public static void main(String[] args) {
        Solution solution = new Solution_3249().new Solution();
        // [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//        System.out.println(solution.countGoodNodes(new int[][]{
//                {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}
//        }));
//
        // [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
        System.out.println(solution.countGoodNodes(new int[][]{
                {0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<Integer>[] graph;
        int ans = 0;

        public int countGoodNodes(int[][] edges) {
            graph = new ArrayList[edges.length + 1];
            // 每个结点的子节点数量
            childCount = new int[edges.length + 1];
            Arrays.fill(childCount, -1);

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            dfs(0, -1);
            return ans;
        }

        private void dfs(int index, int p) {

            Set<Integer> set = new HashSet<>();
            for (Integer i : graph[index]) {
                if (i == p) {
                    continue;
                }
                int count = children(i, index);
                set.add(count);

                dfs(i, index);
            }
            if (set.size() <= 1) {
                // 子节点的子节点数量都一样
                ans++;
            }
        }

        int[] childCount;

        private int children(int index, int p) {
            int res = 1;
            if (childCount[index] != -1) {
                return childCount[index];
            }
            for (Integer i : graph[index]) {
                if (i == p) {
                    continue;
                }
                res += children(i, index);
            }

            return childCount[index] = res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}