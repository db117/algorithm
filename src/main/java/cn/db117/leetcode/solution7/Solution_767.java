


//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 
// 👍 332 👎 0


package cn.db117.leetcode.solution7;

import java.util.Arrays;

/**
 * 767.重构字符串.reorganize-string
 *
 * @author db117
 * @since 2021-07-01 17:57:30
 **/

public class Solution_767 {
    public static void main(String[] args) {
        Solution solution = new Solution_767().new Solution();
        System.out.println(solution.reorganizeString("aab"));
        System.out.println(solution.reorganizeString("aaab"));
        System.out.println(solution.reorganizeString("aaabcda"));
        System.out.println(solution.reorganizeString("vvvlo"));
        System.out.println(solution.reorganizeString("aabbcc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            int[] count = new int[26];
            int max = -1;
            for (char c : chars) {
                count[c - 'a']++;
                max = Math.max(max, count[c - 'a']);
            }

            // 有字符大于总长的一半
            if (max > (len + 1) >> 1) {
                return "";
            }

            // 对字符出现次数进行排序
            // 大于 1000 的部分保存出现次数，小于 1000 的部分保存字符所有位置
            for (int i = 0; i < count.length; i++) {
                count[i] = count[i] * 1000 + i;
            }


            for (int i = 0; i < chars.length; i++) {
                // 每一次都找数量最多的
                Arrays.sort(count);
                // 每一次找到一个不是当前字符的字符
                for (int j = 25; j >= 0; j--) {

                    if (count[j] < 1000) {
                        // 字符用完了
                        continue;
                    }

                    // 当前字符
                    char c = (char) ('a' + count[j] % 1000);

                    if (i > 0 && chars[i - 1] == c) {
                        continue;
                    }
                    count[j] -= 1000;
                    chars[i] = c;
                    break;
                }

            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}