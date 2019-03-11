package com.mingrn.itumate.global.constants;

/**
 * 全局异常状态码常量
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 */
public final class ResponseStatusConstant {

	/**
	 * 失败状态码
	 */
	public static final int REQUEST_FAIL = -1;

	/**
	 * 请求成功状态码
	 */
	public static final int REQUEST_SUCCESS = 0;

	/**
	 * 非法请求状态码
	 */
	public static final int REQUEST_ILLEGAL = 10000;

	/**
	 * 未登录状态码
	 */
	public static final int REQUEST_NOT_LOGIN = 10001;

	/**
	 * 用户名或密码错误状态码
	 */
	public static final int REQUEST_USER_OR_PASSWORD_ERR = 10002;

	/**
	 * 密码错误次数已达上限
	 */
	public static final int REQUEST_PASSWORD_ERROR_LIMIT = 10003;

	/**
	 * 请求参数不能为空状态码
	 */
	public static final int REQUEST_PARAMS_CANT_NOT_EMPTY = 10004;

	/**
	 * 无操作权限状态吗
	 */
	public static final int REQUEST_NO_AUTHORIZED = 10005;

	/**
	 * 查询结果为空状态码
	 */
	public static final int REQUEST_RESULT_IS_EMPTY = 10006;


	/**
	 * 404 错误
	 */
	public static final int REQUEST_NOT_FOUND = 20000;

	/**
	 * 500 错误,内部服务器异常
	 */
	public static final int REQUEST_INTERNAL_SERVER_ERR = 20001;

	/**
	 * 业务异常
	 */
	public static final int REQUEST_SERVICE_EXCEPTION = 20002;

	/**
	 * 断言错误
	 */
	public static final int REQUEST_ASSERTION_ERR = 20003;


}
