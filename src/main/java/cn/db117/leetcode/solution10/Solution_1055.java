

//对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的 子序列 。(例如，“ace” 是 “abcde” 的子序列，而 “aec” 不
//是)。 
//
// 给定源字符串 source 和目标字符串 target，返回 源字符串 source 中能通过串联形成目标字符串 target 的 子序列 的最小数量 。
//如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：source = "abc", target = "abcbc"
//输出：2
//解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
// 
//
// 示例 2： 
//
// 
//输入：source = "abc", target = "acdbc"
//输出：-1
//解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
// 
//
// 示例 3： 
//
// 
//输入：source = "xyz", target = "xzyxz"
//输出：3
//解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= source.length, target.length <= 1000 
// source 和 target 仅包含英文小写字母。 
// 
//
// Related Topics 贪心 双指针 字符串 👍 97 👎 0


package cn.db117.leetcode.solution10;

import java.util.ArrayList;
import java.util.List;

/**
 * 1055.形成字符串的最短路径.shortest-way-to-form-string
 *
 * @author db117
 * @since 2023-04-13 10:53:48
 **/

public class Solution_1055 {
    public static void main(String[] args) {
        Solution solution = new Solution_1055().new Solution();
        // source =
        //"xyz"
        //target =
        //"xzyxz"
        System.out.println(solution.shortestWay("xyz", "xzyxz"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestWay(String source, String target) {
            // 统计出每个字符串出现的次数
            List<Integer>[] count = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                count[i] = new ArrayList<>();
            }
            for (int i = 0; i < source.length(); i++) {
                int index = source.charAt(i) - 'a';
                count[index].add(i);
            }

            // 每次二分查找
            int ans = 1;
            int pre = -1;
            for (char c : target.toCharArray()) {
                List<Integer> list = count[c - 'a'];
                if (list.size() == 0) {
                    // 不可能是前面的子序列
                    return -1;
                }
                // 找到下一个相同的字符的位置
                pre = bs(list, pre);
                if (pre == -1) {
                    // 需要从头开始找了
                    pre = bs(list, pre);
                    ans++;
                }
            }

            return ans;
        }

        // 找大于等于 target 的最小值
        public int bs(List<Integer> arr, int target) {
            if (target == -1) {
                return arr.get(0);
            }
            if (arr.get(arr.size() - 1) <= target) {
                return -1;
            }

            int left = 0;
            int right = arr.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr.get(mid) <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return arr.get(right) > target ? arr.get(right) : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}