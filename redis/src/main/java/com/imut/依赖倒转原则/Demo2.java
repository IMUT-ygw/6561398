package com.imut.依赖倒转原则;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/2/29 16:43
 */
public class Demo2 {
    public static void main(String[] args) {
        Head h = new Head();
        h.open(new IM());
    }
}

/**
 * 电视得开关方式
 */
interface TVCloseAndOpen{
    void open(Open open);
    void close(Close close);
}

/**
 * 电视打开方式有多种：比如遥控器，机身电源等
 */
interface Open{
   void open();
}
interface Close{
    void close();
}

/**
 * 开关实现类
 */
class IM implements Open,Close{

    @Override
    public void open() {
        System.out.println("打开");
    }

    @Override
    public void close() {
        System.out.println("关闭");
    }
}

/**
 * 可以写多个开启和关闭得实现类
 */

class Head implements TVCloseAndOpen{
    @Override
    public void open(Open open) {
        open.open();
    }

    @Override
    public void close(Close close) {
        close.close();
    }
}
