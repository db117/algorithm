

//给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。 
//
// 示例 1： 
//
// 输入: "code"
//输出: false 
//
// 示例 2： 
//
// 输入: "aab"
//输出: true 
//
// 示例 3： 
//
// 输入: "carerac"
//输出: true 
// Related Topics 位运算 哈希表 字符串 👍 59 👎 0


package cn.db117.leetcode.solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * 266.回文排列.palindrome-permutation
 *
 * @author db117
 * @since 2022-03-26 22:17:58
 **/

public class Solution_266 {
    public static void main(String[] args) {
        Solution solution = new Solution_266().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean flag = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if ((entry.getValue() & 1) == 1) {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}