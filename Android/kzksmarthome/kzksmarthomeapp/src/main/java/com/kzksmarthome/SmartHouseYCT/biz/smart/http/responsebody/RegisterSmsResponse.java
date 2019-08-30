package com.kzksmarthome.SmartHouseYCT.biz.smart.http.responsebody;

import com.kzksmarthome.common.lib.okhttp.BaseResponse;

/**
 * @Title: RegisterSmsResponse
 * @Description: 注册短信返回
 * @author laixj
 * @date 2016/9/18 14:50
 * @version V1.0
 */
public class RegisterSmsResponse extends BaseResponse {

    /**
     * success : false
     * result : null
     * error : {"code":"","message":"短信只能在60秒内请求发送一次"}
     */

    private boolean success;
    private Object result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RegisterSmsResponse{" +
                "success=" + success +
                ", result=" + result +
                '}';
    }
}