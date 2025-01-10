package com.test;

public class Test10 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
//        printArray(arr);
        int max = getMax(arr);
        System.out.println(max);
        int[] copy = copyArray(arr,3,7);
        printArray(copy);
    }
    public static int[] copyArray(int[] arr,int from,int to){
        int[] copy = new int[to-from];
        int index = 0;
        for (int i = from; i < to; i++) {
            copy[index] = arr[i];
            index++;
        }

        return copy;

    }
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i]+",");
            }

        }
        System.out.println("]");

    }
}
