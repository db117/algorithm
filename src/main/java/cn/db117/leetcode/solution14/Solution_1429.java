

//给定一系列整数，插入一个队列中，找出队列中第一个唯一整数。 
//
// 实现 FirstUnique 类： 
//
// 
// FirstUnique(int[] nums) 用数组里的数字初始化队列。 
// int showFirstUnique() 返回队列中的 第一个唯一 整数的值。如果没有唯一整数，返回 -1。（译者注：此方法不移除队列中的任何元素） 
// void add(int value) 将 value 插入队列中。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","showFirstUnique","add",
//"showFirstUnique","add","showFirstUnique"]
//[[[2,3,5]],[],[5],[],[2],[],[3],[]]
//输出：
//[null,2,null,2,null,3,null,-1]
//解释：
//FirstUnique firstUnique = new FirstUnique([2,3,5]);
//firstUnique.showFirstUnique(); // 返回 2
//firstUnique.add(5);            // 此时队列为 [2,3,5,5]
//firstUnique.showFirstUnique(); // 返回 2
//firstUnique.add(2);            // 此时队列为 [2,3,5,5,2]
//firstUnique.showFirstUnique(); // 返回 3
//firstUnique.add(3);            // 此时队列为 [2,3,5,5,2,3]
//firstUnique.showFirstUnique(); // 返回 -1
// 
//
// 示例 2： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","add","add","add","add",
//"showFirstUnique"]
//[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
//输出：
//[null,-1,null,null,null,null,null,17]
//解释：
//FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
//firstUnique.showFirstUnique(); // 返回 -1
//firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7]
//firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3]
//firstUnique.add(3);            // 此时队列为 [7,7,7,7,7,7,7,3,3]
//firstUnique.add(7);            // 此时队列为 [7,7,7,7,7,7,7,3,3,7]
//firstUnique.add(17);           // 此时队列为 [7,7,7,7,7,7,7,3,3,7,17]
//firstUnique.showFirstUnique(); // 返回 17
// 
//
// 示例 3： 
//
// 
//输入：
//["FirstUnique","showFirstUnique","add","showFirstUnique"]
//[[[809]],[],[809],[]]
//输出：
//[null,809,null,-1]
//解释：
//FirstUnique firstUnique = new FirstUnique([809]);
//firstUnique.showFirstUnique(); // 返回 809
//firstUnique.add(809);          // 此时队列为 [809,809]
//firstUnique.showFirstUnique(); // 返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^8 
// 1 <= value <= 10^8 
// 最多调用 5000 次 showFirstUnique 和 add 。 
// 
//
// Related Topics 设计 队列 数组 哈希表 数据流 👍 23 👎 0


package cn.db117.leetcode.solution14;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1429.第一个唯一数字.first-unique-number
 *
 * @author db117
 * @since 2023-04-07 11:27:01
 **/

public class Solution_1429 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FirstUnique {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            while (!deque.isEmpty() && map.getOrDefault(deque.peek(), 1) > 1) {
                // 出现多次的不要
                deque.pop();
            }
            return deque.isEmpty() ? -1 : deque.peek();
        }

        public void add(int num) {
            map.merge(num, 1, Integer::sum);
            deque.addLast(num);
        }
    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}