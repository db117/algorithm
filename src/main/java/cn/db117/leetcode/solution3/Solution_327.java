

//给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 
//upper）之内的 区间和的个数 。 
//
// 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 
//
// 
//示例 1：
//
// 
//输入：nums = [-2,5,-1], lower = -2, upper = 2
//输出：3
//解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0], lower = 0, upper = 0
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// -10⁵ <= lower <= upper <= 10⁵ 
// 题目数据保证答案是一个 32 位 的整数 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 488 👎 0


package cn.db117.leetcode.solution3;

import java.util.*;

/**
 * 327.区间和的个数.count-of-range-sum
 *
 * @author db117
 * @see cn.db117.template.TreeArray
 * @since 2022-09-30 14:44:01
 **/

public class Solution_327 {
    public static void main(String[] args) {
        Solution solution = new Solution_327().new Solution();

        System.out.println(solution.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            // 离散化
            // 找出数组数组需要的数字
            Set<Long> set = new HashSet<>(nums.length * 3);
            long sum = 0;
            set.add(sum);
            for (int num : nums) {
                sum += num;
                set.add(sum);
                set.add(sum - lower);
                set.add(sum - upper);
            }
            // 排序进行离散化
            List<Long> list = new ArrayList<>(set);
            Collections.sort(list);
            Map<Long, Integer> hash = new HashMap<>();
            int i = 0;
            for (Long aLong : list) {
                hash.put(aLong, ++i);
            }

            // 树状数组
            tree = new int[list.size() + 10];

            int ans = 0;
            sum = 0;
            add(hash.get(sum), 1);
            for (int num : nums) {
                sum += num;// 前缀和
                int l = query(hash.get(sum - lower));// 查询和在 [0,sum - lower] 的数量
                int u = query(hash.get(sum - upper) - 1);// 查询和在 [0,sum - upper) 的数量
                ans += l - u;// 和在 [sum - lower,sum - upper] 的数量
                add(hash.get(sum), 1);// 当前和的数量加一
            }

            return ans;
        }


        int[] tree;


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
        public void add(int x, int v) {
            for (int i = x; i < tree.length; i += lowBit(i)) {
                tree[i] += v;
            }
        }

        /**
         * 查询[1,x]的和
         *
         * @param x 数组位置(从 1 开始)
         */
        public int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowBit(i)) {
                ans += tree[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}