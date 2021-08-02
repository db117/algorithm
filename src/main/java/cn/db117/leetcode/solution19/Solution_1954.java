


//给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。 
//
// 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。 
//
// 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。 
//
// |x| 的值定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 
// 如果 x < 0 ，那么值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：neededApples = 1
//输出：8
//解释：边长长度为 1 的正方形不包含任何苹果。
//但是边长为 2 的正方形包含 12 个苹果（如上图所示）。
//周长为 2 * 4 = 8 。
// 
//
// 示例 2： 
//
// 
//输入：neededApples = 13
//输出：16
// 
//
// 示例 3： 
//
// 
//输入：neededApples = 1000000000
//输出：5040
// 
//
// 
//
// 提示： 
//
// 
// 1 <= neededApples <= 1015 
// 
// Related Topics 数学 二分查找 
// 👍 8 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1954.收集足够苹果的最小花园周长.minimum-garden-perimeter-to-collect-enough-apples
 *
 * @author db117
 * @since 2021-08-02 14:43:13
 **/

public class Solution_1954 {
    public static void main(String[] args) {
        Solution solution = new Solution_1954().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumPerimeter(long neededApples) {
            long left = 1, right = 1000000;
            while (left < right) {
                long mid = left + (right - left) / 2;

                if (check(mid, neededApples)) {
                    // 可以尝试变小
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right * 2 * 4;
        }

        // 校验 1/2 边长
        private boolean check(long n, long neededApples) {
            // 1+..+n
            long tmp = (n + 1) * (n / 2);
            if ((n & 1) == 1) {
                tmp += (n + 1) / 2;
            }

            //总和
            long total = tmp * (n * 2 * 4 + 4);

            return total >= neededApples;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}