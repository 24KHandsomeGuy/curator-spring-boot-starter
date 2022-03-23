package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 10:58
 * @description
 */
public class BoundedExponentialBackoffRetryProperties {

    private Integer baseSleepTimeMs;

    private Integer maxSleepTimeMs;

    private Integer maxRetries;

    public Integer getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public Integer getMaxSleepTimeMs() {
        return maxSleepTimeMs;
    }

    public void setMaxSleepTimeMs(Integer maxSleepTimeMs) {
        this.maxSleepTimeMs = maxSleepTimeMs;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }
}
