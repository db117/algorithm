//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
// 使得所形成的新单词存在于你构建的字典中。
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 84 👎 0


package cn.db117.leetcode.solution6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 676.实现一个魔法字典.implement-magic-dictionary
 *
 * @author db117
 * @since 2021-07-01 14:51:54
 **/

public class Solution_676 {
    public static void main(String[] args) {
        MagicDictionary solution = new Solution_676().new MagicDictionary();

        // ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
        //[[], [["hello","hallo","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
        solution.buildDict(new String[]{"hello", "hallo", "leetcode" });
        System.out.println(solution.search("hello"));
        System.out.println(solution.search("hhllo"));
        System.out.println(solution.search("hell"));
        System.out.println(solution.search("leetcoded"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MagicDictionary {
        Map<String, Integer> map;
        Set<String> words;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {

            map = new HashMap<>();
            words = new HashSet<>();
        }

        public void buildDict(String[] dictionary) {
            // 广义邻居
            // 把所有的字符替换后存起来，并记录出现的次数
            for (String s : dictionary) {
                words.add(s);
                char[] chars = s.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    chars[i] = '.';
                    String cur = new String(chars);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    chars[i] = tmp;
                }
            }
        }

        public boolean search(String searchWord) {
            char[] chars = searchWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char tmp = chars[i];
                chars[i] = '.';
                String s = new String(chars);
                Integer count = map.get(s);
                if (count != null) {
                    if (count > 1 || !words.contains(searchWord)) {
                        // 不能是自身，单可以是其他字符串变过来的
                        return true;
                    }
                }

                chars[i] = tmp;
            }
            return false;
        }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}