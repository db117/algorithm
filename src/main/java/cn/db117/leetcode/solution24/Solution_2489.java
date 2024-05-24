

//给定一个二进制字符串 s 和两个整数 num1 和 num2。num1 和 num2 为互质。 
//
// 比率子串 是 s 的子串，其中子串中 0 的数量与 1 的数量之比正好是 num1 : num2。 
//
// 
// 例如，如果 num1 = 2 和 num2 = 3，那么 "01011" 和 "1110000111" 是比率子串，而 "11000" 不是。 
// 
//
// 返回 s 的 非空 比率子串的个数。 
//
// 注意: 
//
// 
// 子串 是字符串中连续的字符序列。 
// 如果 gcd(x, y) == 1，则 x 和 y 为 互质，其中 gcd(x, y) 为 x 和 y 的最大公约数。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "0110011", num1 = 1, num2 = 2
//输出: 4
//解释: 有 4 个非空的比率子串。
//- 子字符串 s[0..2]: "0110011"。它包含一个 0 和两个 1。比例是 1:2。
//- 子字符串 s[1..4]: "0110011"。它包含一个 0 和两个 1。比例是 1:2。
//- 子字符串 s[4..6]: "0110011"。它包含一个 0 和两个 1。比例是 1:2。
//- 子字符串 s[1..6]: "0110011"。它包含两个 0 和四个 1。比例是 2:4 == 1:2。
//它可以显示没有更多的比率子串。
// 
//
// 示例 2: 
//
// 
//输入: s = "10101", num1 = 3, num2 = 1
//输出: 0
//解释: s 没有比率子串，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// 1 <= num1, num2 <= s.length 
// num1 和 num2 互质。 
// 
//
// Related Topics 哈希表 数学 字符串 前缀和 👍 2 👎 0


package cn.db117.leetcode.solution24;

import java.util.HashMap;
import java.util.Map;

/**
 * 2489.固定比率的子字符串数.number-of-substrings-with-fixed-ratio
 *
 * @author db117
 * @since 2024-05-22 17:34:49
 **/

public class Solution_2489 {
    public static void main(String[] args) {
        Solution solution = new Solution_2489().new Solution();
        // "0110011"
        //			1
        //			2
        System.out.println(solution.fixedRatio("0110011", 1, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long fixedRatio(String s, int num1, int num2) {
            long ans = 0;
            int n = s.length();
            // 前缀和
            int[] pre = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + (s.charAt(i) == '1' ? 1 : 0);
            }

            // 一个区间内 0 的数量 * num2 == 1 的数量 * num1
            //( 0‘-0)*num2=(1‘-1)*num1
            // 0‘*num2  = 1‘*num1
            // 找到前面出现过的数字，就说明区间内的数字满足条件
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);// 从头开始就满足条件的字符串
            for (int i = 0; i < n; i++) {
                int score = (i + 1 - pre[i + 1]) * num2 - pre[i + 1] * num1;
                Integer left = map.getOrDefault(score, 0);
                ans += left;
                map.put(score, left + 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}