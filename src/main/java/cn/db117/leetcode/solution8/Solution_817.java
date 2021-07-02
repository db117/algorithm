//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
//
// 同时给定列表 G，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 输入: 
//head: 0->1->2->3
//G = [0, 1, 3]
//输出: 2
//解释: 
//链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
// 示例 2： 
//
// 输入: 
//head: 0->1->2->3->4
//G = [0, 3, 1, 4]
//输出: 2
//解释: 
//链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 如果 N 是给定链表 head 的长度，1 <= N <= 10000。 
// 链表中每个结点的值所在范围为 [0, N - 1]。 
// 1 <= G.length <= 10000 
// G 是链表中所有结点的值的一个子集. 
// 
// Related Topics 哈希表 链表 
// 👍 77 👎 0


package cn.db117.leetcode.solution8;

import cn.db117.leetcode.util.ListNode;
import cn.db117.leetcode.util.ListNodeUtil;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 817.链表组件.linked-list-components
 *
 * @author db117
 * @since 2021-07-02 18:53:43
 **/

public class Solution_817 {
    public static void main(String[] args) {
        Solution solution = new Solution_817().new Solution();

        ListNode node = ListNodeUtil.builder(new int[]{0, 1, 2, 3});

        System.out.println(solution.numComponents(node, new int[]{0, 1, 3}));
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
        public int numComponents(ListNode head, int[] nums) {

            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

            int ans = 0;
            while (head != null) {
                // 找到存在于 G 的节点
                while (head != null && !set.contains(head.val)) {
                    head = head.next;
                }

                if (head == null) {
                    break;
                }

                ans++;

                // 一直走完
                while (head.next != null && set.contains(head.next.val)) {
                    head = head.next;
                }
                head = head.next;

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}