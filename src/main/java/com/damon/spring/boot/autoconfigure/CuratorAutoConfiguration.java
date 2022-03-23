package com.damon.spring.boot.autoconfigure;

import com.damon.spring.boot.autoconfigure.properties.CuratorPropertites;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fukuixiang
 * @date 2022/3/21
 * @time 15:41
 * @description
 */
@Configuration
@EnableConfigurationProperties(CuratorPropertites.class)
public class CuratorAutoConfiguration {

    @Bean(initMethod = "start", destroyMethod = "close")
    @ConditionalOnMissingBean(CuratorFramework.class)
    public CuratorFramework curatorClient(CuratorPropertites curatorPropertites) {
        return CuratorFrameworkFactory.builder()
                .connectString(curatorPropertites.getConnectString())
                .retryPolicy(curatorPropertites.getRetryPolicy())
                .connectionTimeoutMs(curatorPropertites.getConnectionTimeoutMs())
                .sessionTimeoutMs(curatorPropertites.getSessionTimeoutMs()).build();
        // extended if necessary.  etc. etc.
    }
}
