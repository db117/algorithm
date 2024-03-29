

//给定两个字符串数组 username 和 website 和一个整数数组 timestamp 。给定的数组长度相同，其中元组 [username[i], 
//website[i], timestamp[i]] 表示用户 username[i] 在时间 timestamp[i] 访问了网站 website[i] 。 
//
// 访问模式 是包含三个网站的列表(不一定是完全不同的)。 
//
// 
// 例如，["home"， "away"， "love"]， ["leetcode"， "love"， "leetcode"]，和 ["luffy"， 
//"luffy"， "luffy"] 都是模式。 
// 
//
// 一种 访问模式 的 得分 是访问该模式中所有网站的用户数量，这些网站在该模式中出现的顺序相同。 
//
// 
// 例如，如果模式是 [“home”，“away”，“love”] ，那么分数就是用户数量 x , x 访问了 “home” ，然后访问了 “away” ，然
//后访问了 “love” 。 
// 同样，如果模式是 ["leetcode"， "love"， "leetcode"] ，那么分数就是用户数量 x ，使得 x 访问了"leetcode"，然
//后访问了 "love" ，之后又访问了 "leetcode" 。 
// 另外，如果模式是 [“luffy”，“luffy”，“luffy”] ，那么分数就是用户数量 x ，这样 x 就可以在不同的时间戳上访问 “luffy” 
//三次。 
// 
//
// 返回 得分 最大的 访问模式 。如果有多个访问模式具有相同的最大分数，则返回字典序最小的。 
//
// 
//
// 示例 1： 
//
// 
//输入：username = ["joe","joe","joe","james","james","james","james","mary",
//"mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about",
//"career","home","cart","maps","home","home","about","career"]
//输出：["home","about","career"]
//解释：本例中的元组是:
//["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],[
//"james","cart",5],["james","maps",6],["james","home",7],["mary","home",8],["mary",
//"about",9], and ["mary","career",10].
//模式("home", "about", "career") has score 2 (joe and mary).
//模式("home", "cart", "maps") 的得分为 1 (james).
//模式 ("home", "cart", "home") 的得分为 1 (james).
//模式 ("home", "maps", "home") 的得分为 1 (james).
//模式 ("cart", "maps", "home") 的得分为 1 (james).
//模式 ("home", "home", "home") 的得分为 0(没有用户访问过home 3次)。 
//
// 示例 2： 
//
// 
//输入: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], 
//website = ["a","b","a","a","b","c"]
//输出: ["a","b","a"]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= username.length <= 50 
// 1 <= username[i].length <= 10 
// timestamp.length == username.length 
// 1 <= timestamp[i] <= 10⁹ 
// website.length == username.length 
// 1 <= website[i].length <= 10 
// username[i] 和 website[i] 都只含小写字符 
// 它保证至少有一个用户访问了至少三个网站 
// 所有元组 [username[i]， timestamp[i]， website[i] 均 不重复 
// 
//
// Related Topics 数组 哈希表 排序 👍 27 👎 0


package cn.db117.leetcode.solution11;

import java.util.*;

/**
 * 1152.用户网站访问行为分析.analyze-user-website-visit-pattern
 *
 * @author db117
 * @since 2023-11-02 17:17:08
 **/

public class Solution_1152 {
    public static void main(String[] args) {
        Solution solution = new Solution_1152().new Solution();
        // ["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
        //			[436363475,710406388,386655081,797150921]
        //			["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]
        System.out.println(solution.mostVisitedPattern(new String[]{
                "zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"
        }, new int[]{
                436363475, 710406388, 386655081, 797150921
        }, new String[]{
                "wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            int n = username.length;
            // username -> (timestamp,website)
            Map<String, TreeMap<Integer, String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(username[i], k -> new TreeMap<>()).put(timestamp[i], website[i]);
            }

            // 统计每个用户的访问记录 -> 用户名字
            Map<String, Set<String>> access = new TreeMap<>();
            map.forEach((name, treeMap) -> {
                ArrayList<String> list = new ArrayList<>(treeMap.values());
                for (int i = 0; i < list.size() - 2; i++) {
                    for (int j = i + 1; j < list.size() - 1; j++) {
                        for (int k = j + 1; k < list.size(); k++) {
                            String key = list.get(i) + "_" + list.get(j) + "_" + list.get(k);
                            access.computeIfAbsent(key, s -> new HashSet<>()).add(name);
                        }
                    }
                }
            });
            int max = 0;
            String ans = null;
            for (Map.Entry<String, Set<String>> entry : access.entrySet()) {
                String s = entry.getKey();
                Set<String> strings = entry.getValue();
                if (strings.size() > max) {
                    // 找用户最多的
                    max = strings.size();
                    ans = s;
                }
            }
            List<String> list = new ArrayList<>();
            Collections.addAll(list, ans.split("_"));

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}