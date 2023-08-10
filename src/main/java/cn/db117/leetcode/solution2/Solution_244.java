

//请设计一个类，使该类的构造函数能够接收一个字符串数组。然后再实现一个方法，该方法能够分别接收两个单词，并返回列表中这两个单词之间的最短距离。 
//
// 实现 WordDistanc 类: 
//
// 
// WordDistance(String[] wordsDict) 用字符串数组 wordsDict 初始化对象。 
// int shortest(String word1, String word2) 返回数组 worddict 中 word1 和 word2 之间的最短距
//离。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//["WordDistance", "shortest", "shortest"]
//[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"]
//, ["makes", "coding"]]
//输出:
//[null, 3, 1]
//
//解释：
//WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", 
//"coding", "makes"]);
//wordDistance.shortest("coding", "practice"); // 返回 3
//wordDistance.shortest("makes", "coding");    // 返回 1 
//
// 
//
// 注意:
// 
//
// 
// 1 <= wordsDict.length <= 3 * 10⁴ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] 由小写英文字母组成 
// word1 和 word2 在数组 wordsDict 中 
// word1 != word2 
// shortest 操作次数不大于 5000 
// 
//
// Related Topics 设计 数组 哈希表 双指针 字符串 👍 84 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244.最短单词距离 II.shortest-word-distance-ii
 *
 * @author db117
 * @since 2023-08-10 14:05:10
 **/

public class Solution_244 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            // 保存每个单词出现的位置
            for (int i = 0; i < wordsDict.length; i++) {
                map.putIfAbsent(wordsDict[i], new ArrayList<>());
                map.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            if (word1.equals(word2)) {
                return 0;
            }
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            // 双指针
            int ans = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (i < list1.size() && j < list2.size()) {
                ans = Math.min(ans, Math.abs(list1.get(i) - list2.get(j)));
                if (list1.get(i) < list2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return ans;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}