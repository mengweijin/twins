package com.github.twins.util;

/**
 * @author mengweijin
 * @date 2022/9/24
 */
public final class ClassUtil {

    private ClassUtil() {

    }

    /**
     * Returns the corresponding wrapper type for the given primitive,
     * or null if the type is not primitive.
     *
     * @param primitiveType
     * @return
     */
    public static Class<?> getWrapperType(Class<?> primitiveType) {
        if (boolean.class.equals(primitiveType)) {
            return Boolean.class;
        } else if (byte.class.equals(primitiveType)) {
            return Byte.class;
        } else if (char.class.equals(primitiveType)) {
            return Character.class;
        } else if (short.class.equals(primitiveType)) {
            return Short.class;
        } else if (int.class.equals(primitiveType)) {
            return Integer.class;
        } else if (long.class.equals(primitiveType)) {
            return Long.class;
        } else if (float.class.equals(primitiveType)) {
            return Float.class;
        } else if (double.class.equals(primitiveType)) {
            return Double.class;
        } else {
            return null;
        }
    }

    /**
     * Returns the corresponding primitive type for the given primitive wrapper,
     * or null if the type is not a primitive wrapper.
     *
     * @param wrapperType
     * @return the corresponding primitive type
     */
    public static Class<?> getPrimitiveType(Class<?> wrapperType) {
        if (Boolean.class.equals(wrapperType)) {
            return Boolean.TYPE;
        } else if (Byte.class.equals(wrapperType)) {
            return Byte.TYPE;
        } else if (Character.class.equals(wrapperType)) {
            return Character.TYPE;
        } else if (Short.class.equals(wrapperType)) {
            return Short.TYPE;
        } else if (Integer.class.equals(wrapperType)) {
            return Integer.TYPE;
        } else if (Long.class.equals(wrapperType)) {
            return Long.TYPE;
        } else if (Float.class.equals(wrapperType)) {
            return Float.TYPE;
        } else if (Double.class.equals(wrapperType)) {
            return Double.TYPE;
        } else {
            return null;
        }
    }

}
