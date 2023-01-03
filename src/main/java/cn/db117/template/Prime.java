package cn.db117.template;

/**
 * 质数
 *
 * @author zhangdb3
 * @date 2023/01/03
 */
public class Prime {

    private final static int mix = (int) 1e6;
    private final static int[] primes = new int[78500];

    // 埃氏筛
    static {
        // 标记是否是质数
        boolean[] flag = new boolean[mix + 1];
        int pi = 0;
        for (int i = 2; i <= mix; ++i)
            if (!flag[i]) {
                primes[pi++] = i;
                // 避免溢出的写法
                for (int j = i; j <= mix / i; ++j) {
                    flag[i * j] = true;
                }
            }
        primes[pi++] = mix + 1;
        primes[pi++] = mix + 1; // 保证下面下标不会越界
    }

    // 线性筛（欧拉筛）
    static {
        // 标记是否是质数
        boolean[] np = new boolean[mix + 1];
        int pi = 0;
        for (int i = 2; i <= mix; ++i) {
            if (!np[i]) {
                // 走到这还没有标记为合数,这为质数
                primes[pi++] = i;
            }
            // 乘以比当前小的质数
            for (int j = 0; j < pi; ++j) {
                int p = primes[j];
                if (i * p > mix) {
                    break;
                }
                // 标记为质数
                np[i * p] = true;
                // 如果当前质数是当前数字的约数则后面的数字会重复
                if (i % p == 0) {
                    break;
                }
            }
        }
        primes[pi++] = mix + 1;
        primes[pi++] = mix + 1;
    }

}
