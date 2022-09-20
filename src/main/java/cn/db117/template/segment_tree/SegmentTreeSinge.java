package cn.db117.template.segment_tree;

/**
 * 线段树
 * 单点修改
 * 动态开点
 *
 * @author db117
 * @see cn.db117.leetcode.solution24.Solution_2407
 * @since 2022/9/15 15:42
 **/
public class SegmentTreeSinge {
    class SegNode {
        // 当前节点左右 范围
        int l, r;
        /**
         * 保存的值
         * 要求操作满足区间可加性
         * 例如 + * | & ^ min max gcd mulMatrix 摩尔投票 最大子段和 ...
         */
        int val;
        /**
         * 左右 节点
         */
        SegNode left, right;

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

    // 操作方式
    public int op(int a, int b) {
        return Integer.max(a, b);
    }

    /**
     * 上推,合并两个子节点的值
     */
    private void pushUp(SegNode node) {
        node.val = op(node.getLeft().val, node.getRight().val);
    }

    /**
     * 更新指定位置的值
     *
     * @param node  节点
     * @param index 指定索引
     * @param val   修改后的值
     */
    public void update(SegNode node, int index, int val) {
        if (node.r == node.l && node.r == index) {
            // 找到目标节点
            node.val = val;
            return;
        }

        // 修改子节点
        int mid = (node.l + node.r) >> 1;
        if (index <= mid) {
            update(node.getLeft(), index, val);
        } else {
            update(node.getRight(), index, val);
        }

        // 合并子节点的数据
        pushUp(node);
    }


    public int query(SegNode node, int ql, int qr) {
        if (ql <= node.l && node.r <= qr) {
            // 找到目标节点
            return node.val;
        }

        // 查询区间在子节点中
        int mid = (node.l + node.r) >> 1;
        if (qr <= mid) {
            return query(node.getLeft(), ql, qr);
        }
        if (ql > mid) {
            return query(node.getRight(), ql, qr);
        }

        // 查询区间跨子节点
        return op(query(node.getLeft(), ql, qr), query(node.getRight(), ql, qr));
    }
}
