

//RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。 
//
// 
// 例如，"#15c" 其实是 "#1155cc" 的简写。 
// 
//
// 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - 
//WX)^2 - (EF - YZ)^2 来计算。 
//
// 那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可
//以表示成类似 "#XYZ" 的形式） 
//
// 任何 具有相同的（最大）相似度的答案都会被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：color = "#09f166"
//输出："#11ee66"
//解释： 
//因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -7
//3
//这已经是所有可以简写的颜色中最相似的了
// 
//
// 示例 2： 
//
// 
//输入：color = "#4e3fe1"
//输出："#5544dd"
// 
//
// 
//
// 提示： 
//
// 
// color.length == 7 
// color[0] == '#' 
// 对于任何 i > 0，color[i] 都是一个在范围 ['0', 'f'] 内的 16 进制数 
// 
// Related Topics 数学 字符串 枚举 👍 14 👎 0


package cn.db117.leetcode.solution8;

/**
 * 800.相似 RGB 颜色.similar-rgb-color
 *
 * @author db117
 * @since 2022-04-26 18:49:29
 **/

public class Solution_800 {
    public static void main(String[] args) {
        Solution solution = new Solution_800().new Solution();
        int n = 0x1f;
        System.out.println(Integer.toHexString(n));
        System.out.println(n);
        n++;
        System.out.println(n);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr = new int[]{0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff};

        public String similarRGB(String color) {

            return "#" + helper(color.substring(1, 3)) + helper(color.substring(3, 5)) + helper(color.substring(5, 7));
        }

        private String helper(String s) {
            int n = Integer.parseInt(s, 16);

            int min = Integer.MAX_VALUE;
            int ans = 0;
            for (int i : arr) {
                int diff = Math.abs(i - n);
                if (diff < min) {
                    min = diff;
                    ans = i;
                }
            }
            String s1 = Integer.toHexString(ans);
            if (s1.length() == 1) {
                s1 = "0" + s1;
            }
            return s1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}