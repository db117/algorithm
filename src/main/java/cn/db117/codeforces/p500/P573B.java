package cn.db117.codeforces.p500;

import java.util.Scanner;

/**
 * 573B - Bear and Blocks
 * time limit per test1 second
 * memory limit per test256 megabytes
 * inputstandard input
 * outputstandard output
 * Limak is a little bear who loves to play. Today he is playing by destroying block towers. He built n towers in a row. The i-th tower is made of hi identical blocks. For clarification see picture for the first sample.
 * <p>
 * Limak will repeat the following operation till everything is destroyed.
 * <p>
 * Block is called internal if it has all four neighbors, i.e. it has each side (top, left, down and right) adjacent to other block or to the floor. Otherwise, block is boundary. In one operation Limak destroys all boundary blocks. His paws are very fast and he destroys all those blocks at the same time.
 * <p>
 * Limak is ready to start. You task is to count how many operations will it take him to destroy all towers.
 * <p>
 * Input
 * The first line contains single integer n (1 ≤ n ≤ 105).
 * <p>
 * The second line contains n space-separated integers h1, h2, ..., hn (1 ≤ hi ≤ 109) — sizes of towers.
 * <p>
 * Output
 * Print the number of operations needed to destroy all towers.
 * <p>
 * Examples
 * inputCopy
 * 6
 * 2 1 4 6 2 2
 * outputCopy
 * 3
 * inputCopy
 * 7
 * 3 3 3 1 3 3 3
 * outputCopy
 * 2
 * Note
 * The picture below shows all three operations for the first sample test. Each time boundary blocks are marked with red color.
 * <p>
 * After first operation there are four blocks left and only one remains after second operation. This last block is destroyed in third operation.
 *
 * @author db117
 * @since 2022/7/18 15:43
 **/
public class P573B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = scanner.nextInt();
        }

        // 第一波就没有了
        dp[0] = 1;
        dp[n - 1] = 1;
        // 不管比左边高多少,都是比左边多一次
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }
        // 不管比右边多多少,都是比右边多一次
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1] + 1, dp[i]);
        }

        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);
    }
}
