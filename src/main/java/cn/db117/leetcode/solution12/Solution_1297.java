// 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
//
// 
// 子串中不同字母的数目必须小于等于 maxLetters 。 
// 子串的长度必须大于等于 minSize 且小于等于 maxSize 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//输出：2
//解释：子串 "aab" 在原字符串中出现了 2 次。
//它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
// 
//
// 示例 2： 
//
// 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//输出：2
//解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
// 
//
// 示例 3： 
//
// 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
//输出：3
// 
//
// 示例 4： 
//
// 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 1 <= maxLetters <= 26 
// 1 <= minSize <= maxSize <= min(26, s.length) 
// s 只包含小写英文字母。 
// 
// Related Topics 位运算 字符串 
// 👍 50 👎 0


package cn.db117.leetcode.solution12;

import java.util.HashMap;
import java.util.Map;

/**
 * 1297.子串的最大出现次数.maximum-number-of-occurrences-of-a-substring
 *
 * @author db117
 * @since 2021-06-03 16:01:02
 **/

public class Solution_1297 {
    public static void main(String[] args) {
        Solution solution = new Solution_1297().new Solution();

        System.out.println(solution.maxFreq("aabcabcab", 2, 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            // 最大长度肯定包含最小的
            Map<String, Integer> map = new HashMap<>();

            char[] chars = s.toCharArray();
            int tmp;
            String key;
            for (int i = 0; i <= chars.length - minSize; i++) {
                tmp = 0;

                // 记录字母出现的次数
                for (int j = 0; j < minSize; j++) {
                    tmp |= (1 << (chars[i + j] - 'a'));
                }

                // 不同的字母数量
                if (Integer.bitCount(tmp) > maxLetters) {
                    continue;
                }

                // 统计数量
                key = s.substring(i, i + minSize);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            return map.values()
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(0);// 啥都没有
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}