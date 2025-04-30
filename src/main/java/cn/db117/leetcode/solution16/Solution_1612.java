

//二叉表达式树是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。 叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 个
//子节点的节点）表示运算符。在本题中，我们只考虑 '+' 运算符（即加法）。 
//
// 给定两棵二叉表达式树的根节点 root1 和 root2 。如果两棵二叉表达式树等价，返回 true ，否则返回 false 。 
//
// 当两棵二叉搜索树中的变量取任意值，分别求得的值都相等时，我们称这两棵二叉表达式树是等价的。 
//
// 
//
// 示例 1: 
//
// 
//输入： root1 = [x], root2 = [x]
//输出： true
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,c]
//输出：true
//解释：a + (b + c) == (b + c) + a 
//
// 示例 3: 
//
// 
//
// 
//输入： root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,d]
//输出： false
//解释： a + (b + c) != (b + d) + a
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点个数相等，且节点个数为范围 [1, 4999] 内的奇数。 
// Node.val 是 '+' 或小写英文字母。 
// 给定的树保证是有效的二叉表达式树。 
// 
//
// 
//
// 进阶：当你的答案需同时支持 '-' 运算符（减法）时，你该如何修改你的答案 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 计数 👍 10 👎 0


package cn.db117.leetcode.solution16;

/**
 * 1612.检查两棵二叉表达式树是否等价.check-if-two-expression-trees-are-equivalent
 *
 * @author db117
 * @since 2025-04-30 11:08:22
 **/

public class Solution_1612 {
    public static void main(String[] args) {
        Solution solution = new Solution_1612().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * class Node {
     *     char val;
     *     Node left;
     *     Node right;
     *     Node() {this.val = ' ';}
     *     Node(char val) { this.val = val; }
     *     Node(char val, Node left, Node right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public boolean checkEquivalence(Node root1, Node root2) {
            if (root1 == root2) {
                return true;
            }
            int[] flag1 = new int[26];
            int[] flag2 = new int[26];
            helper(root1, flag1);
            helper(root2, flag2);
            for (int i = 0; i < flag1.length; i++) {
                if (flag1[i] != flag2[i]) {
                    return false;
                }
            }

            return true;
        }

        void helper(Node root, int[] flag) {
            if (root == null) {
                return;
            }
            if (root.val >= 'a' && root.val <= 'z') {
                flag[root.val - 'a']++;
                return;
            }
            helper(root.left, flag);
            helper(root.right, flag);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}