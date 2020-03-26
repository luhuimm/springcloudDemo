package com.hui;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand("huihui").execute();
        Future<String> future = new MyHystrixCommand("huihui").queue();
        System.out.println(future.get());
        System.out.println(result);
        hystrixRequestContext.shutdown();
    }
}
