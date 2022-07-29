

//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与 
//nums[j] 的数位和相等。 
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。 
//
// 示例 2： 
//
// 
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 8 👎 0


package cn.db117.leetcode.solution23;

import java.util.*;

/**
 * 2342.数位和相等数对的最大和.max-sum-of-a-pair-with-equal-sum-of-digits
 *
 * @author db117
 * @since 2022-07-29 16:54:50
 **/

public class Solution_2342 {
    public static void main(String[] args) {
        Solution solution = new Solution_2342().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
            int max = -1;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int num : nums) {
                int sum = helper(num);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(num);
            }
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() < 2) {
                    continue;
                }

                list.sort(Comparator.reverseOrder());
                max = Math.max(max, list.get(0) + list.get(1));
            }

            return max;
        }

        private int helper(int n) {
            int ans = 0;

            while (n > 0) {
                ans += n % 10;
                n /= 10;
            }
            return ans;
        }
    }
//runtime:115 ms
//memory:60.1 MB

//leetcode submit region end(Prohibit modification and deletion)

}