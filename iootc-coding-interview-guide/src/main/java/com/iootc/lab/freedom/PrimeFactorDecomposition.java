package com.iootc.lab.freedom;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * 分解质因数
 *
 * <p>把一个合数分解成若干个质因数的乘积的形式，即求质因数的过程叫做分解质因数。</p>
 * <p>eg. 60=2*2*3*5</p>
 * @author Johnathon Yuan
 * @since  2019-05-05 15:43
 */
public class PrimeFactorDecomposition {

    public static void main(String[] args) {

        System.out.print("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long start = System.currentTimeMillis();
        doFactor3(number);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("执行时长:" + (end - start) + "ms");
        scanner.close();
    }

    private static void doFactor1(int number) {
        System.out.print(number + " = ");
        while(number > 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i);
                    if(number != i) {
                        System.out.print(" * ");
                    }
                    number = number / i;
                    break;
                }
            }
        }
    }
    private static void doFactor2(int number) {
        System.out.print(number + " = ");
        int mixPrime = 2;
        for (int i = mixPrime; i <= number; i++ ) {
            while (number % i == 0) {
                System.out.print(i);
                if (number != i) {
                    System.out.print(" * ");
                    number = number / i;
                } else {
                    break;
                }
            }
            if (number == 1) {
                break;
            }
        }
    }
    private static void doFactor3(int number) {
        int outNum = number;
        List<Integer> numbers = Lists.newArrayList();
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                number = number/i;
                numbers.add(i--);
            }
        }
        System.out.println(outNum + " = " + numbers);
    }

}
