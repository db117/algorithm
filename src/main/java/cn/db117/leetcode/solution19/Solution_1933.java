

//一个字符串的所有字符都是一样的，被称作等值字符串。 
//
// 
// 举例，"1111" 和 "33" 就是等值字符串。 
// 相比之下，"123"就不是等值字符串。 
// 
//
// 规则：给出一个数字字符串s，将字符串分解成一些等值字符串，如果有且仅有一个等值子字符串长度为2，其他的等值子字符串的长度都是3. 
//
// 如果能够按照上面的规则分解字符串s，就返回真，否则返回假。 
//
// 子串就是原字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 输入: s = "000111000"
//输出: false
//解释:  s只能被分解长度为3的等值子字符串。
// 
//
// 示例 2： 
//
// 输入: s = "00011111222"
//输出: true
//解释: s 能被分解为 ["000","111","11","222"].
// 
//
// 示例 3： 
//
// 输入: s = "01110002223300"
//输出: false
//解释: 一个不能被分解的原因是在开头有一个0.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 1000 
// s 仅包含数字。 
// 
// Related Topics 字符串 👍 2 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1933.判断字符串是否可分解为值均等的子串.check-if-string-is-decomposable-into-value-equal-substrings
 *
 * @author db117
 * @since 2022-06-15 10:45:35
 **/

public class Solution_1933 {
    public static void main(String[] args) {
        Solution solution = new Solution_1933().new Solution();
        System.out.println(solution.isDecomposable("000111000"));
        System.out.println(solution.isDecomposable("00011111222"));
        System.out.println(solution.isDecomposable("01110002223300"));
        System.out.println(solution.isDecomposable("00011111122288"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isDecomposable(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            if (length % 3 != 2) {
                return false;
            }
            // 上一个字符
            char pre = ' ';
            // 当前相同字符长度
            int curLength = 0;
            int index = 0;
            int twoNum = 0;
            while (index < length) {
                if (pre == ' ') {
                    pre = chars[index++];
                    curLength = 1;
                    continue;
                }
                while (index < length && chars[index] == pre) {
                    curLength++;
                    index++;
                }
                int mod = curLength % 3;
                pre = ' ';
                curLength = 0;

                if (mod == 1) {
                    return false;
                }
                if (mod == 2) {
                    twoNum++;
                    if (twoNum > 1) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}