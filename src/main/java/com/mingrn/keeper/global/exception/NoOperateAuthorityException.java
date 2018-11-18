package com.mingrn.keeper.global.exception;

/**
 * 无操作权限异常
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 09/11/2018 19:01
 */
public class NoOperateAuthorityException extends ServiceException {

	public NoOperateAuthorityException() {
	}

	@Override
	public String getMessage() {
		return "You do not have operation permissions";
	}
}
