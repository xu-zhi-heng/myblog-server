package com.sweetfun;

public class Example_03 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5,7,7,8,8,10,11,11};
        int num = 10;
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] <= num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            if (arr[middle] == num) {
                index = middle;
            }
        }
        System.out.println(index);
    }
}
