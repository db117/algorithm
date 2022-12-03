

//给你一个 值互不相同 的二叉树的根节点 root 。 
//
// 在一步操作中，你可以选择 同一层 上任意两个节点，交换这两个节点的值。 
//
// 返回每一层按 严格递增顺序 排序所需的最少操作数目。 
//
// 节点的 层数 是该节点和根节点之间的路径的边数。 
//
// 
//
// 示例 1 ： 
// 输入：root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
//输出：3
//解释：
//- 交换 4 和 3 。第 2 层变为 [3,4] 。
//- 交换 7 和 5 。第 3 层变为 [5,6,8,7] 。
//- 交换 8 和 7 。第 3 层变为 [5,6,7,8] 。
//共计用了 3 步操作，所以返回 3 。
//可以证明 3 是需要的最少操作数目。
// 
//
// 示例 2 ： 
// 输入：root = [1,3,2,7,6,5,4]
//输出：3
//解释：
//- 交换 3 和 2 。第 2 层变为 [2,3] 。 
//- 交换 7 和 4 。第 3 层变为 [4,6,5,7] 。 
//- 交换 6 和 5 。第 3 层变为 [4,5,6,7] 。
//共计用了 3 步操作，所以返回 3 。 
//可以证明 3 是需要的最少操作数目。
// 
//
// 示例 3 ： 
// 输入：root = [1,2,3,4,5,6]
//输出：0
//解释：每一层已经按递增顺序排序，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁵ 
// 树中的所有值 互不相同 。 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 16 👎 0


package cn.db117.leetcode.solution24;

import cn.db117.leetcode.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2471.逐层排序二叉树所需的最少操作数目.minimum-number-of-operations-to-sort-a-binary-tree-by-level
 *
 * @author db117
 * @since 2022-12-03 10:53:31
 **/

public class Solution_2471 {
    public static void main(String[] args) {
        Solution solution = new Solution_2471().new Solution();
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
        public int minimumOperations(TreeNode root) {
            int ans = 0;
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            if (root.left != null) {
                deque.add(root.left);
            }
            if (root.right != null) {
                deque.add(root.right);
            }
            while (!deque.isEmpty()) {
                List<TreeNode> collect = new ArrayList<>(deque);
                List<Integer> list = collect.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
                ans += helper(list);
                deque.clear();
                for (TreeNode treeNode : collect) {
                    if (treeNode.left != null) {
                        deque.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.add(treeNode.right);
                    }
                }
            }
            return ans;
        }

        // 把 list 变成有序需要的次数
        private int helper(List<Integer> list) {
            int ans = 0;
            List<Integer> tmp = new ArrayList<>(list);
            Collections.sort(tmp);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tmp.size(); i++) {
                map.put(tmp.get(i), i);
            }
            for (int i = 0; i < tmp.size(); i++) {
                if (Objects.equals(tmp.get(i), list.get(i))) {
                    continue;
                }

                while (!Objects.equals(tmp.get(i), list.get(i))) {
                    Integer integer = list.set(map.get(list.get(i)), list.get(i));
                    list.set(i, integer);
                    ans++;
                }

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}