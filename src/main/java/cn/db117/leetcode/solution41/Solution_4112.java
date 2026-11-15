

//给你一个长度为 n 的整数数组 parent，表示一棵节点编号从 0 到 n - 1 的有根树，其中 parent[i] 表示节点 i 的父节点。树的根节点
//为节点 0，因此 parent[0] = -1。 
//
// 另给你两个长度均为 n 的整数数组 op 和 score，其中 op[i] 决定节点 i 允许执行的操作，score[i] 表示该节点的分数。 
//
// 你需要按照以下规则处理每个 非叶节点 i： 
//
// 
// 如果 op[i] = 0，你可以选择节点 i 的 至多 一个子节点，并将以该子节点为根的 子树 中所有节点的分数设为 0。 
// 如果 op[i] = 1，你必须选择节点 i 的 恰好 一个子节点，并将以该子节点为根的子树中所有节点的分数设为 0。 
// 
//
// 每个非叶节点都必须恰好处理一次。你可以按任意顺序处理这些节点。 
//
// 返回执行这些操作后，所有节点分数之和的 最大可能值。 
//
// 叶节点 是没有子节点的节点。 
//
// 以某个节点为根的 子树 由该节点及其所有后代节点组成。 
//
// 
//
// 示例 1： 
//
// 
// 
// 
//
// 输入： parent = [-1,0,0,0,1,2,3,3], op = [1,1,0,0,1,1,0,1], score = [5,6,1,2,3,2
//,3,-3] 
//
// 输出： 16 
//
// 解释： 
//
// 一种最优方案是按以下顺序处理节点： 
//
// 
// 节点 4、5、6 和 7：它们都是叶节点，因此不对它们执行任何操作。 
// 节点 1：由于 op[1] = 1，我们必须选择它的一个子节点。选择节点 4，将以它为根的子树中所有节点（节点 4）的分数设为 0。 
// 节点 2：由于 op[2] = 0，我们可以选择一个子节点，也可以不执行任何操作。对于该节点，我们不执行任何操作。 
// 节点 3：由于 op[3] = 0，我们可以选择一个子节点，也可以不执行任何操作。选择节点 7，将以它为根的子树中所有节点（节点 7）的分数设为 0。 
// 节点 0：由于 op[0] = 1，我们必须选择它的一个子节点。选择节点 2，将以它为根的子树中所有节点（节点 2 和 5）的分数设为 0。 
// 
//
// 执行这些操作后，各节点的分数为 [5, 6, 0, 2, 0, 0, 3, 0]，总和为 16。 
//
// 不存在能够得到更大分数总和的合法操作序列。因此，答案为 16。 
//
//
// 示例 2： 
//
// 
// 
// 
//
// 输入： parent = [-1,0,0], op = [0,0,0], score = [1,2,3] 
//
// 输出： 6 
//
// 解释： 
//
// 
// 我们只需要处理节点 0，因为节点 1 和节点 2 都是叶节点。 
// 由于 op[0] = 0，我们可以选择不执行任何操作。 
// 因此，所有节点的分数都得以保留，得到的最大分数总和为 6。 
// 
//
//
// 示例 3： 
//
// 
// 
// 
//
// 输入： parent = [-1], op = [1], score = [-10] 
//
// 输出： -10 
//
// 解释： 
//
// 
// 树中唯一的节点是叶节点，因此无法对任何节点执行操作。 
// 因此，最大分数总和为 -10。 
// 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// n == parent.length == op.length == score.length 
// parent[0] == -1 
// 对于所有 i 在 [1, n - 1] 范围内，均有 0 <= parent[i] <= n - 1 
// 0 <= op[i] <= 1 
// -10⁴ <= score[i] <= 10⁴ 
// 输入保证数组 parent 表示一棵以节点 0 为根的合法树。 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution41;

import java.util.ArrayList;
import java.util.List;

/**
 * 4112.将子树置零后的最大得分.maximize-score-after-zeroing-subtrees
 *
 * @author db117
 * @since 2026-11-15 15:40:11
 **/

public class Solution_4112 {
    public static void main(String[] args) {
        Solution solution = new Solution_4112().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] children;
        int[] op;
        int[] score;
        long[] memo;
        boolean[] vis;

        public int maxScore(int[] parent, int[] op, int[] score) {
            int n = parent.length;

            this.op = op;
            this.score = score;
            children = new ArrayList[n];
            memo = new long[n];
            vis = new boolean[n];

            for (int i = 0; i < n; i++) {
                children[i] = new ArrayList<>();
            }

            for (int i = 1; i < n; i++) {
                children[parent[i]].add(i);
            }

            return (int) dfs(0);
        }

        // 计算以i为根的最大分数
        long dfs(int i) {
            if (vis[i]) {
                return memo[i];
            }
            vis[i] = true;
            List<Integer> child = children[i];
            if (child.isEmpty()) {
                return memo[i] = score[i];
            }
            long sum = score[i];
            long min = Long.MAX_VALUE;// 只需要记录最小值
            for (Integer integer : child) {
                long s = dfs(integer);
                sum += s;
                min = Math.min(min, s);
            }

            if (op[i] == 1) {
                // 必须减去最小值
                memo[i] = sum - min;
            } else {
                // 如果最小值小于0，则减去最小值
                memo[i] = sum - Math.min(0, min);
            }
            return memo[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}