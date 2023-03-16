

//给出两棵二叉搜索树的根节点 
// root1 和
// root2 ，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。 
//
// 如果可以找到返回 True，否则返回 False。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
//输出：true
//解释：2 加 3 和为 5 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
//输出：false 
//
// 
//
// 提示： 
//
// 
// 每棵树上节点数在
// [1, 5000] 范围内。
// 
// -10⁹ <= Node.val, target <= 10⁹ 
// 
//
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二分查找 二叉树 👍 46 👎 0


package cn.db117.leetcode.solution2;

import cn.db117.leetcode.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1214.查找两棵二叉搜索树之和.two-sum-bsts
 *
 * @author db117
 * @since 2023-03-16 15:58:46
 **/

public class Solution_1214 {
    public static void main(String[] args) {
        Solution solution = new Solution_1214().new Solution();
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
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            Set<Integer> set = new HashSet<>();
            // 找到所有数字
            find(root1, set);
            // 校验是否存在
            return check(root2, set, target);
        }

        public void find(TreeNode root, Set<Integer> set) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            find(root.left, set);
            find(root.right, set);
        }

        public boolean check(TreeNode root, Set<Integer> set, int target) {
            if (root == null) {
                return false;
            }
            if (set.contains(target - root.val)) {
                return true;
            }
            // 找左右子节点
            return check(root.left, set, target) || check(root.right, set, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}