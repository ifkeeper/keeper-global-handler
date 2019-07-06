package com.mingrn.itumate.global.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局 Feign 配置
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019-07-06 15:20
 */
@Configuration
public class GlobalFeignConfig {

    /** Feign 客户端调用输出级别 */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
