

//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。 
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。 
//
// 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < 
//end 。 
//
// 实现 MyCalendar 类： 
//
// 
// MyCalendar() 初始化日历对象。 
// boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 
//false 并且不要将该日程安排添加到日历中。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//输出：
//[null, true, false, true]
//
//解释：
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
//。
//myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
// ，且不包含时间 20 。 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 10⁹ 
// 每个测试用例，调用 book 方法的次数最多不超过 1000 次。 
// 
//
// Related Topics 设计 线段树 二分查找 有序集合 👍 231 👎 0


package cn.db117.leetcode.solution7;

import cn.db117.template.segment_tree.SegmentTreeRangeSum;

/**
 * 729.我的日程安排表 I.my-calendar-i
 *
 * @author db117
 * @see SegmentTreeRangeSum
 * @since 2022-09-20 15:40:29
 **/

public class Solution_729 {
    public static void main(String[] args) {
        int[][] arg = new int[][]{{69, 70}, {3, 4}, {39, 40}, {35, 36}, {3, 4}, {55, 56}, {61, 62}, {97, 98},
                {79, 80}, {76, 77}, {46, 47}, {78, 79}, {47, 48}, {38, 39}, {83, 84}, {90, 91}, {90, 91}, {49, 50}, {49, 50},
                {77, 78}, {23, 24}, {89, 90}, {8, 9}, {3, 4}, {2, 3}, {48, 49}, {96, 97}, {4, 5}, {54, 55}, {30, 31}, {97, 98},
                {65, 66}, {93, 94}, {49, 50}, {24, 25}, {17, 18}, {53, 54}, {45, 46}, {53, 54}, {32, 33}, {37, 38}, {5, 6},
                {50, 51}, {48, 49}, {14, 15}, {91, 92}, {79, 80}, {73, 74}, {28, 29}, {31, 32}, {98, 99}, {37, 38}, {19, 20},
                {49, 50}, {54, 55}, {37, 38}, {98, 99}, {12, 13}, {24, 25}, {46, 47}, {74, 75}, {87, 88}, {64, 65}, {61, 62},
                {68, 69}, {28, 29}, {43, 44}, {89, 90}, {64, 65}, {72, 73}, {69, 70}, {88, 89}, {68, 69}, {28, 29}, {20, 21},
                {64, 65}, {17, 18}, {40, 41}, {88, 89}, {22, 23}, {8, 9}, {33, 34}, {13, 14}, {19, 20}, {53, 54}, {99, 100},
                {24, 25}, {82, 83}, {77, 78}, {90, 91}, {72, 73}, {33, 34}, {73, 74}, {0, 1}, {25, 26}, {69, 70}, {73, 74},
                {12, 13}, {33, 34}, {47, 48}, {26, 27}, {77, 78}, {95, 96}, {28, 29}, {77, 78}, {28, 29}, {87, 88}, {16, 17},
                {42, 43}, {51, 52}, {44, 45}, {63, 64}, {24, 25}, {18, 19}, {0, 1}, {45, 46}, {65, 66}, {21, 22}, {37, 38},
                {77, 78}, {97, 98}, {24, 25}, {83, 84}, {20, 21}, {29, 30}, {66, 67}, {29, 30}, {37, 38}, {63, 64}, {15, 16},
                {85, 86}, {61, 62}, {0, 1}, {23, 24}, {96, 97}, {91, 92}, {90, 91}, {80, 81}, {18, 19}, {69, 70}, {3, 4},
                {59, 60}, {21, 22}, {75, 76}, {54, 55}, {65, 66}, {34, 35}, {19, 20}, {79, 80}, {6, 7}, {24, 25}, {29, 30},
                {35, 36}, {9, 10}, {0, 1}, {73, 74}, {65, 66}, {78, 79}, {32, 33}, {58, 59}, {25, 26}, {3, 4}, {78, 79},
                {92, 93}, {37, 38}, {91, 92}, {5, 6}, {79, 80}, {94, 95}, {78, 79}, {38, 39}, {16, 17}, {81, 82}, {34, 35},
                {16, 17}, {33, 34}, {42, 43}, {34, 35}, {89, 90}, {88, 89}, {33, 34}, {68, 69}, {92, 93}, {73, 74}, {64, 65},
                {91, 92}, {44, 45}, {13, 14}, {97, 98}, {64, 65}, {31, 32}, {91, 92}, {1, 2}, {57, 58}, {21, 22}, {38, 39},
                {70, 71}, {84, 85}, {50, 51}, {58, 59}};
        MyCalendar myCalendar = new MyCalendar();
        for (int[] ints : arg) {
            System.out.println(ints[0] + ":" + ints[1]);
            myCalendar.book(ints[0], ints[1]);
        }
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {
        SegNode root;

        public MyCalendar() {
            root = new SegNode(0, (int) 1e9);
        }

        public boolean book(int start, int end) {
            int query = query(root, start, end - 1);
            if (query > 0) {
                return false;
            }
            update(root, start, end - 1, 1);
            return true;
        }

        class SegNode {
            // 当前节点左右 范围
            int l, r;
            /**
             * 区间和
             */
            int sum;
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
            node.sum = node.getLeft().sum + node.getRight().sum;
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
            // 需要根据题意修改,区间每一个位置都增加(需要乘以子节点数量)
            // 最大值(不需要)
            SegNode left = node.getLeft();
            SegNode right = node.getRight();
            left.lazy += add;
            left.sum += add;
            //        left.sum += (left.r - left.l + 1) * add;

            right.lazy += add;
            right.sum += add;
            //        right.sum += (right.r - right.l + 1) * add;

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
                // 需要根据题意修改,区间每一个位置都增加(需要乘以子节点数量)
                // 最大值(不需要)
                node.sum += val;
                node.lazy = val;
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
                return node.sum;
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
            return query(node.getLeft(), ql, qr) + query(node.getRight(), ql, qr);
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}