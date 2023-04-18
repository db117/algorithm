

//给定一个二叉树，统计该二叉树数值相同的子树个数。 
//
// 同值子树是指该子树的所有节点都拥有相同的数值。 
//
// 示例： 
//
// 输入: root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//输出: 4
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 113 👎 0


package cn.db117.leetcode.solution2;

import cn.db117.leetcode.util.TreeNode;

/**
 * 250.统计同值子树.count-univalue-subtrees
 *
 * @author db117
 * @since 2023-04-14 14:40:52
 **/

public class Solution_250 {
    public static void main(String[] args) {
        Solution solution = new Solution_250().new Solution();
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
        int ans = 0;

        public int countUnivalSubtrees(TreeNode root) {
            check(root);
            return ans;
        }

        private boolean check(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                ans++;
                return true;
            }

            // 两个节点都是有相同节点的
            boolean check = check(root.left) & check(root.right);
            if (!check) {
                return false;
            }

            // 判断是否和子节点值一样
            if (root.left != null) {
                if (root.val != root.left.val) {
                    return false;
                }
            }
            if (root.right != null) {
                if (root.val != root.right.val) {
                    return false;
                }
            }
            // 子节点都是，而且值还都一样
            ans++;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}