

//请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。 
//
// 实现 FrequencyTracker 类： 
//
// 
// FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。 
// void add(int number)：添加一个 number 到数据结构中。 
// void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内
//容。 
// bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 
//false。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["FrequencyTracker", "add", "add", "hasFrequency"]
//[[], [3], [3], [2]]
//输出
//[null, null, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
//frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
// 
//
// 示例 2： 
//
// 
//输入
//["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
//[[], [1], [1], [1]]
//输出
//[null, null, null, false]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(1); // 数据结构现在包含 [1]
//frequencyTracker.deleteOne(1); // 数据结构现在为空 []
//frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
// 
//
// 示例 3： 
//
// 
//输入
//["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
//[[], [2], [3], [1]]
//输出
//[null, false, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= number <= 10⁵ 
// 1 <= frequency <= 10⁵ 
// 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10⁵ 次 
// 
//
// Related Topics 设计 哈希表 👍 5 👎 0


package cn.db117.leetcode.solution26;

import java.util.HashMap;
import java.util.Map;

/**
 * 2671.频率跟踪器.frequency-tracker
 *
 * @author db117
 * @since 2023-05-22 10:27:58
 **/

public class Solution_2671 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrequencyTracker {
        // 记录数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 频率
        Map<Integer, Integer> count = new HashMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            Integer cur = map.get(number);

            count.put(cur, count.getOrDefault(cur, 0) + 1);
            if (cur > 1) {
                // 去掉之前的频率
                count.put(cur - 1, count.get(cur - 1) - 1);
            }
        }

        public void deleteOne(int number) {
            Integer curCount = map.get(number);
            if (curCount == null) {
                return;
            }
            if (curCount > 1) {
                // 调整频率
                count.put(curCount, count.get(curCount) - 1);
                count.put(curCount - 1, count.getOrDefault(curCount - 1, 0) + 1);
                map.put(number, curCount - 1);
            } else {
                // 一个
                count.put(1, count.get(1) - 1);
                map.remove(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return count.getOrDefault(frequency, 0) > 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}