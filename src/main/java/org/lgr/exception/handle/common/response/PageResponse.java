package org.lgr.exception.handle.common.response;

import org.lgr.exception.handle.common.enumerate.IResponseEnum;

public class PageResponse<T> extends BaseResponse{
    private Page<T> data;

    public PageResponse(Page<T> data) {
        super();
        this.data = data;
    }

    public PageResponse(int code, String message) {
        super(code, message);
    }

    public PageResponse(int code, String message, Page<T> data) {
        super(code, message);
        this.data = data;
    }

    public PageResponse(IResponseEnum responseEnum, Page<T> data) {
        super(responseEnum);
        this.data = data;
    }

    public Page<T> getData() {
        return data;
    }

    public void setData(Page<T> data) {
        this.data = data;
    }
}
