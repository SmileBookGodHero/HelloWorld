package com.company.algorithm.mt;

/**
 * @author lilei
 * @date 2021-10-07 下午11:02
 * @apiNote
 */

public class MT01 {
    public static void main(String[] args) {
        int[] A = {10, 5};
        int n = 2;
        System.out.println(getDis(A, n));
    }

    public static int getDis(int[] A, int n) {
        // write code here
        if (A == null || n == 0) {
            return 0;
        }
        int res = 0;
        int[] min = new int[n];
        min[0] = A[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], A[i]);
        }
        int[] max = new int[n];
        max[n - 1] = A[n - 1];
        for (int i = n - 2; i > 0; i--) {
            max[i] = Math.max(max[i + 1], A[i]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(max[i] - min[i], res);
        }
        return res;
    }
}