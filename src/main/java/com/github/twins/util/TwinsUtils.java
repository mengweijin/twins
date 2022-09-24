package com.github.twins.util;

import com.github.twins.exception.TwinsMapperException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public final class TwinsUtils {

    private TwinsUtils() {}

    public static Type getTypeArgument(Type type, int index) {
        final Type[] typeArguments = getTypeArguments(type);
        if (null != typeArguments && typeArguments.length > index) {
            return typeArguments[index];
        }
        return null;
    }

    public static Type[] getTypeArguments(Type type) {
        if (null == type) {
            return null;
        }

        final ParameterizedType parameterizedType = toParameterizedType(type);
        return (null == parameterizedType) ? null : parameterizedType.getActualTypeArguments();
    }

    public static ParameterizedType toParameterizedType(Type type) {
        ParameterizedType result = null;
        if (type instanceof ParameterizedType) {
            result = (ParameterizedType) type;
        } else if (type instanceof Class) {
            final Class<?> clazz = (Class<?>) type;
            Type genericSuper = clazz.getGenericSuperclass();
            if (null == genericSuper || Object.class.equals(genericSuper)) {
                // 如果类没有父类，而是实现一些定义好的泛型接口，则取接口的Type
                final Type[] genericInterfaces = clazz.getGenericInterfaces();
                if (genericInterfaces.length > 0) {
                    // 默认取第一个实现接口的泛型Type
                    genericSuper = genericInterfaces[0];
                }
            }
            result = toParameterizedType(genericSuper);
        }
        return result;
    }

    public static <T> T newInstance(Class<T> cls) {
        notNull(cls);
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new TwinsMapperException(e);
        }
    }

    public static void notNull(Object... obj) {
        if(obj != null && Arrays.stream(obj).noneMatch(Objects::isNull)) {
            return;
        }
        throw new TwinsMapperException("[Assertion failed] - the argument elements must not be null");
    }
}
