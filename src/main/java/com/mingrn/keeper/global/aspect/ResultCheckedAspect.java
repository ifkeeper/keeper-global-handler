package com.mingrn.keeper.global.aspect;

import com.mingrn.keeper.global.constants.ResponseStatusConstant;
import com.mingrn.keeper.global.result.ResponseMsgUtil;
import com.mingrn.keeper.global.result.Result;
import com.mingrn.keeper.global.util.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 结果检查
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 08/11/2018 20:50
 */
@Aspect
@Order(6)
@Component
public class ResultCheckedAspect {

	/**
	 * 切点
	 */
	@Pointcut("@annotation(com.mingrn.keeper.global.annotation.Checked)")
	public void resultCheckedAspect() {
	}

	@Around("resultCheckedAspect()")
	public Result after(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取返回值
		Result result = (Result) joinPoint.proceed();
		// 结果不为成功状态码直接返回
		if (result.getResCode() != ResponseStatusConstant.REQUEST_SUCCESS) {
			return result;
		}

		// 结果不为空直接返回
		if (!ObjectUtils.isEmpty(result.getData())) {
			return result;
		}

		return ResponseMsgUtil.resultIsEmptyOrNotExist();
	}
}
