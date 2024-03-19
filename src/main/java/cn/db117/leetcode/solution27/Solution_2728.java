

//给定一个代表环形街道的类 Street 和一个正整数 k，表示街道上房屋的最大数量（也就是说房屋数量不超过 k ）。每个房屋的门初始时可以是开着的也可以是关
//着的。 
//
// 刚开始，你站在一座房子的门前。你的任务是计算街道上的房屋数量。 
//
// Street 类包含以下函数： 
//
// 
// void openDoor() ：打开当前房屋的门。 
// void closeDoor() ：关闭当前房屋的门。 
// boolean isDoorOpen() ：如果当前房屋的门是开着的返回 true ，否则返回 false 。 
// void moveRight() ：向右移动到下一座房屋。 
// void moveLeft() ：向左移动到上一座房屋。 
// 
//
// 返回 ans，它表示街道上的房屋数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：street = [0,0,0,0], k = 10
//输出：4
//解释：街道上有 4 座房屋，它们的门都是关着的。
//房屋数量小于 k，即 10。 
//
// 示例 2： 
//
// 
//输入：street = [1,0,1,1,0], k = 5
//输出：5
//解释：街道上有 5 座房屋，向右移动时第 1、3 和 4 座房屋的门是开着的，其余的门都是关着的。房屋数量等于 k，即 5。
// 
//
// 
//
// 解释： 
//
// 
// n 是房屋数量 
// 1 <= n <= k <= 10³ 
// 
//
// Related Topics 数组 交互 👍 2 👎 0


package cn.db117.leetcode.solution27;

/**
 * 2728.计算一个环形街道上的房屋数量.count-houses-in-a-circular-street
 *
 * @author db117
 * @since 2024-03-19 15:50:03
 **/

public class Solution_2728 {
    public static void main(String[] args) {
        Solution solution = new Solution_2728().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a street.
     * class Street {
     * public Street(int[] doors);
     * public void openDoor();
     * public void closeDoor();
     * public boolean isDoorOpen();
     * public void moveRight();
     * public void moveLeft();
     * }
     */
    class Solution {
        public int houseCount(Street street, int k) {
            // 全关掉
            for (int i = 0; i < k; i++) {
                street.closeDoor();
                street.moveRight();
            }
            int ans = 0;

            // 全打开
            for (int i = 0; i < k; i++) {
                if (street.isDoorOpen()) {
                    break;
                }
                ans++;
                street.openDoor();
                street.moveLeft();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Street {
        public Street(int[] doors) {
        }

        ;

        public void openDoor() {
        }

        ;

        public void closeDoor() {
        }

        ;

        public boolean isDoorOpen() {
            return true;
        }

        ;

        public void moveRight() {
        }

        ;

        public void moveLeft() {
        }

        ;
    }
}