package Lecture2;

import java.util.Scanner;

public class binToDecimal {
    public static void main(String[] args) {
        // Division -> Destination base
        // Multiplication -> Source Base
        int n = new Scanner(System.in).nextInt();
        int bin = 0;
        int r = 0;
        while(n != 0) {
            bin += (n % 10)*Math.pow(5,r++);
            n /= 10;
        }
        System.out.println(bin);
    }
}
