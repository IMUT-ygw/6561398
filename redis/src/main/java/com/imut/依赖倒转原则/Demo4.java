package com.imut.依赖倒转原则;

/**
 * @author nmtl_ygw
 * @Description  setter方法传递依赖
 * @date 2020/2/29 17:04
 */
public class Demo4 {
}

interface OpenClose2{
    public void open();
    void setTv(ITV itv);
}
interface ITV{
    void open();
}

class PersonDemo2 implements OpenClose2{
    private ITV itv;

    @Override
    public void open() {
        this.itv.open();
    }

    @Override
    public void setTv(ITV itv) {
        this.itv = itv;
    }
}
