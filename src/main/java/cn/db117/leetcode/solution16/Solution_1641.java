// 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
// 
//
// 示例 3： 
//
// 
//输入：n = 33
//输出：66045
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 49 👎 0


package cn.db117.leetcode.solution16;

/**
 * 1641.统计字典序元音字符串的数目.count-sorted-vowel-strings
 *
 * @author db117
 * @since 2021-05-24 15:40:19
 **/

public class Solution_1641 {
    public static void main(String[] args) {
        Solution solution = new Solution_1641().new Solution();
        System.out.println(solution.countVowelStrings(2));
        System.out.println(solution.countVowelStrings(33));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int countVowelStrings(int n) {
            // 当前n==1是
            int a = 1, e = 1, i = 1, o = 1, u = 1;

            // 模拟从现有的字符串前面加字符
            for (int j = 1; j < n; j++) {
                // 当字符串长度为n-1,第一个字符为["a","e","i","o","u"]是都可以为a
                a = a + e + i + o + u;
                e = e + i + o + u;
                i = i + o + u;
                o = o + u;
                u = u;
            }

            return a + e + i + o + u;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    // 回溯
    class Solution1 {
        int count = 0;

        public int countVowelStrings(int n) {

            dfs(new int[n], 0);
            return count;
        }

        private void dfs(int[] ints, int index) {
            if (index >= ints.length) {
                count++;
                return;
            }


            int start = 1;
            if (index != 0) {
                start = ints[index - 1];
            }
            for (int i = start; i <= 5; i++) {
                ints[index] = i;

                dfs(ints, index + 1);
            }


        }
    }
}