

//给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。 
//
// 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2
// 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是
//说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。 
//
// 
// 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。 
// 
//
// words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。 
//
// 请你返回 words中 差值整数数组 不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["adc","wzy","abc"]
//输出："abc"
//解释：
//- "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
//- "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
//- "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
//不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
// 
//
// 示例 2： 
//
// 
//输入：words = ["aaa","bob","ccc","ddd"]
//输出："bob"
//解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= words.length <= 100 
// n == words[i].length 
// 2 <= n <= 20 
// words[i] 只含有小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 👍 32 👎 0


package cn.db117.leetcode.solution24;

import java.util.HashMap;
import java.util.Map;

/**
 * 2451.差值数组不同的字符串.odd-string-difference
 *
 * @author db117
 * @since 2023-05-25 11:08:57
 **/

public class Solution_2451 {
    public static void main(String[] args) {
        // ["aaa","bob","ccc","ddd"]
        Solution solution = new Solution_2451().new Solution();
        System.out.println(solution.oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String oddString(String[] words) {
            Map<String, Integer> map = new HashMap<>();
            Map<String, String> origin = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String helper = helper(word);// 转换为首字母为 a 的字符串
                origin.put(helper, word);
                map.merge(helper, 1, Integer::sum);

                if (i > 1) {
                    if (map.get(helper) == 1) {
                        return word;
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String s = entry.getKey();
                Integer integer = entry.getValue();
                if (integer == 1) {
                    return origin.get(s);
                }
            }
            return "";
        }

        private String helper(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == 'a') {
                return s;
            }
            int diff = chars[0] - 'a';
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (((chars[i] - 'a' - diff) + 26) % 26 + 'a');
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}