

//给你一棵二叉树的根节点 root 和一个正整数 k 。 
//
// 树中的 层和 是指 同一层 上节点值的总和。 
//
// 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。 
//
// 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,8,9,2,1,3,7,4,6], k = 2
//输出：13
//解释：树中每一层的层和分别是：
//- Level 1: 5
//- Level 2: 8 + 9 = 17
//- Level 3: 2 + 1 + 3 + 7 = 13
//- Level 4: 4 + 6 = 10
//第 2 大的层和等于 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,null,3], k = 1
//输出：3
//解释：最大的层和是 3 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= 10⁶ 
// 1 <= k <= n 
// 
//
// Related Topics 树 广度优先搜索 二分查找 👍 9 👎 0


package cn.db117.leetcode.solution25;

import cn.db117.leetcode.util.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2583.二叉树中的第 K 大层和.kth-largest-sum-in-a-binary-tree
 *
 * @author db117
 * @since 2023-03-13 10:29:54
 **/

public class Solution_2583 {
    public static void main(String[] args) {
        Solution solution = new Solution_2583().new Solution();
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


        public long kthLargestLevelSum(TreeNode root, int k) {
            long ans = 0;
            PriorityQueue<Long> pq = new PriorityQueue(Comparator.reverseOrder());
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                long cur = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    cur += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                pq.offer(cur);
            }
            if (pq.size() < k) {
                return -1;
            }
            for (int i = 0; i < k - 1; i++) {
                pq.poll();
            }
            return pq.peek();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}