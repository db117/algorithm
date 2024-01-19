

//给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。 
//
// 如果下标 i 满足以下条件，则认为它是一个 美丽下标： 
//
// 
// 0 <= i <= s.length - a.length 
// s[i..(i + a.length - 1)] == a 
// 存在下标 j 使得： 
// 
// 0 <= j <= s.length - b.length 
// s[j..(j + b.length - 1)] == b 
// |j - i| <= k 
// 
// 
//
// 以数组形式按 从小到大排序 返回美丽下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
//
//输出：[16,33]
//解释：存在 2 个美丽下标：[16,33]。
//- 下标 16 是美丽下标，因为 s[16..17] == "my" ，且存在下标 4 ，满足 s[4..11] == "squirrel" 且 |16 -
// 4| <= 15 。
//- 下标 33 是美丽下标，因为 s[33..34] == "my" ，且存在下标 18 ，满足 s[18..25] == "squirrel" 且 |33
// - 18| <= 15 。
//因此返回 [16,33] 作为结果。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", a = "a", b = "a", k = 4
//输出：[0]
//解释：存在 1 个美丽下标：[0]。
//- 下标 0 是美丽下标，因为 s[0..0] == "a" ，且存在下标 0 ，满足 s[0..0] == "a" 且 |0 - 0| <= 4 。
//因此返回 [0] 作为结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= s.length <= 10⁵ 
// 1 <= a.length, b.length <= 10 
// s、a、和 b 只包含小写英文字母。 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution30;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 3006.找出数组中的美丽下标 I.find-beautiful-indices-in-the-given-array-i
 *
 * @author db117
 * @since 2024-01-15 11:30:04
 **/

public class Solution_3006 {
    public static void main(String[] args) {
        Solution solution = new Solution_3006().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            KMP kmp = new KMP();
            List<Integer> aIndex = kmp.KMPSearch(s, a);
            List<Integer> bIndex = kmp.KMPSearch(s, b);
            TreeSet<Integer> set = new TreeSet<>(bIndex);
            List<Integer> ans = new ArrayList<>();
            for (Integer aI : aIndex) {
                Integer floor = set.floor(aI + k);
                if (floor != null && floor >= aI - k) {
                    ans.add(aI);
                }
            }

            return ans;
        }

        public class KMP {
            private int[] computePrefixFunction(char[] pattern) {
                int[] pi = new int[pattern.length];
                int j = 0;
                for (int i = 1; i < pattern.length; i++) {
                    while (j > 0 && pattern[j] != pattern[i]) {
                        j = pi[j - 1];
                    }
                    if (pattern[j] == pattern[i]) {
                        j++;
                    }
                    pi[i] = j;
                }
                return pi;
            }

            public List<Integer> KMPSearch(String text, String pattern) {
                List<Integer> result = new ArrayList<>();
                char[] textArr = text.toCharArray();
                char[] patternArr = pattern.toCharArray();
                int[] pi = computePrefixFunction(patternArr);
                int j = 0;
                for (int i = 0; i < textArr.length; i++) {
                    while (j > 0 && textArr[i] != patternArr[j]) {
                        j = pi[j - 1];
                    }
                    if (textArr[i] == patternArr[j]) {
                        j++;
                    }
                    if (j == patternArr.length) {
                        result.add(i - (j - 1));
                        j = pi[j - 1];
                    }
                }
                return result;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}