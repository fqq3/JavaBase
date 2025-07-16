package Pizza;

/**
 * @author: fqq
 * @Date: 2025/5/17 - 05 - 17 - 23:34
 * @Description: Pizza
 * @version: 1.0
 */
public class FruitPizza  extends Pizza{
    private String burdening;
//构造器
    public FruitPizza(){

    }
    public FruitPizza(String name,String burdening, int weight, int price ){
        super(name,weight,price);
        this.burdening=burdening;
    }
    public String getBurdening() {
        return burdening;
    }

    public void setBurdening(String burdening) {
        this.burdening = burdening;
    }

    @Override
    public String show() {
        return super.show()+"你要加入的水果是："+burdening;
    }
}
