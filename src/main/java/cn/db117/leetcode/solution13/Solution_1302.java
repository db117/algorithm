

//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 68 👎 0


package cn.db117.leetcode.solution13;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302.层数最深叶子节点的和.deepest-leaves-sum
 *
 * @author db117
 * @since 2021-11-05 17:04:02
 **/

public class Solution_1302 {
    public static void main(String[] args) {
        Solution solution = new Solution_1302().new Solution();
        System.out.println(solution.deepestLeavesSum(TreeNodeUtil.build(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8})));
        System.out.println(solution.deepestLeavesSum(TreeNodeUtil.build(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5})));
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
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 广度优先
            while (!queue.isEmpty()) {
                // 是否有下一层
                boolean flag = false;
                int cur = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    cur += poll.val;
                    if (poll.left != null) {
                        queue.offer(poll.left);
                        flag = true;
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                        flag = true;
                    }
                }
                if (!flag) {
                    return cur;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}