package comnclass;

import java.util.*;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 16:11
 * @Description: comnclass
 * @version: 1.0
 */
public class MyList {
    /*
        List接口中常用方法：
        增加：add(int index, E element)
        删除：remove(int index)  remove(Object o)
        修改：set(int index, E element)
        查看：get(int index)
        判断：
         */
    public static void main(String[] args) {
        List l1=new ArrayList();
        l1.addAll(Arrays.asList(new Integer[] {12,45,65,48}));
        System.out.println(l1);
        l1.remove(1);
        l1.add("snf");
        System.out.println(l1);
        Object oo=l1.get(1);
        System.out.println(oo);
//遍历
        for(int i=0;i<l1.size();i++){
            System.out.print(l1.get(i)+"\t");
        }
        System.out.println();
        for(Object obj:l1){
            System.out.print(obj+"\t");
        }
        System.out.println();
        Iterator it1=l1.iterator();
        while(it1.hasNext()){
            System.out.print(it1.next()+"\t");
        }

        ArrayList aa=new ArrayList();
        System.out.println(aa.add("fgh"));
        System.out.println(aa.add("jwh"));

        Vector v1=new Vector();//弃用
        v1.add("djf");
        System.out.println(v1);
        ArrayList<Integer> aI=new ArrayList<>();
        aI.add(35); aI.add(29);
        for(Integer i:aI){
            System.out.println(i);
        }
    }

    public void a(List<?> list){
        //1.遍历：
        for(Object a:list){
            System.out.println(a);
        }
        //2.数据的写入操作 ：
        //list.add("abc");-->出错，不能随意的添加数据
        list.add(null);
        //3.数据的读取操作：
        Object s = list.get(0);
    }
    private static void test1(){
        System.out.println("泛型就相当于标签\n" +
                "形式：<>  \n" +
                "集合容器类在设计阶段/声明阶段不能确定这个容器到底实际存的是什么类型的对象，所以在JDK1.5之前只能把元素类型设计为Object，\n" +
                "JDK1.5之 后使用泛型来解决。因为这个时候除了元素的类型不确定，其他的部分是确定的，例如关于这个元素如何保存，如何管理等是确定的，因此此时把元素的类型设计成一个参数，这个类型参数叫做泛型。\n" +
                "Collection<E>, List<E>， ArrayList<E> 这个<E>就是类型参数，即泛型。\n");
        System.out.println("A 和 B是子类父类的关系，G<A>和G<B>不存在子类父类关系，是并列的 " +
                "加入通配符？后，G<?>就变成了 G<A>和G<B>的父类");
        System.out.println("泛型类中使用泛型:参数类型：A age;\nList:A[] i=(A[]) new Object[10]");
        System.out.println("泛型类构造器：public 类名(){}");



    }

}
