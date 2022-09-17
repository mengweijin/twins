package com.github.twins.util;

import com.github.twins.exception.TwinsMapperException;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public final class TwinsUtils {

    private TwinsUtils() {}

    public static <T> T newInstance(Class<T> cls) {
        Assert.notNull(cls);
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new TwinsMapperException(e);
        }
    }
}
