package com.soft1851.content.center.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonconfig.RibbonConfig;

/**
 * @Author zeng
 * @Date 2020/9/25 11:09
 * @Description
 * @Version 1.0
 */
@Configuration
//@RibbonClient(name = "user-center",configuration = RibbonConfig.class)
//@RibbonClients(defaultConfiguration = RibbonConfig.class)
public class UserCenterRibbonConfig {
}
