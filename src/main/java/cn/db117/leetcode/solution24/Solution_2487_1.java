

//给你一个链表的头节点 head 。 
//
// 移除每个右侧有一个更大数值的节点。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
// 
//
// 
//
// 提示： 
//
// 
// 给定列表中的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 栈 递归 链表 单调栈 👍 74 👎 0


package cn.db117.leetcode.solution24;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 2487.从链表中移除节点.remove-nodes-from-linked-list
 *
 * @author db117
 * @since 2024-01-03 16:23:41
 **/

public class Solution_2487_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_2487_1().new Solution();
        ListNodeUtil.print(solution.removeNodes(ListNodeUtil.builder(new int[]{
                5, 2, 13, 3, 8
        })));
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
        public ListNode removeNodes(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode next = removeNodes(head.next);// 返回的肯定是最大的
            if (next != null && next.val > head.val) {
                return next;// 删除当前节点
            }
            head.next = next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}