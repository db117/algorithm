// 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
// 
//
// 示例2: 
//
// 
// 输入：num = 1
// 输出：[2, -1]
// 
//
// 提示: 
//
// 
// num的范围在[1, 2147483647]之间； 
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。 
// 
// Related Topics 位运算 
// 👍 29 👎 0


package cn.db117.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 05.04.下一个数.closed-number-lcci
 *
 * @author db117
 * @since 2021-05-31 11:16:49
 **/

public class Interview_0504 {
    public static void main(String[] args) {
        Solution solution = new Interview_0504().new Solution();

        //1837591841 [1837591842,1837591832]
        System.out.println(Arrays.toString(solution.findClosedNumbers(1837591841)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findClosedNumbers(int num) {
            // 简单粗暴
            if (num == Integer.MAX_VALUE) {
                return new int[]{-1, -1};
            }

            int pre = -1, next = -1;
            int count = Integer.bitCount(num);

            // 越界
            int max = (int) Math.min(2L * num, Integer.MAX_VALUE);
            for (int i = num + 1; i <= max; i++) {
                if (Integer.bitCount(i) == count) {
                    next = i;
                    break;
                }
            }

            for (int i = num - 1; i >= num / 2; i--) {
                if (Integer.bitCount(i) == count) {
                    pre = i;
                    break;
                }
            }

            return new int[]{next, pre};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}