package arrays;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,11};
        int[] arr2 = {2,4,6,8,10,12};
        int[] arr3 = mergeSort(arr1,arr2);
        for(var i: arr3) System.out.print(i + " ");
    }
    private static int[] mergeSort(int[] arr1,int[] arr2) {
        int i = 0,j = 0,k = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            }
            else {
                arr3[k++] = arr2[j++];
            }
        }
        while(i < arr1.length) arr3[k++] = arr1[i++];
        while(j < arr2.length) arr3[k++] = arr2[j++];
        return arr3;
    }
    private static int quickSort(int[] arr1) {
        int idx = 0;
        return idx;
    }
}
