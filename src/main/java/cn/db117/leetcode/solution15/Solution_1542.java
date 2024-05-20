

//给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。 
//
// 「超赞子字符串」需满足满足下述两个条件： 
//
// 
// 该字符串是 s 的一个非空子字符串 
// 进行任意次数的字符交换后，该字符串可以变成一个回文字符串 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "3242415"
//输出：5
//解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
// 
//
// 示例 2： 
//
// 输入：s = "12345678"
//输出：1
// 
//
// 示例 3： 
//
// 输入：s = "213123"
//输出：6
//解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
// 
//
// 示例 4： 
//
// 输入：s = "00"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 仅由数字组成 
// 
//
// Related Topics 位运算 哈希表 字符串 👍 97 👎 0


package cn.db117.leetcode.solution15;

import java.util.HashMap;
import java.util.Map;

/**
 * 1542.找出最长的超赞子字符串.find-longest-awesome-substring
 *
 * @author db117
 * @since 2024-05-20 10:05:34
 **/

public class Solution_1542 {
    public static void main(String[] args) {
        Solution solution = new Solution_1542().new Solution();
        // "12345678"
//        System.out.println(solution.longestAwesome("12345678"));
        // "213123"
        System.out.println(solution.longestAwesome("213123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestAwesome(String s) {
            // 使用一个数字表示每个字符出现的奇偶次数  0 偶数 1 奇数
            int n = s.length();
            int ans = 1;
            // 记录第一次出现的位置
            Map<Integer, Integer> map = new HashMap<>();
            int flag = 0;
            char[] chars = s.toCharArray();
            map.put(0, -1);// 当前整个字符串是回文的
            for (int i = 0; i < n; i++) {
                int c = chars[i] - '0';
                // 改变当前字符的出现的奇偶次数
                flag ^= 1 << c;

                // 找和当前 flag 相同的位置
                Integer first = map.get(flag);
                if (first != null) {
                    // 当前位置和第一次出现的位置之间的字符都是回文的
                    ans = Math.max(ans, i - first );
                }
                // 找和当前 flag 只有一个字符不同的位置
                // 如果只有一个字符不同则异或的结果肯定是 2 的幂次方
                for (int j = 0; j < 10; j++) {
                    // 一个一个字符进行试
                    int temp = flag ^ (1 << j);
                    Integer tempFirst = map.get(temp);
                    if (tempFirst != null) {
                        ans = Math.max(ans, i - tempFirst);
                    }
                }
                // 记录第一次出现的位置
                map.putIfAbsent(flag, i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}