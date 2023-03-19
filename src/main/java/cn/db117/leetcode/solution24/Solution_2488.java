

//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。 
// 
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 70 👎 0


package cn.db117.leetcode.solution24;

import java.util.HashMap;
import java.util.Map;

/**
 * 2488.统计中位数为 K 的子数组.count-subarrays-with-median-k
 *
 * @author db117
 * @since 2023-03-16 09:52:34
 **/

public class Solution_2488 {
    public static void main(String[] args) {
        Solution solution = new Solution_2488().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubarrays(int[] nums, int k) {
            // 小于目标 -1 大于为 1
            int pos = -1;
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == k) {
                    pos = i;
                    break;
                }
            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);// 后面碰见 0 可以直接加
            int cur = 0;
            for (int i = pos - 1; i >= 0; i--) {
                if (nums[i] < k) {
                    cur++;
                } else {
                    cur--;
                }

                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            // 以当前数字为右边界的子数组
            ans += map.get(0);
            ans += map.getOrDefault(-1, 0);

            cur = 0;
            for (int i = pos + 1; i < n; i++) {
                if (nums[i] < k) {
                    cur--;
                } else {
                    cur++;
                }

                // 奇数
                ans += map.getOrDefault(cur, 0);
                // 偶数
                ans += map.getOrDefault(cur - 1, 0);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}