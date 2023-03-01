

//给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。 
//
// 你可以按下面的步骤翻转一棵二叉树： 
//
// 
// 原来的左子节点变成新的根节点 
// 原来的根节点变成新的右子节点 
// 原来的右子节点变成新的左子节点 
// 
// 
// 上面的步骤逐层进行。题目数据保证每个右节点都有一个同级节点（即共享同一父节点的左节点）且不存在子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：[4,5,2,null,null,3,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 10] 内 
// 1 <= Node.val <= 10 
// 树中的每个右节点都有一个同级节点（即共享同一父节点的左节点） 
// 树中的每个右节点都没有子节点 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 120 👎 0


package cn.db117.leetcode.solution1;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

/**
 * 156.上下翻转二叉树.binary-tree-upside-down
 *
 * @author db117
 * @since 2023-03-01 11:05:35
 **/

public class Solution_156 {
    public static void main(String[] args) {
        Solution solution = new Solution_156().new Solution();
        TreeNodeUtil.print(solution.upsideDownBinaryTree(TreeNodeUtil.build("[1,2,3,4,5]")));
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
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            return helper(root, root.left, root.right);
        }

        public TreeNode helper(TreeNode root, TreeNode left, TreeNode right) {
            if (root == null) {
                return null;
            }
            if (left == null) {
                return root;
            }
            // 先处理左子节点
            TreeNode ans = helper(left, left.left, left.right);
            // 交换节点
            left.left = right;
            left.right = root;
            // 置空当前节点，防止循环
            root.left = null;
            root.right = null;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}