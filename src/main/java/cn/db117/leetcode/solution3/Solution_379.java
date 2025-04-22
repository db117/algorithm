

//设计一个电话目录管理系统，一开始有 maxNumbers 个位置能够储存号码。系统应该存储号码，检查某个位置是否为空，并清空给定的位置。 
//
// 实现 PhoneDirectory 类： 
//
// 
// PhoneDirectory(int maxNumbers) 电话目录初始有 maxNumbers 个可用位置。 
// int get() 提供一个未分配给任何人的号码。如果没有可用号码则返回 -1。 
// bool check(int number) 如果位置 number 可用返回 true 否则返回 false。 
// void release(int number) 回收或释放位置 number。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
//[[3], [], [], [2], [], [2], [2], [2]]
//输出：
//[null, 0, 1, true, 2, false, null, true]
//
//解释：
//PhoneDirectory phoneDirectory = new PhoneDirectory(3);
//phoneDirectory.get();      // 它可以返回任意可用的数字。这里我们假设它返回 0。
//phoneDirectory.get();      // 假设它返回 1。
//phoneDirectory.check(2);   // 数字 2 可用，所以返回 true。
//phoneDirectory.get();      // 返回剩下的唯一一个数字 2。
//phoneDirectory.check(2);   // 数字 2 不再可用，所以返回 false。
//phoneDirectory.release(2); // 将数字 2 释放回号码池。
//phoneDirectory.check(2);   // 数字 2 重新可用，返回 true。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= maxNumbers <= 10⁴ 
// 0 <= number < maxNumbers 
// get，check 和 release 最多被调用 2 * 10⁴ 次。 
// 
//
// Related Topics 设计 队列 数组 哈希表 链表 👍 44 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayDeque;

/**
 * 379.电话目录管理系统.design-phone-directory
 *
 * @author db117
 * @since 2025-04-22 18:59:31
 **/

public class Solution_379 {
    public static void main(String[] args) {
        PhoneDirectory solution = new Solution_379().new PhoneDirectory(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class PhoneDirectory {
        // 保存可以存的位置
        boolean[] flag;
        ArrayDeque<Integer> queue;

        public PhoneDirectory(int maxNumbers) {
            flag = new boolean[maxNumbers];
            queue = new ArrayDeque<>(maxNumbers);
            for (int i = 0; i < maxNumbers; i++) {
                queue.addLast(i);
            }
        }

        public int get() {
            while (!queue.isEmpty() && flag[queue.peek()]) {
                // 去掉无效数据
                queue.pop();
            }
            Integer poll = queue.poll();
            if (poll != null) {
                flag[poll] = true;
                return poll;
            }
            return -1;
        }

        public boolean check(int number) {
            return !flag[number];
        }

        public void release(int number) {
            flag[number] = false;
            queue.addLast(number);
        }
    }

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
//leetcode submit region end(Prohibit modification and deletion)

}