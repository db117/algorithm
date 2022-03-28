

//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。 
//
// 计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表
// [] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：["--++","+--+","++--"]
// 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 500 
// currentState[i] 不是 '+' 就是 '-' 
// 
// Related Topics 字符串 👍 33 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 293.翻转游戏.flip-game
 *
 * @author db117
 * @since 2022-03-27 23:08:12
 **/

public class Solution_293 {
    public static void main(String[] args) {
        Solution solution = new Solution_293().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generatePossibleNextMoves(String currentState) {
            List<String> ans = new ArrayList<>();

            char[] chars = currentState.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '+' && chars[i + 1] == '+') {
                    chars[i] = '-';
                    chars[i + 1] = '-';

                    ans.add(new String(chars));

                    chars[i] = '+';
                    chars[i + 1] = '+';
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}