

//给你两个整数 m 和 n，分别表示网格的行数和列数。 
//
// 请你构造 任意 一个只包含字符 '.' 和 '#' 的 m x n 网格，其中： 
//
// 
// '.' 表示空单元格。 
// '#' 表示障碍物单元格。 
// 
//
// 有效路径 是满足以下条件的空单元格序列： 
//
// 
// 从左上角单元格 (0, 0) 开始。 
// 在右下角单元格 (m - 1, n - 1) 结束。 
// 只能向：
// 
// 右移动，从 (i, j) 到 (i, j + 1)，或者 
// 下移动，从 (i, j) 到 (i + 1, j)。 
// 
// 
// 
//
// 返回任意一个从左上角到右下角 恰好只有一条有效路径 的网格。 
//
// 
//
// 示例 1： 
//
// 
// 输入： m = 2, n = 3 
// 
//
// 输出： ["..#","#.."] 
//
// 解释： 
//
// 
//
// 唯一的有效路径是：(0,0) → (0,1) → (1,1) → (1,2) 
//
//
// 示例 2： 
//
// 
// 输入： m = 3, n = 3 
// 
//
// 输出： ["..#","#..","##."] 
//
// 解释： 
//
// 
//
// 唯一的有效路径是：(0,0) → (0,1) → (1,1) → (1,2) → (2,2) 
//
//
// 示例 3： 
//
// 
// 输入： m = 1, n = 4 
// 
//
// 输出： ["...."] 
//
// 解释： 
//
// 唯一的有效路径是：(0,0) → (0,1) → (0,2) → (0,3) 
//
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 25 
// 
//
// 👍 5 👎 0


package cn.db117.leetcode.solution39;

/**
 * 3963.构造恰好一条路径的网格.create-grid-with-exactly-one-path
 *
 * @author db117
 * @since 2026-10-27 21:51:39
 **/

public class Solution_3963 {
    public static void main(String[] args) {
        Solution solution = new Solution_3963().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] createGrid(int m, int n) {
            String[] ans = new String[m];
            ans[0] = ".".repeat(n);
            for (int i = 1; i < m; i++) {
                ans[i] = "#".repeat(n - 1) + ".";
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}