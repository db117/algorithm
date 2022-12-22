

//给定一个形如
// "HH:MM" 表示的时刻
// time ，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。 
//
// 你可以认为给定的字符串一定是合法的。例如，
// "01:34" 和 
// "12:09" 是合法的，“1:34” 和 “12:9” 是不合法的。 
//
// 
//
// 示例 1: 
//
// 
//输入: "19:34"
//输出: "19:39"
//解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。
//结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后。
// 
//
// 示例 2: 
//
// 
//输入: "23:59"
//输出: "22:22"
//解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。 
//答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// time.length == 5 
// time 为有效时间，格式为 "HH:MM". 
// 0 <= HH < 24 
// 0 <= MM < 60 
// 
//
// Related Topics 字符串 枚举 👍 68 👎 0


package cn.db117.leetcode.solution6;

/**
 * 681.最近时刻.next-closest-time
 *
 * @author db117
 * @since 2022-12-22 11:44:37
 **/

public class Solution_681 {
    public static void main(String[] args) {
        Solution solution = new Solution_681().new Solution();

        System.out.println(solution.nextClosestTime("23:59"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nextClosestTime(String time) {
            // 记录出现的数字
            int[] map = new int[10];
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            map[h / 10]++;
            map[h % 10]++;
            map[m / 10]++;
            map[m % 10]++;
            // 遍历每一分钟
            int start = h * 60 + m;
            int end = start + 1440;
            for (int i = start + 1; i < end; i++) {
                i %= 1440;
                int curH = i / 60;
                int curM = i % 60;
                // 当前时刻可以凑出来
                if (map[curH / 10] > 0 && map[curH % 10] > 0 && map[curM / 10] > 0 && map[curM % 10] > 0) {
                    return "%d%d:%d%d".formatted(curH / 10, curH % 10, curM / 10, curM % 10);
                }
            }
            return time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}