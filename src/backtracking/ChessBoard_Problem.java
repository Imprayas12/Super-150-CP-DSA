package backtracking;
import java.util.*;

public class ChessBoard_Problem {
    public static void main(String[] args) {
        // Your Code Here
        int n = new Scanner(System.in).nextInt();
        List<String> ans = new ArrayList<>();
        countPaths(ans,0,0,n - 1,"");
        for (var i: ans) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + ans.size());
    }
    private static void countPaths(List<String> ans,int row, int col, int dimension,String currentPath) {
        if(row > dimension || col > dimension) return;
        if (row == dimension && col == dimension) {
            ans.add(currentPath + "{" + dimension + "-" + dimension + "}");
            return;
        }
        if(row <= dimension - 2 && col <= dimension - 1) countPaths(ans,row + 2, col + 1,dimension, currentPath + "{" + row + "-" + col + "}K");
        if(row <= dimension - 1 && col <= dimension - 2) countPaths(ans,row + 1, col + 2,dimension, currentPath + "{" + row + "-" + col + "}K");
        if(row == 0 || row == dimension || col == 0 || col == dimension) {
            for (int i = 1; i + col <= dimension; i++) {
                countPaths(ans, row, col + i, dimension, currentPath + "{" + row + "-" + col + "}R");
            }
            for (int i = 1; i + row <= dimension; i++) {
                countPaths(ans, row + i, col, dimension, currentPath + "{" + row + "-" + col + "}R");
            }
        }
        if((row == 0 && col == 0) || (row > 0 && col > 0))
        for(int i = 1; i + row <= dimension && i + col <= dimension; i++) countPaths(ans,row + i,col + i,dimension,currentPath + "{" + row + "-" + col + "}B");
    }
}
