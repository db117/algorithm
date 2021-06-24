// 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
//
// 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。 
//
// 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。 
//
// 子字符串 是一个字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "xyzzaz"
//输出：1
//解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
//唯一的长度为 3 的好子字符串是 "xyz" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aababcabc"
//输出：4
//解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
//好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 计数 滑动窗口 
// 👍 2 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1876.长度为三且各字符不同的子字符串.substrings-of-size-three-with-distinct-characters
 *
 * @author db117
 * @since 2021-06-24 17:12:33
 **/

public class Solution_1876 {
    public static void main(String[] args) {
        Solution solution = new Solution_1876().new Solution();
        System.out.println(solution.countGoodSubstrings("xyzzaz"));
        System.out.println(solution.countGoodSubstrings("aababcabc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodSubstrings(String s) {
            if (s.length() < 3) {
                return 0;
            }
            // 总的
            int count = 0;
            // 重复的
            int repeat = 0;
            int[] arr = new int[26];
            int ans = 0;
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                int right = chars[i] - 'a';

                // 添加一个字符
                if (arr[right] > 0) {
                    // 有重复的
                    repeat++;
                }
                arr[right]++;
                count++;

                if (count < 3) {
                    // 不够三个
                    continue;
                }

                if (repeat == 0) {
                    // 没有重复的
                    ans++;
                }

                // 删除左边的
                int left = chars[i - 2] - 'a';
                if (arr[left] > 1) {
                    // 重复的减一
                    repeat--;
                }
                arr[left]--;
                count--;

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}