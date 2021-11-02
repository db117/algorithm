

//链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。 
//
// 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个 局部极大值点 。 
//
// 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个 局部极小值点 。 
//
// 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。 
//
// 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同
//临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,1]
//输出：[-1,-1]
//解释：链表 [3,1] 中不存在临界点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [5,3,1,2,5,1,2]
//输出：[1,3]
//解释：存在三个临界点：
//- [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
//- [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
//- [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
//第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
//第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1,3,2,2,3,2,2,2,7]
//输出：[3,3]
//解释：存在两个临界点：
//- [1,3,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
//- [1,3,2,2,3,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
//最小和最大距离都存在于第二个节点和第五个节点之间。
//因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
//注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
// 
//
// 示例 4： 
//
// 
//
// 
//输入：head = [2,3,3,2]
//输出：[-1,-1]
//解释：链表 [2,3,3,2] 中不存在临界点。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数量在范围 [2, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
// 👍 1 👎 0


package cn.db117.leetcode.solution20;

import cn.db117.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2058.找出临界点之间的最小和最大距离.find-the-minimum-and-maximum-number-of-nodes-between-critical-points
 *
 * @author db117
 * @since 2021-11-02 16:11:03
 **/

public class Solution_2058 {
    public static void main(String[] args) {
        Solution solution = new Solution_2058().new Solution();
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
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int min = Integer.MAX_VALUE;
            int max = -1;
            List<Integer> list = new ArrayList<>();


            // 记录
            int i = -1;
            ListNode pre = null;
            while (head != null && head.next != null) {
                i++;
                if (pre == null) {
                    pre = head;
                    head = head.next;
                    continue;
                }

                if (pre.val > head.val && head.next.val > head.val) {
                    list.add(i);
                }
                if (pre.val < head.val && head.next.val < head.val) {
                    list.add(i);
                }
                pre = head;
                head = head.next;
            }

            if (list.size() < 2) {
                return new int[]{-1, -1};
            }
            // 比较
            for (int j = 1; j < list.size(); j++) {
                min = Math.min(list.get(j) - list.get(j - 1), min);
            }
            max = list.get(list.size() - 1) - list.get(0);
            return new int[]{min, max};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}