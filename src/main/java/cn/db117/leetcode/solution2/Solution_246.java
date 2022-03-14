

//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。 
//
// 
//
// 示例 1: 
//
// 输入: num = "69"
//输出: true
// 
//
// 示例 2: 
//
// 输入: num = "88"
//输出: true 
//
// 示例 3: 
//
// 输入: num = "962"
//输出: false 
//
// 示例 4： 
//
// 输入：num = "1"
//输出：true
// 
// Related Topics 哈希表 双指针 字符串 👍 40 👎 0


package cn.db117.leetcode.solution2;

/**
 * 246.中心对称数.strobogrammatic-number
 *
 * @author db117
 * @since 2022-03-14 11:39:39
 **/

public class Solution_246 {
    public static void main(String[] args) {
        Solution solution = new Solution_246().new Solution();
        System.out.println(solution.isStrobogrammatic("69"));
        System.out.println(solution.isStrobogrammatic("696"));
        System.out.println(solution.isStrobogrammatic("0"));
        System.out.println(solution.isStrobogrammatic("1"));
        System.out.println(solution.isStrobogrammatic("25"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] map = new char[]{'0', '1', '.', '.', '.', '.', '9', '.', '8', '6'};

        public boolean isStrobogrammatic(String num) {
            char[] chars = num.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left <= right) {
                char c = map[chars[left] - '0'];
                if (c == '.') {
                    return false;
                }
                if (c != chars[right]) {
                    return false;
                }
                right--;
                left++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}