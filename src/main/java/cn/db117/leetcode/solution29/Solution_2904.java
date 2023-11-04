

//给你一个二进制字符串 s 和一个正整数 k 。 
//
// 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。 
//
// 令 len 等于 最短 美丽子字符串的长度。 
//
// 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。 
//
// 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典
//序 大于 字符串 b 。 
//
// 
// 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "100011001", k = 3
//输出："11001"
//解释：示例中共有 7 个美丽子字符串：
//1. 子字符串 "100011001" 。
//2. 子字符串 "100011001" 。
//3. 子字符串 "100011001" 。
//4. 子字符串 "100011001" 。
//5. 子字符串 "100011001" 。
//6. 子字符串 "100011001" 。
//7. 子字符串 "100011001" 。
//最短美丽子字符串的长度是 5 。
//长度为 5 且字典序最小的美丽子字符串是子字符串 "11001" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "1011", k = 2
//输出："11"
//解释：示例中共有 3 个美丽子字符串：
//1. 子字符串 "1011" 。
//2. 子字符串 "1011" 。
//3. 子字符串 "1011" 。
//最短美丽子字符串的长度是 2 。
//长度为 2 且字典序最小的美丽子字符串是子字符串 "11" 。 
// 
//
// 示例 3： 
//
// 
//输入：s = "000", k = 1
//输出：""
//解释：示例中不存在美丽子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// 1 <= k <= s.length 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2904.最短且字典序最小的美丽子字符串.shortest-and-lexicographically-smallest-beautiful-string
 *
 * @author db117
 * @since 2023-10-16 14:09:41
 **/

public class Solution_2904 {
    public static void main(String[] args) {
        Solution solution = new Solution_2904().new Solution();
        //"100011001"
        //			3
//        System.out.println(solution.shortestBeautifulSubstring("100011001", 3));

        // "01011101000111110"
        //			5
//        System.out.println(solution.shortestBeautifulSubstring("01011101000111110", 5));

        // "1111111011111"
        //			12
        System.out.println(solution.shortestBeautifulSubstring("1111111011111", 12));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestBeautifulSubstring(String s, int k) {
            if (s.replace("0", "").length() < k) {
                return "";
            }
            int n = s.length();
            int left = 0;
            int count = 0;
            String ans = s;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
                if (count < k) {
                    continue;
                }
                // 过滤掉 0 开头的
                while (left < i && (s.charAt(left) == '0' || count > k)) {
                    count -= s.charAt(left) - '0';// 去掉多余的 1
                    left++;
                }

                if (i - left + 1 > ans.length()) {
                    continue;
                }
                // 找到了一个
                String t = s.substring(left, i + 1);
                if (i - left + 1 < ans.length()) {
                    ans = t;
                }
                if (i - left + 1 == ans.length() && ans.compareTo(t) > 0) {
                    ans = t;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}