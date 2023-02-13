

//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 👍 102 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1138.字母板上的路径.alphabet-board-path
 *
 * @author db117
 * @since 2023-02-12 21:08:06
 **/

public class Solution_1138 {
    public static void main(String[] args) {
        Solution solution = new Solution_1138().new Solution();
        System.out.println(solution.alphabetBoardPath("leet"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder ans = new StringBuilder();
            // 一行 5 个
            int x = 0, y = 0;
            for (char c : target.toCharArray()) {
                // 曼哈顿距离
                // 先竖着走，在横着走
                // 当目标是 z 时，先横着走

                // 目标位置
                int nx = (c - 'a') / 5, ny = (c - 'a') % 5;
                // 横着
                String a = x > nx ? "U".repeat(x - nx) : "D".repeat(nx - x);
                // 竖着
                String b = y > ny ? "L".repeat(y - ny) : "R".repeat(ny - y);
                if (c == 'z') {
                    ans.append(b).append(a);
                } else {
                    ans.append(a).append(b);
                }
                ans.append('!');

                x = nx;
                y = ny;
            }

            return ans.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}