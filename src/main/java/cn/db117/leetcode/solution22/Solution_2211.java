

//在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。 
//
// 给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆
//车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。 
//
// 碰撞次数可以按下述方式计算： 
//
// 
// 当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。 
// 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。 
// 
//
// 碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。 
//
// 返回在这条道路上发生的 碰撞总次数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：directions = "RLRSLL"
//输出：5
//解释：
//将会在道路上发生的碰撞列出如下：
//- 车 0 和车 1 会互相碰撞。由于它们按相反方向移动，碰撞数量变为 0 + 2 = 2 。
//- 车 2 和车 3 会互相碰撞。由于 3 是静止的，碰撞数量变为 2 + 1 = 3 。
//- 车 3 和车 4 会互相碰撞。由于 3 是静止的，碰撞数量变为 3 + 1 = 4 。
//- 车 4 和车 5 会互相碰撞。在车 4 和车 3 碰撞之后，车 4 会待在碰撞位置，接着和车 5 碰撞。碰撞数量变为 4 + 1 = 5 。
//因此，将会在道路上发生的碰撞总次数是 5 。
// 
//
// 示例 2： 
//
// 
//输入：directions = "LLRR"
//输出：0
//解释：
//不存在会发生碰撞的车辆。因此，将会在道路上发生的碰撞总次数是 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= directions.length <= 10⁵ 
// directions[i] 的值为 'L'、'R' 或 'S' 
// 
// 👍 12 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2211.统计道路上的碰撞次数.count-collisions-on-a-road
 *
 * @author db117
 * @since 2022-03-21 14:30:32
 **/

public class Solution_2211 {
    public static void main(String[] args) {
        Solution solution = new Solution_2211().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCollisions(String directions) {

            char[] chars = directions.toCharArray();
            // 最后状态肯定为 L[0,] +S[0,]+R[0,]
            // 找出最左边的 L
            int left = 0;
            for (char aChar : chars) {
                if (aChar == 'L') {
                    left++;
                } else {
                    break;
                }
            }

            // 最右边的 R
            int right = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == 'R') {
                    right++;
                } else {
                    break;
                }
            }

            // 中间的 S
            int sCount = 0;
            for (char c : chars) {
                if (c == 'S') {
                    sCount++;
                }
            }


            // 剩下的就是需要改变状态的
            return chars.length - left - right - sCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}