package cn.db117.leetcode.solution40;

/**
 *4000. 给定数位和的最大整数
 *@since 2026/7/26
 *@author zhangdabing
 */
public class Solution_4000 {
    class Solution {
        public int largestInteger(int n, int s) {
            if (n * 9 < s) {
                return -1;
            }
            StringBuilder ans = new StringBuilder();

            while (s > 0) {
                int add = Math.min(9, s);
                ans.append(add);
                s -= add;
            }
            if (ans.isEmpty()) {
                return 0;
            }
            while (ans.length() < n) {
                ans.append(0);
            }
            return Integer.parseInt(ans.toString());
        }
    }
}
