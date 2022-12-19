

//给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。 
//
// 如果两个结点在同一行和列，那么顺序则为 从左到右。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,9,8,4,0,1,7]
//输出：[[4],[9],[3,0,1],[8],[7]]
// 
//
// 示例 3： 
// 
// 
//输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
//输出：[[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 201 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 314.二叉树的垂直遍历.binary-tree-vertical-order-traversal
 *
 * @author db117
 * @since 2022-12-19 14:27:07
 **/

public class Solution_314 {
    public static void main(String[] args) {
        Solution solution = new Solution_314().new Solution();
        System.out.println(solution.verticalOrder(TreeNodeUtil.build("[3,9,20,null,null,15,7]")));
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
        public List<List<Integer>> verticalOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> queueCol = new LinkedList<>();
            queue.add(root);
            queueCol.add(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    Integer col = queueCol.poll();
                    map.putIfAbsent(col, new ArrayList<>());
                    map.get(col).add(node.val);

                    if (node.left != null) {
                        queueCol.add(col - 1);
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queueCol.add(col + 1);
                        queue.add(node.right);
                    }
                }
            }

            return new ArrayList<>(map.values());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}