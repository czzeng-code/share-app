package com.soft1851.content.center.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author zeng
 * @Date 2020/10/13 14:49
 * @Description
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuthorization {
    String value();
}
