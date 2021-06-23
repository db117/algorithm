// 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 28 👎 0


package cn.db117.leetcode.solution17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1711.大餐计数.count-good-meals
 *
 * @author db117
 * @since 2021-06-22 19:05:15
 **/

public class Solution_1711 {
    public static void main(String[] args) {
        Solution solution = new Solution_1711().new Solution();

//        System.out.println(solution.countPairs(new int[]{
//                1, 3, 5, 7, 9
//        }));
//        System.out.println(solution.countPairs(new int[]{
//                1, 1, 1, 3, 3, 3, 7
//        }));
        // 1
        System.out.println(solution.countPairs(new int[]{
                1048576, 1048576
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] deliciousness) {
            int[] tmp = new int[22];
            for (int i = 0; i < 22; i++) {
                tmp[i] = 1 << i;
            }
            long ans = 0;
            // 美味->数量
            Map<Integer, Integer> map = new HashMap<>();
            // 已经计算过的
            Set<String> set = new HashSet<>();

            for (int i : deliciousness) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer num = entry.getKey();
                Integer count = entry.getValue();
                for (int i : tmp) {
                    if (i <= num) {
                        continue;
                    }

                    if (map.containsKey(i - num)) {
                        // 去掉重复
                        String key = Math.min(num, (i - num)) + "," + Math.max(num, (i - num));
                        if (!set.contains(key)) {
                            // 找到了大餐
                            if (i - num == num) {
                                // 两个数字相等
                                // 组合公式
                                ans += (long) (count - 1) * count / 2;
                            } else {
                                ans += (long) map.get(i - num) * count;
                            }
                            ans %= 1_000_000_007;
                            set.add(key);
                        }
                    }
                }

            }

            return (int) (ans % 1_000_000_007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}