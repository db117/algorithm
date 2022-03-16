


//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 37 👎 0


package cn.db117.leetcode.office;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

/**
 * 剑指 Offer II 027.回文链表.aMhZSa
 *
 * @author db117
 * @since 2022-03-16 11:45:05
 **/

public class Offer_II027 {
    public static void main(String[] args) {
        Solution solution = new Offer_II027().new Solution();
        System.out.println(solution.isPalindrome(ListNodeUtil.builder(new int[]{0, 1})));
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
        public boolean isPalindrome(ListNode head) {
            // 快慢指针
            ListNode low = head, fast = head.next;
            int count = 1;
            while (fast != null && fast.next != null) {
                count++;
                low = low.next;
                fast = fast.next.next;
            }

            // 翻转连表
            ListNode next = null;
            if (fast == null) {
                // 说明是奇数个节点,low 刚好在中间位置 就从 low 开始翻转
                next = helper(low);
            } else {
                // 说明是偶数个节点, 就从 low 的下一个位置开始翻转
                next = helper(low.next);
            }

            // 一一对比
            while (head != null) {
                count--;

                if (head.val != next.val) {
                    return false;
                }
                if (head == next || count == 0) {
                    return true;
                }
                head = head.next;
                next = next.next;
            }

            return true;
        }

        public ListNode helper(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode ans = helper(head.next);
            head.next.next = head;
            head.next = null;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}