

//单词的 缩写 需要遵循 
// 
// 
// 
// 这样的格式。如果单词只有两个字符，那么它就是它自身的 
// 缩写 。
// 
// 
// 
//
// 以下是一些单词缩写的范例： 
//
// 
// dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母 
// internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母 
// it --> it 单词只有两个字符，它就是它自身的 缩写 
// 
//
// 
//
// 实现 ValidWordAbbr 类： 
//
// 
// ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象 
// boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ： 
// 
// 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。 
// 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
//[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], [
//"cake"]]
//输出
//[null, false, true, false, true, true]
//
//解释
//ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", 
//"card"]);
//validWordAbbr.isUnique("dear"); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2
//r"，但这两个单词不相同
//validWordAbbr.isUnique("cart"); // 返回 true，字典中不存在缩写为 "c2t" 的单词
//validWordAbbr.isUnique("cane"); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2
//e"，但这两个单词不相同
//validWordAbbr.isUnique("make"); // 返回 true，字典中不存在缩写为 "m2e" 的单词
//validWordAbbr.isUnique("cake"); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2
//e" 的单词
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 3 * 10⁴ 
// 1 <= dictionary[i].length <= 20 
// dictionary[i] 由小写英文字母组成 
// 1 <= word <= 20 
// word 由小写英文字母组成 
// 最多调用 5000 次 isUnique 
// 
//
// Related Topics 设计 数组 哈希表 字符串 👍 19 👎 0


package cn.db117.leetcode.solution2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 288.单词的唯一缩写.unique-word-abbreviation
 *
 * @author db117
 * @since 2023-06-26 14:32:41
 **/

public class Solution_288 {
    public static void main(String[] args) {
        // [[["a","a"]],["a"]]
        System.out.println(new ValidWordAbbr(new String[]{"a", "a"}).isUnique("a"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static
    class ValidWordAbbr {
        Set<String> set = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String s : dictionary) {
                set.add(s);
                String shorted = helper(s);
                map.putIfAbsent(shorted, new HashSet<>());
                map.get(shorted).add(s);
            }
        }

        public boolean isUnique(String word) {
            String helper = helper(word);
            if (!set.contains(word)) {
                return !map.containsKey(helper);
            }
            Set<String> stringSet = map.get(helper);
            if (stringSet.size() > 1) {
                return false;
            }
            return stringSet.contains(word);
        }

        private String helper(String s) {
            if (s.length() < 3) {
                return s;
            }
            return String.valueOf(s.charAt(0)) +
                    (s.length() - 2) +
                    s.charAt(s.length() - 1);
        }
    }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}