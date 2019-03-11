package com.mingrn.itumate.global.enums;


import com.mingrn.itumate.global.constants.ResponseStatusConstant;

/**
 * 请全局异常状态码枚举
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 */
public enum ResponseStatusCodeEnum {

    /**
     * 失败状态码
     */
    RESULT_CODE_FAILURE(ResponseStatusConstant.REQUEST_FAIL, "Failure"),

    /**
     * 成功状态码
     */
    RESULT_CODE_SUCCESS(ResponseStatusConstant.REQUEST_SUCCESS, "Success"),

    /**
     * 非法请求状态码
     */
    RESULT_CODE_ILLEGAL_REQUEST(ResponseStatusConstant.REQUEST_ILLEGAL, "Illegal request"),

    /**
     * 未登录状态码
     */
    RESULT_CODE_NOT_LOGIN(ResponseStatusConstant.REQUEST_NOT_LOGIN, "the user is not login"),

    /**
     * 登录用户名或密码错误状态码
     */
    RESULT_CODE_USER_OR_PASSWORD_ERROR(ResponseStatusConstant.REQUEST_USER_OR_PASSWORD_ERR, "username or password Invalid"),

    /**
     * 密码最大失败次数上限状态码
     */
    RESULT_CODE_PASSWORD_ERROR_LIMIT(ResponseStatusConstant.REQUEST_PASSWORD_ERROR_LIMIT, "upper limit for password error"),


    /**
     * 参数不能为空状态码
     */
    RESULT_CODE_PARAMS_CANT_NOT_EMPTY(ResponseStatusConstant.REQUEST_PARAMS_CANT_NOT_EMPTY, "the input parameter is null"),

    /**
     * 无操作权限状态码
     */
    RESULT_CODE_NO_AUTHORIZED(ResponseStatusConstant.REQUEST_NO_AUTHORIZED, "No operation permission"),

    /**
     * 查询结果为空状态码
     */
    RESULT_CODE_RESULT_IS_EMPTY(ResponseStatusConstant.REQUEST_RESULT_IS_EMPTY, "result is empty"),

    /**
     * 404状态码
     */
    RESULT_CODE_NOT_FOUND(ResponseStatusConstant.REQUEST_NOT_FOUND, "request not found"),

    /**
     * 500 错误状态码
     */
    RESULT_CODE_INTERNAL_SERVER_ERR(ResponseStatusConstant.REQUEST_INTERNAL_SERVER_ERR, "request internal server err"),

    /**
     * 业务异常状态码
     */
    RESULT_CODE_SERVICE_EXCEPTION(ResponseStatusConstant.REQUEST_SERVICE_EXCEPTION, "service exception"),

    /**
     * 断言错误状态码
     */
    RESULT_CODE_ASSERTION_ERR(ResponseStatusConstant.REQUEST_ASSERTION_ERR, "assertion error");


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String msg;

    ResponseStatusCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public final Integer getCode() {
        return code;
    }

    public final String getMsg() {
        return msg;
    }
}