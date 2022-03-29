

//给定两个字符串 s 和 t ，如果它们的编辑距离为 1 ，则返回 true ，否则返回 false 。 
//
// 字符串 s 和字符串 t 之间满足编辑距离等于 1 有三种可能的情形： 
//
// 
// 往 s 中插入 恰好一个 字符得到 t 
// 从 s 中删除 恰好一个 字符得到 t 
// 在 s 中用 一个不同的字符 替换 恰好一个 字符得到 t 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "ab", t = "acb"
//输出: true
//解释: 可以将 'c' 插入字符串 s 来得到 t。
// 
//
// 示例 2: 
//
// 
//输入: s = "cab", t = "ad"
//输出: false
//解释: 无法通过 1 步操作使 s 变为 t。 
//
// 
//
// 提示: 
//
// 
// 0 <= s.length, t.length <= 10⁴ 
// s 和 t 由小写字母，大写字母和数字组成 
// 
// Related Topics 双指针 字符串 👍 99 👎 0


package cn.db117.leetcode.solution1;

/**
 * 161.相隔为 1 的编辑距离.one-edit-distance
 *
 * @author db117
 * @since 2022-03-29 11:41:59
 **/

public class Solution_161 {
    public static void main(String[] args) {
        Solution solution = new Solution_161().new Solution();
        System.out.println(solution.isOneEditDistance("a", "ac"));
        System.out.println(solution.isOneEditDistance("a", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (s.equals(t)) {
                return false;
            }
            if (Math.abs(s.length() - t.length()) > 1) {
                return false;
            }

            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();

            // 替换
            if (sc.length == tc.length) {
                int diff = 0;
                for (int i = 0; i < sc.length; i++) {
                    if (sc[i] != tc[i]) {
                        diff++;
                    }
                    if (diff > 1) {
                        return false;
                    }
                }
                return diff == 1;
            }

            // 插入
            if (sc.length < tc.length) {
                int si = 0, ti = 0;
                boolean inserted = false;
                while (si < sc.length && ti < tc.length) {
                    if (sc[si] == tc[ti]) {
                        si++;
                        ti++;
                        continue;
                    }
                    if (inserted) {
                        return false;
                    }
                    inserted = true;
                    ti++;
                }

                return inserted || (ti != tc.length);
            }

            // 删除
            int si = 0, ti = 0;
            boolean deleted = false;
            while (si < sc.length && ti < tc.length) {
                if (sc[si] == tc[ti]) {
                    si++;
                    ti++;
                    continue;
                }
                if (deleted) {
                    return false;
                }
                deleted = true;
                si++;
            }

            return deleted || (si != sc.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}