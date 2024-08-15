package io.threadpool;

import java.util.Arrays;

public class TestArraySort {
    public static void main(String[] args) {
        int [] arr = {100, 200, 300, 900, 700, 600};

        //Bubble Sort
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Final :: " + Arrays.toString(arr));

        int []array = new int[]{100, 200, 300, 900, 700, 600};
        //Insertion Sort
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;

            while (j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
                System.out.println(Arrays.toString(arr));
            }
        }

        System.out.println("Final :: " + Arrays.toString(arr));
    }
}
