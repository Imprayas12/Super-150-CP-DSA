 package Lecture1;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        long s = System.currentTimeMillis();
        int[] nums = {3,-1,4,7,11,9,12};
//        System.out.println(Arrays.binarySearch(nums,13));
        search(nums,1,3);
        System.out.println(Arrays.toString(nums));
        System.out.println("Runtime:" + (System.currentTimeMillis() - s) + " ms");
    }
    private static void search(int[] nums,int i, int j){

        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
