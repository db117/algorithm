


//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
// 
// Related Topics 链表 双指针 
// 👍 64 👎 0


package cn.db117.leetcode.interview;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 面试题 02.04.分割链表.partition-list-lcci
 *
 * @author db117
 * @since 2021-06-24 16:03:45
 **/

public class Interview_0204 {
    public static void main(String[] args) {
        Solution solution = new Interview_0204().new Solution();

        ListNode node = ListNodeUtil.builder(new int[]{
                3, 5, 8, 5, 10, 2, 1
        });

        ListNodeUtil.print(solution.partition(node, 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // 虚头
            ListNode smallHead = new ListNode();
            ListNode bigHead = new ListNode();

            ListNode small = smallHead, big = bigHead;

            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = head;
                } else {
                    big.next = head;
                    big = head;
                }
                head = head.next;

                // 防止循环
                big.next = null;
                small.next = null;
            }
            // 连接两个链表
            small.next = bigHead.next;

            return smallHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}