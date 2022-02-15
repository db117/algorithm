

//给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。 
//
// 如果满足下述条件，则数组 nums 是一个 交替数组 ： 
//
// 
// nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。 
// nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。 
// 
//
// 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。 
//
// 返回使数组变成交替数组的 最少操作数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,3,2,4,3]
//输出：3
//解释：
//使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
//在这种情况下，操作数为 3 。
//可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,2,2]
//输出：2
//解释：
//使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
//在这种情况下，操作数为 2 。
//注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 计数 👍 16 👎 0


package cn.db117.leetcode.solution21;

import java.util.*;

/**
 * 2170.使数组变成交替数组的最少操作数.minimum-operations-to-make-the-array-alternating
 *
 * @author db117
 * @since 2022-02-15 11:22:23
 **/

public class Solution_2170 {
    public static void main(String[] args) {
        Solution solution = new Solution_2170().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            HashMap<Integer, Integer> count0 = new HashMap<>();
            HashMap<Integer, Integer> count1 = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    count0.put(nums[i], count0.getOrDefault(nums[i], 0) + 1);
                } else {
                    count1.put(nums[i], count1.getOrDefault(nums[i], 0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> list0 = new ArrayList<>(count0.entrySet());
            List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(count1.entrySet());
            list0.sort(Comparator.comparingInt(Map.Entry::getValue));
            list1.sort(Comparator.comparingInt(Map.Entry::getValue));

            if (!list0.get(list0.size() - 1).getKey().equals(list1.get(list1.size() - 1).getKey())) {
                return nums.length - list0.get(list0.size() - 1).getValue() - list1.get(list1.size() - 1).getValue();
            }

            if (list0.size() == 1 && list1.size() == 1) {
                return nums.length / 2;
            }

            if (list0.size() == 1) {
                return nums.length - list0.get(0).getValue() - list1.get(list1.size() - 2).getValue();
            }
            if (list1.size() == 1) {
                return nums.length - list1.get(0).getValue() - list0.get(list0.size() - 2).getValue();
            }

            return nums.length - Math.max(list0.get(list0.size() - 1).getValue() + list1.get(list1.size() - 2).getValue(),
                    list1.get(list1.size() - 1).getValue() + list0.get(list0.size() - 2).getValue());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}