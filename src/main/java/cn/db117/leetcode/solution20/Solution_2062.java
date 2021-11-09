

//子字符串 是字符串中的一个连续（非空）的字符序列。 
//
// 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。 
//
// 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aeiouu"
//输出：2
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "aeiouu"
//- "aeiouu"
// 
//
// 示例 2： 
//
// 
//输入：word = "unicornarihan"
//输出：0
//解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
// 
//
// 示例 3： 
//
// 
//输入：word = "cuaieuouac"
//输出：7
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac" 
//
// 示例 4： 
//
// 
//输入：word = "bbaeixoubb"
//输出：0
//解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 仅由小写英文字母组成 
// 
// 👍 4 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;

/**
 * 2062.统计字符串中的元音子字符串.count-vowel-substrings-of-a-string
 *
 * @author db117
 * @since 2021-11-09 18:29:45
 **/

public class Solution_2062 {
    public static void main(String[] args) {
        Solution solution = new Solution_2062().new Solution();
        System.out.println(solution.countVowelSubstrings("aeiouu"));
        System.out.println(solution.countVowelSubstrings("unicornarihan"));
        System.out.println(solution.countVowelSubstrings("cuaieuouac"));
        System.out.println(solution.countVowelSubstrings("bbaeixoubb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelSubstrings(String word) {
            int ans = 0;
            char[] chars = word.toCharArray();
            // 记录元音出现的次数
            int[] flag = new int[26];
            // 元音个数
            int count = 0;

            for (int i = 0; i < chars.length; i++) {
                Arrays.fill(flag, 0);
                count = 0;
                for (int j = i; j < chars.length; j++) {
                    int index = chars[j] - 'a';
                    if (!check(chars[j])) {
                        break;
                    }
                    flag[index]++;
                    if (flag[index] == 1) {
                        count++;
                    }
                    if (count == 5) {
                        ans++;
                    }
                }
            }

            return ans;
        }

        public boolean check(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}