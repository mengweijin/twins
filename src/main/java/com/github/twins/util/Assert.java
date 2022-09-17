package com.github.twins.util;

import com.github.twins.exception.TwinsMapperException;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public class Assert {

    public static void notNull(Object obj) {
        if(obj == null) {
            throw new TwinsMapperException("[Assertion failed] - the object argument must not be null");
        }
    }
}
