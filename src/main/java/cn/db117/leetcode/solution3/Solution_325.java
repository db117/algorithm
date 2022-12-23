

//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,-1,5,-2,3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,-1,2,1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁹ <= k <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 189 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 325.和等于 k 的最长子数组长度.maximum-size-subarray-sum-equals-k
 *
 * @author db117
 * @since 2022-12-23 10:48:25
 **/

public class Solution_325 {
    public static void main(String[] args) {
        Solution solution = new Solution_325().new Solution();
        // 1,-1,5,-2,3
        System.out.println(solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int n = nums.length;
            // 前缀和
            int[] preSum = new int[n + 7];
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }

            // 前缀和 位置 hash
            Map<Integer, List<Integer>> map = new TreeMap<>();
            for (int i = 1; i <= n; i++) {
                map.putIfAbsent(preSum[i], new ArrayList<>());
                map.get(preSum[i]).add(i);
            }

            int ans = 0;
            for (int i = 0; i <= n; i++) {
                // pre
                List<Integer> list = map.get(preSum[i] - k);
                if (list != null) {
                    for (Integer integer : list) {
                        if (integer < i) {
                            ans = Math.max(ans, i - integer);
                        }
                    }
                }

                // suf
                list = map.get(preSum[i] + k);
                if (list != null) {
                    for (Integer integer : list) {
                        if (integer > i) {
                            ans = Math.max(ans, integer - i);
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}