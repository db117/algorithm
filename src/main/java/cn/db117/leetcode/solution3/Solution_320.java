

//单词的 广义缩写词 可以通过下述步骤构造：先取任意数量的 不重叠、不相邻 的子字符串，再用它们各自的长度进行替换。 
//
// 
// 例如，"abcde" 可以缩写为： 
// 
//
// 
// "a3e"（"bcd" 变为 "3" ） 
// "1bcd1"（"a" 和 "e" 都变为 "1"） 
// "5" ("abcde" 变为 "5") 
// "abcde" (没有子字符串被代替) 
// 
// 
// 然而，这些缩写是 无效的 ：
// 
// "23"（"ab" 变为 "2" ，"cde" 变为 "3" ）是无效的，因为被选择的字符串是相邻的 
// "22de" ("ab" 变为 "2" ， "bc" 变为 "2") 是无效的，因为被选择的字符串是重叠的 
// 
// 
//
//
// 给你一个字符串 word ，返回 一个由 word 的所有可能 广义缩写词 组成的列表 。按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "word"
//输出：["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd",
//"wo2","wo1d","wor1","word"]
// 
//
// 示例 2： 
//
// 
//输入：word = "a"
//输出：["1","a"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 15 
// word 仅由小写英文字母组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 94 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * 320.列举单词的全部缩写.generalized-abbreviation
 *
 * @author db117
 * @since 2023-04-23 14:17:19
 **/

public class Solution_320 {
    public static void main(String[] args) {
        Solution solution = new Solution_320().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateAbbreviations(String word) {
            List<String> ans = new ArrayList<>();

            dfs(word.toCharArray(), 0, ans, new StringBuilder(), false);

            return ans;
        }

        /**
         * dfs
         *
         * @param chars 字符
         * @param i     当前索引
         * @param ans   ans
         * @param sb    当前字符串
         * @param isNum 上一个字符是否是数字
         */
        private void dfs(char[] chars, int i, List<String> ans, StringBuilder sb, boolean isNum) {
            if (i == chars.length) {
                ans.add(sb.toString());
                return;
            }

            // 不管前面是啥，则都可以写字符
            sb.append(chars[i]);
            dfs(chars, i + 1, ans, sb, false);
            sb.deleteCharAt(sb.length() - 1);

            if (isNum) {
                // 前面有数字，不能缩写
                return;
            }

            // 枚举所有能缩写的可能
            int count = 0;
            for (int j = i; j < chars.length; j++) {
                count++;
                sb.append(count);
                dfs(chars, j + 1, ans, sb, true);

                // 前面数字可能是 2 个字符
                for (int k = 0; k < String.valueOf(count).length(); k++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}