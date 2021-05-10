package com.iootc.lab.freedom;

import java.util.Arrays;
import java.util.Random;

/**
 * 财富分配
 *
 * <p>房间里有100人，每人都有100元，让他们在玩一个游戏，每轮游戏每个人都要拿出 1 元钱随机给到另一人。
 * 那么请问，当这个游戏进行了数万轮之后，最后这 100 个人的财富分布会是怎样的呢？
 * </p>
 *
 * @author Johnathon Yuan
 * @since 2021-04-12 23:24
 */
public class WealthDistribution {

    public static int PEOPLE_NUMBER = 100;

    public static int INIT_WEALTH = 100;

    public static int[] wealthArray = new int[PEOPLE_NUMBER];

    public static int loop = 34000;

    public static void main(String[] args) {
        init(wealthArray);
        for (int i = 0; i < loop; i++) {
            for(int j = 0; j < PEOPLE_NUMBER ; j++){
                if (wealthArray[j] == 0) {
                    continue;
                }
                int toPeople = chosePeople(j);
                dodoWealthExchange(j, toPeople);
            }
        }
        Arrays.sort(wealthArray);
        print();

    }

    private static void print() {
        for (int j = 0; j < PEOPLE_NUMBER; j++) {
            System.out.println(wealthArray[j]);
        }
    }

    private static void dodoWealthExchange(int j, int toPeople) {
        wealthArray[j] -= 1;
        wealthArray[toPeople] += 1;
    }

    private static int chosePeople(int j) {
        int toPeople = j;
        while (toPeople == j) {
            Random random = new Random();
            toPeople = random.nextInt(100);
        }
        return toPeople;
    }

    private static void init(int[] wealthArray) {
        for (int i = 0; i < wealthArray.length; i++) {
            wealthArray[i] = INIT_WEALTH;
        }
    }
}
