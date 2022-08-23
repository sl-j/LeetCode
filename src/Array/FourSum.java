package Array;


import java.util.*;

public class FourSum {
    public static void main(String[] args) {
    }

    private static double slove(double money){
        double res = 0;
        if(money <= 100000) res = money * 0.05;
        else if(money > 100000 && money < 200000){
            res = 100000 * 0.05 + (money - 100000) * 0.04;
        }else if(money >= 200000 && money < 400000){
            res = 100000 * 0.05 + (200000 - 100000) * 0.04 + (money - 200000) * 0.05;
        }else if(money >= 400000 && money < 600000){
            res = 100000 * 0.05 + (200000 - 100000) * 0.04 + (400000 - 200000) * 0.05 + (money - 400000) * 0.03;
        }else if(money >= 600000 && money < 1000000){
            res = 100000 * 0.05 + (200000 - 100000) * 0.04 + (400000 - 200000) * 0.05 + (600000 - 400000) * 0.03 + (money - 600000) * 0.015;
        }else{
            res = 100000 * 0.05 + (200000 - 100000) * 0.04 + (400000 - 200000) * 0.05 + (600000 - 400000) * 0.03 + (1000000 - 600000) * 0.015
                    + (money - 1000000) * 0.01;
        }

        return res;
    }



}
