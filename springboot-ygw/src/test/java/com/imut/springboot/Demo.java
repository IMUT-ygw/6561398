package com.imut.springboot;

import java.util.Scanner;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 14:18
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int min = Math.min(Math.min(a,b),c);
        int count = 0;
        if(num < min ){
            System.out.println(num);
            return;
        }
        for (int i = 1; i <= num ; i++) {
            if(i < min){
                count++;
                System.out.println(i);
            }else if (i % a != 0 & i % b != 0 & i % c != 0){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
