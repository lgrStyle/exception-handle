package org.lgr.exception.handle.common.i18n;

import org.lgr.exception.handle.common.enumerate.CommonResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class UnifiedMessageSource {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code, Object[] args) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CommonResponseEnum.SERVER_ERROR.newException());
    }
}
