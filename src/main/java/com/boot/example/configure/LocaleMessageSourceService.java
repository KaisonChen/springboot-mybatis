package com.boot.example.configure;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Created by xiaohu on 2018/3/28.
 */
@Component
public class LocaleMessageSourceService {

    @Resource
    private MessageSource messageSource;

    public String getMessage(String code){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code,null,locale);
    }

}
