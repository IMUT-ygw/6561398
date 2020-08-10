package com.imut.springboot.pojo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/17 9:41
 */
public class Car {
    private String name;
    private Integer Money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", Money=" + Money +
                '}';
    }

    public int add(int j){
        return j;
    }
}
