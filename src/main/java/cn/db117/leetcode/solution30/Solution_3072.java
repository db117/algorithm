

//给你一个下标从 1 开始、长度为 n 的整数数组 nums 。 
//
// 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。 
//
// 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二
//次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中： 
//
// 
// 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
//arr1 。 
// 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
//arr2 。 
// 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元
//素数量较少的数组中。 
// 如果仍然相等，那么将 nums[i] 追加到 arr1 。 
// 
//
// 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 
//result = [1,2,3,4,5,6] 。 
//
// 返回整数数组 result 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3,3]
//输出：[2,3,1,3]
//解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
//在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
//因此，连接形成的数组 result 是 [2,3,1,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,14,3,1,2]
//输出：[5,3,1,2,14]
//解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
//在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
//在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
//因此，连接形成的数组 result 是 [5,3,1,2,14] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3,3,3]
//输出：[3,3,3,3]
//解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
//因此，连接形成的数组 result 是 [3,3,3,3] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 树状数组 线段树 数组 模拟 👍 6 👎 0


package cn.db117.leetcode.solution30;

import java.util.*;

/**
 * 3072.将元素分配到两个数组中 II.distribute-elements-into-two-arrays-ii
 *
 * @author db117
 * @since 2024-03-07 11:15:12
 **/

public class Solution_3072 {
    public static void main(String[] args) {
        Solution solution = new Solution_3072().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] resultArray(int[] nums) {
            int n = nums.length;
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            arr1.add(nums[0]);
            arr2.add(nums[1]);

            // 离散化
            int[] sorted = nums.clone();
            Arrays.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(sorted[i], i + 1);
            }

            // 初始化树状数组
            FenwickTree f1 = new FenwickTree(n);
            FenwickTree f2 = new FenwickTree(n);
            f1.update(map.get(nums[0]), 1);
            f2.update(map.get(nums[1]), 1);
            for (int i = 2; i < n; i++) {
                // 查询两个数组中大于 nums[i] 的元素数量
                int k1 = f1.query(n) - f1.query(map.get(nums[i]));
                int k2 = f2.query(n) - f2.query(map.get(nums[i]));
                if (k1 > k2 || (k1 == k2 && arr1.size() <= arr2.size())) {
                    f1.update(map.get(nums[i]), 1);
                    arr1.add(nums[i]);
                } else {
                    f2.update(map.get(nums[i]), 1);
                    arr2.add(nums[i]);
                }
            }

            int[] ans = new int[nums.length];
            for (int i = 0; i < arr1.size(); i++) {
                ans[i] = arr1.get(i);
            }
            for (int i = 0; i < arr2.size(); i++) {
                ans[i + arr1.size()] = arr2.get(i);
            }
            return ans;
        }

        class FenwickTree {
            private int[] tree;
            private int n;

            public FenwickTree(int n) {
                this.n = n;
                this.tree = new int[n + 1];
            }

            public void update(int i, int delta) {
                while (i <= n) {
                    tree[i] += delta;
                    i += lowbit(i);
                }
            }

            public int query(int i) {
                int sum = 0;
                while (i > 0) {
                    sum += tree[i];
                    i -= lowbit(i);
                }
                return sum;
            }

            private int lowbit(int x) {
                return x & (-x);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}