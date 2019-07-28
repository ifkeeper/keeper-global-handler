package com.mingrn.itumate.global.annotation;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

/**
 * 邮件校验注解。
 * 该注解与 {@link Checked checked} 注解同时使用。<code>@Checked</code> 作用于方法,
 * 用于标识检查该方法。
 * <code>@MailValid</code> 注解作用于方法参数,用于表示该参数必须符合邮件格式。
 * 当请求进入方法体之前会在 {@link com.mingrn.itumate.global.aspect.MailValidAspect}
 * 中进行校验。若被 <code>@MailValid</code> 注解标识的参数值不符合邮件格式时,会抛出异常,并会
 * 在全局异常处理{@link com.mingrn.itumate.global.handle.GlobalExceptionHandler}中被拦截。
 * </p>
 * 使用示例见 README.md
 * </p>
 * 注意:该注解一定要与{@link Checked checked} 注解同时使用,否则将不起作用。
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 07/11/2018 20:24
 */
@Documented
@Target({ElementType.PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ParamsIsNotNull
public @interface MailValid {

	boolean valid() default true;

	String message() default "Email format error";

	Pattern REGEXP = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", Pattern.MULTILINE);
}