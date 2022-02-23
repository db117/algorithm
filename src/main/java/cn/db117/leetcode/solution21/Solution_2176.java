

//给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[
//j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,2,2,2,1,3], k = 2
//输出：4
//解释：
//总共有 4 对数符合所有要求：
//- nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
//- nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
//- nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
//- nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4], k = 1
//输出：0
//解释：由于数组中没有重复数值，所以没有数对 (i,j) 符合所有要求。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i], k <= 100 
// 
// Related Topics 数组 👍 2 👎 0


package cn.db117.leetcode.solution21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2176.统计数组中相等且可以被整除的数对.count-equal-and-divisible-pairs-in-an-array
 *
 * @author db117
 * @since 2022-02-23 17:06:40
 **/

public class Solution_2176 {
    public static void main(String[] args) {
        Solution solution = new Solution_2176().new Solution();
        System.out.println(solution.countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
        System.out.println(solution.countPairs(new int[]{1, 2, 3, 4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] nums, int k) {
            int ans = 0;
            // 统计相同数字的位置
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(i);
            }

            for (List<Integer> list : map.values()) {
                int size = list.size();
                // 相同位置直接计算
                for (int i = 0; i < size; i++) {
                    for (int j = i + 1; j < size; j++) {
                        if (list.get(i) * list.get(j) % k == 0) {
                            ans++;
                        }
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}