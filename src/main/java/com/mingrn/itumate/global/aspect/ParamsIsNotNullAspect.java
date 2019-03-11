package com.mingrn.itumate.global.aspect;

import com.mingrn.itumate.global.annotation.ParamsIsNotNull;
import com.mingrn.itumate.global.exception.ParamIsNotNullException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

/**
 * 检查参数AOP
 * 在前置通知中获取方法参数 <code>String[] params = parameter.getName();</code> 时
 * 若发现每个参数都为 arg[\d]时而无法获取正确的参数名,原因是参数名称被编译进了class文件,
 * 替代了早期版本里无意义的arg0、arg1...
 * 保留参数名这一选项由编译开关 `javac -parameters` 默认是关闭的。有以下两种方式开启:
 * 1st:
 * Idea等编译器 需要在 preferences>Compiler>Java Compiler> java Options 中
 * Additional command line parameters: 选项中增加 `-parameters`。
 * 2nd(推荐):
 * 在Maven中使用插件 `maven-compiler-plugin`,示例如下:
 * <code>
 *     <plugin>
 *         <groupId>org.apache.maven.plugins</groupId>
 *         <artifactId>maven-compiler-plugin</artifactId>
 *         <version>${mvn.plugins.maven-compiler.version}</version>
 *         <configuration>
 *             <compilerArgs>
 *                 <arg>-parameters</arg> //增加 -parameters 选项
 *                 <arg>other...</arg>
 *             </<compilerArgs>
 *         </<configuration>
 *     </plugin>
 * </code>
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 */
@Aspect
@Order(5)
@Component
public class ParamsIsNotNullAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParamsIsNotNullAspect.class);

	/**
	 * 切点
	 */
	@Pointcut("@annotation(com.mingrn.itumate.global.annotation.Checked)")
	public void paramsIsNotNullAspect() {
	}

	/**
	 * 前置通知校验 {@link ParamsIsNotNull}
	 */
	@Before("paramsIsNotNullAspect()")
	public void beforeNotice(JoinPoint joinPoint) {
		LOGGER.info("Into ParamsIsNotNullAspect of AOP Class, Begin to check parameters ...");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		// 获取方法参数
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Parameter[] parameters = methodSignature.getMethod().getParameters();
		for (Parameter parameter : parameters) {

			// 没有标注@ParamsIsNotNull,或者是HttpServletRequest、HttpServletResponse、HttpSession时,都不做处理
			if (parameter.getType().isAssignableFrom(HttpServletRequest.class) || parameter.getType().isAssignableFrom(HttpSession.class) ||
					parameter.getType().isAssignableFrom(HttpServletResponse.class) || parameter.getAnnotation(ParamsIsNotNull.class) == null) {
				continue;
			}
			// 参数是否增加不为NULL 或 "" 条件
			ParamsIsNotNull paramsIsNotNull = parameter.getAnnotation(ParamsIsNotNull.class);
			if (!paramsIsNotNull.notNull()) {
				continue;
			}

			// 获取方法参数名称
			String paramsName = parameter.getName();
			// 获取方法参数类型
			Class<?> clazz = parameter.getType();
			String value = request.getParameter(paramsName);
			LOGGER.info("Checked [{}] parameter [{}], and the value is: [{}]", clazz.toString(), paramsName, value);
			if (StringUtils.isBlank(value)) {
				throw new ParamIsNotNullException(clazz.toString(), paramsName);
			}
		}
		LOGGER.info("Parameter validation completed, And no exception parameters");
	}
}
