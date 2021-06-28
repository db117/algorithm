// 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，
//跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by th
//e battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 示例 3： 
//
// 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa a
//aa aaaaaa bbb baba ababa"
//输出："a a a a a a a a bbb baba a"
// 
//
// 示例 4： 
//
// 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattle
//d by the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 5： 
//
// 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is
// accepted"
//输出："it is ab that this solution is ac"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 124 👎 0


package cn.db117.leetcode.solution6;

import cn.db117.leetcode.base.Optimized;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 648.单词替换.replace-words
 *
 * @author db117
 * @since 2021-06-28 17:10:52
 **/
@Optimized
public class Solution_648 {
    public static void main(String[] args) {
        Solution solution = new Solution_648().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            // 快速查询
            Set<String> set = new HashSet<>(dictionary);
            String[] split = sentence.split(" ");

            for (int i = 0; i < split.length; i++) {
                String s = split[i];

                // 从短的开始找,找到直接替换
                for (int j = 1; j <= s.length(); j++) {
                    String sub = s.substring(0, j);
                    if (set.contains(sub)) {
                        split[i] = sub;
                        break;
                    }
                }

            }
            return String.join(" ", split);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}