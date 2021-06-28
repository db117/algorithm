// 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 965 👎 0


package cn.db117.leetcode.solution5;

import java.util.HashMap;
import java.util.Map;

/**
 * 560.和为K的子数组.subarray-sum-equals-k
 *
 * @author db117
 * @since 2021-06-28 17:01:12
 **/

public class Solution_560 {
    public static void main(String[] args) {
        Solution solution = new Solution_560().new Solution();

        System.out.println(solution.subarraySum(new int[]{
                1, 1, 1
        }, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 前缀和 -> 出现次数
            Map<Integer, Integer> hash = new HashMap<>();
            // sum 为 0 时
            hash.put(0, 1);
            int sum = 0;
            int ans = 0;

            for (int num : nums) {
                sum += num;
                if (hash.containsKey(sum - k)) {
                    // 前面出现过 k-sum 差分即为符合题意的区间
                    ans += hash.get(sum - k);
                }

                // 记录当前和出现的次数
                hash.put(sum, hash.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}