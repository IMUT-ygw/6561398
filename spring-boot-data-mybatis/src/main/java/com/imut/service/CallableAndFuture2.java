package com.imut.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 13:01
 */
public class CallableAndFuture2 implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableAndFuture2 c = new CallableAndFuture2();
        FutureTask<Object> futureTask = new FutureTask<>(c);
        FutureTask<Object> futureTask2 = new FutureTask<>(c);
        new Thread(futureTask,"有返回值的线程1").start();
        new Thread(futureTask2,"有返回值的线程2").start();
        System.out.println("子线程的返回值" + futureTask.get());
    }
    @Override
    public Object call() throws Exception {
        int i;
        for (i= 0 ;i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
