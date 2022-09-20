

//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。 
//
// MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里
//的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end。 
//
// 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。 
//
// 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该
//日程安排添加到日历中。 
//
// 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(
//start, end) 
//
// 
//
// 示例： 
//
// MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(50, 60); // returns true
//MyCalendar.book(10, 40); // returns true
//MyCalendar.book(5, 15); // returns false
//MyCalendar.book(5, 10); // returns true
//MyCalendar.book(25, 55); // returns true
//解释： 
//前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
//第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
//第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
//第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
//时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
// 
//
// 
//
// 提示： 
//
// 
// 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。 
// 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。 
// 
//
// Related Topics 设计 线段树 二分查找 有序集合 👍 205 👎 0


package cn.db117.leetcode.solution7;

/**
 * 731.我的日程安排表 II.my-calendar-ii
 *
 * @author db117
 * @since 2022-09-20 16:04:06
 **/

public class Solution_731 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        for (int[] ints : arr) {
            System.out.println(myCalendarTwo.book(ints[0], ints[1]));
        }
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarTwo {
        SegNode root;

        public MyCalendarTwo() {
            root = new SegNode(0, (int) 1e9);
        }

        public boolean book(int start, int end) {
            int query = query(root, start, end - 1);
            if (query >= 2) {
                return false;
            }

            update(root, start, end - 1, 1);
            return true;
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
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}