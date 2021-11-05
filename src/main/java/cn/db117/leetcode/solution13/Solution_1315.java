

//给你一棵二叉树，请你返回满足以下条件的所有节点的值之和： 
//
// 
// 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。） 
// 
//
// 如果不存在祖父节点值为偶数的节点，那么返回 0 。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：18
//解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 63 👎 0


package cn.db117.leetcode.solution13;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

/**
 * 1315.祖父节点值为偶数的节点和.sum-of-nodes-with-even-valued-grandparent
 *
 * @author db117
 * @since 2021-11-05 18:23:59
 **/

public class Solution_1315 {
    public static void main(String[] args) {
        Solution solution = new Solution_1315().new Solution();
        System.out.println(solution.sumEvenGrandparent(TreeNodeUtil.build(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5})));
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
        public int sumEvenGrandparent(TreeNode root) {

            return helper(root, null, null);
        }

        public int helper(TreeNode cur, TreeNode p, TreeNode pp) {
            if (cur == null) {
                return 0;
            }
            // 一直找到祖父不为 null
            if (p == null || pp == null) {
                return helper(cur.left, cur, p) + helper(cur.right, cur, p);
            }

            int ans = 0;
            if ((pp.val & 1) == 0) {
                ans = cur.val;
            }
            return ans + helper(cur.left, cur, p) + helper(cur.right, cur, p);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}