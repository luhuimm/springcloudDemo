package com.hui;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;

    public MyHystrixCommand(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(
                                HystrixCommandProperties.
                                        ExecutionIsolationStrategy.SEMAPHORE)));
        this.name = name;
    }

    protected String run() throws Exception {
//        Thread.sleep(1000* 10);

        System.out.println("get data");
        return this.name +":" + Thread.currentThread().getName();
    }

    @Override
    protected String getFallback() {
        return "失败了";
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }
}
