package Collection;

import java.util.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/9 13:09
 */
public class ConllectionDemo {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,1,2,3,4,5,6,7,8,9,12,11,13,14,15,156,16);
        Collections.fill(arrayList,10);
        System.out.println(arrayList);
    }
}
