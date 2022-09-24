package com.github.twins;

import com.github.twins.converter.TwinsConverter;
import com.github.twins.converter.TwinsConverterFactory;
import com.github.twins.util.TwinsUtils;
import lombok.Data;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
@Data
public class TwinsMapperImpl implements TwinsMapper {

    private TwinsContext context;

    private TwinsMapperImpl() {
        this.context = new TwinsContext();
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        D instance = TwinsUtils.newInstance(destinationClass);
        return this.map(sourceObject, instance);
    }

    @Override
    public <S, D> D map(S sourceObject, D destinationObject) {
        if(sourceObject == null) {
            return null;
        }
        TwinsUtils.notNull(destinationObject);

        TwinsConverterFactory factory = context.getFactory();
        TwinsConverter<?, ?> converter = factory.getConverter(sourceObject.getClass(), destinationObject.getClass());
        if(converter != null) {
            destinationObject = (D) converter.convert(sourceObject, destinationObject.getClass(), context);
        }

        return destinationObject;
    }

}
