package mimicdoublelinkedlist;

/**
 * @Auther: fangqingqing
 * @Date: 2025/4/29 - 04 - 29 - 20:52
 * @Description: mimicdoublelinkedlist
 * @version: 1.0
 */
public class Node {
    private Node pre;
    Object curr;
    private Node next;

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Object getCurr() {
        return curr;
    }

    public void setCurr(Object curr) {
        this.curr = curr;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
