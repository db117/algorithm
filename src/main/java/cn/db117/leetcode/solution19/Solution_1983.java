

//给定两个 以0为索引 的二进制数组 nums1 和 nums2 。找出 最宽 的索引对 (i, j) ，使的 i <= j 并且 nums1[i] + 
//nums1[i+1] + ... + nums1[j] == nums2[i] + nums2[i+1] + ... + nums2[j]。 
//
// 最宽 的指标对是指在 i 和 j 之间的 距离最大 的指标对。一对指标之间的 距离 定义为 j - i + 1 。 
//
// 返回 最宽 索引对的 距离 。如果没有满足条件的索引对，则返回 0 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,1,0,1], nums2 = [0,1,1,0]
//输出: 3
//解释:
//如果i = 1, j = 3:
//Nums1 [1] + Nums1 [2] + Nums1[3] = 1 + 0 + 1 = 2。
//Nums2 [1] + Nums2 [2] + Nums2[3] = 1 + 1 + 0 = 2。
//i和j之间的距离是j - i + 1 = 3 - 1 + 1 = 3。
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [0,1], nums2 = [1,1]
//输出: 1
//解释:
//If i = 1 and j = 1:
//nums1[1] = 1。
//nums2[1] = 1。
//i和j之间的距离是j - i + 1 = 1 - 1 + 1 = 1。
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [0], nums2 = [1]
//输出: 0
//解释:
//没有满足要求的索引对。
// 
//
// 
//
// 提示: 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// nums1[i] 仅为 0 或 1. 
// nums2[i] 仅为 0 或 1. 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 8 👎 0


package cn.db117.leetcode.solution19;

import java.util.HashMap;
import java.util.Map;

/**
 * 1983.范围和相等的最宽索引对.widest-pair-of-indices-with-equal-range-sum
 *
 * @author db117
 * @since 2024-05-22 17:21:55
 **/

public class Solution_1983 {
    public static void main(String[] args) {
        Solution solution = new Solution_1983().new Solution();
        // 			[0,1]
        //			[1,1]
        System.out.println(solution.widestPairOfIndices(new int[]{
                0, 1
        }, new int[]{
                1, 1
        }));

        // [0]
        //			[0]
        System.out.println(solution.widestPairOfIndices(new int[]{
                0
        }, new int[]{
                0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int widestPairOfIndices(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] pre1 = new int[n + 1];
            int[] pre2 = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre1[i + 1] = pre1[i] + nums1[i];
                pre2[i + 1] = pre2[i] + nums2[i];
            }
            int ans = 0;
            // 当两个前缀和的差值相等时,则说明这个区间的和相等
            // 前缀和差值 -》 第一次出现的位置
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);// 从 0 开始的情况
            for (int i = 0; i < n; i++) {
                int diff = pre1[i + 1] - pre2[i + 1];
                Integer first = map.get(diff);

                if (first != null) {
                    // 前面出现了，那么中间的和就是相等的
                    ans = Math.max(ans, i - first);
                } else {
                    map.put(diff, i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}