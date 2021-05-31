// UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
//
// 
// 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。 
// 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位
//，全部为这个符号的 unicode 码。 
// 
//
// 这是 UTF-8 编码的工作方式： 
//
// 
//   Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// 
//
// 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。 
//
// 注意： 
//输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。 
//
// 示例 1： 
//
// 
//data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
//
//返回 true 。
//这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
// 
//
// 示例 2： 
//
// 
//data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
//
//返回 false 。
//前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
//下一个字节是开头为 10 的延续字节，这是正确的。
//但第二个延续字节不以 10 开头，所以是不符合规则的。
// 
// Related Topics 位运算 
// 👍 64 👎 0


package cn.db117.leetcode.solution3;

/**
 * 393.UTF-8 编码验证.utf-8-validation
 *
 * @author db117
 * @since 2021-05-31 14:56:55
 **/

public class Solution_393 {
    public static void main(String[] args) {
        Solution solution = new Solution_393().new Solution();
        System.out.println(Integer.toBinaryString(250));
        System.out.println(solution.validUtf8(new int[]{
                0b11100111, 0b10000111, 0b10000111, 0b11000111, 0b10000111
        }));
        System.out.println(solution.validUtf8(new int[]{
                250, 145, 145, 145, 145
        }));
        // 250,145,145,145,145  false

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validUtf8(int[] data) {
            int n = 0;/* 后面还有几个字符 */
            for (int num : data) {
                if (n > 0) {
                    if (num >> 6 != 0b10) {
                        // 剩余字符必须10开头
                        return false;
                    }
                    n--;
                } else if (num >> 7 == 0) {
                    n = 0;
                } else if (num >> 5 == 0b110) {
                    n = 1;
                } else if (num >> 4 == 0b1110) {
                    n = 2;
                } else if (num >> 3 == 0b11110) {
                    n = 3;
                } else {
                    // utf-8最多4个字符
                    return false;
                }
            }

            return true;
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public boolean validUtf8(int[] data) {

            int next = 0;
            for (int i : data) {
                int leftOne = countLeftOne(i);
                if (leftOne > 4) {
                    // utf-8 最多4个字符
                    return false;
                }
                // 剩余的数字应该是1个1
                if (next != 0 && leftOne != 1) {
                    return false;
                }

                if (next == 0) {
                    if (leftOne == 1) {
                        // 前面不能为10
                        return false;
                    }
                    if (leftOne > 1) {
                        // 开始一个新的utf-8
                        next = leftOne - 1;
                    }
                    continue;
                }

                next--;
            }

            return next == 0;
        }

        // 左边连续1的数量
        public int countLeftOne(int n) {
            int ans = 0;
            for (int i = 7; i > 0; i--) {
                if ((n & (1 << i)) > 0) {
                    ans++;
                } else {
                    break;
                }
            }

            return ans;
        }
    }
}