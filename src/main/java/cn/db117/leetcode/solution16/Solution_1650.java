

//给定一棵二叉树中的两个节点 p 和 q，返回它们的最近公共祖先节点（LCA）。 
//
// 每个节点都包含其父节点的引用（指针）。Node 的定义如下： 
//
// class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node parent;
//}
// 
//
// 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点（我们允许
//一个节点为自身的一个后代节点）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。 
//
// 
//
// 示例 1: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和 1 的最近公共祖先是 3。
// 
//
// 示例 2: 
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和 4 的最近公共祖先是 5，根据定义，一个节点可以是自身的最近公共祖先。
// 
//
// 示例 3: 
//
// 输入: root = [1,2], p = 1, q = 2
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 树中节点个数的范围是 [2, 10⁵]。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有的 Node.val 都是互不相同的。 
// p != q 
// p 和 q 存在于树中。 
// 
//
// Related Topics 树 哈希表 二叉树 👍 34 👎 0


package cn.db117.leetcode.solution16;

import java.util.HashSet;
import java.util.Set;

/**
 * 1650.二叉树的最近公共祖先 III.lowest-common-ancestor-of-a-binary-tree-iii
 *
 * @author db117
 * @since 2023-03-01 13:43:30
 **/

public class Solution_1650 {
    public static void main(String[] args) {
        Solution solution = new Solution_1650().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public Node lowestCommonAncestor(Node p, Node q) {
            Set<Integer> set = new HashSet<>();
            // 从一个节点开始往上找，并保存起来
            Node cur = p;
            while (cur != null) {
                set.add(cur.val);
                cur = cur.parent;
            }

            // 找到第一个出现过的即是公共父节点
            cur = q;
            while (cur != null) {
                if (set.contains(cur.val)) {
                    return cur;
                }
                cur = cur.parent;
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;

}