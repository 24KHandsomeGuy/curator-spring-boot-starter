package com.damon.spring.boot.autoconfigure.properties;

import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.retry.RetryUntilElapsed;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 10:52
 * @description
 */
public class RetryPolicyProperties {

    private static final int DEFAULT_SLEEP_MS_BETWEEN_RETRY = 5 * 1000;

    private static final int DEFAULT_RETRY_TIMES = 3;

    private static final int DEFAULT_RETRY_MAX_ELAPSED_TIME_MS = 60 * 1000;

    @NestedConfigurationProperty
    private RetryOneTimeProperties retryOneTime;

    @NestedConfigurationProperty
    private RetryNTimesProperties retryNTimes;

    @NestedConfigurationProperty
    private RetryUntilElapsedProperties retryUntilElapsed;

    @NestedConfigurationProperty
    private RetryForeverProperties retryForever;

    @NestedConfigurationProperty
    private ExponentialBackoffRetryProperties exponentialBackoffRetry;

    @NestedConfigurationProperty
    private BoundedExponentialBackoffRetryProperties boundedExponentialBackoffRetry;


    public RetryPolicy getRetryPolicy() {
        if (retryOneTime != null) {
            return new RetryOneTime(
                    retryOneTime.getSleepMsBetweenRetry() != null ? retryOneTime.getSleepMsBetweenRetry() : DEFAULT_SLEEP_MS_BETWEEN_RETRY
            );
        } else if (retryNTimes != null) {
            return new RetryNTimes(
                    retryNTimes.getN() != null ? retryNTimes.getN() : DEFAULT_RETRY_TIMES,
                    retryNTimes.getSleepMsBetweenRetries() != null ? retryNTimes.getSleepMsBetweenRetries() : DEFAULT_SLEEP_MS_BETWEEN_RETRY
            );
        } else if (retryUntilElapsed != null) {
            return new RetryUntilElapsed(
                    retryUntilElapsed.getMaxElapsedTimeMs() != null ? retryUntilElapsed.getMaxElapsedTimeMs() : DEFAULT_RETRY_MAX_ELAPSED_TIME_MS,
                    retryUntilElapsed.getSleepMsBetweenRetries() != null ? retryUntilElapsed.getSleepMsBetweenRetries() : DEFAULT_SLEEP_MS_BETWEEN_RETRY
            );
        } else if (retryForever != null) {
            return new RetryForever(
                    retryForever.getRetryIntervalMs() != null ? retryForever.getRetryIntervalMs() : DEFAULT_SLEEP_MS_BETWEEN_RETRY
            );
        } else if (exponentialBackoffRetry != null) {
            return new ExponentialBackoffRetry(
                    exponentialBackoffRetry.getBaseSleepTimeMs() != null ? exponentialBackoffRetry.getBaseSleepTimeMs() : DEFAULT_SLEEP_MS_BETWEEN_RETRY,
                    exponentialBackoffRetry.getMaxRetries() != null ? exponentialBackoffRetry.getMaxRetries() : DEFAULT_RETRY_TIMES,
                    exponentialBackoffRetry.getMaxSleepMs() != null ? exponentialBackoffRetry.getMaxSleepMs() : DEFAULT_RETRY_MAX_ELAPSED_TIME_MS
            );
        } else if (boundedExponentialBackoffRetry != null) {
            return new BoundedExponentialBackoffRetry(
                    boundedExponentialBackoffRetry.getBaseSleepTimeMs() != null ? boundedExponentialBackoffRetry.getBaseSleepTimeMs() : DEFAULT_SLEEP_MS_BETWEEN_RETRY,
                    boundedExponentialBackoffRetry.getMaxSleepTimeMs() != null ? boundedExponentialBackoffRetry.getMaxSleepTimeMs() : DEFAULT_RETRY_MAX_ELAPSED_TIME_MS,
                    boundedExponentialBackoffRetry.getMaxRetries() != null ? boundedExponentialBackoffRetry.getMaxRetries() : DEFAULT_RETRY_TIMES
            );
        }
        return new RetryUntilElapsed(DEFAULT_RETRY_MAX_ELAPSED_TIME_MS, DEFAULT_SLEEP_MS_BETWEEN_RETRY);
    }

    public RetryOneTimeProperties getRetryOneTime() {
        return retryOneTime;
    }

    public void setRetryOneTime(RetryOneTimeProperties retryOneTime) {
        this.retryOneTime = retryOneTime;
    }

    public RetryNTimesProperties getRetryNTimes() {
        return retryNTimes;
    }

    public void setRetryNTimes(RetryNTimesProperties retryNTimes) {
        this.retryNTimes = retryNTimes;
    }

    public RetryUntilElapsedProperties getRetryUntilElapsed() {
        return retryUntilElapsed;
    }

    public void setRetryUntilElapsed(RetryUntilElapsedProperties retryUntilElapsed) {
        this.retryUntilElapsed = retryUntilElapsed;
    }

    public RetryForeverProperties getRetryForever() {
        return retryForever;
    }

    public void setRetryForever(RetryForeverProperties retryForever) {
        this.retryForever = retryForever;
    }

    public ExponentialBackoffRetryProperties getExponentialBackoffRetry() {
        return exponentialBackoffRetry;
    }

    public void setExponentialBackoffRetry(ExponentialBackoffRetryProperties exponentialBackoffRetry) {
        this.exponentialBackoffRetry = exponentialBackoffRetry;
    }

    public BoundedExponentialBackoffRetryProperties getBoundedExponentialBackoffRetry() {
        return boundedExponentialBackoffRetry;
    }

    public void setBoundedExponentialBackoffRetry(BoundedExponentialBackoffRetryProperties boundedExponentialBackoffRetry) {
        this.boundedExponentialBackoffRetry = boundedExponentialBackoffRetry;
    }
}
