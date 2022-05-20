

//指定年份 year 和月份 month，返回 该月天数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：year = 1992, month = 7
//输出：31
// 
//
// 示例 2： 
//
// 
//输入：year = 2000, month = 2
//输出：29
// 
//
// 示例 3： 
//
// 
//输入：year = 1900, month = 2
//输出：28
// 
//
// 
//
// 提示： 
//
// 
// 1583 <= year <= 2100 
// 1 <= month <= 12 
// 
// Related Topics 数学 👍 8 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1118.一月有多少天.number-of-days-in-a-month
 *
 * @author db117
 * @since 2022-05-20 11:01:48
 **/

public class Solution_1118 {
    public static void main(String[] args) {
        Solution solution = new Solution_1118().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int numberOfDays(int year, int month) {
            if (month == 2 && check(year)) {
                return 29;
            }

            return arr[month - 1];
        }

        private boolean check(int year) {
            if (year % 4 == 0 && year % 100 != 0) {
                return true;
            }

            return year % 400 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}