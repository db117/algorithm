

//给你一个正整数数组 nums 和一个整数 k 。 
//
// 一次操作中，你可以将数组的最后一个元素删除，将该元素添加到一个集合中。 
//
// 请你返回收集元素 1, 2, ..., k 需要的 最少操作次数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,5,4,2], k = 2
//输出：4
//解释：4 次操作后，集合中的元素依次添加了 2 ，4 ，5 和 1 。此时集合中包含元素 1 和 2 ，所以答案为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,5,4,2], k = 5
//输出：5
//解释：5 次操作后，集合中的元素依次添加了 2 ，4 ，5 ，1 和 3 。此时集合中包含元素 1 到 5 ，所以答案为 5 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,5,3,1], k = 3
//输出：4
//解释：4 次操作后，集合中的元素依次添加了 1 ，3 ，5 和 2 。此时集合中包含元素 1 到 3  ，所以答案为 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= nums.length 
// 1 <= k <= nums.length 
// 输入保证你可以收集到元素 1, 2, ..., k 。 
// 
//
// Related Topics 位运算 数组 哈希表 👍 5 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2869.收集元素的最少操作次数.minimum-operations-to-collect-elements
 *
 * @author db117
 * @since 2024-04-15 09:36:33
 **/

public class Solution_2869 {
    public static void main(String[] args) {
        Solution solution = new Solution_2869().new Solution();

        // nums = [3,1,5,4,2], k = 2
        System.out.println(solution.minOperations(List.of(3, 1, 5, 4, 2), 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(List<Integer> nums, int k) {
            int[] hash = new int[k+1];
            int ans = 0;
            int cnt = 0;
            int size = nums.size();
            for (int i = size - 1; i >= 0; i--) {
                Integer num = nums.get(i);
                ans++;
                if (num > k) {
                    continue;
                }
                hash[num]++;
                if (hash[num] == 1) {
                    cnt++;
                }
                if (cnt == k) {
                  return ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}