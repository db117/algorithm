

//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 220 👎 0


package cn.db117.leetcode.solution10;

import java.util.HashMap;
import java.util.Map;

/**
 * 1079.活字印刷.letter-tile-possibilities
 *
 * @author db117
 * @since 2023-05-19 15:38:04
 **/

public class Solution_1079_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_1079_1().new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MX = 8;
        // i 个数里面选 j 个的数量组合数
        private static final int[][] c = new int[MX][MX];

        static {
            for (int i = 0; i < MX; i++) {
                c[i][i] = 1;
                c[i][0] = 1;
                for (int j = 1; j < i; j++) {
                    c[i][j] = c[i - 1][j] + c[i - 1][j - 1];// 预处理组合数
                }
            }
        }

        public int numTilePossibilities(String tiles) {
            // 统计每个字符出现的次数
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < tiles.length(); i++) {
                char c = tiles.charAt(i);
                map.merge(c, 1, Integer::sum);
            }
            int m = map.size();
            int n = tiles.length();
            // 前 i 个字符，拼成 j 长度的字符串的组合数
            int[][] f = new int[m + 1][n + 1];
            f[0][0] = 1;

            int i = 1;// 第几个数字
            for (Integer count : map.values()) {// 当前数字出现的次数
                for (int j = 0; j <= n; j++) {// 字符串总长度
                    for (int k = 0; k <= count && k <= j; k++) {// 当前数字选择的数量
                        f[i][j] += f[i - 1][j - k] * c[j][k];
                    }
                }
                i++;
            }

            int ans = 0;
            for (int i1 : f[m]) {
                ans += i1;
            }
            return ans - 1;// 去掉空字符串
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}