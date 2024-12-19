package cn.db117.template.string;

import java.util.Random;

/**
 * 字符串哈希
 */
public class StringHash {
    private static final int MOD = 1_070_777_777;

    public void hash(String target) {

        char[] t = target.toCharArray();
        int n = t.length;

        // 多项式字符串哈希（方便计算子串哈希值）
        // 哈希函数 hash(s) = s[0] * base^(n-1) + s[1] * base^(n-2) + ... + s[n-2] * base + s[n-1]
        final int BASE = (int) 8e8 + new Random().nextInt((int) 1e8); // 随机 base，防止 hack
        int[] powBase = new int[n + 1]; // powBase[i] = base^i
        int[] preHash = new int[n + 1]; // 前缀哈希值 preHash[i] = hash(target[0] 到 target[i-1])
        powBase[0] = 1;
        for (int i = 0; i < n; i++) {
            powBase[i + 1] = (int) ((long) powBase[i] * BASE % MOD);
            preHash[i + 1] = (int) (((long) preHash[i] * BASE + t[i]) % MOD); // 秦九韶算法计算多项式哈希
        }

    }

    // 区间 hash 值
    private int subHash(int l, int r, int[] powBase, int[] preHash) {
        return (int) ((((long) preHash[r] - (long) preHash[l] * powBase[r - l]) % MOD + MOD) % MOD);
    }

}
