package com.github.twins.converter;


import com.github.twins.consts.Const;
import com.github.twins.util.TwinsUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mengweijin
 * @date 2022/9/24
 */
public class TwinsConverterFactory {

    private final Map<String, TwinsConverter<Object, Object>> convertersMap = new ConcurrentHashMap<>();

    public void registerConverter(TwinsConverter<Object, Object> converter){
        TwinsUtils.notNull(converter);
        Class<Object> sourceClass = converter.getSourceClass();
        Class<Object> destinationClass = converter.getDestinationClass();
        this.registerConverter(this.generateId(sourceClass, destinationClass), converter);
    }

    public void registerConverter(String id, TwinsConverter<Object, Object> converter) {
        TwinsUtils.notNull(id, converter);
        convertersMap.put(id, converter);
    }

    public TwinsConverter<Object, Object> getConverter(String id) {
        return convertersMap.get(id);
    }

    public TwinsConverter<?, ?> getConverter(Class<?> sourceClass, Class<?> destinationClass) {
        TwinsConverter<Object, Object> converter = convertersMap.get(this.generateId(sourceClass, destinationClass));
        if(converter == null) {
            converter = convertersMap.get(this.generateId(destinationClass, sourceClass));
        }
        return converter;
    }

    public String generateId(Class<?> sourceClass, Class<?> destinationClass) {
        return "TwinsConverter_" + sourceClass.getName() + Const.UNDERSCORE + destinationClass.getName();
    }
}
