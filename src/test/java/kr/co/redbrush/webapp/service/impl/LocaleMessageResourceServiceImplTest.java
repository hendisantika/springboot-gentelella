package kr.co.redbrush.webapp.service.impl;

import kr.co.redbrush.webapp.enums.MessageKey;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@Slf4j
public class LocaleMessageResourceServiceImplTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    public LocaleMessageSourceServiceImpl messageSourceService = new LocaleMessageSourceServiceImpl();

    @Mock
    private MessageSource messageSource;

    @Before
    public void before() {
    }

    @Test
    public void testGetMessageWithKey() {
        String key = "key";

        messageSourceService.getMessage(key);

        verify(messageSource).getMessage(eq(key), eq(null), any(Locale.class));
    }

    @Test
    public void testGetMessageWithKeyAndObjects() {
        String key = "key";
        Object[] objects = new Object[1];

        messageSourceService.getMessage(key, objects);

        verify(messageSource).getMessage(eq(key), eq(objects), any(Locale.class));
    }

    @Test
    public void testGetMessageWithMessageKey() {
        MessageKey messageKey = MessageKey.ADMIN_CREATE_ERROR;

        messageSourceService.getMessage(messageKey);

        verify(messageSource).getMessage(eq(messageKey.getKey()), eq(null), any(Locale.class));
    }

    @Test
    public void testGetMessageWithMessageKeyAndObjects() {
        MessageKey messageKey = MessageKey.ADMIN_CREATE_ERROR;
        Object[] objects = new Object[1];

        messageSourceService.getMessage(messageKey, objects);

        verify(messageSource).getMessage(eq(messageKey.getKey()), eq(objects), any(Locale.class));
    }
}