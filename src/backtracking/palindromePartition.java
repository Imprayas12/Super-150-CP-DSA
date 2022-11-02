package backtracking;
import java.util.*;

public class palindromePartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> ans = new HashSet<>();
        Set<List<String>> s = new HashSet<>();
        genWays("AAB",0,"",ans,new HashSet<>(),s);
        System.out.println(ans);

    }
    private static void partition(int index, List<List<String>> ans, String s, List<String> current) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)) {
                current.add(s.substring(index,i + 1));
                partition(i + 1,ans,s,current);
                current.remove(current.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s,int i,int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private static void genWays(String ques,int index,String ans,Set<String> cur,Set<Integer> vis,Set<List<String>> s) {
        if(index == ques.length()) {
            return;
        }
        for(int i = 0; i < ques.length(); i++) {
            if(!vis.contains(i)) {
                vis.add(i);
                cur.add(ans + ques.charAt(i));
                genWays(ques,index + 1,ans + ques.charAt(i),cur,vis,s);
                vis.remove(i);
            }
        }
    }
}
