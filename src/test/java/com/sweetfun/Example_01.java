package com.sweetfun;

import java.util.Arrays;

public class Example_01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sort(nums);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
