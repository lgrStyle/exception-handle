package org.lgr.exception.handle.common.enumerate;

import org.lgr.exception.handle.common.BusinessExceptionAssert;

public enum ServletResponseEnum implements BusinessExceptionAssert {

    /**
     * Request error
     */
    REQUEST_ERROR(9002, "Request error.")
    ;

    ServletResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
