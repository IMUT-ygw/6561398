package com.imut.service;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 12:53
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        Callable callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        };
        FutureTask<Integer> future = new FutureTask<>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(2000);
            System.out.println("你好Callable");
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
