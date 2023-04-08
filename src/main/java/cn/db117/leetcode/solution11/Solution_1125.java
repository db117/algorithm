

//作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员
// people[i] 含有一份该备选人员掌握的技能列表）。 
//
// 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团
//队中的成员： 
//
// 
// 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。 
// 
//
// 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],[
//"nodejs","reactjs"]]
//输出：[0,2]
// 
//
// 示例 2： 
//
// 
//输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people 
//= [["algorithms","math","java"],["algorithms","math","reactjs"],["java",
//"csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= req_skills.length <= 16 
// 1 <= req_skills[i].length <= 16 
// req_skills[i] 由小写英文字母组成 
// req_skills 中的所有字符串 互不相同 
// 1 <= people.length <= 60 
// 0 <= people[i].length <= 16 
// 1 <= people[i][j].length <= 16 
// people[i][j] 由小写英文字母组成 
// people[i] 中的所有字符串 互不相同 
// people[i] 中的每个技能是 req_skills 中的技能 
// 题目数据保证「必要团队」一定存在 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 150 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1125.最小的必要团队.smallest-sufficient-team
 *
 * @author db117
 * @since 2023-04-08 20:37:32
 **/

public class Solution_1125 {
    public static void main(String[] args) {
        Solution solution = new Solution_1125().new Solution();
        // req_skills =
        //["java","nodejs","reactjs"]
        //people =
        //[["java"],["nodejs"],["nodejs","reactjs"]]

        System.out.println(Arrays.toString(solution.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs")))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] skill;// 压缩后的状态
        int n;

        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            n = req_skills.length;
            int m = people.size();
            // 状态压缩
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < req_skills.length; i++) {
                map.put(req_skills[i], i);
            }
            skill = new int[m];
            for (int i = 0; i < m; i++) {
                for (String s : people.get(i)) {
                    skill[i] |= 1 << map.get(s);
                }
            }
            // 所有技能都有
            int all = (1 << n) - 1;
            // f[i+1][j] 表示前 i 个人选择 j 个技能（1表示选择）
            long[][] f = new long[m + 1][all + 1];
            Arrays.fill(f[0], all);// 找最小的，会把这些都排除了
            f[0][0] = 0;// 初始

            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= all; j++) {
                    // 不选
                    var non = f[i][j];
                    // 选
                    var use = f[i][j & ~skill[i]/* j去掉当前技能 */] | 1L << i;// 前面 i 个人选择 不在当前集合中的

                    f[i + 1][j] = Long.bitCount(non) < Long.bitCount(use) ? non : use;// 选择需要人数少的
                }

            }

            // 转换答案
            long ansL = f[m][all];
            int[] ans = new int[Long.bitCount(ansL)];
            int index = 0;
            for (int i = 0; i < 64; i++) {
                if ((ansL & (1L << i)) > 0) {
                    ans[index++] = i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}