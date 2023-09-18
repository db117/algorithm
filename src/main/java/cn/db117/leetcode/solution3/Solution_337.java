

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1817 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337.打家劫舍 III.house-robber-iii
 *
 * @author db117
 * @since 2023-09-18 11:10:17
 **/

public class Solution_337 {
    public static void main(String[] args) {
        Solution solution = new Solution_337().new Solution();
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
        Map<TreeNode, Integer> map = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 记忆化
            Integer i = map.get(root);
            if (i != null) {
                return i;
            }

            // 根节点偷则不能偷子节点
            int in = root.val;
            if (root.left != null) {
                // 加上子节点的子节点的最大值
                in += rob(root.left.left);
                in += rob(root.left.right);
            }
            if (root.right != null) {
                in += rob(root.right.left);
                in += rob(root.right.right);
            }
            // 不偷根节点
            int notIn = rob(root.left) + rob(root.right);

            // 返回最大的
            int ans = Math.max(in, notIn);
            map.put(root, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}