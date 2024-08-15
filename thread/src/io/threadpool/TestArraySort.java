package io.threadpool;

import java.util.Arrays;

public class TestArraySort {

    public static void main(String[] args) {

        String str = "a good   example";
        System.out.println("Given an input string:" + str);
        //Write code to reverse the order of the words
        String result=TestArraySort.reverseWords(str);
        System.out.println("Revered words: " + result.trim());
    }
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        String ans ="";
        for(int i=words.length-1; i>=0; i--)
        {
            if (words[i] != " "){
                System.out.println(words[i]);
                ans+=words[i]+ " ";
            }
        }

        String retVal = "";
        String [] arr = str.trim().split(" ");
        for(int i = arr.length-1;i >= 0; i--) {
            if(arr[i] == "") retVal += " ";
            else retVal += arr[i] + " ";

        }

        System.out.println("=========>" + retVal);

        return ans;
    }


    public static void main1(String[] args) {


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
        System.out.println("---" + Arrays.toString(arr));
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
