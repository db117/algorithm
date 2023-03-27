

//你有一棵二叉树，这棵二叉树有个小问题，其中有且只有一个无效节点，它的右子节点错误地指向了与其在同一层且在其右侧的一个其他节点。 
//
// 给定一棵这样的问题二叉树的根节点 root ，将该无效节点及其所有子节点移除（除被错误指向的节点外），然后返回新二叉树的根结点。 
//
// 自定义测试用例： 
//
// 测试用例的输入由三行组成： 
//
// 
// TreeNode root 
// int fromNode （在 correctBinaryTree 中不可见） 
// int toNode （在 correctBinaryTree 中不可见） 
// 
//
// 当以 root 为根的二叉树被解析后，值为 fromNode 的节点 TreeNode 将其右子节点指向值为 toNode 的节点 TreeNode 。然
//后， root 传入 correctBinaryTree 的参数中。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [1,2,3], fromNode = 2, toNode = 3
//输出: [1,null,3]
//解释: 值为 2 的节点是无效的，所以移除之。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [8,3,1,7,null,9,4,2,null,null,null,5,6], fromNode = 7, toNode = 4
//输出: [8,3,1,null,null,9,4,null,null,5,6]
//解释: 值为 7 的节点是无效的，所以移除这个节点及其子节点 2。
// 
//
// 
//
// 提示: 
//
// 
// 树中节点个数的范围是 [3, 10⁴] 。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有的 Node.val 都是互不相同的。 
// fromNode != toNode 
// fromNode 和 toNode 将出现在树中的同一层。 
// toNode 在 fromNode 的右侧。 
// fromNode.right 在测试用例的树中建立后为 null 。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 11 👎 0


package cn.db117.leetcode.solution16;

import cn.db117.leetcode.util.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1660.纠正二叉树.correct-a-binary-tree
 *
 * @author db117
 * @since 2023-03-27 15:55:57
 **/

public class Solution_1660 {
    public static void main(String[] args) {
        Solution solution = new Solution_1660().new Solution();
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
        public TreeNode correctBinaryTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> set = new HashSet<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                // 一层层的找
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.right != null) {
                        if (cur.right.right != null && set.contains(cur.right.right)) {
                            // 如果当前子节点的右节点已经存在，则说明是异常节点
                            cur.right = null;
                            return root;
                        }
                        // 把当前节点记录下来
                        set.add(cur.right);
                        queue.offer(cur.right);
                    }
                    if (cur.left != null) {
                        if (cur.left.right != null && set.contains(cur.left.right)) {
                            cur.left = null;
                            return root;
                        }
                        set.add(cur.left);
                        queue.offer(cur.left);
                    }
                }
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}