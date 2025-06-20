

//给你一个由字符 'N'、'S'、'E' 和 'W' 组成的字符串 s，其中 s[i] 表示在无限网格中的移动操作： 
//
// 
// 'N'：向北移动 1 个单位。 
// 'S'：向南移动 1 个单位。 
// 'E'：向东移动 1 个单位。 
// 'W'：向西移动 1 个单位。 
// 
//
// 初始时，你位于原点 (0, 0)。你 最多 可以修改 k 个字符为任意四个方向之一。 
//
// 请找出在 按顺序 执行所有移动操作过程中的 任意时刻 ，所能达到的离原点的 最大曼哈顿距离 。 
//
// 曼哈顿距离 定义为两个坐标点 (xi, yi) 和 (xj, yj) 的横向距离绝对值与纵向距离绝对值之和，即 |xi - xj| + |yi - yj|
//。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "NWSE", k = 1 
// 
//
// 输出：3 
//
// 解释： 
//
// 将 s[2] 从 'S' 改为 'N' ，字符串 s 变为 "NWNE" 。 
//
// 
// 
// 
// 移动操作 
// 位置 (x, y) 
// 曼哈顿距离 
// 最大值 
// 
// 
// 
// 
// s[0] == 'N' 
// (0, 1) 
// 0 + 1 = 1 
// 1 
// 
// 
// s[1] == 'W' 
// (-1, 1) 
// 1 + 1 = 2 
// 2 
// 
// 
// s[2] == 'N' 
// (-1, 2) 
// 1 + 2 = 3 
// 3 
// 
// 
// s[3] == 'E' 
// (0, 2) 
// 0 + 2 = 2 
// 3 
// 
// 
// 
//
// 执行移动操作过程中，距离原点的最大曼哈顿距离是 3 。 
//
// 示例 2： 
//
// 
// 输入：s = "NSWWEW", k = 3 
// 
//
// 输出：6 
//
// 解释： 
//
// 将 s[1] 从 'S' 改为 'N' ，将 s[4] 从 'E' 改为 'W' 。字符串 s 变为 "NNWWWW" 。 
//
// 执行移动操作过程中，距离原点的最大曼哈顿距离是 6 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 0 <= k <= s.length 
// s 仅由 'N'、'S'、'E' 和 'W' 。 
// 
//
// Related Topics 哈希表 数学 字符串 计数 👍 24 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3443.K 次修改后的最大曼哈顿距离.maximum-manhattan-distance-after-k-changes
 *
 * @author db117
 * @since 2025-06-20 16:16:02
 **/

public class Solution_3443 {
    public static void main(String[] args) {
        Solution solution = new Solution_3443().new Solution();

        // "NWSE"
        //			1
        System.out.println(solution.maxDistance("NWSE", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(String s, int k) {
            int n = s.length();
            int ans = 0;
            int up = 0;
            int down = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'N':
                        up++;
                        break;
                    case 'S':
                        down++;
                        break;
                    case 'E':
                        right++;
                        break;
                    case 'W':
                        left++;
                        break;
                }

                // 上下 和 左右不互相影响
                // 把数量少的变成数量多的方向
                int cur = 0;
                int curK = k;
                int change = Math.min(Math.min(up, down), k);// 上下方向改变的次数
                curK -= change;
                cur += Math.abs(up - down) + change * 2;// 改变后的曼哈顿距离

                if (curK > 0) {// 还能继续改变左右的
                    change = Math.min(Math.min(left, right), curK);
                    cur += Math.abs(left - right) + change * 2;
                }else {
                    cur += Math.abs(left - right);
                }

                ans = Math.max(ans, cur);
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}