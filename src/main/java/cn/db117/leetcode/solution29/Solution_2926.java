

//给你一个下标从 0 开始的整数数组 nums 。 
//
// nums 一个长度为 k 的 子序列 指的是选出 k 个 下标 i0 < i1 < ... < ik-1 ，如果这个子序列满足以下条件，我们说它是 平衡的
// ： 
//
// 
// 对于范围 [1, k - 1] 内的所有 j ，nums[ij] - nums[ij-1] >= ij - ij-1 都成立。 
// 
//
// nums 长度为 1 的 子序列 是平衡的。 
//
// 请你返回一个整数，表示 nums 平衡 子序列里面的 最大元素和 。 
//
// 一个数组的 子序列 指的是从原数组中删除一些元素（也可能一个元素也不删除）后，剩余元素保持相对顺序得到的 非空 新数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,3,5,6]
//输出：14
//解释：这个例子中，选择子序列 [3,5,6] ，下标为 0 ，2 和 3 的元素被选中。
//nums[2] - nums[0] >= 2 - 0 。
//nums[3] - nums[2] >= 3 - 2 。
//所以，这是一个平衡子序列，且它的和是所有平衡子序列里最大的。
//包含下标 1 ，2 和 3 的子序列也是一个平衡的子序列。
//最大平衡子序列和为 14 。 
//
// 示例 2： 
//
// 
//输入：nums = [5,-1,-3,8]
//输出：13
//解释：这个例子中，选择子序列 [5,8] ，下标为 0 和 3 的元素被选中。
//nums[3] - nums[0] >= 3 - 0 。
//所以，这是一个平衡子序列，且它的和是所有平衡子序列里最大的。
//最大平衡子序列和为 13 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-2,-1]
//输出：-1
//解释：这个例子中，选择子序列 [-1] 。
//这是一个平衡子序列，而且它的和是 nums 所有平衡子序列里最大的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 动态规划 👍 16 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2926.平衡子序列的最大和.maximum-balanced-subsequence-sum
 *
 * @author db117
 * @since 2023-11-17 11:19:12
 **/

public class Solution_2926 {
    public static void main(String[] args) {
        Solution solution = new Solution_2926().new Solution();
        // [3,3,5,6]
//        System.out.println(solution.maxBalancedSubsequenceSum(new int[]{
//                3, 3, 5, 6
//        }));

        // [-2,-1]
        System.out.println(solution.maxBalancedSubsequenceSum(new int[]{
                -2, -1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxBalancedSubsequenceSum(int[] nums) {
            int n = nums.length;
            // nums[i] -i
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = nums[i] - i;
            }

            Arrays.sort(f);
            TreeArrayMax treeArrayMax = new TreeArrayMax(n);// 维护最大值
            for (int i = 0; i < n; i++) {
                int j = Arrays.binarySearch(f, nums[i] - i);// 搜索值一定在数组中
                long preMax = treeArrayMax.query(j + 1);
                treeArrayMax.add(j + 1, Math.max(0, preMax) + nums[i]);
            }


            return treeArrayMax.query(n);
        }

        public class TreeArrayMax {
            // 下标从 1 开始
            long[] tree;

            public TreeArrayMax(int n) {
                tree = new long[n + 7];
                Arrays.fill(tree, Integer.MIN_VALUE);// 初始化默认值
            }


            public TreeArrayMax(int[] nums) {
                tree = new long[nums.length + 10];
                Arrays.fill(tree, Integer.MIN_VALUE);// 初始化默认值
            }

            /**
             * 最后一个 1
             */
            public int lowBit(int i) {
                return i & -i;
            }

            /**
             * 在指定位置添加值
             *
             * @param x 数组位置(从 1 开始)
             * @param v 增加的值
             */
            public void add(int x, long v) {
                for (int i = x; i < tree.length; i += lowBit(i)) {
                    tree[i] = Math.max(tree[i], v);
                }
            }

            /**
             * 查询[1,x]的和
             *
             * @param x 数组位置(从 1 开始)
             */
            public long query(int x) {
                long ans = Integer.MIN_VALUE;
                for (int i = x; i > 0; i -= lowBit(i)) {
                    ans = Math.max(ans, tree[i]);
                }
                return ans;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}