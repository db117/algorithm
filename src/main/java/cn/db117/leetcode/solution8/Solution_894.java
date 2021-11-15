

//满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。 
//
// 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。 
//
// 答案中每个树的每个结点都必须有 node.val=0。 
//
// 你可以按任何顺序返回树的最终列表。 
//
// 
//
// 示例： 
//
// 输入：7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//解释：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 20 
// 
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 232 👎 0


package cn.db117.leetcode.solution8;

import cn.db117.leetcode.util.TreeNode;
import cn.db117.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 894.所有可能的满二叉树.all-possible-full-binary-trees
 *
 * @author db117
 * @since 2021-11-12 18:30:03
 **/

public class Solution_894 {
    public static void main(String[] args) {
        Solution solution = new Solution_894().new Solution();

        List<TreeNode> list = solution.allPossibleFBT(7);
        for (TreeNode node : list) {
            TreeNodeUtil.print(node);

        }
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
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> ans = new ArrayList<>();
            // 递归出口
            if ((n & 1) != 1) {
                return ans;
            }
            if (n == 1) {
                ans.add(new TreeNode(0));
                return ans;
            }


            for (int i = 1; i < n; i += 2) {
                // 把剩余的节点分到两个子节点
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i - 1);

                // 把返回的子节点添加到当前节点
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode cur = new TreeNode(0);
                        cur.left = l;
                        cur.right = r;
                        ans.add(cur);
                    }
                }
            }

            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}