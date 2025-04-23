

//你需要用一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的 0 、1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在子结点，则从左子结点开始构建。 
//
// 
//
// 示例 1: 
// 
// 
//输入： s = "4(2(3)(1))(6(5))"
//输出： [4,2,6,3,1,5]
// 
//
// 示例 2: 
//
// 
//输入： s = "4(2(3)(1))(6(5)(7))"
//输出： [4,2,6,3,1,5,7]
// 
//
// 示例 3: 
//
// 
//输入： s = "-4(2(3)(1))(6(5)(7))"
//输出： [-4,2,6,3,1,5,7]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 树中所有数字的值 最多 不超过 2³⁰。 
// 
//
// Related Topics 栈 树 深度优先搜索 字符串 二叉树 👍 121 👎 0


package cn.db117.leetcode.solution5;

/**
 * 536.从字符串生成二叉树.construct-binary-tree-from-string
 *
 * @author db117
 * @since 2025-04-22 19:18:04
 **/

public class Solution_536 {
    public static void main(String[] args) {
        Solution solution = new Solution_536().new Solution();
        // -4(2(3)(1))(6(5)(7))
        System.out.println(solution.str2tree("-4(2(3)(1))(6(5)(7))"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        char[] chars;
        int i = 0;

        public TreeNode str2tree(String s) {
            chars = s.toCharArray();
            return help();
        }

        TreeNode help() {
            if (i >= chars.length) {
                return null;
            }
            // 符号
            int sign = 1;
            if (chars[i] == '-') {
                sign = -1;
                i++;
            }
            // 数字
            int cur = 0;
            while (i < chars.length && chars[i] >= '0') {
                cur *= 10;
                cur += chars[i] - '0';
                i++;
            }
            cur *= sign;
            TreeNode node = new TreeNode(cur);

            // 左右子树
            if (i < chars.length && chars[i] == '(') {
                i++;// 跳过左括号
                node.left = help();
            }
            if (i < chars.length && chars[i] == '(') {
                i++;
                node.right = help();
            }
            i++;// 跳过右括号
            return node;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}