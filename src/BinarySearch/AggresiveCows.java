package BinarySearch;

import java.util.*;

import java.util.*;
public class AggresiveCows {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println(maximizeMinimumPages(arr,n,c,sum));
        }
    }
    private static int maximizeMinimumPages(int[] arr,int n,int c,int sum){
        int low = 0;
        int high = sum;
        int ans = 0;
        while(low <= high) {
            int mid = (low + high)/2;
            if(isPossible(mid,arr,c)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    private static boolean isPossible(int mid,int[] arr,int students) {
        int i = 0;
        int stu = 1;
        int pos = 0;
        while(i < arr.length) {
            if((arr[i] + pos) <= mid){
                pos = pos + arr[i];
                i++;
            }
            else {
                stu++;
                pos = 0;
            }
            if(stu > students)
                return false;
        }
        return true;
    }
}
