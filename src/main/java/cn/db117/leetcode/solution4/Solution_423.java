// 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
//
// 注意: 
//
// 
// 输入只包含小写英文字母。 
// 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。 
// 输入字符串的长度小于 50,000。 
// 
//
// 示例 1: 
//
// 
//输入: "owoztneoer"
//
//输出: "012" (zeroonetwo)
// 
//
// 示例 2: 
//
// 
//输入: "fviefuro"
//
//输出: "45" (fourfive)
// 
// Related Topics 哈希表 数学 字符串 
// 👍 64 👎 0


package cn.db117.leetcode.solution4;

/**
 * 423.从英文中重建数字.reconstruct-original-digits-from-english
 *
 * @author db117
 * @since 2021-06-28 16:38:45
 **/

public class Solution_423 {
    public static void main(String[] args) {
        Solution solution = new Solution_423().new Solution();
        System.out.println(solution.originalDigits("owoztneoer"));
        System.out.println(solution.originalDigits("fviefuro"));
        System.out.println(solution.originalDigits("esnve"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String originalDigits(String s) {
            // 0:zero   z
            // 1:one
            // 2:two    w
            // 3:three
            // 4:four   u
            // 5:five
            // 6:six    x
            // 7:seven
            // 8:eight  g
            // 9:nine

            char[] chars = s.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            int[] ans = new int[10];

            // 0 2 4 6 8 有唯一字符
            ans[0] = count['z' - 'a'];
            ans[2] = count['w' - 'a'];
            ans[4] = count['u' - 'a'];
            ans[6] = count['x' - 'a'];
            ans[8] = count['g' - 'a'];
            // 1 one  zero  two four 只有四个单词有o
            ans[1] = count['o' - 'a'] - ans[0] - ans[2] - ans[4];
            // 3  three two  eight  t
            ans[3] = count['t' - 'a'] - ans[2] - ans[8];
            // 7
            ans[7] = count['s' - 'a'] - ans[6];
            // 5
            ans[5] = count['v' - 'a'] - ans[7];
            // 9
            ans[9] = count['i' - 'a'] - ans[8] - ans[6] - ans[5];

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < ans.length; i++) {
                res.append(String.valueOf(i).repeat(Math.max(0, ans[i])));
            }

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}