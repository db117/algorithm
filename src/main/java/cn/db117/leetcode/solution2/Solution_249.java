

//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 
//
// 示例： 
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。 
//
// Related Topics 数组 哈希表 字符串 👍 99 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249.移位字符串分组.group-shifted-strings
 *
 * @author db117
 * @since 2023-03-30 14:29:27
 **/

public class Solution_249 {
    public static void main(String[] args) {
        Solution solution = new Solution_249().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String string : strings) {
                // 都转成第一个字符为 a 的字符串
                String key = helper(string);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(string);
            }

            return map.values().stream().toList();
        }

        private String helper(String s) {
            if (s.charAt(0) == 'a') {
                return s;
            }
            char[] chars = s.toCharArray();
            int diff = (chars[0] - 'a' + 26) % 26;
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) ((chars[i] - 'a' - diff + 26) % 26 + 'a');
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}