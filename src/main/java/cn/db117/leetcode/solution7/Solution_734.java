

//我们可以将一个句子表示为一个单词数组，例如，句子 "I am happy with leetcode" 可以表示为 arr = ["I","am",
//happy","with","leetcode"] 
//
// 给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，其中 
//similarPairs[i] = [xi, yi] 表示两个单词 xi and yi 是相似的。 
//
// 如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。 
//
// 两个句子是相似的，如果: 
//
// 
// 它们具有 相同的长度 (即相同的字数) 
// sentence1[i] 和 sentence2[i] 是相似的 
// 
//
// 请注意，一个词总是与它自己相似，也请注意，相似关系是不可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c 不一
//定相似 。 
//
// 
//
// 示例 1: 
//
// 
//输入: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama",
//"talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
//输出: true
//解释: 这两个句子长度相同，每个单词都相似。
// 
//
// 示例 2: 
//
// 
//输入: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
//输出: true
//解释: 一个单词和它本身相似。 
//
// 示例 3: 
//
// 
//输入: sentence1 = ["great"], sentence2 = ["doubleplus","good"], similarPairs = [
//["great","doubleplus"]]
//输出: false
//解释: 因为它们长度不同，所以返回false。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sentence1.length, sentence2.length <= 1000 
// 1 <= sentence1[i].length, sentence2[i].length <= 20 
// sentence1[i] 和 sentence2[i] 只包含大小写英文字母 
// 0 <= similarPairs.length <= 2000 
// similarPairs[i].length == 2 
// 1 <= xi.length, yi.length <= 20 
// 所有对 (xi, yi) 都是 不同 的 
// 
// Related Topics 数组 哈希表 字符串 👍 30 👎 0


package cn.db117.leetcode.solution7;

import java.util.*;

/**
 * 734.句子相似性.sentence-similarity
 *
 * @author db117
 * @since 2022-04-26 18:29:59
 **/

public class Solution_734 {
    public static void main(String[] args) {
        Solution solution = new Solution_734().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            if (sentence1.length != sentence2.length) {
                return false;
            }

            // 一个词有多个相识的词
            Map<String, Set<String>> map = new HashMap<>();
            for (List<String> similarPair : similarPairs) {
                String one = similarPair.get(0);
                String two = similarPair.get(1);
                map.putIfAbsent(one, new HashSet<>());
                map.putIfAbsent(two, new HashSet<>());

                map.get(one).add(two);
                map.get(two).add(one);

            }

            for (int i = 0; i < sentence1.length; i++) {
                String one = sentence1[i];
                String two = sentence2[i];
                if (one.equals(two)) {
                    continue;
                }
                // 看有没有相识的
                if (map.containsKey(one) && map.get(one).contains(two)) {
                    continue;
                }
                if (map.containsKey(two) && map.get(two).contains(one)) {
                    continue;
                }
                return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}