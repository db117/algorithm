

//给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 
//parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外： 
//
// 
// 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。 
// 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。 
// 
//
// 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。 
//
// 测试用例会保证可以构造出 有效 的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//输出：[50,20,80,15,17,19]
//解释：根节点是值为 50 的节点，因为它没有父节点。
//结果二叉树如上图所示。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
//输出：[1,2,null,null,3,4]
//解释：根节点是值为 1 的节点，因为它没有父节点。 
//结果二叉树如上图所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= descriptions.length <= 10⁴ 
// descriptions[i].length == 3 
// 1 <= parenti, childi <= 10⁵ 
// 0 <= isLefti <= 1 
// descriptions 所描述的二叉树是一棵有效二叉树 
// 
// 👍 11 👎 0


package cn.db117.leetcode.solution21;

import cn.db117.leetcode.util.TreeNode;

import java.util.*;

/**
 * 2196.根据描述创建二叉树.create-binary-tree-from-descriptions
 *
 * @author db117
 * @since 2022-03-07 11:11:51
 **/

public class Solution_2196 {
    public static void main(String[] args) {
        Solution solution = new Solution_2196().new Solution();
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
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            Set<Integer> pSet = new HashSet<>();
            Set<Integer> cSet = new HashSet<>();
            for (int[] description : descriptions) {
                map.putIfAbsent(description[0], new ArrayList<>(2));
                map.get(description[0]).add(description);

                cSet.add(description[1]);
                pSet.add(description[0]);
            }

            TreeNode ans;
            // 根节点
            Integer root = null;

            // 不在子节点的父节点就是根节点
            for (Integer p : pSet) {
                if (!cSet.contains(p)) {
                    root = p;
                }
            }

            ans = new TreeNode(root);

            // 深度优先构建树
            dfs(ans, map);
            return ans;
        }

        private void dfs(TreeNode root, Map<Integer, List<int[]>> map) {
            if (root == null) {
                return;
            }
            List<int[]> c = map.get(root.val);
            if (c == null) {
                return;
            }

            for (int[] ints : c) {
                if (ints[2] == 1) {
                    root.left = new TreeNode(ints[1]);
                } else {
                    root.right = new TreeNode(ints[1]);
                }
            }

            dfs(root.left, map);
            dfs(root.right, map);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}