

//你有两个果篮，每个果篮中有 n 个水果。给你两个下标从 0 开始的整数数组 basket1 和 basket2 ，用以表示两个果篮中每个水果的成本。 
//
// 你希望两个果篮相等。为此，可以根据需要多次执行下述操作： 
//
// 
// 选中两个下标 i 和 j ，并交换 basket1 中的第 i 个水果和 basket2 中的第 j 个水果。 
// 交换的成本是 min(basket1i,basket2j) 。 
// 
//
// 根据果篮中水果的成本进行排序，如果排序后结果完全相同，则认为两个果篮相等。 
//
// 返回使两个果篮相等的最小交换成本，如果无法使两个果篮相等，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：basket1 = [4,2,2,2], basket2 = [1,4,1,2]
//输出：1
//解释：交换 basket1 中下标为 1 的水果和 basket2 中下标为 0 的水果，交换的成本为 1 。此时，basket1 = [4,1,2,2] 
//且 basket2 = [2,4,1,2] 。重排两个数组，发现二者相等。
// 
//
// 示例 2： 
//
// 
//输入：basket1 = [2,3,4,1], basket2 = [3,2,5,1]
//输出：-1
//解释：可以证明无法使两个果篮相等。
// 
//
// 
//
// 提示： 
//
// 
// basket1.length == bakste2.length 
// 1 <= basket1.length <= 10⁵ 
// 1 <= basket1i,basket2i <= 10⁹ 
// 
//
// Related Topics 贪心 数组 哈希表 👍 12 👎 0


package cn.db117.leetcode.solution25;

import java.util.*;

/**
 * 2561.重排水果.rearranging-fruits
 *
 * @author db117
 * @since 2023-02-07 14:11:09
 **/

public class Solution_2561 {
    public static void main(String[] args) {
        Solution solution = new Solution_2561().new Solution();
        // [84,80,43,8,80,88,43,14,100,88] [32,32,42,68,68,100,42,84,14,8]
        System.out.println(solution.minCost(new int[]{84, 80, 43, 8, 80, 88, 43, 14, 100, 88},
                new int[]{32, 32, 42, 68, 68, 100, 42, 84, 14, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minCost(int[] basket1, int[] basket2) {
            long ans = 0;
            // 使用 map 记录需要调整的数字数量
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < basket1.length; i++) {
                // 如果为 0 则不需要交换
                map.merge(basket1[i], 1, Integer::sum);
                map.merge(basket2[i], -1, Integer::sum);
            }

            // 全局最小值,工具人数字 可以来回倒腾两次换一个数字
            int min = Integer.MAX_VALUE;

            // 记录所有需要交换的数字
            List<Integer> need = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer num = entry.getKey();
                Integer count = entry.getValue();
                min = Math.min(min, num);
                count = Math.abs(count);
                if (count == 0) {
                    continue;
                }
                if ((count & 1) == 1) {
                    // 奇数个数字,分不了
                    return -1;
                }


                // 只有一半需要交换
                for (int i = 0; i < count / 2; i++) {
                    need.add(num);
                }
            }

            // 工具人数字,交换两次可以倒腾一个数字
            min *= 2;

            Collections.sort(need);
            // 交换时用小的交换大的 则只需要计算前半部分
            for (int i = 0; i < need.size() / 2; i++) {
                // 取最小成本
                ans += Math.min(min, need.get(i));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}