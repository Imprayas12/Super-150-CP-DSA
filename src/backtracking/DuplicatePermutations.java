package backtracking;

public class DuplicatePermutations {
    public static void main(String[] args) {
        String query = "abcdba";
        printPermutations(query,"");
    }
    private static void printPermutations(String query, String ans) {
        if(query.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < query.length(); i++) {
            boolean flag = true;
            char curChar = query.charAt(i);
            for(int j = i + 1; j < query.length(); j++) {
                if(query.charAt(j) == curChar) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                printPermutations(query.substring(0,i) + query.substring(i+1),ans + curChar);
            }
        }
    }
}
