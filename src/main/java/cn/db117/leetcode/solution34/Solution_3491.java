

//给定一个字符串数组 numbers 表示电话号码。如果没有电话号码是任何其他电话号码的前缀，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入：numbers = ["1","2","4","3"] 
// 
//
// 输出：true 
//
// 解释： 
//
// 没有数字是其它数字的前缀，所以输出为 true。 
//
// 示例 2： 
//
// 
// 输入：numbers = ["001","007","15","00153"] 
// 
//
// 输出：false 
//
// 解释： 
//
// 字符串 "001" 是字符串 "00153" 的前缀。因此，输出是 false。 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 50 
// 1 <= numbers[i].length <= 50 
// 所有数字只包含 '0' 到 '9' 的数位。 
// 
//
// Related Topics 字典树 数组 字符串 排序 👍 0 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3491.电话号码前缀.phone-number-prefix
 *
 * @author db117
 * @since 2025-04-18 14:04:23
 **/

public class Solution_3491 {
    public static void main(String[] args) {
        Solution solution = new Solution_3491().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean phonePrefix(String[] numbers) {
            Arrays.sort(numbers);
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i].startsWith(numbers[i - 1])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}