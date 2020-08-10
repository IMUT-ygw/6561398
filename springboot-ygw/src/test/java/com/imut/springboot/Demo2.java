package com.imut.springboot;

import java.util.Scanner;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 14:40
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length ; i++) {
            if(c[i] > 'a' & c[i] < 'w') {
                System.out.print((char) (c[i] + 3));
            }else{
                System.out.println((char)(c[i] - 23));
            }
        }
    }
}
