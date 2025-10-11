

//一个魔法师有许多不同的咒语。 
//
// 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。 
//
// 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] +
// 1 或者 power[i] + 2 的咒语。 
//
// 每个咒语最多只能被使用 一次 。 
//
// 请你返回这个魔法师可以达到的伤害值之和的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：power = [1,1,3,4] 
// 
//
// 输出：6 
//
// 解释： 
//
// 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。 
//
// 示例 2： 
//
// 
// 输入：power = [7,1,6,6] 
// 
//
// 输出：13 
//
// 解释： 
//
// 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。 
//
// 
//
// 提示： 
//
// 
// 1 <= power.length <= 10⁵ 
// 1 <= power[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 动态规划 计数 排序 👍 81 👎 0


package cn.db117.leetcode.solution31;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3186.施咒的最大总伤害.maximum-total-damage-with-spell-casting
 *
 * @author db117
 * @since 2025-10-11 17:18:43
 **/

public class Solution_3186 {
    public static void main(String[] args) {
        Solution solution = new Solution_3186().new Solution();
        // [7,1,6,6]
        System.out.println(solution.maximumTotalDamage(new int[]{7, 1, 6, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Long> memo = new HashMap<>();

        public long maximumTotalDamage(int[] power) {
            for (int j : power) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }

            return dfs(map.lastKey());
        }

        long dfs(int i) {
            if (i <= 0) {
                return 0;
            }
            Long tmp = memo.get(i);
            if (tmp != null) {
                return tmp;
            }
            // 下一个数字
            Integer next = map.lowerKey(i);
            if (next == null) {
                next = -1;
            }
            // 不选
            long ans = dfs(next);
            // 选
            next = map.lowerKey(i - 2);// 比当前数字小 2 的最大数字
            if (next == null) {
                next = -1;
            }
            ans = Math.max(ans, dfs(next) + (long) map.get(i) * i);// 加上当前数字的伤害

            memo.put(i, ans);// 缓存
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}