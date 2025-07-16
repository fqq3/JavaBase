package mimicdoublelinkedlist;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 20:55
 * @Description: mimicdoublelinkedlist
 * @version: 1.0
 */
public class MyLinkedList {
    Node first;
    Node last;
    int count;
    public MyLinkedList() {
        first = null;
        last = null;
        count = 0;
    }
    public void add(Object o){
        if(first==null){
            Node n = new Node();
            n.setPre(null);
            n.setCurr(o);
            n.setNext(null);
            first = n;
            last = n;
        }else{
            Node n = new Node();
            n.setPre(last);
            n.setCurr(o);
            n.setNext(null);
            last.setNext(n);//-----------
            last=n;
        }
        count++;
    }
    public int getSize(){
        return count;
    }
    public Object get(int index){//index从0开始
        Node n = first;
        for(int i=0;i<index;i++){
            n=n.getNext();
        }
        return n.getCurr();
    }
}
class Test{
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add("m");
        System.out.println(list.getSize());
    }
}