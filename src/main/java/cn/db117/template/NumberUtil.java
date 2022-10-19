package cn.db117.template;

/**
 * 数字操作
 *
 * @author db117
 * @since 2022/10/18 16:24
 **/
public class NumberUtil {
    /**
     * 翻转数字
     * 需要大于 0
     */
    public long reverse(long n) {
        long ans = 0;
        while (n > 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }
}
