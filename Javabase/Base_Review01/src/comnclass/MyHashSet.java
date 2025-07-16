package comnclass;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Auther: fangqingqing
 * @Date: 2025/5/2 - 05 - 02 - 16:09
 * @Description: comnclass
 * @version: 1.0
 */
public class MyHashSet {
    public static void main(String[] args) {
        //set 无序 元素唯一
        System.out.println("HashSet的底层是用HashMap实现的，");
        HashSet<Integer> hs= new HashSet<>();
        hs.add(12);
        hs.add(25);
        hs.add(17);
        hs.add(9);
        hs.add(9);
        System.out.println(hs.size());
        System.out.println(hs);
        HashSet<String> hss= new HashSet<>();
        hss.add("sold out");
        hss.add("Tia");
        hss.add("lie");
        hss.add("standard");
        System.out.println(hss.size());
        System.out.println(hss);
        //LinkedHashSet
        //创建一个HashSet集合：
        LinkedHashSet<Integer> hs1 = new LinkedHashSet<>();
        System.out.println(hs1.add(19));//true
        hs1.add(5);
        hs1.add(20);
        System.out.println(hs1.add(19));//false 这个19没有放入到集合中
        hs1.add(41);
        hs1.add(0);
        System.out.println(hs1.size());//唯一，无序
        System.out.println(hs1);
        //TreeSet 按升序遍历
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(15);
        ts.add(15);
        ts.add(18);
        ts.add(11);
        ts.add(25);
        ts.add(35);
        System.out.println(ts);
        System.out.println(ts.size());
        TreeSet<String> tss = new TreeSet<>();
        tss.add("a");
        tss.add("bb");
        tss.add("cd");
        tss.add("ww");
        tss.add("df");
        tss.add("bd");
        tss.add("bd");
        System.out.println(tss);
        System.out.println(tss.size());

    }
}
