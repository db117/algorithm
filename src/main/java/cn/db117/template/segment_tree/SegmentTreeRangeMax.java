package cn.db117.template.segment_tree;


import cn.db117.leetcode.solution7.Solution_729;
import cn.db117.leetcode.solution7.Solution_731;
import cn.db117.leetcode.solution7.Solution_732;

/**
 * 线段树
 * 区间修改,区间查询
 * 动态开点,懒更新
 *
 * @author db117
 * @see Solution_731
 * @see Solution_732
 * @see Solution_729
 * @since 2022/9/16 11:45
 **/
public class SegmentTreeRangeMax {

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
