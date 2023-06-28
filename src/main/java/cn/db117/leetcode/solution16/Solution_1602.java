

//给定一棵二叉树的根节点 root 和树中的一个节点 u ，返回与 u 所在层中距离最近的右侧节点，当 u 是所在层中最右侧的节点，返回 null 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,null,4,5,6], u = 4
//输出：5
//解释：节点 4 所在层中，最近的右侧节点是节点 5。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [3,null,4,2], u = 2
//输出：null
//解释：2 的右侧没有节点。
// 
//
// 示例 3： 
//
// 
//输入：root = [1], u = 1
//输出：null
// 
//
// 示例 4： 
//
// 
//输入：root = [3,4,2,null,null,null,1], u = 4
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树中节点个数的范围是 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁵ 
// 树中所有节点的值是唯一的。 
// u 是以 root 为根的二叉树的一个节点。 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 12 👎 0


package cn.db117.leetcode.solution16;

import cn.db117.leetcode.util.TreeNode;

/**
 * 1602.找到二叉树中最近的右侧节点.find-nearest-right-node-in-binary-tree
 *
 * @author db117
 * @since 2023-06-28 17:09:30
 **/

public class Solution_1602 {
    public static void main(String[] args) {
        Solution solution = new Solution_1602().new Solution();
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
        int uDepth = -1;
        int u;
        TreeNode ans = null;

        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            this.u = u.val;
            dfs(root, 0);
            return ans;
        }

        public void dfs(TreeNode node, int depth) {
            if (node == null || ans != null) {
                return;
            }
            dfs(node.left, depth + 1);

            // 找到了
            if (uDepth == depth) {
                ans = node;
                return;
            }

            // 记录深度
            if (node.val == u) {
                uDepth = depth;
            }


            dfs(node.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}