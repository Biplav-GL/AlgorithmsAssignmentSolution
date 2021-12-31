package com.gl.services;

public class BinarySearch {
    public static int performBinarySearch(double[] arr, int first, int last, double key) {
        int mid = ( first + last ) /2;
        while(first <= last){
            if (arr[mid] < key){
                first = mid+1;
            }
            else if(arr[mid] == key){
                return mid;
            }
            else {
                last = mid-1;
            }
            mid = ( first + last )/2;
        }
        return -1;
    }
}
