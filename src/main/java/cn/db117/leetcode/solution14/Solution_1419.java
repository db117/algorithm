

//给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 
//croakOfFrogs 中会混合多个 “croak” 。 
//
// 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。 
//
// 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会
//发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：croakOfFrogs = "croakcroak"
//输出：1 
//解释：一只青蛙 “呱呱” 两次
// 
//
// 示例 2： 
//
// 
//输入：croakOfFrogs = "crcoakroak"
//输出：2 
//解释：最少需要两只青蛙，“呱呱” 声用黑体标注
//第一只青蛙 "crcoakroak"
//第二只青蛙 "crcoakroak"
// 
//
// 示例 3： 
//
// 
//输入：croakOfFrogs = "croakcrook"
//输出：-1
//解释：给出的字符串不是 "croak" 的有效组合。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= croakOfFrogs.length <= 10⁵ 
// 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k' 
// 
//
// Related Topics 字符串 计数 👍 130 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1419.数青蛙.minimum-number-of-frogs-croaking
 *
 * @author db117
 * @since 2023-05-06 10:19:17
 **/

public class Solution_1419 {
    public static void main(String[] args) {
        Solution solution = new Solution_1419().new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroak"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int max = -1;
            int c = 0, r = 0, o = 0, a = 0;
            char[] chars = croakOfFrogs.toCharArray();
            for (char aChar : chars) {
                switch (aChar) {
                    case 'c' -> c++;
                    case 'r' -> r++;
                    case 'o' -> o++;
                    case 'a' -> a++;
                }
                if (r > c || o > r || a > o) {
                    // 肯定有字符拼不成单词
                    return -1;
                }
                if (aChar == 'k') {
                    c--;
                    r--;
                    o--;
                    a--;
                    if (c < 0 || r < 0 || o < 0 || a < 0) {
                        // 凑不齐一个单词
                        return -1;
                    }
                    // 如果是有效的 那么当前拼成的单词一定是在中间
                    // 直接找前面出现最多的字符
                    max = Math.max(max, Math.max(c, Math.max(r, Math.max(o, a))));
                }
            }
            if (c != 0 || r != 0 || o != 0 || a != 0) {
                return -1;
            }
            return max + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}