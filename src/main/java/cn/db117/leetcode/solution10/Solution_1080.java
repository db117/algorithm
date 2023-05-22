

//给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。 
//
// 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。 
//
// 叶子节点，就是没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//输出：[1,2,3,4,null,null,7,8,9,null,14]
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//输出：[5,4,8,11,null,17,4,7,null,null,null,5]
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,2,-3,-5,null,4,null], limit = -1
//输出：[1,null,-3,4]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 5000] 内 
// -10⁵ <= Node.val <= 10⁵ 
// -10⁹ <= limit <= 10⁹ 
// 
//
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 121 👎 0


package cn.db117.leetcode.solution10;

import cn.db117.leetcode.util.TreeNode;

/**
 * 1080.根到叶路径上的不足节点.insufficient-nodes-in-root-to-leaf-paths
 *
 * @author db117
 * @since 2023-05-22 11:27:36
 **/

public class Solution_1080 {
    public static void main(String[] args) {
        Solution solution = new Solution_1080().new Solution();
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
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            boolean dfs = dfs(root, limit, 0);
            if (dfs) {
                return null;
            }
            return root;
        }

        private boolean dfs(TreeNode node, int limit, int sum) {
            if (node == null) {
                return true;
            }
            if (node.right == null && node.left == null) {
                // 当前叶子节点
                return sum + node.val < limit;
            }


            boolean left = dfs(node.left, limit, sum + node.val);
            boolean right = dfs(node.right, limit, sum + node.val);

            // 删除掉不合格的节点
            if (left) {
                node.left = null;
            }
            if (right) {
                node.right = null;
            }

            // 子节点都被删了，当前节点继续删
            return left && right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}