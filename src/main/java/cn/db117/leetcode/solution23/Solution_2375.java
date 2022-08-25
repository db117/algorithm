

//给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。 
//
// 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件： 
//
// 
// num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。 
// 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。 
// 如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。 
// 
//
// 请你返回满足上述条件字典序 最小 的字符串 num。 
//
// 
//
// 示例 1： 
//
// 
//输入：pattern = "IIIDIDDD"
//输出："123549876"
//解释：
//下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
//下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
//一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
//"123549876" 是满足条件最小的数字。
//注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。 
//
// 示例 2： 
//
// 
//输入：pattern = "DDD"
//输出："4321"
//解释：
//一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
//"4321" 是满足条件最小的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pattern.length <= 8 
// pattern 只包含字符 'I' 和 'D' 。 
// 
//
// Related Topics 栈 贪心 字符串 回溯 👍 23 👎 0


package cn.db117.leetcode.solution23;

import cn.db117.leetcode.base.Optimized;

/**
 * 2375.根据模式串构造最小数字.construct-smallest-number-from-di-string
 *
 * @author db117
 * @since 2022-08-25 16:17:57
 **/
@Optimized// 可以用贪心来做,找连续下降或上升的段
public class Solution_2375 {
    public static void main(String[] args) {
        Solution solution = new Solution_2375().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String ans;

        public String smallestNumber(String pattern) {
            // 简单回溯,数据量不大
            // 如果字符串长度变大则需要用贪心
            char[] chars = pattern.toCharArray();
            boolean[] flag = new boolean[10];
            char[] ansChars = new char[chars.length + 1];
            for (int i = 1; i < 10; i++) {
                ansChars[0] = (char) (i + '0');
                flag[i] = true;
                dfs(chars, flag, 1, ansChars);
                flag[i] = false;
            }
            return ans;
        }

        private void dfs(char[] pattern, boolean[] flag, int i, char[] ansChars) {
            if (ans != null) {
                return;
            }
            if (i == pattern.length + 1) {
                ans = new String(ansChars);
                return;
            }

            boolean up = pattern[i - 1] == 'I';
            int preNum = ansChars[i - 1] - '0';


            if (up) {
                for (int j = preNum; j < 10; j++) {
                    if (!flag[j]) {
                        flag[j] = true;
                        ansChars[i] = (char) (j + '0');

                        dfs(pattern, flag, i + 1, ansChars);

                        flag[j] = false;
                        ansChars[i] = '-';
                    }
                }
            } else {
                for (int j = 1; j < preNum; j++) {
                    if (!flag[j]) {
                        flag[j] = true;
                        ansChars[i] = (char) (j + '0');

                        dfs(pattern, flag, i + 1, ansChars);

                        flag[j] = false;
                        ansChars[i] = '-';
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}