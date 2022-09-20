

//给你一个整数数组 nums 和一个整数 k 。 
//
// 找到 nums 中满足以下要求的最长子序列： 
//
// 
// 子序列 严格递增 
// 子序列中相邻元素的差值 不超过 k 。 
// 
//
// 请你返回满足上述要求的 最长子序列 的长度。 
//
// 子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
//输出：5
//解释：
//满足要求的最长子序列是 [1,3,4,5,8] 。
//子序列长度为 5 ，所以我们返回 5 。
//注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [7,4,5,1,8,12,4,7], k = 5
//输出：4
//解释：
//满足要求的最长子序列是 [4,5,8,12] 。
//子序列长度为 4 ，所以我们返回 4 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,5], k = 1
//输出：1
//解释：
//满足要求的最长子序列是 [1] 。
//子序列长度为 1 ，所以我们返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁵ 
// 
//
// 👍 34 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2407.最长递增子序列 II.longest-increasing-subsequence-ii
 *
 * @author db117
 * @see cn.db117.template.segment_tree.SegmentTreeSinge
 * @since 2022-09-15 16:50:56
 **/

public class Solution_2407 {
    public static void main(String[] args) {
        Solution solution = new Solution_2407().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
        System.out.println(solution.lengthOfLIS(new int[]{7, 4, 5, 1, 8, 12, 4, 7}, 4));
        System.out.println(solution.lengthOfLIS(new int[]{1, 5}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums, int k) {
            int m = 0;
            // 找最大区间
            for (int num : nums) {
                m = Math.max(m, num);
            }
            // 构建线段树
            SegNode root = new SegNode(1, m);

            for (int num : nums) {
                if (num == 1) {
                    // num 1 长度肯定为 1
                    update(root, 1, 1);
                    continue;
                }
                // 查询 [1,当前值) 的最大长度
                int query = query(root, Math.max(0, num - k), num - 1);
                // 更新当前数字最大值
                update(root, num, query + 1);
            }
            return root.val;
        }

        class SegNode {
            int l, r;
            int val;
            SegNode left, right;

            public SegNode(int l, int r) {
                this.l = l;
                this.r = r;
            }

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

        public int op(int a, int b) {
            return Integer.max(a, b);
        }


        private void pushUp(SegNode node) {
            node.val = op(node.getLeft().val, node.getRight().val);
        }

        public void update(SegNode node, int index, int val) {
            if (node.r == node.l && node.r == index) {
                node.val = val;
                return;
            }

            int mid = (node.l + node.r) >> 1;
            if (index <= mid) {
                update(node.getLeft(), index, val);
            } else {
                update(node.getRight(), index, val);
            }
            pushUp(node);
        }


        public int query(SegNode node, int ql, int qr) {
            if (ql <= node.l && node.r <= qr) {
                return node.val;
            }

            int mid = (node.l + node.r) >> 1;
            if (qr <= mid) {
                return query(node.getLeft(), ql, qr);
            }
            if (ql > mid) {
                return query(node.getRight(), ql, qr);
            }


            return op(query(node.getLeft(), ql, qr), query(node.getRight(), ql, qr));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}