package com.mingrn.keeper.global.exception;

/**
 * 未登录异常
 *
 * @author MinGRn
 */
public class NotLoginException extends ServiceException {

	public NotLoginException() {
	}

	@Override
	public String getMessage() {
		return "You are not logged in, Please login now or register if you do not have an account";
	}
}
