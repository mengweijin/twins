package com.github.twins;

import com.github.twins.converter.TwinsConverterFactory;
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

    private TwinsConverterFactory factory = new TwinsConverterFactory();

    private List<TwinsMapping<?, ?>> mappings = new ArrayList<>();

    public TwinsContext() {

    }


}
