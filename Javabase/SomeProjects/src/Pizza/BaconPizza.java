package Pizza;

/**
 * @author: fqq
 * @Date: 2025/5/17 - 05 - 17 - 23:38
 * @Description: Pizza
 * @version: 1.0
 */
public class BaconPizza extends Pizza{
    private int weight;

    public BaconPizza(String name, int s, int p, int weight) {
        super(name, s, p);
        this.weight = weight;
    }

    public BaconPizza() {

    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String show() {

        return super.show()+
                "培根的克重是是：" + weight+"克" ;
    }
}
