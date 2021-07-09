//创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
//
// 1. set(string key, string value, int timestamp) 
//
// 
// 存储键 key、值 value，以及给定的时间戳 timestamp。 
// 
//
// 2. get(string key, int timestamp) 
//
// 
// 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。 
//
// 如果有多个这样的值，则返回对应最大的 timestamp_prev 的那个值。 
// 如果没有值，则返回空字符串（""）。 
// 
//
// 
//
// 示例 1： 
//
// 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["f
//oo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//输出：[null,null,"bar","bar",null,"bar2","bar2"]
//解释：  
//TimeMap kv;   
//kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1   
//kv.get("foo", 1);  // 输出 "bar"   
//kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即
// "bar"）   
//kv.set("foo", "bar2", 4);   
//kv.get("foo", 4); // 输出 "bar2"   
//kv.get("foo", 5); // 输出 "bar2"   
//
// 
//
// 示例 2： 
//
// 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [
//[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["lov
//e",20],["love",25]]
//输出：[null,null,null,"","high","high","low","low"]
// 
//
// 
//
// 提示： 
//
// 
// 所有的键/值字符串都是小写的。 
// 所有的键/值字符串长度都在 [1, 100] 范围内。 
// 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。 
// 1 <= timestamp <= 10^7 
// TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。 
// 
// Related Topics 设计 哈希表 字符串 二分查找 
// 👍 78 👎 0


package cn.db117.leetcode.solution9;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981.基于时间的键值存储.time-based-key-value-store
 *
 * @author db117
 * @since 2021-07-09 15:07:34
 **/

public class Solution_981 {
    public static void main(String[] args) {
        TimeMap solution = new Solution_981().new TimeMap();
        // 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [
//[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["lov
//e",20],["love",25]]
        solution.set("love", "high", 10);
        solution.set("love", "low", 20);

        System.out.println(solution.get("love", 5));
        System.out.println(solution.get("love", 10));
        System.out.println(solution.get("love", 15));
        System.out.println(solution.get("love", 20));
        System.out.println(solution.get("love", 25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TimeMap {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.get(key);

            if (treeMap == null) {
                return "";
            }

            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            if (entry == null) {
                return "";
            }

            return entry.getValue();
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}