package org.lgr.exception.handle.common.response;

import org.lgr.exception.handle.common.enumerate.CommonResponseEnum;
import org.lgr.exception.handle.common.enumerate.IResponseEnum;

public class BaseResponse {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    public BaseResponse() {
        this.code = CommonResponseEnum.SUCCESS.getCode();
        this.message = CommonResponseEnum.SUCCESS.getMessage();
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
