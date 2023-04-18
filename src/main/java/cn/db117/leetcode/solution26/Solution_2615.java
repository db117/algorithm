

//给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 
//且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。 
//
// 返回数组 arr 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1,1,2]
//输出：[5,0,3,4,0]
//解释：
//i = 0 ，nums[0] == nums[2] 且 nums[0] == nums[3] 。因此，arr[0] = |0 - 2| + |0 - 3| 
//= 5 。 
//i = 1 ，arr[1] = 0 因为不存在值等于 3 的其他下标。
//i = 2 ，nums[2] == nums[0] 且 nums[2] == nums[3] 。因此，arr[2] = |2 - 0| + |2 - 3| 
//= 3 。
//i = 3 ，nums[3] == nums[0] 且 nums[3] == nums[2] 。因此，arr[3] = |3 - 0| + |3 - 2| 
//= 4 。 
//i = 4 ，arr[4] = 0 因为不存在值等于 2 的其他下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,5,3]
//输出：[0,0,0]
//解释：因为 nums 中的元素互不相同，对于所有 i ，都有 arr[i] = 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 15 👎 0


package cn.db117.leetcode.solution26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2615.等值距离和.sum-of-distances
 *
 * @author db117
 * @since 2023-04-11 10:25:15
 **/

public class Solution_2615 {
    public static void main(String[] args) {
        Solution solution = new Solution_2615().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] distance(int[] nums) {
            int n = nums.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }

            Map<Integer, long[]> preMap = new HashMap<>();
            Map<Integer, long[]> lastMap = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer num = entry.getKey();
                List<Integer> list = entry.getValue();

                int size = list.size();
                if (size < 2) {
                    continue;
                }

                // 前后都算一下到当前位置的距离和
                long[] pres = new long[size + 1];
                for (int i = 1; i < size; i++) {
                    pres[i + 1] = pres[i] + (long) i * (list.get(i) - list.get(i - 1));
                }
                long[] lastArr = new long[size + 1];
                for (int i = size - 2; i >= 0; i--) {
                    lastArr[i] = lastArr[i + 1] + (long) (size - i - 1) * (list.get(i + 1) - list.get(i));
                }
                preMap.put(num, pres);
                lastMap.put(num, lastArr);
            }

            long[] ans = new long[n];

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer num = entry.getKey();
                List<Integer> list = entry.getValue();
                if (list.size() < 2) {
                    continue;
                }
                long[] pre = preMap.get(num);
                long[] last = lastMap.get(num);
                for (int i = 0; i < list.size(); i++) {
                    // 直接加前后到当前位置的距离
                    ans[list.get(i)] = pre[i + 1] + last[i];
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}