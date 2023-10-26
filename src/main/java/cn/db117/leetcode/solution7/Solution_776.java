

//给你一棵二叉搜索树（BST）的根结点 root 和一个整数 target 。请将该树按要求拆分为两个子树：其中一个子树结点的值都必须小于等于给定的目标值；另
//一个子树结点的值都必须大于目标值；树中并非一定要存在值为 target 的结点。 
//
// 除此之外，树中大部分结构都需要保留，也就是说原始树中父节点 p 的任意子节点 c ，假如拆分后它们仍在同一个子树中，那么结点 p 应仍为 c 的父结点。 
//
//
// 返回 两个子树的根结点的数组 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,6,1,3,5,7], target = 2
//输出：[[2,1],[4,3,6,null,null,5,7]]
// 
//
// 示例 2: 
//
// 
//输入: root = [1], target = 1
//输出: [[1],[]]
// 
//
// 
//
// 提示： 
//
// 
// 二叉搜索树节点个数在 [1, 50] 范围内 
// 0 <= Node.val, target <= 1000 
// 
//
// Related Topics 树 二叉搜索树 递归 二叉树 👍 125 👎 0


package cn.db117.leetcode.solution7;

import cn.db117.leetcode.util.TreeNode;

/**
 * 776.拆分二叉搜索树.split-bst
 *
 * @author db117
 * @since 2023-10-26 10:13:42
 **/

public class Solution_776 {
    public static void main(String[] args) {
        Solution solution = new Solution_776().new Solution();
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


        public TreeNode[] splitBST(TreeNode root, int target) {
            if (root == null) {
                return new TreeNode[]{null, null};
            }
            // 把每个节点都当成根节点,进行切割
            // 小于等于的放左边,大于的放右边
            // 上层进行合并
            if (root.val == target) {
                // 找到了
                TreeNode right = root.right;
                root.right = null;
                return new TreeNode[]{root, right};
            }

            if (root.val < target) {
                // 右边找
                TreeNode[] split = splitBST(root.right, target);
                root.right = split[0];
                return new TreeNode[]{root, split[1]};
            }
            // 左边找
            TreeNode[] split = splitBST(root.left, target);
            root.left = split[1];
            return new TreeNode[]{split[0], root};
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}