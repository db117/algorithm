// 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 双指针 字符串 
// 👍 27 👎 0


package cn.db117.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.11.单词距离.find-closest-lcci
 *
 * @author db117
 * @since 2021-06-24 16:18:15
 **/

public class Interview_1711 {
    public static void main(String[] args) {
        Solution solution = new Interview_1711().new Solution();

        System.out.println(solution.findClosest(new String[]{
                        "I", "am", "a", "student", "from", "a", "university", "in", "a", "city"
                },
                "a",
                "student"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 单词 -> 索引位置
        Map<String, List<Integer>> map = new HashMap<>();

        public int findClosest(String[] words, String word1, String word2) {

            if (map.size() == 0) {
                // 第一次调用,构建 hash 表
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (!map.containsKey(word)) {
                        map.put(word, new ArrayList<>());
                    }
                    map.get(word).add(i);

                }
            }

            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            if (list1 == null || list2 == null) {
                return 0;
            }

            // 双指针找最小差
            int index1 = 0, index2 = 0, min = Integer.MAX_VALUE;

            while (index1 < list1.size() && index2 < list2.size()) {
                int diff = list1.get(index1) - list2.get(index2);
                // 保持两个数字的距离最小
                if (diff < 0) {
                    index1++;
                } else {
                    index2++;
                }

                min = Math.min(min, Math.abs(diff));
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}