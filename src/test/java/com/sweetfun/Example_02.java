package com.sweetfun;
public class Example_02 {
    public static void main(String[] args) {

    }
    private static void max(int[][] nums, int length) {
        for (int i = 1; i <= length; i++) {
            if (i == 1) {
                System.out.println(0);
                continue;
            }
            int middle = (int) Math.floor(length / i);
            for (int j = 0; j < length; j++) {
                int sum1 = 0;
                int sum0 = 0;
                if (j + middle > length) {
                    continue;
                }

                for (int k = 0; k < middle; k++) {

                }
            }
        }
    }
}
