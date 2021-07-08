


//给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。 
//
// 提示： 
//
// 
// 整数点是具有整数坐标的点。 
// 矩形周边上的点包含在矩形覆盖的空间中。 
// 第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。 
// 每个矩形的长度和宽度不超过 2000。 
// 1 <= rects.length <= 100 
// pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。 
// pick 最多被调用10000次。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[[[1,1,5,5]]],[],[],[]]
//输出: 
//[null,[4,1],[4,1],[3,3]]
// 
//
// 示例 2： 
//
// 
//输入: 
//["Solution","pick","pick","pick","pick","pick"]
//[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
//输出: 
//[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]] 
//
// 
//
// 输入语法的说明： 
//
// 输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 rects。pick 没有参数。参数总是用列表包装的，即使没有也
//是如此。 
//
// 
// Related Topics 水塘抽样 数学 二分查找 有序集合 前缀和 随机化 
// 👍 37 👎 0


package cn.db117.leetcode.solution4;

import java.util.Arrays;
import java.util.Random;

/**
 * 497.非重叠矩形中的随机点.random-point-in-non-overlapping-rectangles
 *
 * @author db117
 * @since 2021-07-08 17:51:08
 **/

public class Solution_497 {
    public static void main(String[] args) {
        Solution solution = new Solution_497().new Solution(new int[][]{{-2, -2, -1, -1}, {1, 0, 3, 0}});
        for (int i = 0; i < 1000; i++) {
            System.out.println(Arrays.toString(solution.pick()));
        }

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] sums;
        int[][] rects;
        Random random = new Random();

        // 跟 528 一样
        public Solution(int[][] rects) {
            // 前缀和，随机一个数字。然后二分查找
            sums = new int[rects.length + 1];
            this.rects = rects;
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                // 当前矩形面积（所有点，所有需要 +1）
                int cur = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                sums[i + 1] = sums[i] + cur;
            }
        }

        public int[] pick() {
            int r = random.nextInt(sums[sums.length - 1] + 1);

            int index = bs(r);
            int[] rect = rects[index];

            // 随机点的位置
            return new int[]{rect[0] + random.nextInt(rect[2] - rect[0] + 1),
                    rect[1] + random.nextInt(rect[3] - rect[1] + 1)};
        }

        // 找到大于等于目标值的最小值
        private int bs(int target) {
            int left = 0, right = sums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (sums[mid] >= target) {
                    // 可能是目标值，继续往左边找
                    right = mid;
                } else {
                    // 目标在右边
                    left = mid + 1;
                }
            }
            // 初始化的时候有 +1
            return right == 0 ? 0 : right - 1;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}