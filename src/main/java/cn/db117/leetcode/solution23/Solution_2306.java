

//给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下： 
//
// 
// 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。 
// 交换 ideaA 和 ideaB 的首字母。 
// 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字
//。 
// 否则，不是一个有效的名字。 
// 
//
// 返回 不同 且有效的公司名字的数目。 
//
// 
//
// 示例 1： 
//
// 输入：ideas = ["coffee","donuts","time","toffee"]
//输出：6
//解释：下面列出一些有效的选择方案：
//- ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
//- ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
//- ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
//- ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
//- ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
//- ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
//因此，总共有 6 个不同的公司名字。
//
//下面列出一些无效的选择方案：
//- ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
//- ("time", "toffee")：在原数组中存在交换后形成的两个名字。
//- ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
// 
//
// 示例 2： 
//
// 输入：ideas = ["lack","back"]
//输出：0
//解释：不存在有效的选择方案。因此，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= ideas.length <= 5 * 10⁴ 
// 1 <= ideas[i].length <= 10 
// ideas[i] 由小写英文字母组成 
// ideas 中的所有字符串 互不相同 
// 
//
// Related Topics 位运算 数组 哈希表 字符串 枚举 👍 93 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2306.公司命名.naming-a-company
 *
 * @author db117
 * @since 2024-09-26 11:27:00
 **/

public class Solution_2306 {
    public static void main(String[] args) {
        Solution solution = new Solution_2306().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long distinctNames(String[] ideas) {
            long ans = 0;
            Set<String>[] sets = new HashSet[26];
            Arrays.setAll(sets, i -> new HashSet<>());
            for (String idea : ideas) {
                sets[idea.charAt(0) - 'a'].add(idea.substring(1));
            }

            for (int a = 0; a < 26; a++) {
                for (int b = 0; b < a; b++) {
                    // 交集
                    int m = 0;
                    for (String s : sets[a]) {
                        if (sets[b].contains(s)) {
                            m++;
                        }
                    }

                    // 不同首字母，不同的后缀的可以组成一个公司名字
                    ans += (long) (sets[a].size() - m) * (sets[b].size() - m);
                }
            }
            // 可以反过来
            return ans * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}