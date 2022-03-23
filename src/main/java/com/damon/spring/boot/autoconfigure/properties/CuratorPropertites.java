package com.damon.spring.boot.autoconfigure.properties;

import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.RetryUntilElapsed;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 16:27
 * @description
 */
@ConfigurationProperties(prefix = "curator")
public class CuratorPropertites {

    private String connectString = "localhost:2181";

    private Integer sessionTimeoutMs = 60000;

    private Integer connectionTimeoutMs = 15000;

    @NestedConfigurationProperty
    private RetryPolicyProperties retryPolicyConfiguration;

    public RetryPolicyProperties getRetryPolicyConfiguration() {
        return retryPolicyConfiguration;
    }

    public void setRetryPolicyConfiguration(RetryPolicyProperties retryPolicyConfiguration) {
        this.retryPolicyConfiguration = retryPolicyConfiguration;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public Integer getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(Integer sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public Integer getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(Integer connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicyConfiguration == null ? new RetryUntilElapsed(60000, 5000) : retryPolicyConfiguration.getRetryPolicy();
    }
}
