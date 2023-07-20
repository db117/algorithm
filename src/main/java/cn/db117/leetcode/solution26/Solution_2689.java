

//给定一个二叉树的根节点 root 和整数 k。除了左右孩子之外，该树的每个节点还有另外两个属性：一个仅包含小写英文字母（可能为空）的 字符串 node.
//val 和一个非负整数 node.len。这棵树中有两种类型的节点： 
//
// 
// 叶子节点：这些节点没有子节点，node.len = 0，node.val 是一个 非空 字符串。 
// 内部节点：这些节点至少有一个子节点（最多两个子节点），node.len > 0，node.val 是一个 空 字符串。 
// 
//
// 上述描述的树被称为 Rope 二叉树。现在我们用以下递归方式定义 S[node]： 
//
// 
// 如果 node 是一个叶子节点，则 S[node] = node.val， 
// 否则，如果 node 是一个内部节点，则 S[node] = concat(S[node.left], S[node.right])，且 S[node].
//length = node.len。 
// 
//
// 返回字符串 S[root] 的第 k 个字符。 
//
// 注意：如果 s 和 p 是两个字符串，则 concat(s, p) 是将字符串 p 连接到 s 后面的字符串。例如，concat("ab", "zz") 
//= "abzz"。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [10,4,"abcpoe","g","rta"], k = 6
//输出："b"
//解释：在下面的图片中，我们在内部节点上放置一个表示 node.len 的整数，在叶子节点上放置一个表示 node.val 的字符串。 你可以看到，S[
//root] = concat(concat("g", "rta"), "abcpoe") = "grtaabcpoe"。因此，S[root][5]，表示它的第6个字符
//，等于 "b"。
// 
//
// 
//
// 示例 2： 
//
// 
//输入：root = [12,6,6,"abc","efg","hij","klm"], k = 3
//输出："c"
//解释：在下面的图片中，我们在内部节点上放置一个表示 node.len 的整数，在叶子节点上放置一个表示 node.val 的字符串。 你可以看到，S[
//root] = concat(concat("abc", "efg"), concat("hij", "klm")) = "abcefghijklm"。因此，S[
//root][2]，表示它的第3个字符，等于 "c"。
// 
//
// 
//
// 示例 3： 
//
// 
//输入：root = ["ropetree"], k = 8
//输出："e"
//解释：在下面的图片中，我们在内部节点上放置一个表示 node.len 的整数，在叶子节点上放置一个表示 node.val 的字符串。 你可以看到，S[
//root] = "ropetree"。因此，S[root][7]，表示它的第8个字符，等于 "e"。
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 这棵树的节点数量在区间 [1, 10³] 
// node.val 仅包含小写英文字母 
// 0 <= node.val.length <= 50 
// 0 <= node.len <= 10⁴ 
// 对于叶子节点， node.len = 0 且 node.val 是非空的 
// 对于内部节点， node.len > 0 且 node.val 为空 
// 1 <= k <= S[root].length 
// 
//
// Related Topics 树 深度优先搜索 👍 0 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2689.从 Rope 树中提取第 K 个字符.extract-kth-character-from-the-rope-tree
 *
 * @author db117
 * @since 2023-07-20 10:58:24
 **/

public class Solution_2689 {
    public static void main(String[] args) {
        Solution solution = new Solution_2689().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public char getKthCharacter(RopeTreeNode root, int k) {
            if (root == null) {
                return ' ';
            }
            if (root.len == 0) {
                // 叶子节点
                return root.val.charAt(k - 1);
            }

            // 左子树长度
            int leftLen = 0;
            RopeTreeNode left = root.left;
            if (left != null) {
                leftLen = left.len == 0 ? left.val.length() : left.len;
            }
            if (k <= leftLen) {
                // 在左子树
                return getKthCharacter(left, k);
            } else {
                // 在右子树
                return getKthCharacter(root.right, k - leftLen);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        RopeTreeNode() {
        }

        RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

    }

}