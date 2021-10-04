package com.company.algorithm.nc;

public class NC156_1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 1, 5, 1, 5};
        int k = 3;
        System.out.println(foundOnceNumber(arr, k));
    }

    public static int foundOnceNumber(int[] arr, int k) {
        int[] binarySum = new int[32];
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : arr) {
                sum += (num >> i & 1);
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binarySum[i] % k != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
