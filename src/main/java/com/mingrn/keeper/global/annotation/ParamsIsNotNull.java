package com.mingrn.keeper.global.annotation;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;

/**
 * 参数不能为 NULL 或 '' 注解。
 * 该注解与 {@link Checked} 注解同时使用。<code>@Checked</code> 作用于方法,
 * 用于标识检查该方法。
 * <code>@ParamsIsNotNull</code> 注解作用于方法参数,用于表示该方法不能为 NULL 或 ''。
 * 当请求进入方法体之前会在 {@link com.mingrn.common.global.aspect.ParamsIsNotNullAspect}
 * 中进行校验。若被 <code>@ParamsIsNotNull</code> 注解标识的参数值为 NULL 或 '' 时,会抛出
 * {@link com.mingrn.common.global.exception.ParamIsNotNullException} 异常,并会
 * 在全局异常处理{@link com.mingrn.common.global.handle.GlobalExceptionHandler#paramIsNotNullException(HttpServletRequest, Exception)}中被拦截。
 * </p>
 * 该注解与 {@link org.springframework.web.bind.annotation.RequestParam} 注解唯一的区别在于
 * <code>@RequestParam</code> 注解只校验参数不为 NULL,对于 '' 是不做校验。
 * </p>
 * 使用示例见 README.md
 * </p>
 * 注意:该注解一定要与{@link Checked} 注解同时使用,否则将不起作用。
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 07/11/2018 20:24
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamsIsNotNull {
	boolean notNull() default true;
}