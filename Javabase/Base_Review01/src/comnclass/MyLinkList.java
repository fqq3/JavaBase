package comnclass;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 20:15
 * @Description: comnclass
 * @version: 1.0
 */
public class MyLinkList {


    public static void main(String[] args) {
            /*
       LinkedList常用方法：*/
        System.out.println("增加 addFirst(E e) addLast(E e)");
//        System.out.println("offer(E e) offerFirst(E e) offerLast(E e)---有异常");
        System.out.println("删除 poll()");
        System.out.println("pollFirst() pollLast()  ---》JDK1.6以后新出的方法，提高了代码的健壮性");
//        System.out.println("removeFirst() removeLast()---有异常");
        System.out.println("修改");
        System.out.println("查看 \nelement()");
//        System.out.println("getFirst()  getLast()---有异常");
        System.out.println("indexOf(Object o)   lastIndexOf(Object o)");
        System.out.println("peek()");
        System.out.println("peekFirst() peekLast()");
        System.out.println("判断");
        LinkedList<String> list=new LinkedList<>();
        list.add("hello  ");
        list.add("Sold out ");
        list.add("In a wold of flowers ");
        list.add("I'be a leader ");
        System.out.println(list);
        list.addFirst("Start:");
        list.addLast(":End");
        System.out.println(list);
        list.offer("offer");
        System.out.println(list);
        list.offerFirst("offerFirst");
        list.offerLast("offerLast");
        System.out.println(list);
        System.out.println(list.poll());//删除头元素，并返回头元素
        System.out.println(list);
        System.out.println(list.pollFirst());
        System.out.println(list);
        System.out.println(list.pollLast());
        System.out.println(list);
        System.out.println("-----------------------------------------------");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        System.out.println("\n               -----------------");
        for(String str:list){
            System.out.print(str);
        }
        System.out.println("\n               -----------------");
        Iterator it =list.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println("\n  迭代节省内存版        ----------------------");
        for(Iterator<String> it1=list.iterator();it1.hasNext();){
            System.out.print(it1.next());
        }
    }
}
