

//给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中： 
//
// 
// 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 
//时才能向 右 移动。 
// 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。 
// 
//
// 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：start = "_L__R__R_", target = "L______RR"
//输出：true
//解释：可以从字符串 start 获得 target ，需要进行下面的移动：
//- 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
//- 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
//- 将第二个片段向右移动散步，字符串现在变为 "L______RR" 。
//可以从字符串 start 得到 target ，所以返回 true 。
// 
//
// 示例 2： 
//
// 输入：start = "R_L_", target = "__LR"
//输出：false
//解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
//但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
// 
//
// 示例 3： 
//
// 输入：start = "_R", target = "R_"
//输出：false
//解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。 
//
// 
//
// 提示： 
//
// 
// n == start.length == target.length 
// 1 <= n <= 10⁵ 
// start 和 target 由字符 'L'、'R' 和 '_' 组成 
// 
// 👍 17 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2337.移动片段得到字符串.move-pieces-to-obtain-a-string
 *
 * @author db117
 * @since 2022-07-12 18:43:09
 **/

public class Solution_2337 {
    public static void main(String[] args) {
        Solution solution = new Solution_2337().new Solution();

        // "_L__R__R_L"
        //"L______RR_"
        System.out.println(solution.canChange("_L__R__R_L", "L______RR_"));
        // "_L"
        //"LL"
        System.out.println(solution.canChange("_L", "LL"));
        System.out.println(solution.canChange("__", "__"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
                return false;
            }
            char[] sc = start.toCharArray();
            char[] tc = target.toCharArray();
            int len = sc.length;
            int i = 0, j = 0;
            while (i < len && j < len) {
                while (i < len && sc[i] == '_') {
                    i++;
                }
                while (j < len && tc[j] == '_') {
                    j++;
                }
                if (i == len) {
                    return true;
                }

                if (sc[i] != tc[j]) {
                    // 有不一样的
                    return false;
                }

                // L 只能往左边走
                if (tc[j] == 'L' && i < j) {
                    return false;
                }
                // R 只能往右边走
                if (tc[j] == 'R' && i > j) {
                    return false;
                }

                i++;
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}