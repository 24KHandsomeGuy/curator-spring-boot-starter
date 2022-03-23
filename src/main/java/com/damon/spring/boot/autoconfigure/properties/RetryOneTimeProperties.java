package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 19:34
 * @description
 */
public class RetryOneTimeProperties {

    private Integer sleepMsBetweenRetry;

    public Integer getSleepMsBetweenRetry() {
        return sleepMsBetweenRetry;
    }

    public void setSleepMsBetweenRetry(Integer sleepMsBetweenRetry) {
        this.sleepMsBetweenRetry = sleepMsBetweenRetry;
    }
}
