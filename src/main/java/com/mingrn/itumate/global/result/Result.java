package com.mingrn.itumate.global.result;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 统一返回结果类
 *
 * @author MinGRn
 */
public class Result<T> {

    /** 响应码 */
    private Integer code;

    /** 响应信息 */
    private String message;

    /**
     * 数据
     */
    private T data;

    Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJson() {
        return this.data == null ? JSON.toJSONString(this) : this.toJson(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
    }

    public String toJson(SerializerFeature... features) {
        return null == features ? this.toJson() : JSON.toJSONString(this, features);
    }

    @Override
    public String toString() {
        return "Result{code=" + this.code + ", message=\'" + this.message + '\'' + ", data=" + this.data + '}';
    }
}