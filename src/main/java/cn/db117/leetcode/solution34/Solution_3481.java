

//给定一个 replacements 映射和一个可能包含格式为 %var% 占位符 的字符串 text，其中每个 var 对应 replacements 中的
//一个键。每个替换值本身可能包含 一个或多个 此类占位符。每个 占位符 都被与其相应的替换键对应的值替换。 
//
// 返回完全替换后 不 含任何 占位符 的 text 字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入：replacements = [["A","abc"],["B","def"]], text = "%A%_%B%" 
// 
//
// 输出："abc_def" 
//
// 解释： 
//
// 
// 映射将 "A" 与 "abc" 关联，并将 "B" 与 "def" 关联。 
// 用 "abc" 替换文本中的 %A%，并用 "def" 替换文本中的 %B%。 
// 最终文本变为 "abc_def"。 
// 
//
// 示例 2： 
//
// 
// 输入：replacements = [["A","bce"],["B","ace"],["C","abc%B%"]], text = "%A%_%B%_%
//C%" 
// 
//
// 输出："bce_ace_abcace" 
//
// 解释： 
//
// 
// 映射将 "A" 与 "bce" 关联，"B" 与 "ace" 关联，以及 "C" 与 "abc%B%" 关联。 
// 用 "bce" 替换文本中的 %A%，并用 "ace" 替换文本中的 %B%。 
// 接着，对于 %C%，用 "ace" 替换 "abc%B%" 中的 %B% 来得到 "abcace"。 
// 最终文本变为 "bce_ace_abcace"。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= replacements.length <= 10 
// replacements 中的每个元素是一个双值列表 [key, value]，其中： 
// 
// key 是一个大写英语字母。 
// value 是一个最多有 8 个字符，可能包含 0 个或更多格式为 %<key>% 的占位符的非空字符串。 
// 
// 所有的替换键互不相同。 
// text 字符串是通过从替换映射中随机串联所有 key 占位符（格式为 %<key>%）而形成的，以虚线分隔。 
// text.length == 4 * replacements.length - 1 
// text 或任何替换值中的每个占位符对应 replacements 映射中的一个键。 
// 替换键之间没有循环依赖。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 哈希表 字符串 👍 0 👎 0


package cn.db117.leetcode.solution34;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3481.应用替换.apply-substitutions
 *
 * @author db117
 * @since 2025-04-27 19:47:06
 **/

public class Solution_3481 {
    public static void main(String[] args) {
        Solution solution = new Solution_3481().new Solution();
        // [["A","bce"],["B","ace"],["C","abc%B%"]]
        //			"%A%_%B%_%C%"
//        System.out.println(solution.applySubstitutions(List.of(List.of("A", "bce"), List.of("B", "ace"), List.of("C", "abc%B%")), "%A%_%B%_%C%"));

        // [["J","pswslzw"],["M","zb%J%qu"],["L","%M%l%J%"]]
        //			"%M%_%J%_%L%"
        System.out.println(solution.applySubstitutions(List.of(List.of("J", "pswslzw"), List.of("M", "zb%J%qu"), List.of("L", "%M%l%J%")), "%M%_%J%_%L%"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> map = new HashMap<>();

        public String applySubstitutions(List<List<String>> replacements, String text) {

            replacements.forEach(list -> map.put(list.get(0).charAt(0), list.get(1)));

            for (Map.Entry<Character, String> entry : map.entrySet()) {
                Character character = entry.getKey();
                String s = entry.getValue();
                if (s.contains("%")) {
                    s = helper(s);
                }
                map.put(character, s);
            }

            for (int i = 0; i < 26; i++) {
                char c = (char) ('A' + i);
                if (map.containsKey(c)) {
                    text = text.replace("%" + c + "%", map.get(c));
                }
            }
            return text;
        }

        String helper(String s) {
            if (!s.contains("%")) {
                return s;
            }
            // 一直找到没有为止
            while (s.contains("%")) {
                int index = s.indexOf("%");
                if (index + 2 < s.length()) {
                    char c = s.charAt(index + 1);
                    if (map.containsKey(c)) {
                        s = s.replace("%" + c + "%", map.get(c));
                    }
                }
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}