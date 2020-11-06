package org.lgr.exception.handle.common.enumerate;

import org.lgr.exception.handle.common.BusinessExceptionAssert;

public enum CommonResponseEnum implements BusinessExceptionAssert {
    /**
     * success
     */
    SUCCESS(1, "success"),
    /**
     * Server error
     */
    SERVER_ERROR(9001, "Server error."),

    CARD_QUREY_ERROR(1003, "查询卡信息失败"),

    DEVICE_QUREY_ERROR(1004, "查询设备信息失败")
    ;

    CommonResponseEnum(int code, String message) {
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
