package backtracking;

import java.util.Scanner;

public class N_Queens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] ans = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) ans[i][j] = '.';
        }
        System.out.println("\n" + placeQueens(N,ans,0,""));
    }
    private static int placeQueens(int N,char[][] ans,int r,String cur) {
        if(r == N) {
            System.out.print(cur + " ");
            return 1;
        }
        int s = 0;
        for(int j = 0; j < N; j++) {
            if(isSafe(ans,r,j)) {
                ans[r][j] = 'Q';
               s += placeQueens(N, ans, r + 1,cur + "{" + (r + 1) + "-" + (j + 1) +"}" + " ");
                ans[r][j] = '.';
            }
        }
        return s;
    }
    private static boolean isSafe(char[][] ans,int r,int c) {
        //Check in left
        for(int i = c; i >= 0; i--) {
            if(ans[r][i] == 'Q') return false;
        }
        //Check in right
        for(int i = c; i < ans.length; i++) {
            if(ans[r][i] == 'Q') return false;
        }
        //Check down
        for(int i = r; i < ans.length; i++) {
            if(ans[i][c] == 'Q') return false;
        }
        //Check Up
        for(int i = r; i >= 0; i--) {
            if(ans[i][c] == 'Q') return false;
        }
        //Check up-left
        for(int i = r,j = c; i >= 0 && j >= 0; i--,j--) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check up-right
        for(int i = r,j = c; i >= 0 && j < ans.length; i--,j++) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check bottom-left
        for(int i = r,j = c; i < ans.length && j >= 0; i++,j--) {
            if(ans[i][j] == 'Q') return false;
        }
        //Check bottom-right
        for(int i = r,j = c; i < ans.length && j < ans.length; i++,j++) {
            if(ans[i][j] == 'Q') return false;
        }
        return true;
    }
}
