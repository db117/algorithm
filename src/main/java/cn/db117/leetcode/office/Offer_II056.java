


//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 37 👎 0


package cn.db117.leetcode.office;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

/**
 * 剑指 Offer II 056.二叉搜索树中两个节点之和.opLdQZ
 *
 * @author db117
 * @since 2022-07-26 15:22:54
 **/

public class Offer_II056 {
    public static void main(String[] args) {
        Solution solution = new Offer_II056().new Solution();
        // [8,6,10,5,7,9,11]
        //12
        TreeNode build = TreeNodeUtil.build(new Integer[]{8, 6, 10, 5, 7, 9, 11});
        System.out.println(solution.findTarget(build, 12));
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
        TreeNode root;

        public boolean findTarget(TreeNode root, int k) {
            this.root = root;
            return dfs(root, k);
        }

        public boolean dfs(TreeNode node, int k) {
            if (node == null) {
                return false;
            }

            if (dfs(node.left, k)) {
                return true;
            }

            TreeNode find = find(root, k - node.val);
            if (find != null && find.val != node.val) {
                return true;
            }

            return dfs(node.right, k);
        }

        public TreeNode find(TreeNode root, int target) {
            if (root == null) {
                return null;
            }
            if (root.val == target) {
                return root;
            } else if (root.val > target) {
                return find(root.left, target);
            } else {
                return find(root.right, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}