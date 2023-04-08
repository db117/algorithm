

//请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。 
//
//
// 1 号机（发送方）有如下函数： 
//
// string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//} 
//
// 2 号机（接收方）有如下函数： 
//
// vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
// 
//
// 1 号机（发送方）执行： 
//
// string encoded_string = encode(strs);
// 
//
// 2 号机（接收方）执行： 
//
// vector<string> strs2 = decode(encoded_string);
// 
//
// 此时，2 号机（接收方）的 strs2 需要和 1 号机（发送方）的 strs 相同。 
//
// 请你来实现这个 encode 和 decode 方法。 
//
// 注意： 
//
// 
// 因为字符串可能会包含 256 个合法 ascii 字符中的任何字符，所以您的算法必须要能够处理任何可能会出现的字符。 
// 请勿使用 “类成员”、“全局变量” 或 “静态变量” 来存储这些状态，您的编码和解码算法应该是非状态依赖的。 
// 请不要依赖任何方法库，例如 eval 又或者是 serialize 之类的方法。本题的宗旨是需要您自己实现 “编码” 和 “解码” 算法。 
// 
//
// Related Topics 设计 数组 字符串 👍 95 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 271.字符串的编码与解码.encode-and-decode-strings
 *
 * @author db117
 * @since 2023-04-07 13:51:53
 **/

public class Solution_271 {
    public static void main(String[] args) {
        // ["Hello","World"]
        Codec codec = new Codec();
        String encode = codec.encode(Arrays.asList("Hello", "World"));
        System.out.println(codec.decode(encode));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public static class Codec {
        private char spilt = (char) 10086;

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder ans = new StringBuilder();
            for (String str : strs) {
                ans.append(str).append(spilt);
            }
            return ans.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int left = 0, right = 0;
            List<String> ans = new ArrayList<>();
            while (right < n) {
                while (chars[right] != spilt) {
                    right++;
                }
                ans.add(s.substring(left, right));

                right++;
                left = right;
            }
            return ans;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)

}