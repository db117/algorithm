

//给你一个整数数据流，请你实现一个数据结构，检查数据流中最后 k 个整数是否 等于 给定值 value 。 
//
// 请你实现 DataStream 类： 
//
// 
// DataStream(int value, int k) 用两个整数 value 和 k 初始化一个空的整数数据流。 
// boolean consec(int num) 将 num 添加到整数数据流。如果后 k 个整数都等于 value ，返回 true ，否则返回 
//false 。如果少于 k 个整数，条件不满足，所以也返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["DataStream", "consec", "consec", "consec", "consec"]
//[[4, 3], [4], [4], [4], [3]]
//输出：
//[null, false, false, true, false]
//
//解释：
//DataStream dataStream = new DataStream(4, 3); // value = 4, k = 3 
//dataStream.consec(4); // 数据流中只有 1 个整数，所以返回 False 。
//dataStream.consec(4); // 数据流中只有 2 个整数
//                      // 由于 2 小于 k ，返回 False 。
//dataStream.consec(4); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
//dataStream.consec(3); // 最后 k 个整数分别是 [4,4,3] 。
//                      // 由于 3 不等于 value ，返回 False 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= value, num <= 10⁹ 
// 1 <= k <= 10⁵ 
// 至多调用 consec 次数为 10⁵ 次。 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution25;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2526.找到数据流中的连续整数.find-consecutive-integers-from-a-data-stream
 *
 * @author db117
 * @since 2023-01-09 17:40:19
 **/

public class Solution_2526 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DataStream {
        Queue<Integer> queue = new LinkedList<>();
        int value;
        int k;
        int count;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            queue.offer(num);
            if (num == value) {
                count++;
            }
            if (queue.size() < k) {
                // 不够 k 个数
                return false;
            }
            // 多余的数字直接删掉,只记录最后 k 个
            if (queue.size() > k) {
                if (queue.poll() == value) {
                    count--;
                }
            }
            return count == k;
        }
    }

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}