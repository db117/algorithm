

//给你一个字符串 word，由 不同 小写英文字母组成。 
//
// 电话键盘上的按键与 不同 小写英文字母集合相映射，可以通过按压按键来组成单词。例如，按键 2 对应 ["a","b","c"]，我们需要按一次键来输入 
//"a"，按两次键来输入 "b"，按三次键来输入 "c"。 
//
// 现在允许你将编号为 2 到 9 的按键重新映射到 不同 字母集合。每个按键可以映射到 任意数量 的字母，但每个字母 必须 恰好 映射到 一个 按键上。你需
//要找到输入字符串 word 所需的 最少 按键次数。 
//
// 返回重新映射按键后输入 word 所需的 最少 按键次数。 
//
// 下面给出了一种电话键盘上字母到按键的映射作为示例。注意 1，*，# 和 0 不 对应任何字母。 
// 
// 
//
// 示例 1： 
// 
// 
//输入：word = "abcde"
//输出：5
//解释：图片中给出的重新映射方案的输入成本最小。
//"a" -> 在按键 2 上按一次
//"b" -> 在按键 3 上按一次
//"c" -> 在按键 4 上按一次
//"d" -> 在按键 5 上按一次
//"e" -> 在按键 6 上按一次
//总成本为 1 + 1 + 1 + 1 + 1 = 5 。
//可以证明不存在其他成本更低的映射方案。
// 
//
// 示例 2： 
// 
// 
//输入：word = "xyzxyzxyzxyz"
//输出：12
//解释：图片中给出的重新映射方案的输入成本最小。
//"x" -> 在按键 2 上按一次
//"y" -> 在按键 3 上按一次
//"z" -> 在按键 4 上按一次
//总成本为 1 * 4 + 1 * 4 + 1 * 4 = 12 。
//可以证明不存在其他成本更低的映射方案。
//注意按键 9 没有映射到任何字母：不必让每个按键都存在与之映射的字母，但是每个字母都必须映射到按键上。
// 
//
// 示例 3： 
// 
// 
//输入：word = "aabbccddeeffgghhiiiiii"
//输出：24
//解释：图片中给出的重新映射方案的输入成本最小。
//"a" -> 在按键 2 上按一次
//"b" -> 在按键 3 上按一次
//"c" -> 在按键 4 上按一次
//"d" -> 在按键 5 上按一次
//"e" -> 在按键 6 上按一次
//"f" -> 在按键 7 上按一次
//"g" -> 在按键 8 上按一次
//"h" -> 在按键 9 上按两次
//"i" -> 在按键 9 上按一次
//总成本为 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 2
//4 。
//可以证明不存在其他成本更低的映射方案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 仅由小写英文字母组成。 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author db117
 * @since 2024-01-22 10:59:21
 **/

public class Solution_3016 {
    public static void main(String[] args) {
        Solution solution = new Solution_3016().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumPushes(String word) {
            int ans = 0;
            int n = word.length();
            int[] count = new int[26];
            Integer[] id = new Integer[26];
            // 统计字符出现的次数
            for (int i = 0; i < n; i++) {
                count[word.charAt(i) - 'a']++;
            }
            // 按照次数排序
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
            // 排序
            Arrays.sort(id, Comparator.comparingInt(o -> -count[o]));
            int[] index = new int[26];
            for (int i = 0; i < id.length; i++) {
                if (count[id[i]] == 0) {
                    break;
                }
                index[id[i]] = (i + 1 + 7) / 8;
            }

            // 把出现次数多的放前面
            for (int i = 0; i < n; i++) {
                int cur = word.charAt(i) - 'a';
                ans += index[cur];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}