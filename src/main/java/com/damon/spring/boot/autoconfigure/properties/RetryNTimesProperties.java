package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 19:32
 * @description
 */
public class RetryNTimesProperties {

    private Integer n;

    private Integer sleepMsBetweenRetries;

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getSleepMsBetweenRetries() {
        return sleepMsBetweenRetries;
    }

    public void setSleepMsBetweenRetries(Integer sleepMsBetweenRetries) {
        this.sleepMsBetweenRetries = sleepMsBetweenRetries;
    }
}
