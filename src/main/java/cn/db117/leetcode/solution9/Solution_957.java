

//8 间牢房排成一排，每间牢房不是有人住就是空着。 
//
// 每天，无论牢房是被占用或空置，都会根据以下规则进行更改： 
//
// 
// 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。 
// 否则，它就会被空置。 
// 
//
// （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。） 
//
// 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。 
//
// 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：cells = [0,1,0,1,1,0,0,1], N = 7
//输出：[0,0,1,1,0,0,0,0]
//解释：
//下表概述了监狱每天的状况：
//Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
// 
//
// 示例 2： 
//
// 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
//输出：[0,0,1,1,1,1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// cells.length == 8 
// cells[i] 的值为 0 或 1 
// 1 <= N <= 10^9 
// 
// Related Topics 位运算 数组 哈希表 数学 👍 102 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;

/**
 * 957.N 天后的牢房.prison-cells-after-n-days
 *
 * @author db117
 * @since 2021-10-08 18:12:06
 **/

public class Solution_957 {
    public static void main(String[] args) {
        Solution solution = new Solution_957().new Solution();
        System.out.println(Arrays.toString(solution.prisonAfterNDays(new int[]{
                1, 0, 0, 1, 0, 0, 1, 0
        }, 1000000000)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int n) {
            // 14 次一循环
            n = (n - 1) % 14;

            // 原始的数据不能用，两边都不能为1。循环从第一次计算后开始
            for (int i = 0; i <= n; i++) {
                int[] next = new int[8];
                for (int j = 1; j < 7; j++) {
                    if (cells[j - 1] == cells[j + 1]) {
                        next[j] = 1;
                    }
                }
                cells = next;

            }

            return cells;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}