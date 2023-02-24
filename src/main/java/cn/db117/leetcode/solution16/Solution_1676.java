

//给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，返回 nodes 中所有节点的最近公共祖先（LCA）。数组（列表）
//中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。 
//
// 我们扩展二叉树的最近公共祖先节点在维基百科上的定义：“对于任意合理的 i 值， n 个节点 p1 、 p2、...、 pn 在二叉树 T 中的最近公共祖先
//节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。 
//
// 
//
// 示例 1: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
//输出: 2
//解释: 节点 4 和 7 的最近公共祖先是 2。
// 
//
// 示例 2: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
//输出: 1
//解释: 单个节点的最近公共祖先是该节点本身。
// 
//
//
// 示例 3: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
//输出: 5
//解释: 节点 7、6、2 和 4 的最近公共祖先节点是 5。
// 
//
// 示例 4: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [0,1,2,3,4,5,6,7,8]
//输出: 3
//解释: 树中所有节点的最近公共祖先是根节点。
// 
//
// 
//
// 提示: 
//
// 
// 树中节点个数的范围是 [1, 10⁴] 。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有的 Node.val 都是互不相同的。 
// 所有的 nodes[i] 都存在于该树中。 
// 所有的 nodes[i] 都是互不相同的。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 25 👎 0


package cn.db117.leetcode.solution16;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 1676.二叉树的最近公共祖先 IV.lowest-common-ancestor-of-a-binary-tree-iv
 *
 * @author db117
 * @since 2023-02-24 10:58:34
 **/

public class Solution_1676 {
    public static void main(String[] args) {
        Solution solution = new Solution_1676().new Solution();
        /// [3,5,1,6,2,0,8,null,null,7,4]
        System.out.println(solution.lowestCommonAncestor(TreeNodeUtil.build("[3,5,1,6,2,0,8,null,null,7,4]"),
                new TreeNode[]{new TreeNode(4), new TreeNode(7)}).val);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            if (nodes.length == 1) {
                return nodes[0];
            }
            Set<Integer> set = new HashSet<>();
            for (TreeNode node : nodes) {
                set.add(node.val);
            }

            dfs(root, set);

            return ans;
        }

        private int dfs(TreeNode root, Set<Integer> set) {
            if (root == null || ans != null) {
                return 0;
            }
            int count = 0;

            count += dfs(root.left, set);

            count += dfs(root.right, set);


            if (set.contains(root.val)) {
                count++;
            }
            if (ans == null && count == set.size()) {
                // 都找到了
                ans = root;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}