

//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 89 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239.串联字符串的最大长度.maximum-length-of-a-concatenated-string-with-unique-characters
 *
 * @author db117
 * @since 2021-05-20 10:20:12
 **/

public class Solution_1239 {
    public static void main(String[] args) {
        Solution solution = new Solution_1239().new Solution();

//        System.out.println(solution.maxLength(Arrays.asList("un", "iq", "ue")));
//        System.out.println(solution.maxLength(Arrays.asList("cha", "r", "act", "ers")));
//        System.out.println(solution.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
//        System.out.println(solution.maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list;
        List<Integer> bitMarkList;
        int max;

        public int maxLength(List<String> arr) {
            list = arr;
            // 使用一个数字标记字符出现的位置
            // 计算出每一位字符的bit
            bitMarkList = new ArrayList<>(list.size());
            for (String s : list) {
                int tmp = 0;
                for (char c : s.toCharArray()) {
                    tmp |= 1 << (c - 'a');
                }
                if (s.length() == Integer.bitCount(tmp)) {
                    bitMarkList.add(tmp);
                } else {
                    // 字符本身就重复
                    bitMarkList.add(0);
                }
            }

            // 每一个字符都分选和不选
            dfs(0, 0);
            return max;

        }

        private void dfs(int index, int bitMark) {
            if (index == list.size()) {
                return;
            }
            // 不选择当前字符
            dfs(index + 1, bitMark);

            // 选择当前字符
            Integer tmp = bitMarkList.get(index);
            if (tmp == 0 || (tmp & bitMark) > 0) {
                return;
            }

            // 选的情况下字符使用情况标记
            tmp = bitMark | tmp;

            max = Math.max(max, Integer.bitCount(tmp));

            dfs(index + 1, tmp);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}