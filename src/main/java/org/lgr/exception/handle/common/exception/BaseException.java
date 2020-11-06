package org.lgr.exception.handle.common.exception;

import org.lgr.exception.handle.common.enumerate.IResponseEnum;

public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private IResponseEnum responseEnum;
    private Object[] args;

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }

    public IResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public Object[] getArgs(){
        return args;
    }
}
