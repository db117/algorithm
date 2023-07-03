

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 626 👎 0


package cn.db117.leetcode.solution4;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 445.两数相加 II.add-two-numbers-ii
 *
 * @author db117
 * @since 2023-07-03 10:38:03
 **/

public class Solution_445 {
    public static void main(String[] args) {
        Solution solution = new Solution_445().new Solution();
        ListNode listNode = solution.addTwoNumbers(ListNodeUtil.builder(new int[]{5}), ListNodeUtil.builder(new int[]{5}));
        ListNodeUtil.print(listNode);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 翻转链表
            l1 = reverse(l1);
            l2 = reverse(l2);
            // 相加
            ListNode ans = new ListNode();
            ListNode cur = ans;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            // 最后一位进位
            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            // 再次翻转
            return reverse(ans.next);
        }

        private ListNode reverse(ListNode l2) {
            ListNode cur = l2;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}