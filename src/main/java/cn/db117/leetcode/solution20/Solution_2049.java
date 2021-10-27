

//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 5 👎 0


package cn.db117.leetcode.solution20;

import java.util.HashMap;
import java.util.Map;

/**
 * 2049.统计最高分的节点数目.count-nodes-with-the-highest-score
 *
 * @author db117
 * @since 2021-10-27 15:03:04
 **/

public class Solution_2049 {
    public static void main(String[] args) {
        Solution solution = new Solution_2049().new Solution();
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 2, 0}));
        System.out.println(solution.countHighestScoreNodes(new int[]{-1, 0, 3, 0, 3, 1}));// 1
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countHighestScoreNodes(int[] parents) {
            // 父节点 -》子节点 用高低位来保存两个子节点
            Map<Integer, Long> tree = new HashMap<>();
            // 缓存每一个节点包含子节点的数量
            int[] cache = new int[parents.length];
            // 构建树
            for (int i = 1; i < parents.length; i++) {
                int parent = parents[i];
                Long child = tree.get(parent);
                if (child == null) {
                    tree.put(parent, (long) i);
                } else {
                    tree.put(parent, child * Integer.MAX_VALUE + i);
                }
            }
            long max = -1;
            int count = 1;

            for (int i = 0; i < parents.length; i++) {
                // 每一个都算一遍
                long cur = helper(i, tree, cache);
                if (max == cur) {
                    count++;
                } else if (max < cur) {
                    count = 1;
                    max = cur;
                }
            }
            return count;
        }

        /**
         * 计算三部分
         * 两个子节点
         * 整个树，除了自己的
         */
        private long helper(int cur, Map<Integer, Long> tree, int[] cache) {
            long ans = 1;
            // 整个树减去自身
            if (cur != 0) {
                ans *= cache.length - count(cur, tree, cache);
            }
            Long child = tree.get(cur);
            if (child != null) {
                // 子节点
                ans *= count((int) (child % Integer.MAX_VALUE), tree, cache);
                if (child > Integer.MAX_VALUE) {
                    ans *= count((int) (child / Integer.MAX_VALUE), tree, cache);
                }
            }

            return ans;
        }

        /**
         * 统计
         *
         * @param parent 父
         * @param tree   树
         * @param cache  缓存
         * @return int
         */
        public int count(int parent, Map<Integer, Long> tree, int[] cache) {
            if (cache[parent] != 0) {
                return cache[parent];
            }

            int ans = 1;
            Long childs = tree.get(parent);
            if (childs != null) {
                // 找子节点
                ans += count((int) (childs % Integer.MAX_VALUE), tree, cache);
                if (childs > Integer.MAX_VALUE) {
                    // 如果有另一个子节点
                    ans += count((int) (childs / Integer.MAX_VALUE), tree, cache);
                }
            }

            // 缓存
            cache[parent] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}