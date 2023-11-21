

//给你一个长度为 n 、下标从 0 开始的二维字符串数组 access_times 。对于每个 i（0 <= i <= n - 1 ），access_
//times[i][0] 表示某位员工的姓名，access_times[i][1] 表示该员工的访问时间。access_times 中的所有条目都发生在同一天内。 
//
// 访问时间用 四位 数字表示， 符合 24 小时制 ，例如 "0800" 或 "2250" 。 
//
// 如果员工在 同一小时内 访问系统 三次或更多 ，则称其为 高访问 员工。 
//
// 时间间隔正好相差一小时的时间 不 被视为同一小时内。例如，"0815" 和 "0915" 不属于同一小时内。 
//
// 一天开始和结束时的访问时间不被计算为同一小时内。例如，"0005" 和 "2350" 不属于同一小时内。 
//
// 以列表形式，按任意顺序，返回所有 高访问 员工的姓名。 
//
// 
//
// 示例 1： 
//
// 
//输入：access_times = [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0
//540"]]
//输出：["a"]
//解释："a" 在时间段 [05:32, 06:31] 内有三条访问记录，时间分别为 05:32 、05:49 和 06:21 。
//但是 "b" 的访问记录只有两条。
//因此，答案是 ["a"] 。 
//
// 示例 2： 
//
// 
//输入：access_times = [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1
//508"],["d","1444"],["d","1410"],["c","0809"]]
//输出：["c","d"]
//解释："c" 在时间段 [08:08, 09:07] 内有三条访问记录，时间分别为 08:08 、08:09 和 08:29 。
//"d" 在时间段 [14:10, 15:09] 内有三条访问记录，时间分别为 14:10 、14:44 和 15:08 。
//然而，"e" 只有一条访问记录，因此不能包含在答案中，最终答案是 ["c","d"] 。 
//
// 示例 3： 
//
// 
//输入：access_times = [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],[
//"ab","1124"],["ab","1120"]]
//输出：["ab","cd"]
//解释："ab"在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、11:20 和 11:24 。
//"cd" 在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、10:46 和 10:55 。
//因此，答案是 ["ab","cd"] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= access_times.length <= 100 
// access_times[i].length == 2 
// 1 <= access_times[i][0].length <= 10 
// access_times[i][0] 仅由小写英文字母组成。 
// access_times[i][1].length == 4 
// access_times[i][1] 采用24小时制表示时间。 
// access_times[i][1] 仅由数字 '0' 到 '9' 组成。 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 0 👎 0


package cn.db117.leetcode.solution29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2933.高访问员工.high-access-employees
 *
 * @author db117
 * @since 2023-11-21 14:29:38
 **/

public class Solution_2933 {
    public static void main(String[] args) {
        Solution solution = new Solution_2933().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {
            List<String> ans = new ArrayList<>();
            // 姓名 -> 时间
            Map<String, List<String>> map = new HashMap<>();
            for (List<String> accessTime : access_times) {
                String name = accessTime.get(0);
                String time = accessTime.get(1);

                List<String> list = map.getOrDefault(name, new ArrayList<>());
                list.add(time);
                map.put(name, list);
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String k = entry.getKey();
                List<String> v = entry.getValue();
                if (v.size() < 3) {
                    continue;
                }
                v.sort(String::compareTo);
                for (int i = 0; i < v.size() - 2; i++) {
                    Integer a = Integer.valueOf(v.get(i));
                    Integer b = Integer.valueOf(v.get(i + 2));
                    if (b - a < 100) {
                        ans.add(k);
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}