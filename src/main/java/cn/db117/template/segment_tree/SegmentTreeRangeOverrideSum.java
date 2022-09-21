package cn.db117.template.segment_tree;


/**
 * 线段树
 * 区间覆盖,区间查询和
 * 动态开点,懒更新
 *
 * @author db117
 * @see cn.db117.leetcode.solution7.Solution_715
 * @since 2022/9/16 11:45
 **/
public class SegmentTreeRangeOverrideSum {

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
