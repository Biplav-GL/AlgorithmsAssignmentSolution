package com.gl.services;

public class GetDuplicates {

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
