package cn.db117.leetcode.solution40;


import java.util.Arrays;

/**
 *4013. 按奇偶比统计子数组 II
 *@since 2026/8/5
 *@author zhangdabing
 */
public class Solution_4013 {


    //leetcode submit region begin(Prohibit modification and deletion)
    static
    class Solution {
        public long countRatioSubarrays(int[] nums, int a, int b) {
            // x / y <= a / bz
            // bx≤ay
            // bx−ay≤0
            int n = nums.length;
            long[] prefix = new long[n + 1];
            // 对于数组(l,r)  prefix[l]≥prefix[r]


            for (int i = 0; i < n; i++) {
                if ((nums[i] & 1) == 0) {
                    prefix[i + 1] = prefix[i] + b;
                } else {
                    prefix[i + 1] = prefix[i] - a;
                }
            }

            long[] sorted = prefix.clone();
            Arrays.sort(sorted);

            Fenwick fenwick = new Fenwick(n + 1);

            long ans = 0;

            for (int i = 0; i < prefix.length; i++) {
                long v = prefix[i];
                int rank = lowerBound(sorted, v) + 1;// 树状数组从 1 开始
                long less = fenwick.query(rank - 1);// 比当前v小的数量
                ans += i - less;// 比当前数字大的个数
                fenwick.add(rank, 1);
            }
            return ans;
        }


        private int lowerBound(long[] nums, long target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }


        static class Fenwick {
            private final long[] tree;

            Fenwick(int n) {
                tree = new long[n + 1];
            }

            void add(int index, long value) {
                while (index < tree.length) {
                    tree[index] += value;
                    index += index & -index;
                }
            }

            long query(int index) {
                long sum = 0;

                while (index > 0) {
                    sum += tree[index];
                    index -= index & -index;
                }

                return sum;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
