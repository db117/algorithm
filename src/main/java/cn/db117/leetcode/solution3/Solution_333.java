

//给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。 
//
// 二叉搜索树（BST）中的所有节点都具备以下属性： 
//
// 
// 左子树的值小于其父（根）节点的值。 
// 右子树的值大于其父（根）节点的值。 
// 
//
// 注意：子树必须包含其所有后代。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,15,1,8,null,7]
//输出：3
//解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。 
//
// 示例 2： 
//
// 
//输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树上节点数目的范围是 [0, 10⁴] 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶: 你能想出 O(n) 时间复杂度的解法吗？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 177 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

/**
 * 333.最大二叉搜索子树.largest-bst-subtree
 *
 * @author db117
 * @since 2024-04-26 14:58:55
 **/

public class Solution_333 {
    public static void main(String[] args) {
        Solution solution = new Solution_333().new Solution();
        // [3,2,4,null,null,1]
        TreeNode build = TreeNodeUtil.build("[3,2,4,null,null,1]");
        System.out.println(solution.largestBSTSubtree(build));

        // [10,5,15,1,8,null,7]  3
        System.out.println(solution.largestBSTSubtree(TreeNodeUtil.build("[10,5,15,1,8,null,7]")));
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
        public int largestBSTSubtree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 当前节点是二叉搜索树
            if (check(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                return count(root);
            }
            // 不是二叉搜索树,分别计算左右子树
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }

        // 检查是否是二叉搜索树
        private boolean check(TreeNode root, int min, int max) {
            if (root == null) {
                return true;
            }
            // 当前节点是否符合
            if (root.val <= min || root.val >= max) {
                return false;
            }

            // 左子树是否符合
            return check(root.left, min, root.val) && check(root.right, root.val, max);
        }

        // 统计节点个数
        private int count(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return count(root.left) + count(root.right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}