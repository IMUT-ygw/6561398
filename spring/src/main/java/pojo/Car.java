package pojo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/18 15:34
 */
public class Car {
    public  String name;
    public Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
