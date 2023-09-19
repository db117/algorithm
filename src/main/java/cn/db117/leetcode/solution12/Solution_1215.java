

//如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。 
//
// 例如，321 是一个步进数，而 421 不是。 
//
// 给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。 
//
// 
//
// 示例： 
//
// 输入：low = 0, high = 21
//输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= low <= high <= 2 * 10^9 
// 
//
// Related Topics 广度优先搜索 回溯 👍 38 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1215.步进数.stepping-numbers
 *
 * @author db117
 * @since 2023-09-19 10:50:33
 **/

public class Solution_1215 {
    public static void main(String[] args) {
        Solution solution = new Solution_1215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int low;
        int high;
        Set<Integer> set = new HashSet<>();

        public List<Integer> countSteppingNumbers(int low, int high) {
            this.low = low;
            this.high = high;

            for (int i = 0; i < 10; i++) {
                // 以每个数字开头
                dfs(i);
            }

            List<Integer> list = new ArrayList<>(set);
            list.sort(Integer::compareTo);
            return list;
        }

        private void dfs(long cur) {
            if (cur > high) {
                return;
            }
            if (cur >= low) {
                set.add((int) cur);
            }

            int last = (int) (cur % 10);
            if (last == 0) {
                dfs(cur * 10 + 1);
            } else if (last == 9) {
                dfs(cur * 10 + 8);
            } else {
                dfs(cur * 10 + last - 1);
                dfs(cur * 10 + last + 1);
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}