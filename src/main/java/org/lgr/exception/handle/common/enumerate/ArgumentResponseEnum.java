package org.lgr.exception.handle.common.enumerate;

import org.lgr.exception.handle.common.BusinessExceptionAssert;

public enum ArgumentResponseEnum implements BusinessExceptionAssert {

    /**
     * Valid error
     */
    VALID_ERROR(9002, "Valid error.")
    ;

    ArgumentResponseEnum(int code, String message) {
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
