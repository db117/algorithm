

//给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。 
//
// 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：head = [0,3,1,0,4,5,2,0]
//输出：[4,11]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：3 + 1 = 4
//- 标记为红色的节点之和：4 + 5 + 2 = 11
// 
//
// 示例 2： 
// 
//
// 
//输入：head = [0,1,0,3,0,2,2,0]
//输出：[1,3,4]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：1 = 1
//- 标记为红色的节点之和：3 = 3
//- 标记为黄色的节点之和：2 + 2 = 4
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [3, 2 * 10⁵] 内 
// 0 <= Node.val <= 1000 
// 不 存在连续两个 Node.val == 0 的节点 
// 链表的 开端 和 末尾 节点都满足 Node.val == 0 
// 
// Related Topics 链表 模拟 👍 2 👎 0


package cn.db117.leetcode.solution21;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 2181.合并零之间的节点.merge-nodes-in-between-zeros
 *
 * @author db117
 * @since 2022-02-23 15:06:11
 **/

public class Solution_2181 {
    public static void main(String[] args) {
        Solution solution = new Solution_2181().new Solution();
        ListNodeUtil.print(solution.mergeNodes(ListNodeUtil.builder(new int[]{0, 3, 1, 0, 4, 5, 2, 0})));
        ListNodeUtil.print(solution.mergeNodes(ListNodeUtil.builder(new int[]{0, 1, 0, 3, 0, 2, 2, 0})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode ans = head;
            while (head != null) {
                if (head.next == null) {
                    break;
                    // 到头了
                }

                if (head.next.val != 0) {
                    // 后面加到前面来
                    head.val += head.next.val;
                    head.next = head.next.next;
                    continue;
                }

                // 下一个为 0
                if (head.next.next == null) {
                    head.next = null;
                    // 到头了
                    break;
                }

                // 换下一个
                head = head.next;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}