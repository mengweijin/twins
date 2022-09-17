package com.github.twins;

import com.github.twins.converter.TwinsConverter;
import com.github.twins.mapping.TwinsMapping;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengweijin
 * @date 2022/9/17
 */
@Data
public class TwinsContext {

    private TwinsConfiguration configuration = new TwinsConfiguration();

    private List<TwinsConverter> converters = new ArrayList<>();

    private List<TwinsMapping<?, ?>> mappings = new ArrayList<>();

    public TwinsContext() {

    }

    public void register(TwinsConverter converter) {
        this.converters.add(converter);
    }
}
