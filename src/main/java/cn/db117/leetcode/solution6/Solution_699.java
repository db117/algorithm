

//在二维平面上的 x 轴上，放置着一些方块。 
//
// 给你一个二维整数数组 positions ，其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 
//sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。 
//
// 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。一个方块仅仅是擦过另
//一个方块的左侧边或右侧边不算着陆。一旦着陆，它就会固定在原地，无法移动。 
//
// 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。 
//
// 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。 
//
// 
//
// 示例 1： 
// 
// 
//输入：positions = [[1,2],[2,3],[6,1]]
//输出：[2,5,5]
//解释：
//第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 2 。
//第 2 个方块掉落后，最高的堆叠由方块 1 和 2 组成，堆叠的最高高度为 5 。
//第 3 个方块掉落后，最高的堆叠仍然由方块 1 和 2 组成，堆叠的最高高度为 5 。
//因此，返回 [2, 5, 5] 作为答案。
// 
//
// 示例 2： 
//
// 
//输入：positions = [[100,100],[200,100]]
//输出：[100,100]
//解释：
//第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 100 。
//第 2 个方块掉落后，最高的堆叠可以由方块 1 组成也可以由方块 2 组成，堆叠的最高高度为 100 。
//因此，返回 [100, 100] 作为答案。
//注意，方块 2 擦过方块 1 的右侧边，但不会算作在方块 1 上着陆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= positions.length <= 1000 
// 1 <= lefti <= 10⁸ 
// 1 <= sideLengthi <= 10⁶ 
// 
//
// Related Topics 线段树 数组 有序集合 👍 176 👎 0


package cn.db117.leetcode.solution6;

import java.util.ArrayList;
import java.util.List;

/**
 * 699.掉落的方块.falling-squares
 *
 * @author db117
 * @see cn.db117.template.segment_tree.SegmentTreeRangeOverrideMax
 * @since 2022-09-21 11:44:19
 **/

public class Solution_699 {
    public static void main(String[] args) {
        Solution solution = new Solution_699().new Solution();
        System.out.println(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        // [7,16,17]
        System.out.println(solution.fallingSquares(new int[][]{{9, 7}, {1, 9}, {3, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            SegNode root = new SegNode(0, (int) 1e9);
            List<Integer> ans = new ArrayList<>(positions.length);
            for (int[] position : positions) {
                // 查询区间 [left i, left i+sideLength i) 最大高度
                int max = query(root, position[0], position[0] + position[1] - 1);
                // 区间 [left i, left i+sideLength i) 增加最大高度 sideLength i
                update(root, position[0], position[0] + position[1] - 1, position[1] + max);
                // 全区间最大高度
                ans.add(root.max);
            }
            return ans;
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
            int override = node.lazy;
            if (override == -1) {
                return;
            }

            // 把子节点的数据修改,并标记懒更新
            // 区间每一个位置都覆盖(最大值 不需要乘以子节点数量)
            SegNode left = node.getLeft();
            SegNode right = node.getRight();
            left.lazy = override;
            left.max = override;

            right.lazy = override;
            right.max = override;

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
                node.max = val;
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
//leetcode submit region end(Prohibit modification and deletion)

}