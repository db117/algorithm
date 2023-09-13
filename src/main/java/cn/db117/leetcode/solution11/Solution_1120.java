

//给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。 
//
// 子树是树中的任意节点和它的所有后代构成的集合。 
//
// 树的平均值是树中节点值的总和除以节点数。 
//
// 
//
// 示例： 
//
// 
//
// 输入：[5,6,1]
//输出：6.00000
//解释： 
//以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
//以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
//以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
//所以答案取最大值 6。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 到 5000之间。 
// 每个节点的值介于 0 到 100000 之间。 
// 如果结果与标准答案的误差不超过 10^-5，那么该结果将被视为正确答案。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 66 👎 0


package cn.db117.leetcode.solution11;

import cn.db117.leetcode.util.TreeNode;

/**
 * 1120.子树的最大平均值.maximum-average-subtree
 *
 * @author db117
 * @since 2023-09-13 11:21:38
 **/

public class Solution_1120 {
    public static void main(String[] args) {
        Solution solution = new Solution_1120().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        double ans = 0;

        public double maximumAverageSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            int sum = left[0] + right[0] + root.val;
            int count = left[1] + right[1] + 1;

            ans = Math.max(ans, sum * 1.0 / count);

            return new int[]{sum, count};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}