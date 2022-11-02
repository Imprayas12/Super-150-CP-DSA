package backtracking;

import java.util.*;

public class recursive {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int dice = sc.nextInt();
		int dest = 4;
		Set<List<Integer>> set = new HashSet<>();
		genWays(set,new ArrayList<>(),1,dice,dest);
		for(var i: set) System.out.println(i);
		System.out.println("Runtime : " + (System.currentTimeMillis() - start)/1000);
	}
	private static void genWays(Set<List<Integer>> set,List<Integer> cur,int ind,int dice,int dest) {
		if(dest == 0) {
			set.add(new ArrayList<>(cur));
			return;
		}
		if(ind > dice) return;
		if(ind<= dest) {
			cur.add(ind);
			genWays(set,cur,ind + 1,dice,dest - ind);
			genWays(set,cur,ind,dice,dest - ind);
			cur.remove(cur.size() - 1);
		}
		genWays(set,cur,ind + 1,dice,dest);
	}
}