package backtracking;
import java.util.*;
public class permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();
//        List<String> list = new ArrayList<>();
        boolean[] vis = new boolean[26];
        printPerm(str,"");
//        for(var i: list) System.out.println(i);
    }
    private static void printPerm(String que,String cur) {
        if(cur.length() == que.length()) {
            System.out.println(cur);
            return;
        }
        boolean[] vis = new boolean[26];
        for(int i = 0; i < que.length(); i++) {
            if(!vis[que.charAt(i) - 'a']) {
                vis[que.charAt(i) - 'a'] = true;
                printPerm(que.substring(0,i) + que.substring(i + 1), cur + que.charAt(i));
            }
        }
    }
    private static void printPerm(char[] que,int index) {
        if(index == que.length) {
            for(var i: que) System.out.print(i);
            System.out.println();
            return;
        }
        for(int i = index; i < que.length; i++) {
            swap(i, index, que);
            printPerm(que, index + 1);
            swap(i, index, que);
        }
    }
    private static void swap(int i,int j,char[] que) {
        char temp = que[i];
        que[i] = que[j];
        que[j] = temp;
    }
}
