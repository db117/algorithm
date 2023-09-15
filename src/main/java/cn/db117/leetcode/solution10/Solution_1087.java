

//给定一个表示单词列表的字符串 s 。单词中的每个字母都有一个或多个选项。 
//
// 
// 如果有一个选项，则字母按原样表示。 
// 如果有多个选项，则用大括号分隔选项。例如,
// "{a,b,c}" 表示选项
// ["a", "b", "c"] 。 
// 
//
// 例如，如果
// s = "a{b,c}" ，第一个字符总是 'a' ，但第二个字符可以是 'b' 或 'c' 。原来的列表是
// ["ab", "ac"] 。 
//
// 请你 按字典顺序 ，返回所有以这种方式形成的单词。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "{a,b}c{d,e}f"
//输出：["acdf","acef","bcdf","bcef"]
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：["abcd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 50 
// 
// s 由括号 '{}' , ',' 和小写英文字母组成。 
// 
// s 保证是一个有效的输入。 
// 没有嵌套的大括号。 
// 在一对连续的左括号和右括号内的所有字符都是不同的。 
// 
//
// Related Topics 广度优先搜索 字符串 回溯 👍 62 👎 0


package cn.db117.leetcode.solution10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1087.花括号展开.brace-expansion
 *
 * @author db117
 * @since 2023-09-15 15:08:13
 **/

public class Solution_1087 {
    public static void main(String[] args) {
        Solution solution = new Solution_1087().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] expand(String s) {
            List<String> pre = new ArrayList<>();
            pre.add("");

            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == '{') {
                    // 大括号
                    int j = i + 1;
                    while (j < n && s.charAt(j) != '}') {
                        j++;
                    }

                    // 把前面的字符和后面的字符拼接
                    String[] split = s.substring(i + 1, j).split(",");
                    List<String> temp = new ArrayList<>();
                    for (String s1 : split) {
                        for (String s2 : pre) {
                            temp.add(s2 + s1);
                        }
                    }
                    pre = temp;
                    i = j + 1;
                } else {
                    // 普通字符
                    int j = i + 1;
                    while (j < n && s.charAt(j) != '{' && s.charAt(j) != '}') {
                        j++;
                    }
                    String substring = s.substring(i, j);
                    List<String> temp = new ArrayList<>();
                    for (String s1 : pre) {
                        temp.add(s1 + substring);
                    }
                    pre = temp;
                    i = j;
                }
            }
            pre.sort(Comparator.naturalOrder());
            return pre.toArray(new String[0]);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}