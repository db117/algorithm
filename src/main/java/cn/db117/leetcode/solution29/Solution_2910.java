

//给你一个长度为 n 下标从 0 开始的整数数组 nums 。 
//
// 我们想将下标进行分组，使得 [0, n - 1] 内所有下标 i 都 恰好 被分到其中一组。 
//
// 如果以下条件成立，我们说这个分组方案是合法的： 
//
// 
// 对于每个组 g ，同一组内所有下标在 nums 中对应的数值都相等。 
// 对于任意两个组 g1 和 g2 ，两个组中 下标数量 的 差值不超过 1 。 
// 
//
// 请你返回一个整数，表示得到一个合法分组方案的 最少 组数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3,2,3]
//输出：2
//解释：一个得到 2 个分组的方案如下，中括号内的数字都是下标：
//组 1 -> [0,2,4]
//组 2 -> [1,3]
//所有下标都只属于一个组。
//组 1 中，nums[0] == nums[2] == nums[4] ，所有下标对应的数值都相等。
//组 2 中，nums[1] == nums[3] ，所有下标对应的数值都相等。
//组 1 中下标数目为 3 ，组 2 中下标数目为 2 。
//两者之差不超过 1 。
//无法得到一个小于 2 组的答案，因为如果只有 1 组，组内所有下标对应的数值都要相等。
//所以答案为 2 。 
//
// 示例 2： 
//
// 
//输入：nums = [10,10,10,3,1,1]
//输出：4
//解释：一个得到 2 个分组的方案如下，中括号内的数字都是下标：
//组 1 -> [0]
//组 2 -> [1,2]
//组 3 -> [3]
//组 4 -> [4,5]
//分组方案满足题目要求的两个条件。
//无法得到一个小于 4 组的答案。
//所以答案为 4 。 
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
// Related Topics 贪心 数组 哈希表 👍 24 👎 0


package cn.db117.leetcode.solution29;

import java.util.HashMap;
import java.util.Map;

/**
 * 2910.合法分组的最少组数.minimum-number-of-groups-to-create-a-valid-assignment
 *
 * @author db117
 * @since 2023-11-08 14:24:43
 **/

public class Solution_2910 {
    public static void main(String[] args) {
        Solution solution = new Solution_2910().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minGroupsForValidAssignment(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int ans = n;
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int k = Integer.MAX_VALUE;// 最小的组大小，一组肯定是小于等于这个值的
            for (Integer i : map.values()) {
                k = Math.min(k, i);
            }
            while (k > 0) {
                // 从最小的组大小开始遍历
                int check = check(map, k);
                if (check != -1) {
                    return check;
                }
                k--;
            }
            return ans;
        }

        private int check(Map<Integer, Integer> map, int k) {
            int ans = 0;
            for (Integer count : map.values()) {
                if (count / k < count % k) {
                    return -1;
                }
                // 先按照 k 进行分组，然后剩余的分到每个组中
                // 那么就相当于每个组最多都有 k+1 个,相当于对 k+1 向上取整
                ans += (count + k) / (k + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}