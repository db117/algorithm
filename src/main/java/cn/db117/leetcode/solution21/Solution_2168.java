

//给你一个由数字组成的字符串 s，返回 s 中独特子字符串数量，其中的每一个数字出现的频率都相同。
//
// 
//
// 示例1: 
//
// 
//输入: s = "1212"
//输出: 5
//解释: 符合要求的子串有 "1", "2", "12", "21", "1212".
//要注意，尽管"12"在s中出现了两次，但在计数的时候只计算一次。
// 
//
// 示例 2: 
//
// 
//输入: s = "12321"
//输出: 9
//解释: 符合要求的子串有 "1", "2", "3", "12", "23", "32", "21", "123", "321".
// 
//
// 
//
// 解释: 
//
// 
// 1 <= s.length <= 1000 
// s 只包含阿拉伯数字. 
// 
//
// Related Topics 哈希表 字符串 计数 哈希函数 滚动哈希 👍 9 👎 0


package cn.db117.leetcode.solution21;

import java.util.HashSet;
import java.util.Set;

/**
 * 2168.每个数字的频率都相同的独特子字符串的数量.unique-substrings-with-equal-digit-frequency
 *
 * @author db117
 * @since 2022-12-19 17:45:11
 **/

public class Solution_2168 {
    public static void main(String[] args) {
        Solution solution = new Solution_2168().new Solution();

        System.out.println(solution.equalDigitFrequency("1212"));
        System.out.println(solution.equalDigitFrequency("12321"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalDigitFrequency(String s) {
            int len = s.length();
            Set<String> set = new HashSet<>();
            // 前缀和
            int[][] preSum = new int[len + 7][];
            int[] temp = new int[10];
            preSum[0] = temp.clone();
            for (int i = 0; i < len; i++) {
                int n = s.charAt(i) - '0';
                temp[n]++;
                preSum[i + 1] = temp.clone();
            }

            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    //  通过前缀和进行比较
                    if (check(preSum[i], preSum[j + 1])) {
                        set.add(s.substring(i, j + 1));
                    }
                }
            }
            return set.size();
        }

        private boolean check(int[] left, int[] right) {
            int diff = -1;
            for (int i = 0; i < 10; i++) {
                int d = right[i] - left[i];
                if (d == 0) {
                    continue;
                }
                if (diff == -1) {
                    diff = d;
                    continue;
                }
                if (d != diff) {
                    return false;
                }

            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}