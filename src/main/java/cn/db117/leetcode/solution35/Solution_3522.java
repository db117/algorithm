

//给你两个数组：instructions 和 values，数组的长度均为 n。 
//
// 你需要根据以下规则模拟一个过程： 
//
// 
// 从下标 i = 0 的第一个指令开始，初始得分为 0。 
// 如果 instructions[i] 是 "add"： 
// 
// 将 values[i] 加到你的得分中。 
// 移动到下一个指令 (i + 1)。 
// 
// 如果 instructions[i] 是 "jump"： 
// 
// 移动到下标为 (i + values[i]) 的指令，但不修改你的得分。 
// 
// 
//
// 当以下任一情况发生时，过程会终止： 
//
// 
// 越界（即 i < 0 或 i >= n），或 
// 尝试再次执行已经执行过的指令。被重复访问的指令不会再次执行。 
// 
//
// 返回过程结束时的得分。 
//
// 
//
// 示例 1： 
//
// 
// 输入： instructions = ["jump","add","add","jump","add","jump"], values = [2,1,3,
//1,-2,-3] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 从下标 0 开始模拟过程： 
//
// 
// 下标 0：指令是 "jump"，移动到下标 0 + 2 = 2。 
// 下标 2：指令是 "add"，将 values[2] = 3 加到得分中，移动到下标 3。得分变为 3。 
// 下标 3：指令是 "jump"，移动到下标 3 + 1 = 4。 
// 下标 4：指令是 "add"，将 values[4] = -2 加到得分中，移动到下标 5。得分变为 1。 
// 下标 5：指令是 "jump"，移动到下标 5 + (-3) = 2。 
// 下标 2：已经访问过。过程结束。 
// 
//
// 示例 2： 
//
// 
// 输入： instructions = ["jump","add","add"], values = [3,1,1] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 从下标 0 开始模拟过程： 
//
// 
// 下标 0：指令是 "jump"，移动到下标 0 + 3 = 3。 
// 下标 3：越界。过程结束。 
// 
//
// 示例 3： 
//
// 
// 输入： instructions = ["jump"], values = [0] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 从下标 0 开始模拟过程： 
//
// 
// 下标 0：指令是 "jump"，移动到下标 0 + 0 = 0。 
// 下标 0：已经访问过。过程结束。 
// 
//
// 
//
// 提示： 
//
// 
// n == instructions.length == values.length 
// 1 <= n <= 10⁵ 
// instructions[i] 只能是 "add" 或 "jump"。 
// -10⁵ <= values[i] <= 10⁵ 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution35;

/**
 * 3522.执行指令后的得分.calculate-score-after-performing-instructions
 *
 * @author db117
 * @since 2025-04-21 10:20:40
 **/

public class Solution_3522 {
    public static void main(String[] args) {
        Solution solution = new Solution_3522().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long calculateScore(String[] instructions, int[] values) {
            // 模拟过程
            int n = instructions.length;
            long ans = 0;
            int i = 0;
            boolean[] visited = new boolean[n];
            while (i < n && i >= 0) {
                if (visited[i]) {
                    break;
                }
                visited[i] = true;
                String instruction = instructions[i];
                if ("jump".equals(instruction)) {
                    i += values[i];
                } else {
                    ans += values[i];
                    i++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}