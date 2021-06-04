// 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
//
// 
// 
// 如果当前数字为偶数，则将其除以 2 。 
// 
// 
// 如果当前数字为奇数，则将其加上 1 。 
// 
// 
//
// 题目保证你总是可以按上述规则将测试用例变为 1 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "1101"
//输出：6
//解释："1101" 表示十进制数 13 。
//Step 1) 13 是奇数，加 1 得到 14 
//Step 2) 14 是偶数，除 2 得到 7
//Step 3) 7  是奇数，加 1 得到 8
//Step 4) 8  是偶数，除 2 得到 4  
//Step 5) 4  是偶数，除 2 得到 2 
//Step 6) 2  是偶数，除 2 得到 1  
// 
//
// 示例 2： 
//
// 输入：s = "10"
//输出：1
//解释："10" 表示十进制数 2 。
//Step 1) 2 是偶数，除 2 得到 1 
// 
//
// 示例 3： 
//
// 输入：s = "1"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 由字符 '0' 或 '1' 组成。 
// s[0] == '1' 
// 
// Related Topics 位运算 字符串 
// 👍 29 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1404.将二进制表示减到 1 的步骤数.number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 *
 * @author db117
 * @since 2021-06-03 16:44:27
 **/

public class Solution_1404 {
    public static void main(String[] args) {
        Solution solution = new Solution_1404().new Solution();
        System.out.println(solution.numSteps("1101"));
        System.out.println(solution.numSteps("10"));
        System.out.println(solution.numSteps("1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSteps(String s) {
            // 先找到最后一个1的位置
            int i = s.length() - 1;
            char[] chars = s.toCharArray();
            while (chars[i] == '0') {
                i--;
            }
            if (i == 0) {
                // 1000...
                return chars.length - 1;
            }

            // 统计从最右边的 1 到最左边中间一共有多少个 0
            // 每一个 0 都需要继续 +1 的操作
            int countZero = 0;
            while (i > 0) {
                if (chars[i] == '0') {
                    countZero++;
                }
                i--;
            }

            // 所有都加到 1000000(长度比原有字符串多 1)
            return s.length() + 1 + countZero;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}