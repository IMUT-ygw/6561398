package com.imut.springboot;

import java.util.Scanner;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 15:03
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int lines = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int yMin = 1;
        int xMin = 1;
        int now_n = 1;
        int yMax = rows;// 行
        int xMax = lines;// 列
        int xIndex = xMin;
        int yIndex = yMin;
        int[][] num = new int[yMax + 1][xMax + 1];
        while (xIndex <= xMax && yIndex <= yMax) {
            for (xIndex = xMin; xIndex <= xMax; xIndex++) {
                num[yIndex][xIndex] = now_n++;
            }
            xIndex--;
            yMin++;
            for (yIndex = yMin; yIndex <= yMax; yIndex++) {
                num[yIndex][xIndex] = now_n++;
            }
            yIndex--;
            xMax--;
            for (xIndex = xMax; xIndex >= xMin; xIndex--) {
                num[yIndex][xIndex] = now_n++;
            }
            xIndex++;
            yMax--;
            for (yIndex = yMax; yIndex >= yMin; yIndex--) {
                num[yIndex][xIndex] = now_n++;
            }
            yIndex++;
            xMin++;
        }
        System.out.println(num[x][y]);
    }
}
