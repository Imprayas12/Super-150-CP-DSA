package backtracking;
import java.util.*;

public class RowQueen {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        countCoins(10,new int[]{2,3,5,7},"");
        System.out.println("Runtime = " +(System.currentTimeMillis() - start) +"ms");
    }
    private static void recur(boolean[] board,int queens,int queen_placed_so_far,String ans) {
        if(queen_placed_so_far == queens) {
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < board.length; i++) {
            if(!board[i]){
                board[i] = true;
                recur(board, queens, queen_placed_so_far + 1, ans + " b" + i + "q" + queen_placed_so_far);
                board[i] = false;
            }
        }
    }
    private static void recur2(String[] board,String ans,int ind,int queen) {
        if(queen == 3) {
            System.out.println(ans);
            return;
        }
        if(ind == board.length) return;
        if(ans.length() == 0)
        recur2(board,ans + board[ind] + "q" + queen,ind + 1,queen + 1);
        else recur2(board,ans + board[ind] + "q" + queen,ind + 1,queen + 1);
        recur2(board,ans,ind + 1,queen);
    }
    private static void countCoins(int amount,int[] coins,String ans) {
        if(amount == 0) {
            System.out.println(ans);
            return;
        }
        for (int coin : coins) {
            if (coin <= amount) {
                countCoins(amount - coin, coins, ans + coin);
            }
        }
    }
}
