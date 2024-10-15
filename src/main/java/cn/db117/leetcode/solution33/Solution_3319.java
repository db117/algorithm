

//给你一棵 二叉树 的根节点 root 和一个整数k。 
//
// 返回第 k 大的 完美二叉子树 的大小，如果不存在则返回 -1。 
//
// 完美二叉树 是指所有叶子节点都在同一层级的树，且每个父节点恰有两个子节点。 
//
// 子树 是指树中的某一个节点及其所有后代形成的树。 
//
// 
//
// 示例 1： 
//
// 
// 输入： root = [5,3,6,5,2,5,7,1,8,null,null,6,8], k = 2 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
//
// 完美二叉子树的根节点在图中以黑色突出显示。它们的大小按降序排列为 [3, 3, 1, 1, 1, 1, 1, 1]。 第 2 大的完美二叉子树的大小是 3
//。 
//
// 示例 2： 
//
// 
// 输入： root = [1,2,3,4,5,6,7], k = 1 
// 
//
// 输出： 7 
//
// 解释： 
//
// 
//
// 完美二叉子树的大小按降序排列为 [7, 3, 3, 1, 1, 1, 1]。最大的完美二叉子树的大小是 7。 
//
// 示例 3： 
//
// 
// 输入： root = [1,2,3,null,4], k = 3 
// 
//
// 输出： -1 
//
// 解释： 
//
// 
//
// 完美二叉子树的大小按降序排列为 [1, 1]。完美二叉子树的数量少于 3。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数目在 [1, 2000] 范围内。 
// 1 <= Node.val <= 2000 
// 1 <= k <= 1024 
// 
//
// Related Topics 树 深度优先搜索 二叉树 排序 👍 0 👎 0


package cn.db117.leetcode.solution33;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.PriorityQueue;

/**
 * 3319.第 K 大的完美二叉子树的大小.k-th-largest-perfect-subtree-size-in-binary-tree
 *
 * @author db117
 * @since 2024-10-15 10:26:25
 **/

public class Solution_3319 {
    public static void main(String[] args) {
        Solution solution = new Solution_3319().new Solution();
        // [5,3,6,5,2,5,7,1,8,null,null,6,8]
        //			2
//        System.out.println(solution.kthLargestPerfectSubtree(TreeNodeUtil.build(new Integer[]{5, 3, 6, 5, 2, 5, 7, 1, 8, null, null, 6, 8}), 2));

        // [1,2,3,null,4]
        //			3
        System.out.println(solution.kthLargestPerfectSubtree(TreeNodeUtil.build(new Integer[]{1, 2, 3, null, 4}), 3));
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
        private PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public int kthLargestPerfectSubtree(TreeNode root, int k) {
            dfs(root);
            // 不够k个
            if (pq.size() < k) {
                return -1;
            }
            // 弹出k-1个
            for (int i = 0; i < k - 1; i++) {
                pq.poll();
            }
            return pq.poll();
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);
            // 不是完美二叉树
            if (left == -1 || right == -1) {
                return -1;
            }
            if (left == right) {
                int ans = left + right + 1;
                pq.offer(ans);
                return ans;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}