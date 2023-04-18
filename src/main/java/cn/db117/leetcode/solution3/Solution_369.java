

//给定一个用链表表示的非负整数， 然后将这个整数 再加上 1 。 
//
// 这些数字的存储是这样的：最高位有效的数字位于链表的首位
// head 。 
//
// 
//
// 示例 1: 
//
// 
//输入: head = [1,2,3]
//输出: [1,2,4]
// 
//
// 
// 
//
// 示例 2: 
//
// 
//输入: head = [0]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中的节点数在
// [1, 100] 的范围内。 
// 0 <= Node.val <= 9 
// 由链表表示的数字不包含前导零，除了零本身。 
// 
//
// Related Topics 链表 数学 👍 104 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.util.ListNode;

/**
 * 369.给单链表加一.plus-one-linked-list
 *
 * @author db117
 * @since 2023-04-12 10:20:41
 **/

public class Solution_369 {
    public static void main(String[] args) {
        Solution solution = new Solution_369().new Solution();
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
        public ListNode plusOne(ListNode head) {
            int add = helper(head);
            if (add > 0) {
                // 都进位了，需要加一个
                ListNode ans = new ListNode(add);
                ans.next = head;
                return ans;
            }
            return head;
        }

        private int helper(ListNode next) {
            if (next == null) {
                // 上一个是最后一个
                return 1;
            }
            // 加上后面的进位
            next.val += helper(next.next);
            // 进位
            int ans = next.val / 10;

            next.val %= 10;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}