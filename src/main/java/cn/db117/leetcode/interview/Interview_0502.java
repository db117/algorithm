


//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 70 👎 0


package cn.db117.leetcode.interview;

/**
 * 面试题 05.02.二进制数转字符串.bianry-number-to-string-lcci
 *
 * @author db117
 * @since 2023-03-02 10:08:10
 **/

public class Interview_0502 {
    public static void main(String[] args) {
        Solution solution = new Interview_0502().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder("0.");
            for (int i = 0; i < 6; i++) {
                // 二进制左移一位
                num *= 2;
                // 大于等于 1 则表示当前位为 1
                if (num >= 1) {
                    sb.append(1);
                    num -= 1;
                    if (num == 0) {
                        // 后面没有了
                        break;
                    }
                } else {
                    sb.append(0);
                }
            }

            // num ！= 0  则表示不能用 6 位表示
            return num == 0 ? sb.toString() : "ERROR";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}