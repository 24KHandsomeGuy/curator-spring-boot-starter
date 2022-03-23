package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 10:58
 * @description
 */
public class RetryUntilElapsedProperties {

    private Integer maxElapsedTimeMs;

    private Integer sleepMsBetweenRetries;

    public Integer getMaxElapsedTimeMs() {
        return maxElapsedTimeMs;
    }

    public void setMaxElapsedTimeMs(Integer maxElapsedTimeMs) {
        this.maxElapsedTimeMs = maxElapsedTimeMs;
    }

    public Integer getSleepMsBetweenRetries() {
        return sleepMsBetweenRetries;
    }

    public void setSleepMsBetweenRetries(Integer sleepMsBetweenRetries) {
        this.sleepMsBetweenRetries = sleepMsBetweenRetries;
    }
}