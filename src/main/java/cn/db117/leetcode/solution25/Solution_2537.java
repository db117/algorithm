

//给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。 
//
// 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。 
//
// 子数组 是原数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1,1,1], k = 10
//输出：1
//解释：唯一的好子数组是这个数组本身。
// 
//
// 示例 2： 
//
// 输入：nums = [3,1,4,3,2,2,4], k = 2
//输出：4
//解释：总共有 4 个不同的好子数组：
//- [3,1,4,3,2,2] 有 2 对。
//- [3,1,4,3,2,2,4] 有 3 对。
//- [1,4,3,2,2,4] 有 2 对。
//- [4,3,2,2,4] 有 2 对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 15 👎 0


package cn.db117.leetcode.solution25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537.统计好子数组的数目.count-the-number-of-good-subarrays
 *
 * @author db117
 * @since 2023-01-17 14:54:22
 **/

public class Solution_2537 {
    public static void main(String[] args) {
        Solution solution = new Solution_2537().new Solution();
        System.out.println(solution.countGood(new int[]{2, 3, 1, 3, 2, 3, 3, 3, 1, 1, 3, 2, 2, 2}, 18));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countGood(int[] nums, int k) {
            long ans = 0;
            // 双指针
            int left = 0;
            int cur = 0;
            Map<Integer, Integer> count = new HashMap<>();
            for (int right = 0; right < nums.length; right++) {
                int num = nums[right];
                cur += count.getOrDefault(num, 0);
                count.merge(num, 1, Integer::sum);

                if (cur < k) {
                    // 这个区间不满足题意
                    continue;
                }
                while (left < right) {
                    // 收缩左边界,直到区间最小
                    Integer lc = count.getOrDefault(nums[left], 0);
                    if (cur - lc + 1 >= k) {
                        // 左边界可以收缩
                        cur -= lc - 1;
                        count.put(nums[left], lc - 1);
                        left++;
                    } else {
                        break;
                    }
                }

                // 以左边界开始的所有左边子数组全部符合题意
                ans += left + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}