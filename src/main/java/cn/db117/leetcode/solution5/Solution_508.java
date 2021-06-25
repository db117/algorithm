//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 深度优先搜索 哈希表 二叉树 
// 👍 116 👎 0


package cn.db117.leetcode.solution5;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 508.出现次数最多的子树元素和.most-frequent-subtree-sum
 *
 * @author db117
 * @since 2021-06-25 18:16:03
 **/

public class Solution_508 {
    public static void main(String[] args) {
        Solution solution = new Solution_508().new Solution();

        TreeNode treeNode = TreeNodeUtil.build(new Integer[]{5, 2, -5});

        System.out.println(Arrays.toString(solution.findFrequentTreeSum(treeNode)));
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
        public int[] findFrequentTreeSum(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            // 记录每一个和出现的次数
            helper(root, map);

            // 找到最大的次数
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer sum = entry.getKey();
                Integer count = entry.getValue();
                if (count < max) {
                    continue;
                }
                if (count > max) {
                    // 有更大的了
                    ans.clear();
                    max = count;
                    ans.add(sum);
                } else {
                    ans.add(sum);
                }
            }
            return ans.stream()
                    .mapToInt(i -> i)
                    .toArray();
        }

        public int helper(TreeNode root, Map<Integer, Integer> map) {
            if (root == null) {
                return 0;
            }
            int sum = root.val;
            if (root.left != null) {
                sum += helper(root.left, map);
            }
            if (root.right != null) {
                sum += helper(root.right, map);
            }

            // 保存当前和的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}