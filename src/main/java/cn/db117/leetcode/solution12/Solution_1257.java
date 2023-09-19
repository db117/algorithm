

//给你一些区域列表 regions ，每个列表的第一个区域都包含这个列表内所有其他区域。 
//
// 很自然地，如果区域 X 包含区域 Y ，那么区域 X 比区域 Y 大。 
//
// 给定两个区域 region1 和 region2 ，找到同时包含这两个区域的 最小 区域。 
//
// 如果区域列表中 r1 包含 r2 和 r3 ，那么数据保证 r2 不会包含 r3 。 
//
// 数据同样保证最小公共区域一定存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//regions = [["Earth","North America","South America"],
//["North America","United States","Canada"],
//["United States","New York","Boston"],
//["Canada","Ontario","Quebec"],
//["South America","Brazil"]],
//region1 = "Quebec",
//region2 = "New York"
//输出："North America"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= regions.length <= 10^4 
// region1 != region2 
// 所有字符串只包含英文字母和空格，且最多只有 20 个字母。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 数组 哈希表 字符串 👍 52 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1257.最小公共区域.smallest-common-region
 *
 * @author db117
 * @since 2023-09-19 10:37:39
 **/

public class Solution_1257 {
    public static void main(String[] args) {
        Solution solution = new Solution_1257().new Solution();
        // [["Earth","North America","South America"],["North America","United States","Canada"],["United States","New York","Boston"],["Canada","Ontario","Quebec"],["South America","Brazil"]]
        //			"Quebec"
        //			"New York"
        System.out.println(solution.findSmallestRegion(
                List.of(
                        List.of("Earth", "North America", "South America"),
                        List.of("North America", "United States", "Canada"),
                        List.of("United States", "New York", "Boston"),
                        List.of("Canada", "Ontario", "Quebec"),
                        List.of("South America", "Brazil")
                ),
                "Quebec",
                "New York"
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
            // 每个区域的父区域
            Map<String, String> map = new HashMap<>();
            for (List<String> region : regions) {
                String parent = region.get(0);
                for (int i = 1; i < region.size(); i++) {
                    map.put(region.get(i), parent);
                }
            }

            // 找到两个区域的父区域
            List<String> list1 = getParent(map, region1);
            List<String> list2 = getParent(map, region2);

            // 找到最小的公共区域
            for (String s : list1) {
                if (list2.contains(s)) {
                    return s;
                }
            }
            return "";
        }

        private List<String> getParent(Map<String, String> map, String region1) {
            List<String> ans = new ArrayList<>();
            while (region1 != null) {
                ans.add(region1);
                region1 = map.get(region1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}