package backtracking;

import java.util.*;

public class K_night {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] ans = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) ans[i][j] = '.';
        }
        System.out.println("\n" + placeKnights(N,ans,0,0,"",N));
    }
    private static int placeKnights(int N,char[][] ans,int r,int c,String cur,int N_O_K) {
        if(r >= N || N_O_K < 0) return 0;
        if(N_O_K == 0) {
            System.out.print(cur + " ");
            return 1;
        }
        int s = 0;
        if(c >= N) s += placeKnights(N,ans,r + 1,0,cur,N_O_K);
        else {
            if(isSafe(ans,r,c)) {
            ans[r][c] = 'K';
            s += placeKnights(N, ans, r, c + 1, cur + "{" + r + "-" + c + "} ", N_O_K - 1);
            ans[r][c] = '.';
        }
        s += placeKnights(N,ans,r,c + 1,cur,N_O_K);
        }
        return s;
    }
    private static boolean isSafe(char[][] ans,int r,int c) {
        if(r >= 2 && c >= 1) {
            if(ans[r - 2][c - 1] == 'K') return false;
        }
        if(r >= 2 && c < ans.length - 1) {
            if(ans[r - 2][c + 1] == 'K') return false;
        }
        if(r >= 1 && c >= 2) {
            if(ans[r - 1][c - 2] == 'K') return false;
        }
        if(r >= 1 && c < ans.length - 2) {
            if(ans[r - 1][c + 2] == 'K') return false;
        }
        if(r < ans.length - 2 && c < ans.length - 1) {
            if(ans[r + 2][c + 1] == 'K') return false;
        }
        if(r < ans.length - 2 && c >= 1) {
            if(ans[r + 2][c - 1] == 'K') return false;
        }
        if(r < ans.length - 1 && c < ans.length - 2) {
            if(ans[r + 1][c + 2] == 'K') return false;
        }
        if(r < ans.length - 1 && c >= 2) {
            if(ans[r + 1][c - 2] == 'K') return false;
        }
        if(c >= 2 && r < ans.length - 1) {
            if(ans[r + 1][c - 2] == 'K') return false;
        }
        if(c >= 2 && r >= 1){
            if(ans[r - 1][c - 2] == 'K') return false;
        }
        if(c >= 1 && r >= 2) {
            if(ans[r - 2][c - 1] == 'K') return false;
        }
        if(c >= 1 && r < ans.length - 2) {
            if(ans[r + 2][c - 1] == 'K') return false;
        }
        if(c < ans.length - 2 && r >= 1) {
            if(ans[r - 1][c + 2] == 'K') return false;
        }
        if(c < ans.length - 2 && r < ans.length - 1) {
            if(ans[r + 1][c + 2] == 'K') return false;
        }
        if(c < ans.length - 1 && r >= 2) {
            if(ans[r - 2][c + 1] == 'K') return false;
        }
        if(c < ans.length - 1 && r < ans.length - 2) {
            return ans[r + 2][c + 1] != 'K';
        }
        return true;
    }
}
