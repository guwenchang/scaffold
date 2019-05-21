package com.smart.starter.i18n.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化
 * @author guwenchang
 * @date 2019-04-29 17:53
 */
@Component
@Slf4j
public class LocaleMessage {

    private final MessageSource messageSource;

    @Autowired
    public LocaleMessage(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, null);
    }

    public String getMessage(String code, Object[] args, String defaultMessage) {
        log.debug("locale {}",LocaleContextHolder.getLocale().toString());
        return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }
}
