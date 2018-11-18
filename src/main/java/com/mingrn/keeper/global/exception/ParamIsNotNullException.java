package com.mingrn.keeper.global.exception;

/**
 * 参数不能为空异常
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 06/11/2018 19:53
 */
public class ParamIsNotNullException extends ServiceException {

	private String parameterType;
	private String parameterName;


	public ParamIsNotNullException(final String parameterType, final String parameterName) {
		this.parameterType = parameterType;
		this.parameterName = parameterName;
	}

	@Override
	public String getMessage() {
		return String.format("request [%s] parameter [%s] must not be empty or null", this.parameterType, this.parameterName);
	}
}
