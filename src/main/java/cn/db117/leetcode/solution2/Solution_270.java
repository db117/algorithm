

//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 111 👎 0


package cn.db117.leetcode.solution2;

import cn.db117.leetcode.util.TreeNode;

/**
 * 270.最接近的二叉搜索树值.closest-binary-search-tree-value
 *
 * @author db117
 * @since 2022-03-28 10:52:03
 **/

public class Solution_270 {
    public static void main(String[] args) {
        Solution solution = new Solution_270().new Solution();
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

        public int closestValue(TreeNode root, double target) {
            int[] ans = new int[1];
            double[] min = new double[1];
            min[0] = Double.MAX_VALUE;

            dfs(root, target, min, ans);
            return ans[0];
        }

        private void dfs(TreeNode root, double target, double[] min, int[] ans) {
            if (root == null) {
                return;
            }

            double diff = Math.abs(root.val - target);
            if (diff <= min[0]) {
                min[0] = diff;
                ans[0] = root.val;
            }

            dfs(root.right, target, min, ans);
            dfs(root.left, target, min, ans);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}