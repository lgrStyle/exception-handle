package org.lgr.exception.handle.common.response;

import org.lgr.exception.handle.common.enumerate.IResponseEnum;

public class ErrorResponse extends BaseResponse{

    public ErrorResponse(int code, String message) {
        super(code, message);
    }

    public ErrorResponse(IResponseEnum responseEnum) {
        super(responseEnum);
    }

}
