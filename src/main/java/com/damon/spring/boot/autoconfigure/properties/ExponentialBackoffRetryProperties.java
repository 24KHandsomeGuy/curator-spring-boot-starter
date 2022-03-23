package com.damon.spring.boot.autoconfigure.properties;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 10:58
 * @description
 */
public class ExponentialBackoffRetryProperties {

    private Integer baseSleepTimeMs;

    private Integer maxRetries;

    private Integer maxSleepMs;

    public Integer getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Integer getMaxSleepMs() {
        return maxSleepMs;
    }

    public void setMaxSleepMs(Integer maxSleepMs) {
        this.maxSleepMs = maxSleepMs;
    }
}
