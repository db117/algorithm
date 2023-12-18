

//给你一个长度为 n 下标从 0 开始的整数数组 nums 。 
//
// 你可以对 nums 执行特殊操作 任意次 （也可以 0 次）。每一次特殊操作中，你需要 按顺序 执行以下步骤： 
//
// 
// 从范围 [0, n - 1] 里选择一个下标 i 和一个 正 整数 x 。 
// 将 |nums[i] - x| 添加到总代价里。 
// 将 nums[i] 变为 x 。 
// 
//
// 如果一个正整数正着读和反着读都相同，那么我们称这个数是 回文数 。比方说，121 ，2552 和 65756 都是回文数，但是 24 ，46 ，235 都
//不是回文数。 
//
// 如果一个数组中的所有元素都等于一个整数 y ，且 y 是一个小于 10⁹ 的 回文数 ，那么我们称这个数组是一个 等数数组 。 
//
// 请你返回一个整数，表示执行任意次特殊操作后使 nums 成为 等数数组 的 最小 总代价。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：6
//解释：我们可以将数组中所有元素变为回文数 3 得到等数数组，数组变成 [3,3,3,3,3] 需要执行 4 次特殊操作，代价为 |1 - 3| + |2 -
// 3| + |4 - 3| + |5 - 3| = 6 。
//将所有元素变为其他回文数的总代价都大于 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,12,13,14,15]
//输出：11
//解释：我们可以将数组中所有元素变为回文数 11 得到等数数组，数组变成 [11,11,11,11,11] 需要执行 5 次特殊操作，代价为 |10 - 11
//| + |12 - 11| + |13 - 11| + |14 - 11| + |15 - 11| = 11 。
//将所有元素变为其他回文数的总代价都大于 11 。
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [22,33,22,33,22]
//输出：22
//解释：我们可以将数组中所有元素变为回文数 22 得到等数数组，数组变为 [22,22,22,22,22] 需要执行 2 次特殊操作，代价为 |33 - 22
//| + |33 - 22| = 22 。
//将所有元素变为其他回文数的总代价都大于 22 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 4 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 2967.使数组成为等数数组的最小代价.minimum-cost-to-make-array-equalindromic
 *
 * @author db117
 * @since 2023-12-18 11:13:14
 **/

public class Solution_2967 {
    public static void main(String[] args) {
        Solution solution = new Solution_2967().new Solution();
        // [10,12,13,14,15]
        System.out.println(solution.minimumCost(new int[]{
                10, 12, 13, 14, 15
        }));

        // [107,846,886,574,104,863,476,259,338,647]
        System.out.println(solution.minimumCost(new int[]{
                107, 846, 886, 574, 104, 863, 476, 259, 338, 647
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static TreeSet<Integer> set = new TreeSet<>();

        static {
            // 严格按顺序从小到大生成所有回文数（不用字符串转换）
            int palIdx = 0;
            for (int base = 1; base <= 10000; base *= 10) {
                // 生成奇数长度回文数
                for (int i = base; i < base * 10; i++) {
                    int x = i;
                    for (int t = i / 10; t > 0; t /= 10) {
                        x = x * 10 + t % 10;
                    }
                    set.add(x);
                }
                // 生成偶数长度回文数
                if (base <= 1000) {
                    for (int i = base; i < base * 10; i++) {
                        int x = i;
                        for (int t = i; t > 0; t /= 10) {
                            x = x * 10 + t % 10;
                        }
                        set.add(x);
                    }
                }
            }
            set.add(1000000001); // 哨兵，防止越界
        }

        public long minimumCost(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            // 找到中位数
            int mid = n / 2;
            // 中位数最近的回文数
            Integer floor = set.floor(nums[mid]);
            Integer higher = set.higher(nums[mid]);

            return Math.min(helper(nums, floor), helper(nums, higher));
        }

        private long helper(int[] nums, int target) {
            long ans = 0;
            for (int num : nums) {
                ans += Math.abs(num - target);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}