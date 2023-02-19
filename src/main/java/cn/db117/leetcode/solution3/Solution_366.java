

//给你一棵二叉树，请按以下要求的顺序收集它的全部节点： 
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 212 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 366.寻找二叉树的叶子节点.find-leaves-of-binary-tree
 *
 * @author db117
 * @since 2023-02-15 17:45:58
 **/

public class Solution_366 {
    public static void main(String[] args) {
        Solution solution = new Solution_366().new Solution();
        System.out.println(solution.findLeaves(TreeNodeUtil.build("[1,2,3,4,5]")));
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
        private boolean isStop = false;

        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            while (!isStop) {
                // 每一次都找最下面的子节点
                List<Integer> cur = new ArrayList<>();
                helper(cur, root);
                if (!cur.isEmpty()) {
                    ans.add(cur);
                }
            }
            return ans;
        }

        private void helper(List<Integer> cur, TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                cur.add(root.val);
                // 最后一个节点  跟节点
                isStop = true;
                return;
            }
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    cur.add(root.left.val);
                    root.left = null;
                } else {
                    helper(cur, root.left);
                }
            }
            if (root.right != null) {
                if (root.right.left == null && root.right.right == null) {
                    cur.add(root.right.val);
                    root.right = null;
                } else {
                    helper(cur, root.right);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}