// 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 515 👎 0


package cn.db117.leetcode.solution7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 763.划分字母区间.partition-labels
 *
 * @author db117
 * @since 2021-06-08 16:30:58
 **/

public class Solution_763 {
    public static void main(String[] args) {
        Solution solution = new Solution_763().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>(26);
            // 统计每一个字母的最大位置
            int[] max = new int[26];
            char[] chars = s.toCharArray();
            Arrays.fill(max, -1);

            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                max[index] = Math.max(i, max[index]);
            }

            // 滑动窗口
            int left = 0;
            // 当前区间需要右边最大位置
            int curMax = max[chars[0] - 'a'];

            for (int right = 0; right < chars.length; right++) {
                if (right < curMax) {
                    // 更新最大右边界
                    curMax = Math.max(max[chars[right] - 'a'], curMax);
                    continue;
                }
                if (right == curMax) {
                    // 开始新的区间
                    ans.add(right - left + 1);
                    left = right + 1;

                    if (left == chars.length) {
                        // 走完了
                        break;
                    }
                    curMax = max[chars[left] - 'a'];
                }
            }

            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}