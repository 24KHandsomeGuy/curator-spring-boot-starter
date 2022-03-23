package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 10:58
 * @description
 */
public class RetryForeverProperties {

    private Integer retryIntervalMs;

    public Integer getRetryIntervalMs() {
        return retryIntervalMs;
    }

    public void setRetryIntervalMs(Integer retryIntervalMs) {
        this.retryIntervalMs = retryIntervalMs;
    }
}
