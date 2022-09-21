

//当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。 
//
// 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。 
//
// 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。 
//
// 
// MyCalendarThree() 初始化对象。 
// int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
//[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
//输出：
//[null, 1, 1, 2, 3, 3, 3]
//
//解释：
//MyCalendarThree myCalendarThree = new MyCalendarThree();
//myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是
// 2 次预订。
//myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
//myCalendarThree.book(5, 10); // 返回 3
//myCalendarThree.book(25, 55); // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 10⁹ 
// 每个测试用例，调用 book 函数最多不超过 400次 
// 
//
// Related Topics 设计 线段树 二分查找 有序集合 👍 185 👎 0


package cn.db117.leetcode.solution7;

/**
 * 732.我的日程安排表 III.my-calendar-iii
 *
 * @author db117
 * @since 2022-09-21 10:40:22
 **/

public class Solution_732 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarThree {
        SegNode root;

        public MyCalendarThree() {
            root = new SegNode(0, (int) 1e9);
        }

        public int book(int start, int end) {
            update(root, start, end - 1, 1);
            return query(root, 0, (int) 1e9);
        }

        class SegNode {
            // 当前节点左右 范围
            int l, r;
            /**
             * 区间最大值
             */
            int max;
            /**
             * 左右 节点
             */
            SegNode left, right;
            /**
             * 延迟更新
             */
            int lazy;

            public SegNode(int l, int r) {
                this.l = l;
                this.r = r;
            }

            // 动态开点
            public SegNode getLeft() {
                if (left == null) {
                    left = new SegNode(l, (l + r) >> 1);
                }
                return left;
            }

            public SegNode getRight() {
                if (right == null) {
                    right = new SegNode(((l + r) >> 1) + 1, r);
                }
                return right;
            }
        }

        /**
         * 上推,合并两个子节点的值
         */
        private void pushUp(SegNode node) {
            node.max = Math.max(node.getLeft().max, node.getRight().max);
        }

        /**
         * 向下传递懒更新
         */
        private void pushDown(SegNode node) {
            int add = node.lazy;
            if (add == 0) {
                return;
            }

            // 把子节点的数据修改,并标记懒更新
            // 区间每一个位置都增加(找最大值不需要乘以子节点数量)
            SegNode left = node.getLeft();
            SegNode right = node.getRight();
            left.lazy += add;
            left.max += add;

            right.lazy += add;
            right.max += add;

            // 清除标记
            node.lazy = 0;
        }

        /**
         * 更新指定位置的值
         *
         * @param node 节点
         * @param val  修改后的值
         */
        public void update(SegNode node, int l, int r, int val) {
            if (l <= node.l && node.r <= r) {
                // 懒更新
                // 最大值(不需要需要乘以子节点数量)
                node.max += val;
                node.lazy += val;
                return;
            }

            // 修改子节点
            int mid = (node.l + node.r) >> 1;
            SegNode left = node.getLeft();
            SegNode right = node.getRight();

            pushDown(node);

            if (r <= mid) {
                // 修改区间在左边
                update(left, l, r, val);
            } else if (l > mid) {
                // 修改区间在右边
                update(right, l, r, val);
            } else {
                // 修改区间两边都有
                update(left, l, r, val);
                update(right, l, r, val);
            }

            // 合并子节点的数据
            pushUp(node);
        }


        public int query(SegNode node, int ql, int qr) {
            if (node.r < ql || node.l > qr) {
                // 不在区间内
                return 0;
            }
            if (ql <= node.l && node.r <= qr) {
                // 找到目标节点
                return node.max;
            }

            pushDown(node);
            // 查询区间在子节点中
            int mid = (node.l + node.r) >> 1;
            if (qr <= mid) {
                return query(node.getLeft(), ql, qr);
            }
            if (ql > mid) {
                return query(node.getRight(), ql, qr);
            }

            // 查询区间跨子节点
            return Math.max(query(node.getLeft(), ql, qr), query(node.getRight(), ql, qr));
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}