

//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。 
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 186 👎 0


package cn.db117.leetcode.solution10;

import cn.db117.leetcode.util.TreeNode;

/**
 * 1026.节点与其祖先之间的最大差值.maximum-difference-between-node-and-ancestor
 *
 * @author db117
 * @since 2023-04-18 21:43:11
 **/

public class Solution_1026 {
    public static void main(String[] args) {
        Solution solution = new Solution_1026().new Solution();
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

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int[] dfs(TreeNode root) {
            // 最小 最大值
            int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE};
            if (root == null) {
                return arr;
            }
            arr[0] = root.val;
            arr[1] = root.val;
            // 子节点的最小最大值
            int[] leftAns = dfs(root.left);
            int[] rightAns = dfs(root.right);


            arr[0] = Math.min(arr[0], Math.min(leftAns[0], rightAns[0]));
            arr[1] = Math.max(arr[1], Math.max(leftAns[1], rightAns[1]));

            ans = Math.max(ans, Math.max(root.val - arr[0], arr[1] - root.val));
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}