package 斗地主案例;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/9 18:38
 */
public class DouDiZhu2 {
    public static void main(String[] args) {
        Map<Integer,String> poker = new HashMap<>();
        String[] color = {"♥","♠","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int count = 0;
            for (String colors: color) {
                for (String number: numbers) {
                   poker.put(count,colors+number);
                   count++;
                }
            }
            poker.put(52,"小王");
            poker.put(53,"大王");

        ArrayList<Integer> xipai = new ArrayList<>();
        for (int i = 0; i <poker.size() ; i++) {
            xipai.add(i);
        }

        //洗牌
        Collections.shuffle(xipai);

        //发牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i <poker.size() ; i++) {
            if(i >= 51){
                dipai.add(poker.get(xipai.get(i)));
            }else if (i %3 ==0){
                player01.add(poker.get(xipai.get(i)));
            }else if (i%3 ==1){
                player02.add(poker.get(xipai.get(i)));
            }else if (i%3 ==2){
                player03.add(poker.get(xipai.get(i)));
            }
        }

        //看牌
        System.out.println("玩家一：" + player01);
        System.out.println("玩家二：" + player02);
        System.out.println("玩家三：" + player03);
        System.out.println("底牌：" + dipai);


    }
}
