package com.github.twins;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public interface TwinsMapper {

    /**
     * Create and return a new instance of type D mapped with the properties of
     * <code>sourceObject</code>.
     *
     * @param sourceObject
     *            the object to map from
     * @param destinationClass
     *            the type of the new object to return
     * @return a new instance of type D mapped with the properties of
     *         <code>sourceObject</code>
     */
    <S, D> D map(S sourceObject, Class<D> destinationClass);

    <S, D> D map(S sourceObject, D destinationObject);
}
