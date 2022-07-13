

//给你两个整数：m 和 n ，表示矩阵的维数。 
//
// 另给你一个整数链表的头节点 head 。 
//
// 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，
//则用 -1 填充。 
//
// 返回生成的矩阵。 
//
// 
//
// 示例 1： 
//
// 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
//输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
//解释：上图展示了链表中的整数在矩阵中是如何排布的。
//注意，矩阵中剩下的空格用 -1 填充。
// 
//
// 示例 2： 
//
// 输入：m = 1, n = 4, head = [0,1,2]
//输出：[[0,1,2,-1]]
//解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。 
//注意，矩阵中剩下的空格用 -1 填充。 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 链表中节点数目在范围 [1, m * n] 内 
// 0 <= Node.val <= 1000 
// 
// Related Topics 数组 链表 矩阵 模拟 👍 11 👎 0


package cn.db117.leetcode.solution23;

import cn.db117.leetcode.util.ListNode;

import java.util.Arrays;

/**
 * 2326.螺旋矩阵 IV.spiral-matrix-iv
 *
 * @author db117
 * @since 2022-07-13 18:19:09
 **/

public class Solution_2326 {
    public static void main(String[] args) {
        Solution solution = new Solution_2326().new Solution();
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
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] ans = new int[m][n];
            for (int[] an : ans) {
                Arrays.fill(an, -1);
            }
            // 未读取的上下左右的边界
            int left = 0, right = n - 1, top = 0, down = m - 1;

            int index = 0;
            int x = 0, y = 0;

            while (true) {
                if (left > right) {
                    break;
                }
                // 向右
                for (int i = left; i <= right; i++) {
                    if (head == null) {
                        break;
                    }
                    ans[top][i] = head.val;
                    head = head.next;
                }
                top++;
                if (head == null) {
                    break;
                }
                if (top > down) {
                    break;
                }
                // 向下
                for (int i = top; i <= down; i++) {
                    if (head == null) {
                        break;
                    }
                    ans[i][right] = head.val;
                    head = head.next;
                }
                right--;
                if (head == null) {
                    break;
                }

                if (right < left) {
                    break;
                }
                // 向左
                for (int i = right; i >= left; i--) {
                    if (head == null) {
                        break;
                    }
                    ans[down][i] = head.val;
                    head = head.next;
                }
                down--;
                if (head == null) {
                    break;
                }
                if (down < top) {
                    break;
                }
                // 向上
                for (int i = down; i >= top; i--) {
                    if (head == null) {
                        break;
                    }
                    ans[i][left] = head.val;
                    head = head.next;
                }
                left++;
                if (head == null) {
                    break;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}