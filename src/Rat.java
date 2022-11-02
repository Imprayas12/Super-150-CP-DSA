import java.util.Scanner;

public class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for(int i = 0; i < n; i++) {
            String temp = sc.next();
            grid[i] = temp.toCharArray();
        }
        int[] X = {-1,1,0,0};
        int[] Y = {0,0,1,-1};
        int[][] ans = new int[n][m];
        ans[0][0] = 0;
        helper(grid,ans,0,0,X,Y);
    }
    private static boolean helper(char[][] grid,int[][] ans,int x,int y,int[] X,int[] Y) {
        if(x == grid.length - 1&& y == grid[0].length - 1) {
            ans[x][y] = 0;
            for (int[] an : ans) {
                for (int j = 0; j < ans[0].length; j++) {
                    System.out.print(an[j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if(x < 0 || y < 0 || x == grid.length|| y == grid[0].length || grid[x][y] == 'X') return false;
        ans[x][y] = 1;
        grid[x][y] = 'X';
        for(int i = 0; i < X.length; i++) {
            if(helper(grid,ans,x + X[i],y + Y[i],X,Y)) return true;
        }
        grid[x][y] = 'O';
        ans[x][y] = 0;
        return false;
    }
}
