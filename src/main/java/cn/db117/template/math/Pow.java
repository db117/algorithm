package cn.db117.template.math;

/**
 * 快速幂
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(new Pow().quickPow(2, 22));
    }

    int MOD = (int) (1e9 + 7);

    public long quickPow(long x, long n) {
        x %= MOD;
        long res = 1L;
        while (n > 0) {
            if ((n & 1) != 0) {
                // 如果为奇数
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }


    public long quickPow1(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long ret = quickPow1(x, y >> 1);
        return y % 2 == 0 ? ret * ret : ret * ret * x;
    }


}
