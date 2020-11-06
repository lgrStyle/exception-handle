package org.lgr.exception.handle.common.response;

import org.lgr.exception.handle.common.enumerate.IResponseEnum;

public class DataResponse<T> extends BaseResponse {
    private T data;

    public DataResponse(T data) {
        super();
        this.data = data;
    }

    public DataResponse(int code, String message) {
        super(code, message);
    }

    public DataResponse(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public DataResponse(IResponseEnum responseEnum, T data) {
        super(responseEnum);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
