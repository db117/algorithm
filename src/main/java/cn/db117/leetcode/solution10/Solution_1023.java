

//如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 
//个字符。） 
//
// 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 
//pattern 匹配时， answer[i] 才为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FB"
//输出：[true,false,true,true,false]
//示例：
//"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer". 
//
// 示例 2： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBa"
//输出：[true,false,true,false,false]
//解释：
//"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
//"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
// 
//
// 示例 3： 
//
// 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBaT"
//输入：[false,true,false,false,false]
//解释： 
//"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 100 
// 1 <= queries[i].length <= 100 
// 1 <= pattern.length <= 100 
// 所有字符串都仅由大写和小写英文字母组成。 
// 
//
// Related Topics 字典树 双指针 字符串 字符串匹配 👍 82 👎 0


package cn.db117.leetcode.solution10;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023.驼峰式匹配.camelcase-matching
 *
 * @author db117
 * @since 2023-04-14 13:37:51
 **/

public class Solution_1023 {
    public static void main(String[] args) {
        Solution solution = new Solution_1023().new Solution();
// ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]  FB
        System.out.println(solution.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans = new ArrayList<>(queries.length);
            for (String query : queries) {
                ans.add(check(query, pattern));
            }
            return ans;
        }

        private boolean check(String q, String p) {
            char[] charsQ = q.toCharArray();
            char[] charsP = p.toCharArray();
            int i = 0, j = 0;
            int m = q.length();
            int n = p.length();
            while (i < m || j < n) {
                // 查询字符串还有
                if (j >= n) {
                    // 后面没有大写字符就行了、
                    while (i < m) {
                        if (charsQ[i++] <= 'Z') {
                            return false;
                        }
                    }
                    return true;
                }
                // 如果匹配字符串多了，就不行了
                if (i >= m) {
                    return false;
                }

                if (charsQ[i] == charsP[j]) {
                    i++;
                    j++;
                    continue;
                }

                // 查询字符串不能多出 大写字符
                while (i < m && charsQ[i] != charsP[j]) {
                    if (charsQ[i] < 'Z') {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}