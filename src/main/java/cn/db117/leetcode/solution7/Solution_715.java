

//Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。 
//
// 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。 
//
// 实现 RangeModule 类: 
//
// 
// RangeModule() 初始化数据结构的对象。 
// void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的
//数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。 
// boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返
//回 true ，否则返回 false 。 
// void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", 
//"queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//输出
//[null, null, null, true, false, true]
//
//解释
//RangeModule rangeModule = new RangeModule();
//rangeModule.addRange(10, 20);
//rangeModule.removeRange(14, 16);
//rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
//rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样
//的数字）
//rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left < right <= 10⁹ 
// 在单个测试用例中，对 addRange 、 queryRange 和 removeRange 的调用总数不超过 10⁴ 次 
// 
//
// Related Topics 设计 线段树 有序集合 👍 203 👎 0


package cn.db117.leetcode.solution7;

/**
 * 715.Range 模块.range-module
 *
 * @author db117
 * @see cn.db117.template.segment_tree.SegmentTreeRangeOverrideSum
 * @since 2022-09-21 11:17:53
 **/

public class Solution_715 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RangeModule {
        SegNode root;

        public RangeModule() {
            root = new SegNode(0, (int) 1e9);
        }

        public void addRange(int left, int right) {
            // 区间覆盖
            update(root, left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            // 区间查询并比较
            return query(root, left, right - 1) == right - left;
        }

        public void removeRange(int left, int right) {
            // 区间覆盖
            update(root, left, right - 1, 0);
        }


        // ++++++++++++++++++++++++++++
        class SegNode {
            // 当前节点左右 范围
            int l, r;
            /**
             * 区间最大值
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
            int override = node.lazy;
            if (override == -1) {
                return;
            }

            // 把子节点的数据修改,并标记懒更新
            // 区间每一个位置都覆盖(需要乘以子节点数量)
            SegNode left = node.getLeft();
            SegNode right = node.getRight();
            left.lazy = override;
            left.sum = override * (left.r - left.l + 1);

            right.lazy = override;
            right.sum = override * (right.r - right.l + 1);

            // 清除标记
            node.lazy = -1;
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
                node.sum = val * (node.r - node.l + 1);
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
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}