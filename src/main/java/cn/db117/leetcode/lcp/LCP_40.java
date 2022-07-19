


//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//>输入：`cards = [1,2,8,9], cnt = 3`
//>
//>输出：`18`
//>
//>解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//>输入：`cards = [3,3,1], cnt = 1`
//>
//>输出：`0`
//>
//>解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
//
// Related Topics 贪心 数组 排序 👍 33 👎 0


package cn.db117.leetcode.lcp;

import java.util.*;

/**
 * LCP 40.心算挑战.uOAnQW
 *
 * @author db117
 * @since 2022-07-19 15:15:58
 **/

public class LCP_40 {
    public static void main(String[] args) {
        Solution solution = new LCP_40().new Solution();
        // [2,7,8,11,12]
        //3
        // 30
//        System.out.println(solution.maxmiumScore(new int[]{2, 7, 8, 11, 12}, 3));

        // [2,2,2,2]
        //3
        // 6

        System.out.println(solution.maxmiumScore(new int[]{2, 2, 2, 2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            for (int card : cards) {
                if ((card & 1) == 0) {
                    even.add(card);
                } else {
                    odd.add(card);
                }
            }

            even.sort(Comparator.reverseOrder());
            odd.sort(Comparator.reverseOrder());

            // 前缀和
            int[] evenPreSum = new int[even.size()];
            int[] oddPreSum = new int[odd.size()];


            for (int i = 0; i < even.size(); i++) {
                evenPreSum[i] = even.get(i);
                if (i > 0) {
                    evenPreSum[i] += evenPreSum[i - 1];
                }
            }

            for (int i = 0; i < odd.size(); i++) {
                oddPreSum[i] = odd.get(i);
                if (i > 0) {
                    oddPreSum[i] += oddPreSum[i - 1];
                }
            }

            int ans = 0;
            // 枚举去奇数的个数
            for (int i = 0; i <= cnt; i++) {
                if (evenPreSum.length < cnt - i ||
                        oddPreSum.length < i) {
                    continue;
                }

                // 前缀和直接加
                int sum = 0;
                if (i > 0) {
                    sum += oddPreSum[i - 1];
                }
                if (cnt - i > 0) {
                    sum += evenPreSum[cnt - i - 1];
                }

                if ((sum & 1) == 0) {
                    ans = Math.max(ans, sum);
                }
            }
            // 没有找到
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}