package comnclass;

import java.util.*;

/**
 * @Auther: fangqingqing
 * @Date: 2025/5/4 - 05 - 04 - 16:55
 * @Description: comnclass
 * @version: 1.0
 */
public class MyMap {
    public static void main(String[] args) {
        /*
        增加：put(K key, V value)
        删除：clear() remove(Object key)
        修改：
        查看：entrySet() get(Object key) keySet() size() values()
        判断：containsKey(Object key) containsValue(Object value)
            equals(Object o) isEmpty()
         */
        //map key无序唯一
        Map<String,Integer> m1=new HashMap();
        m1.put("lisa",34);
        System.out.println("liki1:"+m1.put("liki", 15));
        System.out.println("liki2:"+m1.put("liki", 35));
        m1.put("lali",24);
        m1.put("lkeisa",31);
        m1.put("kedoa",47);
        System.out.println(m1.size());
        System.out.println(m1);
        m1.remove("lkeisa");
        System.out.println(m1);
        System.out.println(m1.containsKey("laloe"));
        System.out.println(m1.containsValue("jaxi"));
//        m1.clear();
        System.out.println(m1);
        Map<String,Integer> m2=new HashMap();
        //
        System.out.println("equals进行了重写，比较的是集合中的值是否一致."
                +m1.equals(m2));
        System.out.println("判断是否为空："+m2.isEmpty());
        Set<String> set=m1.keySet();
        for(String s:set){
            System.out.println(s);
            System.out.println(m1.get(s));
        }
        System.out.println(m1.get("kedoa"));
        Collection<Integer> values=m1.values();
        System.out.println(values);
        Set<Map.Entry<String,Integer>> entry =m1.entrySet();
        for(Map.Entry<String,Integer> e:entry){
            System.out.println(e.getKey()+":"+e.getValue());
        }
        Map<String,Integer> map=new LinkedHashMap<>();
        map.put(null,34);
        map.put(null,23);
        map.put("null",31);
        map.put("nubile",34);
        System.out.println(map);
        //TreeMap
        Map <String,Integer> tmap1=new TreeMap();
        tmap1.put("laziya",24);
        tmap1.put("liya",37);
        tmap1.put("liya",35);
        tmap1.put("dociya",18);
        for(Map.Entry<String,Integer> e:tmap1.entrySet()){
            System.out.println(e.getKey()+":"+e.getValue());
        }
        //hashmap允许key空值，hashtable不允许
        HashMap<Integer,String>  hm=new HashMap<>();
        hm.put(1,"lazy");
        System.out.println(hm.put(2, "lumn"));
        hm.put(3,"pariazia");
        System.out.println(hm.put(2, "tiailan"));
        System.out.println("集合中的元素"+hm);
        System.out.println("HashMap中元素的数量"+hm.size());
        System.out.println("底层原理是entry类数组，[hash, key, value, next]");
        System.out.println("不同键值对若相同哈希码，则在数组相同位置追加节点形成链表，JDK1.7(头插法)上JDK1.8(尾插法)下");
        System.out.println("哈希表=数组+链表");

        System.out.println("但是这是一个理想状态，元素不可能完全的均匀分布，很可能就哈西碰撞产生链表了。产生链表的话 查询时间就长了。 \n" +
                "---》空间好，时间不好\n" +
                "\n" +
                "那么有人说 ，把装填因子搞小一点，0.5，  如果是0.5的话，就浪费空间，但是可以做到 到0.5就扩容 ，然后哈西碰撞就少，\n" +
                "不产生链表的话，那么查询效率很高   \n" +
                "---》时间好，空间不好");
        System.out.println("主数组的长度为2的倍数,原因1：\n" +
                "h%length 和 h & length-1等效的前提就是  length必须是2的整数倍\n" +
                "原因2：如果不是2的整数倍，那么 哈西碰撞 哈西冲突的概率就高了很多\n" +
                "\n" +
                "位运算 就  涉及  到  length是不是2的整数倍：\n" +
                "比如是2的整数倍：得到的索引值，一定在 0-15之间（数组是16的时候）" +
                "如果不是2的整数倍，那么 哈西碰撞 哈西冲突的概率就高了很多,链表多，效率低");


    }
}
