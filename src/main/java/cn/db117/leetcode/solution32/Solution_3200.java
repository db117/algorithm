

//给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 
//3 行有 3 个球，依此类推。 
//
// 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。 
//
// 返回可以实现的三角形的 最大 高度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： red = 2, blue = 4 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
//
// 上图显示了唯一可能的排列方式。 
//
// 示例 2： 
//
// 
// 输入： red = 2, blue = 1 
// 
//
// 输出： 2 
//
// 解释： 
//
// 上图显示了唯一可能的排列方式。 
//
// 示例 3： 
//
// 
// 输入： red = 1, blue = 1 
// 
//
// 输出： 1 
//
// 示例 4： 
//
// 
// 输入： red = 10, blue = 1 
// 
//
// 输出： 2 
//
// 解释： 
//
// 上图显示了唯一可能的排列方式。 
//
// 
//
// 提示： 
//
// 
// 1 <= red, blue <= 100 
// 
//
// Related Topics 数组 枚举 👍 4 👎 0


package cn.db117.leetcode.solution32;

/**
 * 3200.三角形的最大高度.maximum-height-of-a-triangle
 *
 * @author db117
 * @since 2024-07-04 14:27:47
 **/

public class Solution_3200 {
    public static void main(String[] args) {
        Solution solution = new Solution_3200().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeightOfTriangle(int red, int blue) {
            int ans = 0;
            int first = Math.min(red, blue);
            int second = Math.max(red, blue);
            for (int i = 1; i <= Math.max(red, blue); i++) {
                if ((i % 2) == 0) {
                    if (second < i) {
                        break;
                    }
                    second -= i;
                } else {
                    if (first < i) {
                        break;
                    }
                    first -= i;
                }
                ans++;
            }

            int ans1 = 0;
            int first1 = Math.min(red, blue);
            int second1 = Math.max(red, blue);
            for (int i = 1; i <= Math.max(red, blue); i++) {
                if ((i % 2) == 1) {
                    if (second1 < i) {
                        break;
                    }
                    second1 -= i;
                } else {
                    if (first1 < i) {
                        break;
                    }
                    first1 -= i;
                }
                ans1++;
            }
            return Math.max(ans, ans1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}