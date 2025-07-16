package comnclass;

import java.util.*;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 15:46
 * @Description: comnclass
 * @version: 1.0
 */
public class MyCollection {
    public static void main(String[] args) {
         /*
        Collection接口的常用方法：
        增加：add(E e) addAll(Collection<? extends E> c)
        删除：clear() remove(Object o)
        修改：
        查看：iterator() size()
        判断：contains(Object o)  equals(Object o) isEmpty()
         */
        Collection c1=new ArrayList();
        c1.add(13);
        c1.add(450);
        System.out.println(c1);
        List list= Arrays.asList(new Integer[]{23,43,15,44});
        c1.addAll(list);
        System.out.println(c1.size());
        System.out.println("Whether remove?"+c1.remove(15));
        System.out.println(c1.isEmpty());
        System.out.println(c1);
        c1.clear();
        System.out.println(c1);
        Collection c2=new ArrayList();
        c2.add(54); c2.add(23);c2.add(89);
        System.out.println(c1.equals(c2));
        System.out.println("比较地址");
        System.out.println( c1 == c2);
        System.out.println("是否包含元素"+c1.contains(54));
//方法一：增强循环
        System.out.println("增强循环\t");
        for(Object o:c2){
            System.out.print(o+"\t");
        }
//方法二：迭代器
        System.out.println("\n迭代器");
        Iterator it= c2.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"\t");
        }


    }
}
