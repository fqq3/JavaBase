package Pizza;

/**
 * @author: fqq
 * @Date: 2025/5/17 - 05 - 17 - 23:29
 * @Description: Pizza
 * @version: 1.0
 */
public class Pizza {
    String name;
    private int size;
    private int price;
    //构造器
    Pizza(String name,int s,int p){
        this.name=name;
        this.size=s;
        this.price=p;
    }
    Pizza(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return size;
    }

    public void setWeight(int weight) {
        this.size = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String show(){
        return "披萨名是"+name+"\n大小是:"+size+"寸\n价格是:"+price+"元\n";
    }
}
