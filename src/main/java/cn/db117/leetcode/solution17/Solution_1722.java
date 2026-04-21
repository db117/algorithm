package cn.db117.leetcode.solution17;
//给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] =
//[ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指
//向的元素。 
//
// 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[
//i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。 
//
// 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。 
//
// 
//
// 示例 1： 
//
// 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//输出：1
//解释：source 可以按下述方式转换：
//- 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
//- 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
//source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
// 
//
// 示例 2： 
//
// 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//输出：2
//解释：不能对 source 执行交换操作。
//source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。 
//
// 示例 3： 
//
// 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1
//,3],[1,4]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == source.length == target.length 
// 1 <= n <= 10⁵ 
// 1 <= source[i], target[i] <= 10⁵ 
// 0 <= allowedSwaps.length <= 10⁵ 
// allowedSwaps[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 
//
// Related Topics 深度优先搜索 并查集 数组 👍 96 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        // 建图
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : allowedSwaps) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        int ans = 0;
        Set<Integer> visited = new HashSet<>();// 访问过的
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Map<Integer, Integer> diff = new HashMap<>();
                dfs(i, source, target, g, diff, visited);
                for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
                    ans += Math.abs(entry.getValue());
                }
            }
        }
        return ans / 2;// 记录的所有不同的，需要减去
    }

    void dfs(int i, int[] source, int[] target,
             List<Integer>[] edges,
             Map<Integer, Integer> diff,
             Set<Integer> visited) {
        if (!visited.add(i)) {
            return;
        }

        // 记录不同的数量
        diff.merge(source[i], 1, Integer::sum);
        diff.merge(target[i], -1, Integer::sum);
        for (int edge : edges[i]) {
            if (!visited.contains(edge)) {
                dfs(edge, source, target, edges, diff, visited);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
