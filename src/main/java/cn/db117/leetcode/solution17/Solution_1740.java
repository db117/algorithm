

//给定一棵二叉树的根节点 root 以及两个整数 p 和 q ，返回该二叉树中值为 p 的结点与值为 q 的结点间的 距离 。 
//
// 两个结点间的 距离 就是从一个结点到另一个结点的路径上边的数目。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
//输出：3
//解释：在 5 和 0 之间有 3 条边：5-3-1-0 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
//输出：2
//解释：在 5 和 7 之间有 2 条边：5-2-7 
//
// 示例 3： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
//输出：0
//解释：一个结点与它本身之间的距离为 0 
//
// 
//
// 提示： 
//
// 
// 树中结点个数的范围在 [1, 10⁴]. 
// 0 <= Node.val <= 10⁹ 
// 树中所有结点的值都是唯一的. 
// p 和q 是树中结点的值. 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 20 👎 0


package cn.db117.leetcode.solution17;

import cn.db117.leetcode.util.TreeNode;

/**
 * 1740.找到二叉树中的距离.find-distance-in-a-binary-tree
 *
 * @author db117
 * @since 2023-03-10 17:36:43
 **/

public class Solution_1740 {
    public static void main(String[] args) {
        Solution solution = new Solution_1740().new Solution();
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
        int p, q;
        TreeNode father;

        public int findDistance(TreeNode root, int p, int q) {
            if (p == q) {
                return 0;
            }
            this.p = p;
            this.q = q;
            // 找共同父节点
            father(root);
            // 找到共同父节点的距离
            return find(father, p, 0) + find(father, q, 0);
        }

        public int father(TreeNode root) {
            if (root == null || father != null) {
                return 0;
            }
            int ans = 0;
            ans += father(root.left);
            ans += father(root.right);

            if (root.val == p || root.val == q) {
                ans++;
            }
            // 第一次找到两个点
            if (father == null && ans == 2) {
                father = root;
            }
            return ans;
        }

        public int find(TreeNode root, int num, int deep) {
            if (root == null) {
                return -1;
            }
            if (root.val == num) {
                return deep;
            }
            int l = find(root.left, num, deep + 1);
            if (l != -1) {
                return l;
            }
            return find(root.right, num, deep + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}