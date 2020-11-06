package org.lgr.exception.handle.common;

import org.lgr.exception.handle.common.enumerate.IResponseEnum;
import org.lgr.exception.handle.common.exception.BaseException;
import org.lgr.exception.handle.common.exception.BusinessException;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }

}
