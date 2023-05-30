

//给出二叉树的根节点 root，树上每个节点都有一个不同的值。 
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 235 👎 0


package cn.db117.leetcode.solution11;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1110.删点成林.delete-nodes-and-return-forest
 *
 * @author db117
 * @since 2023-05-30 09:47:06
 **/

public class Solution_1110 {
    public static void main(String[] args) {
        Solution solution = new Solution_1110().new Solution();
        // root = [1,2,3,4,5,6,7], to_delete = [3,5]
        TreeNode build = TreeNodeUtil.build("[1,2,3,4,5,6,7]");
        System.out.println(solution.delNodes(build, new int[]{3, 5}));
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
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> ans = new ArrayList<>();
            Set<Integer> set = Arrays.stream(to_delete)
                    .boxed()
                    .collect(Collectors.toSet());

            dfs(root, set, ans);

            // 根节点
            if (!set.contains(root.val)) {
                ans.add(root);
            }
            return ans;
        }

        private void dfs(TreeNode root, Set<Integer> set, List<TreeNode> ans) {
            if (root == null) {
                return;
            }
            dfs(root.left, set, ans);
            dfs(root.right, set, ans);
            // 删除无效节点
            if (root.left != null && set.contains(root.left.val)) {
                root.left = null;
            }
            if (root.right != null && set.contains(root.right.val)) {
                root.right = null;
            }

            // 把删除后的子节点加入到答案中
            if (set.contains(root.val)) {
                if (root.left != null) {
                    ans.add(root.left);
                }
                if (root.right != null) {
                    ans.add(root.right);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}