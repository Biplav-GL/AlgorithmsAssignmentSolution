package com.gl.services;

public class BinarySearch {
    public static boolean performBinarySearch(double[] arr, int first, int last, double key) {
        int mid = ( first + last ) /2;
        while(first <= last){
            if (arr[mid] < key){
                first = mid+1;
            }
            else if(arr[mid] == key){
                return true;
            }
            else {
                last = mid-1;
            }
            mid = ( first + last )/2;
        }
        if(first > last){
            return false;
        }
        return true;
    }
}
