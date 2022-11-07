

//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 111 👎 0


package cn.db117.leetcode.solution8;

import java.util.ArrayList;
import java.util.List;

/**
 * 816.模糊坐标.ambiguous-coordinates
 *
 * @author db117
 * @since 2022-11-07 16:44:06
 **/

public class Solution_816 {
    public static void main(String[] args) {
        Solution solution = new Solution_816().new Solution();

        System.out.println(solution.ambiguousCoordinates("(123)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s;

        public List<String> ambiguousCoordinates(String _s) {
            s = _s.substring(1, _s.length() - 1);
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < s.length() - 1; i++) {
                // 添加 ， 生成两个数字，取笛卡尔
                List<String> l = helper(0, i);
                List<String> r = helper(i + 1, s.length() - 1);

                for (String s1 : l) {
                    for (String s2 : r) {
                        // 拼接
                        ans.add("(" + s1 + ", " + s2 + ")");
                    }
                }
            }
            return ans;
        }

        private List<String> helper(int start, int end) {
            List<String> ans = new ArrayList<>();
            if (start == end || s.charAt(start) != '0') {
                // 字符串只有 1 个字符，或不是 0 开始
                // 全部添加
                ans.add(s.substring(start, end + 1));
            }
            for (int i = start; i < end; i++) {
                // 添加 .
                String l = s.substring(start, i + 1);
                String r = s.substring(i + 1, end + 1);
                if (l.length() > 1 && l.charAt(0) == '0') {
                    continue;
                }
                if (r.charAt(r.length() - 1) == '0') {
                    continue;
                }

                ans.add(l + "." + r);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}