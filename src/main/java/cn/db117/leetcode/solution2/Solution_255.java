

//给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: preorder = [5,2,1,3,6]
//输出: true 
//
// 示例 2： 
//
// 
//输入: preorder = [5,2,6,1,3]
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 10⁴ 
// 1 <= preorder[i] <= 10⁴ 
// preorder 中 无重复元素 
// 
//
// 
//
// 进阶：您能否使用恒定的空间复杂度来完成此题？ 
//
// Related Topics 栈 树 二叉搜索树 递归 数组 二叉树 单调栈 👍 199 👎 0


package cn.db117.leetcode.solution2;

/**
 * 255.验证二叉搜索树的前序遍历序列.verify-preorder-sequence-in-binary-search-tree
 *
 * @author db117
 * @since 2024-03-20 20:47:28
 **/

public class Solution_255 {
    public static void main(String[] args) {
        Solution solution = new Solution_255().new Solution();
        // [5,2,1,3,6]
        System.out.println(solution.verifyPreorder(new int[]{
                5, 2, 1, 3, 6
        }));

        // [2,1]
        System.out.println(solution.verifyPreorder(new int[]{
                2, 1
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            return help(preorder, 0, preorder.length - 1);
        }

        private boolean help(int[] preorder, int left, int right) {
            if (left >= right) {
                return true;
            }
            // 找到左右子树的分界点(第一个大于根节点的节点)
            int mid = left + 1;
            int root = preorder[left];
            while (mid <= right && preorder[mid] < root) {
                // 找到第一个大于根节点的
                mid++;
            }

            // 判断右子树是否都大于根节点
            for (int i = mid; i <= right; i++) {
                if (preorder[i] < root) {
                    return false;
                }
            }

            // 递归判断左右子树
            return help(preorder, left + 1, mid - 1)
                    && help(preorder, mid, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}