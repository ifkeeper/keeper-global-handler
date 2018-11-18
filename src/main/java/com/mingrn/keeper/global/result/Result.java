package com.mingrn.keeper.global.result;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 统一返回结果类
 *
 * @author MinGRn
 */
public class Result<T> {

	/**
	 * 响应码
	 */
	private Integer resCode;

	/**
	 * 响应信息
	 */
	private String resMsg;

	/**
	 * 数据
	 */
	private T data;

	Result() {
	}

	public Integer getResCode() {
		return this.resCode;
	}

	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return this.resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
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
		return "Result{resCode=" + this.resCode + ", resMsg=\'" + this.resMsg + '\'' + ", data=" + this.data + '}';
	}
}