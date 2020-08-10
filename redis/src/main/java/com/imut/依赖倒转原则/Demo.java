package com.imut.依赖倒转原则;

/**
 * @author nmtl_ygw
 * @Description  通过构造方法传递
 * @date 2020/2/29 16:55
 */
public class Demo {
    public static void main(String[] args) {
        OpenClose op = new OpenClose((OpenGouZao) new IM1());
        OpenClose op1 = new OpenClose((CloseGouZao) new IM1());
        op1.close();
        op.open();
    }
}

interface ITv{
    public void open();
    public void close();
}

interface OpenGouZao{
    public void open();
}
interface CloseGouZao{
    public void close();
}

class IM1 implements OpenGouZao,CloseGouZao{

    @Override
    public void open() {
        System.out.println("打开");
    }

    @Override
    public void close() {
        System.out.println("关闭");
    }
}

class OpenClose implements ITv{

    private OpenGouZao openGouZao;
    private CloseGouZao closeGouZao;

    public OpenClose(OpenGouZao openGouZao){
        this.openGouZao = openGouZao;
    }
    public OpenClose(CloseGouZao closeGouZao){
        this.closeGouZao = closeGouZao;
    }

    @Override
    public void open() {
        this.openGouZao.open();
    }

    @Override
    public void close() {
        this.closeGouZao.close();
    }
}
