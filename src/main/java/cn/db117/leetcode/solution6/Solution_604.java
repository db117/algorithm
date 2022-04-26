

//设计并实现一个迭代压缩字符串的数据结构。给定的压缩字符串的形式是，每个字母后面紧跟一个正整数，表示该字母在原始未压缩字符串中出现的次数。 
//
// 设计一个数据结构，它支持如下两种操作： next 和 hasNext。 
//
// 
// next() - 如果原始字符串中仍有未压缩字符，则返回下一个字符，否则返回空格。 
// hasNext() - 如果原始字符串中存在未压缩的的字母，则返回true，否则返回false。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", 
//"next", "hasNext"]
//[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
//输出：
//[null, "L", "e", "e", "t", "C", "o", true, "d", true]
//
//解释：
//StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
//stringIterator.next(); // 返回 "L"
//stringIterator.next(); // 返回 "e"
//stringIterator.next(); // 返回 "e"
//stringIterator.next(); // 返回 "t"
//stringIterator.next(); // 返回 "C"
//stringIterator.next(); // 返回 "o"
//stringIterator.hasNext(); // 返回 True
//stringIterator.next(); // 返回 "d"
//stringIterator.hasNext(); // 返回 True 
//
// 
//
// 提示： 
//
// 
// 1 <= compressedString.length <= 1000 
// compressedString 由小写字母、大写字母和数字组成。 
// 在 compressedString 中，单个字符的重复次数在 [1,10 ^9] 范围内。 
// next 和 hasNext 的操作数最多为 100 。 
// 
// Related Topics 设计 数组 哈希表 字符串 迭代器 👍 45 👎 0


package cn.db117.leetcode.solution6;

/**
 * 604.迭代压缩字符串.design-compressed-string-iterator
 *
 * @author db117
 * @since 2022-04-26 16:09:34
 **/

public class Solution_604 {
    public static void main(String[] args) {
        StringIterator solution = new Solution_604().new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(solution.next());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StringIterator {
        char[] chars;
        int[] count;

        int i;

        public StringIterator(String compressedString) {
            if (compressedString.length() == 0) {
                return;
            }
            char[] arr = compressedString.toCharArray();
            int n = 0;
            for (char c : arr) {
                if (c > '9') {
                    n++;
                }
            }

            chars = new char[n];
            count = new int[n];

            int index = -1;
            for (char c : arr) {
                if (c > '9') {
                    index++;
                    chars[index] = c;
                    continue;
                }

                count[index] *= 10;
                count[index] += c - '0';
            }
        }

        public char next() {
            if (i >= chars.length) {
                return ' ';
            }

            if (count[i] == 1) {
                char ans = chars[i];
                i++;
                return ans;
            }
            count[i]--;
            return chars[i];
        }

        public boolean hasNext() {
            if (i >= chars.length) {
                return false;
            }
            return count[i] > 0;
        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}