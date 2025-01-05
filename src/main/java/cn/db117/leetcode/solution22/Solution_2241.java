

//一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。
// 
//
// 取款时，机器会优先取 较大 数额的钱。 
//
// 
// 比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和 $20
//0 的钞票。 
// 但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500 的钞票，然后
//无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。 
// 
//
// 请你实现 ATM 类： 
//
// 
// ATM() 初始化 ATM 对象。 
// void deposit(int[] banknotesCount) 分别存入 $20 ，$50，$100，$200 和 $500 钞票的数目。 
// int[] withdraw(int amount) 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和 $500 钞票的数
//目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1] （这种情况下 不 取出任何钞票）。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
//[[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
//输出：
//[null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]
//
//解释：
//ATM atm = new ATM();
//atm.deposit([0,0,1,2,1]); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
//atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩
//余钞票的数量为 [0,0,0,2,0] 。
//atm.deposit([0,1,0,1,1]); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
//                          // 机器中剩余钞票数量为 [0,1,0,3,1] 。
//atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会
//被拒绝。
//                          // 由于请求被拒绝，机器中钞票的数量不会发生改变。
//atm.withdraw(550);        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500 的钞票。 
//
//
// 
//
// 提示： 
//
// 
// banknotesCount.length == 5 
// 0 <= banknotesCount[i] <= 10⁹ 
// 1 <= amount <= 10⁹ 
// 总共 最多有 5000 次 withdraw 和 deposit 的调用。 
// 函数 withdraw 和 deposit 至少各有 一次 调用。 
// 
//
// Related Topics 贪心 设计 数组 👍 34 👎 0


package cn.db117.leetcode.solution22;

import java.util.Arrays;

/**
 * 2241.设计一个 ATM 机器.design-an-atm-machine
 *
 * @author db117
 * @since 2025-01-05 21:36:49
 **/

public class Solution_2241 {
    public static void main(String[] args) {
        ATM atm = new Solution_2241().new ATM();
        atm.deposit(new int[]{100000 * 4000, 100000 * 4000, 100000 * 4000, 100000 * 4000, 100000 * 4000});
        System.out.println(Arrays.toString(atm.withdraw(1000000000)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ATM {
        int[] count = new int[5];

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                count[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] ans = new int[5];
            if (amount >= 500) {
                if (amount / 500 >= count[4]) {
                    ans[4] += count[4];
                    amount -= 500 * count[4];
                } else {
                    ans[4] += amount / 500;
                    amount %= 500;
                }
            }
            if (amount >= 200) {
                if (amount / 200 >= count[3]) {
                    ans[3] += count[3];
                    amount -= 200 * count[3];
                } else {
                    ans[3] += amount / 200;
                    amount %= 200;
                }
            }
            if (amount >= 100) {
                if (amount / 100 >= count[2]) {
                    ans[2] += count[2];
                    amount -= 100 * count[2];
                } else {
                    ans[2] += amount / 100;
                    amount %= 100;
                }
            }
            if (amount >= 50) {
                if (amount / 50 >= count[1]) {
                    ans[1] += count[1];
                    amount -= 50 * count[1];
                } else {
                    ans[1] += amount / 50;
                    amount %= 50;
                }
            }
            if (amount >= 20) {
                if (amount / 20 >= count[0]) {
                    ans[0] += count[0];
                    amount -= 20 * count[0];
                } else {
                    ans[0] += amount / 20;
                    amount %= 20;
                }
            }

            if (amount > 0) {
                return new int[]{-1};
            }

            for (int i = 0; i < 5; i++) {
                count[i] -= ans[i];
            }
            return ans;
        }
    }

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
//leetcode submit region end(Prohibit modification and deletion)

}