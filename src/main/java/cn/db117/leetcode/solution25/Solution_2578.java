

//给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足： 
//
// 
// num1 和 num2 直接连起来，得到 num 各数位的一个排列。 
// 
//
// 
// 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。 
// 
// 
// num1 和 num2 可以包含前导 0 。 
//
//
// 请你返回 num1 和 num2 可以得到的和的 最小 值。 
//
// 注意： 
//
// 
// num 保证没有前导 0 。 
// num1 和 num2 中数位顺序可以与 num 中数位顺序不同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4325
//输出：59
//解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
// 
//
// 示例 2： 
//
// 
//输入：num = 687
//输出：75
//解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
// 
//
// 
//
// 提示： 
//
// 
// 10 <= num <= 10⁹ 
// 
//
// Related Topics 贪心 数学 排序 👍 13 👎 0


package cn.db117.leetcode.solution25;

import java.util.PriorityQueue;

/**
 * 2578.最小和分割.split-with-minimum-sum
 *
 * @author db117
 * @since 2023-07-20 10:26:21
 **/

public class Solution_2578 {
    public static void main(String[] args) {
        Solution solution = new Solution_2578().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitNum(int num) {
            int[] arr = new int[10];
            while (num > 0) {
                arr[num % 10]++;
                num /= 10;
            }


            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(0);
            pq.offer(0);
            for (int i = 1; i < 10; i++) {
                while (arr[i] > 0) {
                    // 每次取最小的一个数字
                    Integer min = pq.poll();
                    // 把当前数字放到最小的数字后面
                    min *= 10;
                    min += i;
                    pq.offer(min);
                    arr[i]--;
                }
            }
            return pq.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}