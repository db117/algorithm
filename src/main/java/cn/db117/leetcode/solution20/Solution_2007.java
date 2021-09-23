

//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 0 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2007.从双倍数组中还原原数组.find-original-array-from-doubled-array
 *
 * @author db117
 * @since 2021-09-22 18:27:14
 **/

public class Solution_2007 {
    public static void main(String[] args) {
        Solution solution = new Solution_2007().new Solution();

        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{
                1, 3, 4, 2, 6, 8
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            if ((changed.length & 1) == 1) {
                return new int[0];
            }

            // 记录非 0 数字出现的次数
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j : changed) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }

            int[] ans = new int[changed.length / 2];
            int k = 0;
            while (!map.isEmpty()) {
                Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
                Integer num = firstEntry.getKey();
                Integer count = firstEntry.getValue();
                if (num == 0) {
                    // 0
                    if ((count & 1) == 1) {
                        return new int[0];
                    }
                    for (int i = 0; i < count / 2; i++) {
                        ans[k++] = 0;
                    }
                    map.remove(num);
                    continue;
                }

                if (!map.containsKey(num * 2)) {
                    // 没有 2 倍的
                    return new int[0];
                }

                ans[k++] = num;

                // 减去数量
                if (count > 1) {
                    map.put(num, count - 1);
                } else {
                    map.remove(num);
                }

                Integer next = map.get(num * 2);
                if (next > 1) {
                    map.put(num * 2, next - 1);
                } else {
                    map.remove(num * 2);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}