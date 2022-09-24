package com.github.twins.converter;


import com.github.twins.TwinsContext;
import com.github.twins.common.TwinsType;
import com.github.twins.util.TwinsUtils;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
public interface TwinsConverter<A, B> {

    default Object convert(Object source, Class<?> destinationClass, TwinsContext context) {
        if (this.getDestinationClass().isAssignableFrom(destinationClass)
                || TwinsType.isWrapperFor(this.getDestinationClass(), destinationClass)
                || TwinsType.isPrimitiveFor(this.getDestinationClass(), destinationClass)
        ) {
            return convertTo((A) source, (Class<? extends B>) destinationClass, context);
        } else {
            return convertFrom((B)source, (Class<A>)destinationClass, context);
        }
    };

    default Class<A> getSourceClass() {
        return (Class<A>) TwinsUtils.getTypeArgument(this.getClass(), 0);
    }

    default Class<B> getDestinationClass() {
        return (Class<B>) TwinsUtils.getTypeArgument(this.getClass(), 1);
    }

    B convertTo(A source, Class<? extends B> destinationClass, TwinsContext context);

    A convertFrom(B source, Class<? extends A> destinationClass, TwinsContext context);

}
