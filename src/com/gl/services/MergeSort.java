package com.gl.services;



public class MergeSort {

    /* Approach one was the below function where I can add one more additional Parameter while calling
    performMergeSort Method,But to reduce the complexity I have created two different functions
    which can be called by the user in a simple way.

    This is just a thought - Please suggest which one is better.

        Input Details:
        double[] arr      --> Array to be Sorted
        int left          --> Left most position of Array
        int right         --> Right most position of Array
        boolean sortType  --> For Ascending Sort enter true and false for a descending sort

        public static void performMergeSort(double[] arr, int left, int right, boolean sortType){
            if (left < right) {
                int mid = (left+right)/2;
                performMergeSort(arr, left, mid, sortType);
                performMergeSort(arr, mid+1, right, sortType);
                mergeArray(arr, left, mid, right, sortType);
            }
        }
     */

    //Method for Descending Order Sort
    public static void descendingSort(double[] arr, int left, int right){
        if (left < right) {
            int mid = (left+right)/2;
            descendingSort(arr, left, mid);
            descendingSort(arr, mid+1, right);
            mergeArray(arr, left, mid, right, false);
        }
    }

    //Method for Ascending Order Sort
    public static void ascendingSort(double[] arr, int left, int right){
        if (left < right) {
            int mid = (left+right)/2;
            ascendingSort(arr, left, mid);
            ascendingSort(arr, mid+1, right);
            mergeArray(arr, left, mid, right, true);
        }
    }

    /* Input Details:
        boolean sortType --> For Ascending Sort enter true and false for a descending sort
    */
    public static void mergeArray(double[] arr, int left, int mid, int right, boolean sortType) {
        int len1 = mid-left+1;
        int len2 = right-mid;

        double[] leftArr = new double[len1];
        double[] rightArr = new double[len2];

        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left+i];
        }
        for (int j = 0; j < len2; j++) {
            rightArr[j] = arr[mid+1+j];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = left;

        while (i< len1 && j< len2){
            if ((sortType) ? leftArr[i] <= rightArr[j] : leftArr[i] >= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i< len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j< len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
