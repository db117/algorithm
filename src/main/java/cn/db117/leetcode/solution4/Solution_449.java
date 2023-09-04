

//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 451 👎 0


package cn.db117.leetcode.solution4;

import cn.db117.leetcode.util.TreeNode;

/**
 * 449.序列化和反序列化二叉搜索树.serialize-and-deserialize-bst
 *
 * @author db117
 * @since 2023-09-04 10:31:48
 **/

public class Solution_449 {
    public static void main(String[] args) {
        Codec solution = new Solution_449().new Codec();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            dfs(sb, root);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void dfs(StringBuilder sb, TreeNode root) {
            if (root == null) {
                return;
            }
            sb.append(root.val).append(",");
            dfs(sb, root.left);
            dfs(sb, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] s = data.split(",");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            return helper(arr, 0, arr.length - 1);
        }


        private TreeNode helper(int[] split, int left, int right) {
            if (left > right) {
                return null;
            }
            TreeNode root = new TreeNode(split[left]);
            if (left == right) {
                return root;
            }
            // 找到中间节点,左边的都是左子树,右边的都是右子树
            int mid = -1;
            for (int i = left + 1; i <= right; i++) {
                if (split[i] > split[left]) {
                    mid = i;
                    break;
                }
            }
            if (mid == -1) {
                // 没有右子树
                mid = right + 1;
            }
            // 递归构建
            root.left = helper(split, left + 1, mid - 1);
            root.right = helper(split, mid, right);

            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}