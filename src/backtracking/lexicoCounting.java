package backtracking;

import java.util.*;

public class lexicoCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> ans = new ArrayList<Integer>();
        counting(10,ans);
    }
    private static void counting(int num,List<Integer> ans) {
        if(num > 1000)
            return;
        ans.add(num);
        if(num == 0)
            for(int i = 1; i < 10; i++) {
                counting(i,ans);
            } else {
            for (int i = 0; i < 10; i++) {
                counting(num * 10 + i, ans);
            }
        }
    }
}
