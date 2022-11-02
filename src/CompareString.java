public class CompareString {
    public static void main(String[] args) {
        genSubs("Akansha");
//        System.out.println("Kartik".compareTo("Karan"));
    }
    private static int compareTo(String s1, String s2) {
        int l1 = 0;
        int l2 = 0;
            while(l1 < s1.length() && l2 < s2.length()){
                if(s1.charAt(l1) != s2.charAt(l2)) return s1.charAt(l1) - s2.charAt(l2);
                l1++;
                l2++;
            }
            return s1.length() - s2.length();
    }
    private static void genSubs(String s1) {
        int len = 1;
        int idx = 0;
        while(idx < s1.length()) {
            int i = 0;
            while (i < s1.length() && i + len <= s1.length()) {
                System.out.print(s1.substring(i, i + len) + " ");
                i++;
            }
            System.out.println();
            len++;
            idx++;
        }
//        System.out.println(s1);
    }
}
