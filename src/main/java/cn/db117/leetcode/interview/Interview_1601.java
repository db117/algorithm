// 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
//
// 示例： 
//
// 
//输入: numbers = [1,2]
//输出: [2,1]
// 
//
// 提示： 
//
// 
// numbers.length == 2 
// -2147483647 <= numbers[i] <= 2147483647 
// 
// Related Topics 位运算 数学 
// 👍 49 👎 0


package cn.db117.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 16.01.交换数字.swap-numbers-lcci
 *
 * @author db117
 * @since 2021-05-31 10:48:12
 **/

public class Interview_1601 {
    public static void main(String[] args) {
        Solution solution = new Interview_1601().new Solution();
        System.out.println(Arrays.toString(solution.swapNumbers(new int[]{1, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] ^= numbers[1];
            numbers[1] ^= numbers[0];
            numbers[0] ^= numbers[1];
            return numbers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}