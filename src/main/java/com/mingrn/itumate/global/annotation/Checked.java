package com.mingrn.itumate.global.annotation;

import java.lang.annotation.*;

/**
 * 检查注解,作用于方法
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 08/11/2018 09:22
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Checked {
}
