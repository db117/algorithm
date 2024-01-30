

//给你一个下标从 0 开始长度为 n 的数组 nums 。 
//
// 每一秒，你可以对数组执行以下操作： 
//
// 
// 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 
//nums[(i + 1) % n] 三者之一。 
// 
//
// 注意，所有元素会被同时替换。 
//
// 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,1,2]
//输出：1
//解释：我们可以在 1 秒内将数组变成相等元素：
//- 第 1 秒，将每个位置的元素分别变为 [nums[3],nums[1],nums[3],nums[3]] 。变化后，nums = [2,2,2,2] 。
//
//1 秒是将数组变成相等元素所需要的最少秒数。
// 
//
// 示例 2： 
//
// 输入：nums = [2,1,3,3,2]
//输出：2
//解释：我们可以在 2 秒内将数组变成相等元素：
//- 第 1 秒，将每个位置的元素分别变为 [nums[0],nums[2],nums[2],nums[2],nums[3]] 。变化后，nums = [2,
//3,3,3,3] 。
//- 第 2 秒，将每个位置的元素分别变为 [nums[1],nums[1],nums[2],nums[3],nums[4]] 。变化后，nums = [3,
//3,3,3,3] 。
//2 秒是将数组变成相等元素所需要的最少秒数。
// 
//
// 示例 3： 
//
// 输入：nums = [5,5,5,5]
//输出：0
//解释：不需要执行任何操作，因为一开始数组中的元素已经全部相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 👍 50 👎 0


package cn.db117.leetcode.solution28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2808.使循环数组所有元素相等的最少秒数.minimum-seconds-to-equalize-a-circular-array
 *
 * @author db117
 * @since 2024-01-30 13:48:59
 **/

public class Solution_2808 {
    public static void main(String[] args) {
        Solution solution = new Solution_2808().new Solution();
        // [1,2,1,2]
//        System.out.println(solution.minimumSeconds(List.of(1, 2, 1, 2)));

        // [5,5,5,5]
        System.out.println(solution.minimumSeconds(List.of(5, 5, 5, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            int ans = n;
            Map<Integer, List<Integer>> count = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                Integer num = nums.get(i);
                count.putIfAbsent(num, new ArrayList<>());
                count.get(num).add(i);
            }

            // 对每个数字进行计算
            for (List<Integer> value : count.values()) {
                int cur = 0;
                for (int j = 0, size = value.size(); j < size; j++) {
                    Integer i = value.get(j);
                    // 每一个数字往前面找
                    if (j == 0) {
                        // 第一个数字,只能往后面找会找到最后一个
                        int dist = i + n - 1 - value.get(size - 1);
                        cur = Math.max(cur, (dist + 1) / 2);
                        continue;
                    }

                    Integer pre = value.get(j - 1);
                    // 两个数字之间的距离,需要的次数
                    cur = Math.max(cur, (i - pre) / 2);

                }
                ans = Math.min(ans, cur);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}