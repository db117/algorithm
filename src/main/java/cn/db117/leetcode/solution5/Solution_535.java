//TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时
//，它将返回一个简化的URL http://tinyurl.com/4e9iAk. 
//
// 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可
//以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。 
// Related Topics 设计 哈希表 字符串 哈希函数 
// 👍 120 👎 0


package cn.db117.leetcode.solution5;

import java.util.HashMap;
import java.util.Map;

/**
 * 535.TinyURL 的加密与解密.encode-and-decode-tinyurl
 *
 * @author db117
 * @since 2021-07-01 10:35:42
 **/

public class Solution_535 {
    public static void main(String[] args) {
        Codec solution = new Solution_535().new Codec();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {
        String pre = "http://tinyurl.com/";
        Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String s = pre + Integer.toHexString(longUrl.hashCode());
            map.put(s, longUrl);
            return s;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

}