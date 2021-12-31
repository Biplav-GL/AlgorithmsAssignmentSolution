package com.gl.services;

public class GetDuplicates {

    //Method to get the count of duplicates key present in an array and return the count
    public static int findDuplicatesInArray(boolean[] arr, boolean key){
        int count= 0;
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                count++;
            }
        }
        return count;
    }
}
