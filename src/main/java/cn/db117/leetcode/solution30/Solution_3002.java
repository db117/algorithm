

//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。 
//
// 你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元
//素插入到集合 s 中。 
//
// 返回集合 s可能的 最多 包含多少元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,1,2], nums2 = [1,1,1,1]
//输出：2
//解释：从 nums1 和 nums2 中移除两个 1 。移除后，数组变为 nums1 = [2,2] 和 nums2 = [1,1] 。因此，s = {1,
//2} 。
//可以证明，在移除之后，集合 s 最多可以包含 2 个元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
//输出：5
//解释：从 nums1 中移除 2、3 和 6 ，同时从 nums2 中移除两个 3 和一个 2 。移除后，数组变为 nums1 = [1,4,5] 和 
//nums2 = [2,3,2] 。因此，s = {1,2,3,4,5} 。
//可以证明，在移除之后，集合 s 最多可以包含 5 个元素。 
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]
//输出：6
//解释：从 nums1 中移除 1、2 和 3 ，同时从 nums2 中移除 4、5 和 6 。移除后，数组变为 nums1 = [1,2,3] 和 
//nums2 = [4,5,6] 。因此，s = {1,2,3,4,5,6} 。
//可以证明，在移除之后，集合 s 最多可以包含 6 个元素。 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 2 * 10⁴ 
// n是偶数。 
// 1 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 哈希表 👍 9 👎 0


package cn.db117.leetcode.solution30;

import java.util.HashSet;
import java.util.Set;

/**
 * 3002.移除后集合的最多元素数.maximum-size-of-a-set-after-removals
 *
 * @author db117
 * @since 2024-01-11 11:04:31
 **/

public class Solution_3002 {
    public static void main(String[] args) {
        Solution solution = new Solution_3002().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSetSize(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }
            int ans = 0;
            int same = 0;// 相同元素的数量
            for (Integer integer : set1) {
                if (set2.contains(integer)) {
                    same++;
                }
            }
            int a = set1.size() - same;// 独有元素的数量
            int b = set2.size() - same;
            // 其中一个独有的元素数量大于 n/2 ,另一个就可以随便选了
            if (a >= n / 2) {
                return n / 2 + Math.min(n / 2, set2.size());
            }
            if (b >= n / 2) {
                return n / 2 + Math.min(n / 2, set1.size());
            }

            // 独有元素特别多
            if (a + b >= n) {
                return n;
            }
            // 相同元素特别多
            if (same == n) {
                return n;
            }
            // 都选上独有的,在用相同的元素充填
            return Math.min(n, a + b + same);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}