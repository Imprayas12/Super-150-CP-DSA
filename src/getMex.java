import java.util.*;
public class getMex {
    public static void main(String[] args) {
        int x = 3;
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < 5; i++) values.add(sc.nextInt());
        System.out.println(getMex(values,x));
    }
    private static int getMex(ArrayList<Integer> values,int x) {
        int i = 0;
        int temp = values.size();
        while(i < values.size()) {
            if(values.contains(i)) {
                values.remove(values.indexOf(i));
                i++;
            }
            else break;
        }
        for(int j = 0; j < values.size(); j++) {
            if((values.get(j) - i) % x != 0) return i;
        }
        return temp;
    }
}
