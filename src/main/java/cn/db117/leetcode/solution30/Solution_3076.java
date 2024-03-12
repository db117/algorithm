

//给你一个数组 arr ，数组中有 n 个 非空 字符串。 
//
// 请你求出一个长度为 n 的字符串 answer ，满足： 
//
// 
// answer[i] 是 arr[i] 最短 的子字符串，且它不是 arr 中其他任何字符串的子字符串。如果有多个这样的子字符串存在，answer[i] 应
//该是它们中字典序最小的一个。如果不存在这样的子字符串，answer[i] 为空字符串。 
// 
//
// 请你返回数组 answer 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = ["cab","ad","bad","c"]
//输出：["ab","","ba",""]
//解释：求解过程如下：
//- 对于字符串 "cab" ，最短没有在其他字符串中出现过的子字符串是 "ca" 或者 "ab" ，我们选择字典序更小的子字符串，也就是 "ab" 。
//- 对于字符串 "ad" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bad" ，最短没有在其他字符串中出现过的子字符串是 "ba" 。
//- 对于字符串 "c" ，不存在没有在其他字符串中出现过的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：arr = ["abc","bcd","abcd"]
//输出：["","","abcd"]
//解释：求解过程如下：
//- 对于字符串 "abc" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bcd" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "abcd" ，最短没有在其他字符串中出现过的子字符串是 "abcd" 。
// 
//
// 
//
// 提示： 
//
// 
// n == arr.length 
// 2 <= n <= 100 
// 1 <= arr[i].length <= 20 
// arr[i] 只包含小写英文字母。 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 👍 3 👎 0


package cn.db117.leetcode.solution30;

import java.util.ArrayList;
import java.util.List;

/**
 * 3076.数组中的最短非公共子字符串.shortest-uncommon-substring-in-an-array
 *
 * @author db117
 * @since 2024-03-12 15:12:03
 **/

public class Solution_3076 {
    public static void main(String[] args) {
        Solution solution = new Solution_3076().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String[] shortestSubstrings(String[] arr) {
            int n = arr.length;
            String[] ans = new String[n];
            List<String>[] subList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                // 找到所有的子字符串
                subList[i] = findSubstrings(arr[i]);
            }

            for (int i = 0; i < n; i++) {
                String str = arr[i];
                List<String> strings = subList[i];
                for (String string : strings) {
                    boolean flag = true;
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            continue;
                        }
                        // 暴力比较
                        if (subList[j].contains(string)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans[i] = string;
                        break;
                    } else {
                        ans[i] = "";
                    }
                }
            }

            return ans;
        }


        public List<String> findSubstrings(String str) {
            List<String> substrings = new ArrayList<>();
            int length = str.length();

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    substrings.add(str.substring(i, j));
                }
            }
            substrings.sort((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            });
            return substrings;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}