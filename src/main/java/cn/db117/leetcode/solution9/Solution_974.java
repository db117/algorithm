// 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 283 👎 0


package cn.db117.leetcode.solution9;

import java.util.HashMap;
import java.util.Map;

/**
 * 974.和可被 K 整除的子数组.subarray-sums-divisible-by-k
 *
 * @author db117
 * @since 2021-06-29 17:21:42
 **/

public class Solution_974 {
    public static void main(String[] args) {
        Solution solution = new Solution_974().new Solution();

        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            // 同余定理
            // 数论中的重要概念。给定一个正整数m，如果两个整数a和b满足a-b能够被m整除，即(a-b)/m得到一个整数，
            // 那么就称整数a与b对模m同余，记作a≡b(mod m)。对模m同余是整数的一个等价关系。

            // 不知道同余定理搞不起来
            int ans = 0;
            int sum = 0;
            // 记录前缀和的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 和等于 k 时,使用
            map.put(0, 1);

            for (int num : nums) {
                sum += num;
                sum %= k;
                if (sum < 0) {
                    sum += k;
                }

                // 余数相等,则差可以被整除
                ans += map.getOrDefault(sum, 0);

                // 保存当前前缀和
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}