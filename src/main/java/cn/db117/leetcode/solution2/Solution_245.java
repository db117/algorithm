

//给定一个字符串数组 wordsDict 和两个字符串 word1 和 word2 ，返回这两个单词在列表中出现的最短距离。 
//
// 注意：word1 和 word2 是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。 
//
// 
//
// 示例 1： 
//
// 
//输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "coding"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "makes"
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= wordsDict.length <= 10⁵ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] 由小写英文字母组成 
// word1 和 word2 都在 wordsDict 中 
// 
//
// Related Topics 数组 字符串 👍 56 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 245.最短单词距离 III.shortest-word-distance-iii
 *
 * @author db117
 * @since 2023-08-14 10:39:53
 **/

public class Solution_245 {
    public static void main(String[] args) {
        Solution solution = new Solution_245().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            if (word1.equals(word2)) {
                // 相同的话,找到相邻的最小距离
                int ans = wordsDict.length;
                int pre = -1;
                for (int i = 0; i < wordsDict.length; i++) {
                    if (word1.equals(wordsDict[i])) {
                        if (pre != -1) {
                            ans = Math.min(ans, i - pre);
                        }
                        pre = i;
                    }
                }
                return ans;
            }
            // 下面和 244 一样
            // 记录下标
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equals(wordsDict[i])) {
                    list1.add(i);
                } else if (word2.equals(wordsDict[i])) {
                    list2.add(i);
                }
            }

            int i1 = 0, i2 = 0;
            int ans = wordsDict.length;
            // 双指针
            // 每次移动小的那个
            while (i1 < list1.size() && i2 < list2.size()) {
                Integer index1 = list1.get(i1);
                Integer index2 = list2.get(i2);
                ans = Math.min(ans, Math.abs(index1 - index2));
                if (index1 < index2) {
                    i1++;
                } else {
                    i2++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}