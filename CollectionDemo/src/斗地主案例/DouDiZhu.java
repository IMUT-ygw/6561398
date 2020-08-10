package 斗地主案例;

import sun.util.locale.provider.SPILocaleProviderAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/9 18:18
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //制作扑克牌
        ArrayList<String> poker = new ArrayList<>();
        String[] color = {"♥","♠","♣","♦"};
        String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        poker.add("大王");
        poker.add("小王");
        for (String colors: color) {
            for (String number: numbers) {
                poker.add(colors+number);
            }
        }

        //洗牌
        Collections.shuffle(poker);

        //发牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i <poker.size() ; i++) {
            String s = poker.get(i);
            if(i >=51 ){
                dipai.add(s);
            }else if(i%3==0){
                player01.add(s);
            }else if (i%3==1){
                player02.add(s);
            }else if (i%3==2){
                player03.add(s);
            }
        }
        //排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);

        //看牌
        System.out.println("玩家一：" + player01);
        System.out.println("玩家二：" + player02);
        System.out.println("玩家三：" + player03);
        System.out.println("底牌：" + dipai);
    }
}
