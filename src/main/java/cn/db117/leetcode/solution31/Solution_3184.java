

//给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标
//对 i, j 的数目。 
//
// 整天 定义为时间持续时间是 24 小时的 整数倍 。 
//
// 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。 
//
// 
//
// 示例 1： 
//
// 
// 输入： hours = [12,12,30,24,24] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1) 和 (3, 4)。 
//
// 示例 2： 
//
// 
// 输入： hours = [72,48,24,3] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 100 
// 1 <= hours[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 计数 👍 15 👎 0


package cn.db117.leetcode.solution31;

import java.util.HashMap;
import java.util.Map;

/**
 * 3184.构成整天的下标对数目 I.count-pairs-that-form-a-complete-day-i
 *
 * @author db117
 * @since 2024-10-22 10:24:42
 **/

public class Solution_3184 {
    public static void main(String[] args) {
        Solution solution = new Solution_3184().new Solution();
        // [12,12,30,24,24]
//        System.out.println(solution.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        // [24,19,29]
        System.out.println(solution.countCompleteDayPairs(new int[]{24, 19, 29}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteDayPairs(int[] hours) {
            // 取模版的两数之和
            int n = hours.length;
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int hour : hours) {
                ans += map.getOrDefault((24 - (hour % 24)) % 24, 0);
                map.merge(hour % 24, 1, Integer::sum);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}