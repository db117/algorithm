

//给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。 
//
// 
//
// 示例 1: 
//
// 
//输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"coding", word2 = "practice"
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "coding"
//输出: 1 
//
// 
//
// 提示: 
//
// 
// 1 <= wordsDict.length <= 3 * 10⁴ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] 由小写英文字母组成 
// word1 和 word2 在 wordsDict 中 
// word1 != word2 
// 
// Related Topics 数组 字符串 👍 90 👎 0


package cn.db117.leetcode.solution2;

/**
 * 243.最短单词距离.shortest-word-distance
 *
 * @author db117
 * @since 2022-03-14 11:35:04
 **/

public class Solution_243 {
    public static void main(String[] args) {
        Solution solution = new Solution_243().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            // 用两个变量保存最近的两个单词的位置
            int i1 = -1, i2 = -1;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equals(wordsDict[i])) {
                    i1 = i;
                    if (i2 != -1) {
                        // 前面最近的 word2
                        ans = Math.min(ans, i1 - i2);
                    }
                } else if (wordsDict[i].equals(word2)) {
                    i2 = i;
                    if (i1 != -1) {
                        ans = Math.min(ans, i2 - i1);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}