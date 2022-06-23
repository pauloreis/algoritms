package easy.manipuleString;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // add spaces into string after and before
//        Sample Input
//
//        java 100
//        cpp 65
//        python 50
//
//        Sample Output
//
//================================
//        java           100
//        cpp            065
//        python         050
//                ================================
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.println(String.format("%-15.15s", s1) + String.format("%03d", x));
        }
        System.out.println("================================");

    }
}
