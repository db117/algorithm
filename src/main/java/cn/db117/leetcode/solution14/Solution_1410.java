

//「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。 
//
// HTML 里这些特殊字符和它们对应的字符实体包括： 
//
// 
// 双引号：字符实体为 &quot; ，对应的字符是 " 。 
// 单引号：字符实体为 &apos; ，对应的字符是 ' 。 
// 与符号：字符实体为 &amp; ，对应对的字符是 & 。 
// 大于号：字符实体为 &gt; ，对应的字符是 > 。 
// 小于号：字符实体为 &lt; ，对应的字符是 < 。 
// 斜线号：字符实体为 &frasl; ，对应的字符是 / 。 
// 
//
// 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "&amp; is an HTML entity but &ambassador; is not."
//输出："& is an HTML entity but &ambassador; is not."
//解释：解析器把字符实体 &amp; 用 & 替换
// 
//
// 示例 2： 
//
// 
//输入：text = "and I quote: &quot;...&quot;"
//输出："and I quote: \"...\""
// 
//
// 示例 3： 
//
// 
//输入：text = "Stay home! Practice on Leetcode :)"
//输出："Stay home! Practice on Leetcode :)"
// 
//
// 示例 4： 
//
// 
//输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
//输出："x > y && x < y is always false"
// 
//
// 示例 5： 
//
// 
//输入：text = "leetcode.com&frasl;problemset&frasl;all"
//输出："leetcode.com/problemset/all"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^5 
// 字符串可能包含 256 个ASCII 字符中的任意字符。 
// 
//
// Related Topics 哈希表 字符串 👍 46 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1410.HTML 实体解析器.html-entity-parser
 *
 * @author db117
 * @since 2023-11-23 10:20:38
 **/

public class Solution_1410 {
    public static void main(String[] args) {
        Solution solution = new Solution_1410().new Solution();
        // &&gt;
        System.out.println(solution.entityParser("&&gt;"));
//        System.out.println(solution.entityParser("&amp;gt;"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String entityParser(String text) {
            // 双引号：字符实体为 &quot; ，对应的字符是 " 。
            //单引号：字符实体为 &apos; ，对应的字符是 ' 。
            //与符号：字符实体为 &amp; ，对应对的字符是 & 。
            //大于号：字符实体为 &gt; ，对应的字符是 > 。
            //小于号：字符实体为 &lt; ，对应的字符是 < 。
            //斜线号：字符实体为 &frasl; ，对应的字符是 / 。

            int n = text.length();
            StringBuilder sb = new StringBuilder(n);
            int cur = 0;
            int left = -1;
            boolean flag = false;
            while (cur < n) {
                char c = text.charAt(cur);
                if (flag) {
                    if (c == '&') {
                        // 之前已经有一个 &
                        sb.append(text, left, cur);
                        left = cur;
                        flag = false;
                    } else if (c == ';') {
                        // 正常结束
                        String decode = decode(text.substring(left, cur + 1));
                        sb.append(decode);
                        flag = false;
                        cur++;
                    } else {
                        // 普通字符
                        cur++;
                    }
                } else {
                    if (c == '&') {
                        // 开始匹配
                        flag = true;
                        left = cur;
                    } else {
                        sb.append(c);
                    }
                    cur++;
                }

            }

            if (flag) {
                // 最后一个& 后面的
                sb.append(text, left, cur);
            }

            return sb.toString();
        }

        private String decode(String s) {
            return switch (s) {
                case "&quot;" -> "\"";
                case "&apos;" -> "'";
                case "&amp;" -> "&";
                case "&gt;" -> ">";
                case "&lt;" -> "<";
                case "&frasl;" -> "/";
                default -> s;
            };
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}