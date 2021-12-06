

//给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 
//startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。 
//
// 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向： 
//
// 
// 'L' 表示从一个节点前往它的 左孩子 节点。 
// 'R' 表示从一个节点前往它的 右孩子 节点。 
// 'U' 表示从一个节点前往它的 父 节点。 
// 
//
// 请你返回从 s 到 t 最短路径 每一步的方向。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//输出："UURL"
//解释：最短路径为：3 → 1 → 5 → 2 → 6 。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [2,1], startValue = 2, destValue = 1
//输出："L"
//解释：最短路径为：2 → 1 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目为 n 。 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= n 
// 树中所有节点的值 互不相同 。 
// 1 <= startValue, destValue <= n 
// startValue != destValue 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 23 👎 0


package cn.db117.leetcode.solution20;

import cn.db117.leetcode.util.TreeNode;

/**
 * 2096.从二叉树一个节点到另一个节点每一步的方向.step-by-step-directions-from-a-binary-tree-node-to-another
 *
 * @author db117
 * @since 2021-12-21 18:30:47
 **/

public class Solution_2096 {
    public static void main(String[] args) {
        Solution solution = new Solution_2096().new Solution();
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

        public String getDirections(TreeNode root, int startValue, int destValue) {
            StringBuilder start = new StringBuilder();
            StringBuilder dest = new StringBuilder();
            // 从跟节点向两个节点开始走
            dfs(root, startValue, start);
            dfs(root, destValue, dest);

            if (start.length() == 0) {
                return dest.toString();
            }

            // 去掉相同的路径
            while (start.length() > 0 && dest.length() > 0) {
                if (start.charAt(0) == dest.charAt(0)) {
                    start.deleteCharAt(0);
                    dest.deleteCharAt(0);
                } else {
                    break;
                }
            }

            if (start.length() == 0) {
                return dest.toString();
            }
            // 从起点到根节点都是 U
            if (dest.length() == 0) {
                return "U".repeat(Math.max(0, start.length()));
            }

            return "U".repeat(start.length()) + dest;
        }

        private boolean dfs(TreeNode root, int v, StringBuilder b) {
            if (root == null) {
                return false;
            }
            if (root.val == v) {
                return true;
            }

            b.append('L');
            if (dfs(root.left, v, b)) {
                return true;
            }
            b.deleteCharAt(b.length() - 1);

            b.append('R');
            if (dfs(root.right, v, b)) {
                return true;
            }
            b.deleteCharAt(b.length() - 1);

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}